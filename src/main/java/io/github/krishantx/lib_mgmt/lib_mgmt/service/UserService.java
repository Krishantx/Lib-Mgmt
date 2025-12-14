package io.github.krishantx.lib_mgmt.lib_mgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.User;
import io.github.krishantx.lib_mgmt.lib_mgmt.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    public void addUser(User user) {
        userRepo.addUser(user);
    }

    public void deleteUser(int userId) {
        userRepo.deleteUser(userId);
    }

    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    public User getUser(int userId) {
        User user = userRepo.getUser(userId);
        return user;
    }

    public List<User> allUsers() {
        return userRepo.getAllUsers();
    }
}
