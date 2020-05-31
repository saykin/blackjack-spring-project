package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.Player;
import com.devskiller.friendly_id.FriendlyId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private final UUID sessionId;
    private final String gameUrl;
    private final List<Player> playerList;

    public Game(UUID sessionId) {
        this.sessionId = sessionId;
        this.gameUrl = FriendlyId.toFriendlyId(sessionId);
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

    public boolean addPlayerToSession(Player player) {
        return playerList.add(player);
    }
}
