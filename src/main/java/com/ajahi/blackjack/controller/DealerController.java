package com.ajahi.blackjack.controller;


import com.ajahi.blackjack.data.CardRepository;
import com.ajahi.blackjack.data.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DealerController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    DealerRepository dealerRepository;

    @RequestMapping("/playtest")
    public String playTest(ModelMap modelMap) {
        cardRepository.createDeck();
        List<String> vinner = dealerRepository.playBlackjack();
        modelMap.put("vinner", vinner);
        return "playtest";
    }

}
