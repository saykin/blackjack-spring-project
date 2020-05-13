package com.ajahi.blackjack.data;

import com.ajahi.blackjack.model.Card;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CardRepository {

    private static final String[] SUIT = {"SPADES", "HEARTS", "CLUBS", "DIAMOND"};
    private static final String[] VALUE_NAMES = {"A", "2", "3", "4",
            "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final List<Card> deckOfCards = new ArrayList<>();;
//    private Gson gson = new Gson();

    public void createDeck() {
        for (String suit : SUIT) {
            for (String value : VALUE_NAMES) {
                deckOfCards.add(new Card(suit, value));
            }
        }
    }

    public List<Card> getDeck() {
        return deckOfCards;
    }

    public List<Card> getShuffledDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;

    }

    /*private String getDeckString() {
        return gson.toJson(
                deckOfCards,
                new TypeToken<ArrayList<Card>>() {}.getType());
    }*/
}
