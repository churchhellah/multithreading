package org.threads.service.impl;

import org.threads.dto.PlayerInfo;
import org.threads.game.impl.GameMasterImpl;
import org.threads.game.impl.PlayBoardImpl;
import org.threads.service.GameMode;
import org.threads.service.TicketGenerator;

import java.util.HashMap;
import java.util.Map;

public class GameController {
    private final GameMasterImpl gameMaster = new GameMasterImpl();
    private final TicketGenerator ticketGenerator = new TicketGeneratorImpl();
    // Так как у игрока может быть N карточек - создаем переменную, куда можно складывать карточки
    private final Map<String, PlayBoardImpl> playerBoards = new HashMap<>();
    private final GameMode gameMode;

    // Принимаем объект TicketGenerator для генерации билетов
    public GameController(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    // Генерируем билет и создаёт карточку для игрока
    public String registerPlayer(PlayerInfo playerInfo) {
        String ticketId = ticketGenerator.generateTicket();
        PlayBoardImpl playBoard = new PlayBoardImpl();
        playerBoards.put(ticketId, playBoard);
        return ticketId;
    }

    public void startGame() {
        while (true) {
            // Извлекаем бочонки с помощью GameMasterImpl
            int drawnNumber = gameMaster.getLottoKeg();
            System.out.println("Drawn number: " + drawnNumber);

            for (Map.Entry<String, PlayBoardImpl> entry : playerBoards.entrySet()) {
                PlayBoardImpl board = entry.getValue();
                // Закрываем число на карточках игроков
                board.closeNumber(drawnNumber);

                // Проверяем условия выигрыша
                if (board.isAllNumbersOnRowAreClosed()) { // Все числа в строке закрыты
                    System.out.println("Player with ticket " + entry.getKey() + " has a full row!");
                    return;
                }

                if (board.isAllNumbersOnCardClosed()) { // Все числа на карточке закрыты
                    System.out.println("Player with ticket " + entry.getKey() + " wins!");
                    return;
                }
            }
        }
    }
}
