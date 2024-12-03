package org.threads.service;

import org.threads.dto.PlayerInfo;

public interface PlayerRepository {
    void registerPlayer();
    PlayerInfo getPlayerInfo(String ticketNumber);
}
