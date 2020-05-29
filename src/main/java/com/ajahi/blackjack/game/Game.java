package com.ajahi.blackjack.game;

import com.ajahi.blackjack.player.Player;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Entity
public class Game {
    @Id
    private UUID gameSessionId;
    private List<Player> players;

}
