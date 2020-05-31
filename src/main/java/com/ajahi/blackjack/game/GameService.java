package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.Player;
import com.ajahi.blackjack.player.PlayerService;
import com.ajahi.blackjack.user.User;
import com.ajahi.blackjack.user.UserService;
import com.devskiller.friendly_id.FriendlyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameService {
    private final UserService userService;
    private final PlayerService playerService;
    private final Map<UUID, Game> gameSessions;

    @Autowired
    public GameService(UserService userService, PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
        gameSessions = new HashMap<>();
    }

    public String createGameSession() {
        UUID sessionId = UUID.randomUUID();
        System.out.println(sessionId);
        Game game = new Game(sessionId);
        gameSessions.put(sessionId, game);
        return game.getGameUrl();
    }

    public void addPlayerToGameSession(String username, String sessionUrl) {
        UUID sessionId = FriendlyId.toUuid(sessionUrl);
        User user = userService.findUser(username);
        gameSessions.get(sessionId).addPlayerToSession(playerService.addPlayer(user));
    }

    public boolean findGameSession(String sessionUrl) {
        return (gameSessions.get(FriendlyId.toUuid(sessionUrl)) != null);
    }

    public void deleteSession(String sessionUrl) {
        gameSessions.remove(FriendlyId.toUuid(sessionUrl));
    }
}
