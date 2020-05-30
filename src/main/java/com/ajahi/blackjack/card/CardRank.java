package com.ajahi.blackjack.card;

public enum CardRank {
    ACE (11),
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (10),
    QUEEN (10),
    KING (10);

    public final int rank;

    CardRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
