package org.threads.game;

import lombok.extern.slf4j.Slf4j;
import org.threads.dto.PlayerInfo;
import org.threads.service.GameMode;
import org.threads.service.impl.GameController;

@Slf4j
public class Game {
    private final GameController gameController;

    public Game(GameMode gameMode) {
        this.gameController = new GameController(gameMode);
    }

    public void initializePlayers() {
        String ticket1 = gameController.registerPlayer(new PlayerInfo("Alice", "Smith"));
        String ticket2 = gameController.registerPlayer(new PlayerInfo("Bob", "Johnson"));

        System.out.println("Players registered:");
        System.out.println("Ticket 1: " + ticket1);
        System.out.println("Ticket 2: " + ticket2);
    }

    public void start() {
        System.out.println("Starting the game!");
        gameController.startGame();
    }

    public static void main(String[] args) {
        // Указываем режим игры
        GameMode gameMode = GameMode.FULL_ROW;

        // Создаём объект Game
        Game game = new Game(gameMode);

        // Инициализируем игроков
        game.initializePlayers();

        // Запускаем игру
        game.start();
    }
}