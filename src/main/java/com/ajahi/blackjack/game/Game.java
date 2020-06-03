package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private final UUID sessionId;
    private final String gameUrl;
    private final List<Player> playerList;
    private final int maxSessionPlayerSize;
    private int sessionPlayerSize;

    public Game() {
        this.sessionId = UUID.randomUUID();
        this.gameUrl = sessionId.toString().replaceAll("-", "").substring(0, 8);
        playerList = new ArrayList<>();
        maxSessionPlayerSize = 7;
        sessionPlayerSize = 0;
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

    public boolean addPlayerToSession(Player player) {
        if(sessionPlayerSize <= maxSessionPlayerSize) {
            sessionPlayerSize++;
            return playerList.add(player);
        }
        else
            return false;
    }
}
