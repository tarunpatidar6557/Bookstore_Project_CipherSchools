package com.example.demo.bookstoremanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BookstoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreManagementApplication.class, args);
	}

}
