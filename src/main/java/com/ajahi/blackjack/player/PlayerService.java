package com.ajahi.blackjack.player;

import com.ajahi.blackjack.Card.Card;
import com.ajahi.blackjack.Card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository players;

    @Autowired
    public PlayerService(PlayerRepository players, CardService cards) {
        this.players = players;
    }

    public void addCard(UUID playerId, Card card) {
        Player player = players.findById(playerId).orElseThrow(NullPointerException::new);
        player.addDrawnCard(card);
        if (card.getRank() == 11 && !player.isHasAce()) {
            player.setHasAce(true);
            player.setCardValue(card.getRank());
        } else {
            player.setCardValue(card.getRank());
        }
    }

    public void saveInfo() {
        Player player = new Player("Hama", "123456");
    }
}
