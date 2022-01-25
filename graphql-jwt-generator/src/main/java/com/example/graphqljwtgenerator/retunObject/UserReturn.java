package com.example.graphqljwtgenerator.retunObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReturn {
    private String username;
    private String password;
    private String jwt;
}
