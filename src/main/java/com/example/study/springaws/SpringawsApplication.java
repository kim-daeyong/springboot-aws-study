package com.example.study.springaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing // JPA auditing 활성화
@SpringBootApplication
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringawsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringawsApplication.class, args);
	}

}
