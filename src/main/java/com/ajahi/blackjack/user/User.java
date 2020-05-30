package com.ajahi.blackjack.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(10);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
    private UUID userId;

    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 8)
    @JsonIgnore
    private String userPassword;
    @NotNull
    private int userBank;
    @NotNull
    private int userRank;
    @NotNull
    private LocalDate playerRegistrationDate;

    public User(){}

    public User(String username, String userPassword) {
        this.username = username;
        setUserPassword(userPassword);
        this.userBank = 2000;
        this.userRank = 0;
        this.playerRegistrationDate = LocalDate.now();
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = PASSWORD_ENCODER.encode(userPassword);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserBank(int userBank) {
        this.userBank = userBank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserBank() {
        return userBank;
    }

    public int getUserRank() {
        return userRank;
    }

    public LocalDate getPlayerRegistrationDate() {
        return playerRegistrationDate;
    }
}
