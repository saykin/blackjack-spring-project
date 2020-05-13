package com.ajahi.blackjack.data;

import com.ajahi.blackjack.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class DealerRepository {

    @Autowired
    CardRepository cardRepository;

    private Stack<Card> deck = new Stack<>();
    private PlayerRepository hama = new PlayerRepository();
    private PlayerRepository magnus = new PlayerRepository();

    public DealerRepository() {
        hama.getPlayer().setPlayerName("Hama");
        magnus.getPlayer().setPlayerName("Magnus");
    }

    public boolean checkIfOver(PlayerRepository player) {
        return player.getTotalValueOfDrawnCards() > 21;
    }


    public void drawCard(PlayerRepository player) {
        if (!deck.empty())
            player.addCard(deck.pop());
        player.calculateCardValue();
    }

    public List<String> playBlackjack() {
        hama.getCardsDrawn().removeAll(hama.getCardsDrawn());
        magnus.getCardsDrawn().removeAll(magnus.getCardsDrawn());
        List<String> test = new ArrayList<>();
        deck.addAll(cardRepository.getShuffledDeck());
        drawCard(hama);
        drawCard(hama);
        drawCard(magnus);
        drawCard(magnus);
        if (hama.isBlackjack() && magnus.isBlackjack()) {
            test.add("Begge har Blackjack");
            test.add(String.format("%s | %d | %s",
                    hama.getPlayer().getPlayerName(),
                    hama.getTotalValueOfDrawnCards(),
                    hama.getAllCards()));
            test.add(String.format("%s | %d | %s",
                    magnus.getPlayer().getPlayerName(),
                    magnus.getTotalValueOfDrawnCards(),
                    magnus.getAllCards()));
            return test;
        }

        while (hama.getTotalValueOfDrawnCards() < 17) {
            drawCard(hama);
            if (checkIfOver(hama)) {
                test.add(String.format("Vinner: %s", magnus.getPlayer().getPlayerName()));
                test.add(String.format("%s | %d | %s",
                        magnus.getPlayer().getPlayerName(),
                        magnus.getTotalValueOfDrawnCards(),
                        magnus.getAllCards()));
                test.add(String.format("%s | %d | %s",
                        hama.getPlayer().getPlayerName(),
                        hama.getTotalValueOfDrawnCards(),
                        hama.getAllCards()));
                return test;
            }
        }

        while (magnus.getTotalValueOfDrawnCards() <= hama.getTotalValueOfDrawnCards()) {
            drawCard(magnus);
            if (checkIfOver(magnus)) {
                test.add(String.format("Vinner: %s", hama.getPlayer().getPlayerName()));
                test.add(String.format("%s | %d | %s",
                        hama.getPlayer().getPlayerName(),
                        hama.getTotalValueOfDrawnCards(),
                        hama.getAllCards()));
                test.add(String.format("%s | %d | %s",
                        magnus.getPlayer().getPlayerName(),
                        magnus.getTotalValueOfDrawnCards(),
                        magnus.getAllCards()));
                return test;
            }
        }

        if (hama.getTotalValueOfDrawnCards() > magnus.getTotalValueOfDrawnCards()) {
            test.add(String.format("Vinner: %s", hama.getPlayer().getPlayerName()));
            test.add(String.format("%s | %d | %s",
                    hama.getPlayer().getPlayerName(),
                    hama.getTotalValueOfDrawnCards(),
                    hama.getAllCards()));
            test.add(String.format("%s | %d | %s",
                    magnus.getPlayer().getPlayerName(),
                    magnus.getTotalValueOfDrawnCards(),
                    magnus.getAllCards()));
            return test;
        } else {
            test.add(String.format("Vinner: %s", magnus.getPlayer().getPlayerName()));
            test.add(String.format("%s | %d | %s",
                    hama.getPlayer().getPlayerName(),
                    hama.getTotalValueOfDrawnCards(),
                    hama.getAllCards()));
            test.add(String.format("%s | %d | %s",
                    magnus.getPlayer().getPlayerName(),
                    magnus.getTotalValueOfDrawnCards(),
                    magnus.getAllCards()));
            return test;
        }
    }
}
