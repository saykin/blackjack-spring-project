package com.ajahi.blackjack.Card;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CardService {
    private List<Card> deckOfCards;
    private List<Card> shuffledDeck;

    public CardService(List<Card> deckOfCards) {
        this.deckOfCards = new ArrayList<>();
    }

    public void createDeck() {
        for (CardSuit cs : CardSuit.values()) {
            for (CardRank cr : CardRank.values())
                deckOfCards.add(new Card(cs.getSuit(), cr.getRank()));
        }
        shuffledDeck = deckOfCards;

    }

    public List<Card> shuffleDeck() {
        Collections.shuffle(shuffledDeck);
        return shuffledDeck;
    }
}
