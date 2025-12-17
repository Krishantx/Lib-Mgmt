package io.github.krishantx.lib_mgmt.lib_mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.krishantx.lib_mgmt.lib_mgmt.models.LoginBody;
import io.github.krishantx.lib_mgmt.lib_mgmt.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginBody loginBody) {
        return userService.authenticateUser(loginBody);
    }
    
} 
