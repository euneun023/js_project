package com.example.boardPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties
//@ComponentScan(basePackages = "com.example.boardPage")  // 필요한 패키지를 스캔하도록 설정
@ComponentScan(basePackages = "com.example.boardPage")
public class BoardPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardPageApplication.class, args);
		System.out.println("hi");
	}

}
