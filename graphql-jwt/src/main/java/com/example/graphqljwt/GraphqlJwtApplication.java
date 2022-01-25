package com.example.graphqljwt;

import com.example.graphqljwt.entity.UserEntity;
import com.example.graphqljwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GraphqlJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlJwtApplication.class, args);
	}

	@Autowired
	private UserRepo userRepo;
}
