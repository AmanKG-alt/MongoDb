package com.mongoDB.MongoDb;

import com.mongoDB.MongoDb.models.User;
import com.mongoDB.MongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public MongoDbApplication(UserRepository userRepository){
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Save Couple of users if the collection is empty
		if(userRepository.findAll().isEmpty()){

			userRepository.save(new User("Aman", "Gupta"));
			userRepository.save(new User("Amit", "Gupta"));
			userRepository.save(new User("Sumit", "Gupta"));
		}

		//fetch all users
		for(User user: userRepository.findAll()){
			System.out.println(user);
		}

	}
}


//Implement CommnadLineRunner to Save and fetch a couple of users when the application is fully Started