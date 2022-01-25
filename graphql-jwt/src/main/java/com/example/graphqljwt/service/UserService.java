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
}
