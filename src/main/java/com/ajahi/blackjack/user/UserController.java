package com.ajahi.blackjack.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.UUID;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test-create-user")
    public String testCreateUser() {
        userService.addUser(new com.ajahi.blackjack.user.User("Hama", "12345678"));
        return "User created";
    }

    @GetMapping("/test-create-multiple-users")
    public String testCreateMultipleUsers() {
        userService.addMultipleUsers(Arrays.asList(new User("Olav", "12345678"),
                new User("Preben", "12345678"),
                new User("Robin", "12345678"),
                new User("Morgan", "12345678")));
        return "Several players added";
    }

    @GetMapping("/print-users")
    public String printUsers() {
        userService.findAllUsers().forEach(user -> System.out.println(user.getUserId()));
        return "Printing all users to log";
    }

    @GetMapping("/get-hama-username")
    public String printSpecificUser() {
        System.out.println(userService.findUser("Hama").getUsername());
        return "Printing Hama to log";
    }

    @GetMapping("/get-hama-id")
    public String printSpecificUserId() {
        System.out.println(userService.findUserById(UUID.fromString("419a0d37-cc70-4fc4-8550-7290c70eeb00")).getUserId());
        return "Printing ID of Hama to log";
    }
}
