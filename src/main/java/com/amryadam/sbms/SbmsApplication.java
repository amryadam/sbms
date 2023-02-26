package com.amryadam.sbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SbmsApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SbmsApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository userRepository,PasswordEncoder encoder){
//		return args -> {
//			userRepository.save(new User("user",encoder.encode("password"),"USER"));
//			userRepository.save(new User("admin",encoder.encode("password"),"ADMIN"));
//		};
//	}

}

