package com.example.graphqljwtgenerator.controller;

import com.example.graphqljwtgenerator.retunObject.UserReturn;
import com.example.graphqljwtgenerator.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/login/{username}/{password}")
    public UserReturn login(@PathVariable String username, @PathVariable String password) throws Exception {
        return jwtService.login(username, password);
    }

    @PostMapping("/register/{username}/{password}")
    public UserReturn register(@PathVariable String username, @PathVariable String password) throws Exception{
        return jwtService.register(username, password);
    }
}
