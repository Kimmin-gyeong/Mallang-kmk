package com.smhrd.malang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //auditing 기능활성화 (엔티티)
@SpringBootApplication
public class MalangApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalangApplication.class, args);
	}

}
