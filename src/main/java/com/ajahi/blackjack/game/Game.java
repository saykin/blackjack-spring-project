package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private final UUID sessionId;
    private final String gameUrl;
    private final List<Player> playerList;

    public Game() {
        this.sessionId = UUID.randomUUID();
        this.gameUrl = sessionId.toString().substring(0,8);
        playerList = new ArrayList<>();
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
