package com;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DBClientApp {

    public static void main(String[] args) {
	SpringApplication.run(DBClientApp.class, args);
    }
}
