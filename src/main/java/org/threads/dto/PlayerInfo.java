package org.threads.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.threads.game.PlayBoard;

@AllArgsConstructor
@Getter
public class PlayerInfo {
    private String firstName;
    private String lastName;
    private String ticketId;
    private PlayBoard playBoard;
}