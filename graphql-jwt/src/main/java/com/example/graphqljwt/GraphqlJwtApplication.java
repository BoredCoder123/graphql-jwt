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

	@PostConstruct
	void init(){
		List<UserEntity> users = Stream.of(new UserEntity(1, "user1", "password"),
				new UserEntity(4, "user4", "password"),
				new UserEntity(3, "user3", "password"),
				new UserEntity(2, "user2", "password")
				).collect(Collectors.toList());

		userRepo.saveAll(users);
	}
}
