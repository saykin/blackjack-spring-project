package com.ajahi.blackjack.card;

public enum CardSuit {
    DIAMONDS ("Diamonds"),
    CLUBS ("Clubs"),
    HEARTS ("Hearts"),
    SPADES ("Spades");

    public final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
