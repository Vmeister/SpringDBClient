package com;

import com.model.User;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DBClientApp {
    
    @Autowired
    UserRepository userRepository;
    
    public static void main(String[] args) {
	SpringApplication.run(DBClientApp.class, args);
    }
    
    /**@Bean
    public boolean initDatabase() {
        User user = new User("admin", "password", "ADMIN", true);
        User user2 = new User("user", "password", "USER", true);
        userRepository.delete(user);
        userRepository.delete(user2);
        userRepository.saveAndFlush(user);
        userRepository.saveAndFlush(user2);
        return true;
    }*/
}
