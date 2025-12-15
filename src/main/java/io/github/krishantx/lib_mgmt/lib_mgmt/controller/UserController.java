package io.github.krishantx.lib_mgmt.lib_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.User;
import io.github.krishantx.lib_mgmt.lib_mgmt.service.BookService;
import io.github.krishantx.lib_mgmt.lib_mgmt.service.UserService;

@RestController
public class UserController {
    
    @Autowired UserService userService;
    @Autowired BookService bookService;

    // Method to add a new user
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    // TODO Method to update existing user details
    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    // TODO Method to get all the users
    @GetMapping("/users")
    public List<User> allUsers() {
        List<User> users = userService.allUsers();
        return users;
    }

    // TODO Method to find a specific user
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        User user = userService.getUser(userId);
        return user;
    }

    //TODO Method to delete a user
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }

    
}
