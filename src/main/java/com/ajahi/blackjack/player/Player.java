package com.ajahi.blackjack.player;

import com.ajahi.blackjack.Card.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Player {

    @Id
    @GeneratedValue(generator = "UUID")
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(10);
    private UUID playerId;

    @JsonIgnore
    @Size(min = 8)
    private String password;

    @NotNull
    @Size(min = 3, max = 30, message = "Player name must be between 3 and 30 letters")
    private String playerName;

    @NotNull
    private int playerRank;

    @NotNull
    private int playerBank;

    @NotNull
    private LocalDate playerRegistrationDate;

    private List<Card> cardsDrawn;

    private int cardValue;

    private boolean hasAce;

    @NotNull
    private String role;

    public Player() {
    }

    public Player(String playerName, String password) {
        this.playerName = playerName;
        setPassword(password);
        playerBank = 2000;
        playerId = UUID.randomUUID();
        playerRegistrationDate = LocalDate.now();
        cardsDrawn = new ArrayList<>();
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    public int getPlayerBank() {
        return playerBank;
    }

    public void setPlayerBank(int playerBank) {
        this.playerBank = playerBank;
    }

    public LocalDate getPlayerRegistrationDate() {
        return playerRegistrationDate;
    }

    public void setPlayerRegistrationDate(LocalDate playerRegistrationDate) {
        this.playerRegistrationDate = playerRegistrationDate;
    }

    public List<Card> getCardsDrawn() {
        return cardsDrawn;
    }

    public void addDrawnCard(Card card) {
        cardsDrawn.add(card);
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue += cardValue;
    }

    public boolean isHasAce() {
        return hasAce;
    }

    public void setHasAce(boolean hasAce) {
        this.hasAce = hasAce;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
