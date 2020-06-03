package com.ajahi.blackjack.player;

import com.ajahi.blackjack.card.CardService;
import com.ajahi.blackjack.user.User;
import com.ajahi.blackjack.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final CardService cardService;
    private final UserRepository userRepository;

    @Autowired
    public PlayerService(CardService cardService, UserRepository userRepository) {
        this.cardService = cardService;
        this.userRepository = userRepository;
    }

    public void addCard() {

    }

    public Player createPlayer(User user) {
        Player newPlayer = new Player(user);
        return newPlayer;
    }
}
