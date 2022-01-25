package com.example.graphqljwt.returnObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class UserReturn {
    private Integer id;
    private String username;
    private String password;
    private String jwt;
}
