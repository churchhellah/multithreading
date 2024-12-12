package org.threads.game;

import lombok.extern.slf4j.Slf4j;
import org.threads.dto.PlayerInfo;
import org.threads.game.impl.GameMasterImpl;
import org.threads.game.impl.InMemoryPlayerRepositoryImpl;
import org.threads.game.impl.LottoKegsImpl;
import org.threads.game.impl.PlayBoardImpl;
import org.threads.service.impl.TicketGeneratorImpl;

@Slf4j
public class Game {

    private final GameMasterImpl gameMaster = new GameMasterImpl();
    private final InMemoryPlayerRepositoryImpl playerRepository = new InMemoryPlayerRepositoryImpl();
    private final LottoKegsImpl lottoKegs = LottoKegsImpl.getInstance();
    private final PlayBoardImpl playBoard = new PlayBoardImpl();
    private final TicketGeneratorImpl ticketGenerator = new TicketGeneratorImpl();

    public void game() {
        playerRepository.registerPlayer(ticketGenerator.generateTicket(), new PlayerInfo("Нина", "Лотова"));
        playerRepository.registerPlayer(ticketGenerator.generateTicket(), new PlayerInfo("Гарик", "Харламов"));
    }
}
