package org.threads.game.impl;

import org.threads.dto.PlayerInfo;
import org.threads.game.PlayerRepository;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPlayerRepositoryImpl implements PlayerRepository {
    private final ConcurrentHashMap<String, PlayerInfo> playerMap = new ConcurrentHashMap<>();

    @Override
    public void registerPlayer(String ticketId, PlayerInfo playerInfo) {
        if (playerMap.contains(ticketId)) {
            throw new IllegalArgumentException ("Ticket with ID: " + ticketId + " already registered");
        }
        playerMap.put(ticketId, playerInfo);
    }

    @Override
    public PlayerInfo getPlayerInfo(String ticketId) {
        return playerMap.get(ticketId);
    }
}
