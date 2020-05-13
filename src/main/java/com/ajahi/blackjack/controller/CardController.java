package com.ajahi.blackjack.controller;


import com.ajahi.blackjack.data.CardRepository;
import com.ajahi.blackjack.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CardController {

//  This class is for now mainly used to test that I could retrieve a sorted and shuffled deck of Cards

    @Autowired
    private CardRepository cardRepository;

    @RequestMapping("/")
    public String displayHome() {
        return "home";
    }

    @RequestMapping("/cards")
    public String listDeck(ModelMap modelMap) {
        cardRepository.createDeck();
        List<Card> cards = cardRepository.getDeck();
        modelMap.put("cards", cards);
        return "cards";
    }

    @RequestMapping("/shuffled")
    public String listShuffledDeck(ModelMap modelMap) {
        cardRepository.createDeck();
        List<Card> cards = cardRepository.getShuffledDeck();
        modelMap.put("cards", cards);
        return "shuffled";
    }

}
