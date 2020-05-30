package com.ajahi.blackjack.player;

import com.ajahi.blackjack.Card.Card;
import com.ajahi.blackjack.user.User;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final User user;
    private final String username;
    private final List<Card> cardsDrawn;
    private int cardValue;
    private boolean hasAce;
    private int playerBank;

    public Player(User user) {
        this.user = user;
        this.username = user.getUsername();
        this.cardsDrawn = new ArrayList<>();
        this.cardValue = 0;
        this.hasAce = false;
        this.playerBank = user.getUserBank();
    }

    public User getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public List<Card> getCardsDrawn() {
        return cardsDrawn;
    }

    public boolean addDrawnCard(Card card) {
        return cardsDrawn.add(card);
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public boolean isHasAce() {
        return hasAce;
    }

    public void setHasAce(boolean hasAce) {
        this.hasAce = hasAce;
    }

    public int getPlayerBank() {
        return playerBank;
    }

    public void setPlayerBank(int playerBank) {
        this.playerBank = playerBank;
    }
}
