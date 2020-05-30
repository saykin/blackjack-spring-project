package com.ajahi.blackjack.Card;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Service
public class CardService {
    private List<Card> deckOfCards;
    private List<Card> shuffledDeck;

    public CardService() {
    }

    public CardService(List<Card> deckOfCards) {
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    public void createDeck() {
        for (CardSuit cs : CardSuit.values()) {
            for (CardRank cr : CardRank.values())
                deckOfCards.add(new Card(cs.getSuit(), cr.getRank()));
        }
        shuffledDeck = deckOfCards;

    }

    public Stack<Card> shuffleDeck() {
        Collections.shuffle(shuffledDeck);
        Stack<Card> stack = new Stack<>();
        stack.addAll(shuffledDeck);
        return stack;
    }

    public Card drawCard() {
        return shuffleDeck().pop();
    }
}
