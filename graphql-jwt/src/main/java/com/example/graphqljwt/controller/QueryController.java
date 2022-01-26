package com.example.graphqljwt.controller;

import com.example.graphqljwt.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class QueryController implements GraphQLQueryResolver {
    public String firstQuery() {
        return "abc";
    }

    @Autowired
    private UserService userService;

    public UserDetails getuser(String username) throws Exception {
        return userService.loadByUsername(username);
    }
}
