package com.marolix.Bricks99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="messages.properties")
public class Bricks99Application {

	public static void main(String[] args) {
		//System.out.println("program entry");
		SpringApplication.run(Bricks99Application.class, args);
	}

}
