package com.example.graphqljwt.service;

import com.example.graphqljwt.entity.UserEntity;
import com.example.graphqljwt.repo.UserRepo;
import com.example.graphqljwt.returnObjects.UserReturn;
import com.example.graphqljwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Unable to find user");
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserReturn login(String username, String password) throws Exception {
        UserReturn user = new UserReturn();
        UserEntity userFromDB = userRepo.findByUsername(username);
        if(userFromDB==null)
            throw new Exception("User not found");
        user.setId(userFromDB.getId());
        user.setUsername(userFromDB.getUsername());
        user.setPassword(userFromDB.getPassword());
        user.setJwt(jwtUtil.generateToken(new User(userFromDB.getUsername(), userFromDB.getPassword(), new ArrayList<>())));
        return user;
    }

//    public UserReturn register(String username, String password) throws Exception {
//        User user = userRepo.findByUsername(username);
//        if(user!=null)
//            throw new Exception("User already present");
//        user = new UserEntity();
//        user.setUsername(username);
//        user.setPassword(password);
//        UserDetails savedUser = userRepo.save(user);
//        String jwt = jwtUtil.generateToken(new User(savedUser.getUsername(), savedUser.getPassword()));
//        return new UserReturn(savedUser)
//    }
}
