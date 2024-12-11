package org.threads.game;

import org.threads.dto.PlayerInfo;

public interface PlayerRepository {
    void registerPlayer(String ticketId, PlayerInfo playerInfo);
    PlayerInfo getPlayerInfo(String ticketNumber);
}
