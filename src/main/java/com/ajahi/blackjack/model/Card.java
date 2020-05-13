package com.ajahi.blackjack.model;

public class Card {
    private String suit;
    private String value;
    private int suitValue;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    private int convertCardToInteger() {
        if (value.matches("[JjQqKkAa]")) {
            if (value.equalsIgnoreCase("A"))
                return suitValue = 11;
            else
                return suitValue = 10;
        } else {
            return suitValue = Integer.parseInt(value);
        }
    }

    public int getSuitValue() {
        return convertCardToInteger();
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
