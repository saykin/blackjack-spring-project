package com.ajahi.blackjack.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/create-session")
    public String createSession() {
        String test = gameService.createGameSession();
        return String.format("Game session %s created", test);
    }

    @GetMapping("/{sessionUrl}")
    public String openGameSession(@PathVariable String sessionUrl) {
        if (gameService.findGameSession(sessionUrl))
            return "Game session found";
        else
            return "Game session not found";
    }

    @GetMapping("/{sessionUrl}/{username}")
    public String addPlayer(@PathVariable String sessionUrl, @PathVariable String username) {
        gameService.addPlayerToGameSession(username, sessionUrl);
        return "Player added to session";
    }
}
