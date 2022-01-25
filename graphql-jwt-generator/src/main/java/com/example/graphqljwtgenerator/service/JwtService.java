package com.example.graphqljwtgenerator.service;

import com.example.graphqljwtgenerator.entity.UserEntity;
import com.example.graphqljwtgenerator.repo.UserRepo;
import com.example.graphqljwtgenerator.retunObject.UserReturn;
import com.example.graphqljwtgenerator.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    public UserReturn login(String username, String password) throws Exception{
        UserEntity user = userRepo.findByUsernameAndPassword(username, password);
        if(user==null)
            throw new Exception("Bad credentials");
        return new UserReturn(user.getUsername(), user.getPassword(), jwtUtil.generateToken(user.getUsername()));
    }

    public UserReturn register(String username, String password) throws Exception{
        UserEntity user = userRepo.findByUsernameAndPassword(username, password);
        if(user!=null)
            throw new Exception("User already exists");
        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(password);
        UserEntity savedUser = userRepo.save(newUser);
        return new UserReturn(savedUser.getUsername(), savedUser.getPassword(), jwtUtil.generateToken(savedUser.getUsername()));
    }
}
