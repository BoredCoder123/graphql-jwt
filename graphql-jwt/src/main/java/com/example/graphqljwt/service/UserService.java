package com.example.graphqljwt.service;

import com.example.graphqljwt.entity.UserEntity;
import com.example.graphqljwt.repo.UserRepo;
import com.example.graphqljwt.returnObjects.UserReturn;
import com.example.graphqljwt.util.JwtUtil;
import io.jsonwebtoken.IncorrectClaimException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Log4j2
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

    public UserDetails loadByUsername(String username) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!((User) principal).getUsername().equals(username))
            throw new Exception("Jwt and username dont match");
        UserEntity user = userRepo.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Unable to find user");
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
