package com.ajahi.blackjack.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Player {
    private String playerName;
    private UUID playerId;
    private LocalDate playerRegistrationDate;


    public Player(String playerName) {
        this.playerName = playerName;
        this.playerId = UUID.randomUUID();
        this.playerRegistrationDate = LocalDate.now();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public LocalDate getPlayerRegistrationDate() {
        return playerRegistrationDate;
    }

    public void setPlayerRegistrationDate(LocalDate playerRegistrationDate) {
        this.playerRegistrationDate = playerRegistrationDate;
    }
}
