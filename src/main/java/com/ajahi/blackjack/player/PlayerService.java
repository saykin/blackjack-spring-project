package com.ajahi.blackjack.player;

import com.ajahi.blackjack.Card.CardService;
import com.ajahi.blackjack.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final CardService cardService;

    @Autowired
    public PlayerService(CardService cardService) {
        this.cardService = cardService;
    }



    public void addCard() {

    }

    public void addPlayer(User user) {

    }
}
