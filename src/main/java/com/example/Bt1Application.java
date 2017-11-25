package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.service.MathService;

@SpringBootApplication
public class Bt1Application {
    
	@Autowired
	private MathService mathService;
	public static void main(String[] args) {
		SpringApplication.run(Bt1Application.class, args);
	}
	
	//：这个方法会在应用程序启动后首先被调用。
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			System.out.println("Hello, Spring Boot!");
			Stream<Long> fs = mathService.factorialStream();
			fs.limit(10).forEach(System.out::println);
		};
	}
	
}
