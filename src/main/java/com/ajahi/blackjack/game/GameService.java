package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.PlayerService;
import com.ajahi.blackjack.user.User;
import com.ajahi.blackjack.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class GameService {
    private final UserService userService;
    private final PlayerService playerService;

    @Autowired
    public GameService(UserService userService, PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
    }

    public void addPlayerToGameSession(User user) {
        playerService.addPlayer(user);
    }
}
