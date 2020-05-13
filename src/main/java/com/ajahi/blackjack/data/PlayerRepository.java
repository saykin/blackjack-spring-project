package com.ajahi.blackjack.data;

import com.ajahi.blackjack.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerRepository {

    private int totalValueOfDrawnCards;
    private boolean blackjack;
    private boolean moreThanOneAce;
    private List<Card> cardsDrawn;

    public PlayerRepository () {
        this.totalValueOfDrawnCards = 0;
        this.blackjack = false;
        this.moreThanOneAce = false;
        this.cardsDrawn = new ArrayList<>();
    }

    public boolean checkForAce(int i) {
        return cardsDrawn.get(i).getValue().equalsIgnoreCase("A");
    }

    public void calculateCardValue() {
        for (int i = 0; i < getCardsDrawn().size(); i++) {
            if (checkForAce(i) && isMoreThanOneAce())
                totalValueOfDrawnCards += 1;
            else {
                if (checkForAce(i))
                    setMoreThanOneAce(true);
                totalValueOfDrawnCards += getCardsDrawn().get(i).getSuitValue();
            }
        }
        if (getTotalValueOfDrawnCards() == 21) {
            setBlackjack(true);
        }
    }

    public String getAllCards() {
        return cardsDrawn.stream()
                .map(kort ->  kort.getSuit().substring(0, 1) + kort.getSuitValue())
                .collect(Collectors.joining(","));
    }

    public int getTotalValueOfDrawnCards() {
        return totalValueOfDrawnCards;
    }

    public void setTotalValueOfDrawnCards(int totalValueOfDrawnCards) {
        this.totalValueOfDrawnCards = totalValueOfDrawnCards;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isMoreThanOneAce() {
        return moreThanOneAce;
    }

    public void setMoreThanOneAce(boolean moreThanOneAce) {
        this.moreThanOneAce = moreThanOneAce;
    }

    public List<Card> getCardsDrawn() {
        return cardsDrawn;
    }
}
