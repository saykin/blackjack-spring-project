package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.Player;
import com.ajahi.blackjack.player.PlayerService;
import com.ajahi.blackjack.user.User;
import com.ajahi.blackjack.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {
    private final UserService userService;
    private final PlayerService playerService;
    private final Map<String, Game> gameSessions;

    @Autowired
    public GameService(UserService userService, PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
        gameSessions = new HashMap<>();
    }

    public String createGameSession() {
        Game game = new Game();
        gameSessions.put(game.getGameUrl(), game);
        Player dealer = createNewDealerForSession();
        gameSessions.get(game.getGameUrl()).addPlayerToSession(dealer);
        return game.getGameUrl();
    }

    private Player createNewDealerForSession() {
        User user = new User();
        user.setUsername("House");
        return new Player(user);
    }

    public void addPlayerToGameSession(String username, String sessionUrl) {
        gameSessions.get(sessionUrl).addPlayerToSession(playerService.createPlayer(userService.findUser(username)));
    }

    public boolean findGameSession(String sessionUrl) {
        return gameSessions.get(sessionUrl) != null;
    }

    public void deleteSession(String sessionUrl) {
        gameSessions.remove(sessionUrl);
    }
}
