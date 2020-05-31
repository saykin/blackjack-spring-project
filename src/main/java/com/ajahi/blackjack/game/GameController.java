package com.ajahi.blackjack.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/create-session")
    public String createSession(Model model) {
        String test = gameService.createGameSession();
        return String.format("Game session %s created", test);
    }

    @GetMapping("/game-session/{url}")
    public String openGameSession(@PathVariable String url) {
        if (gameService.findGameSession(url))
            return "Game session found";
        else
            return "Game session not found";
    }
}
