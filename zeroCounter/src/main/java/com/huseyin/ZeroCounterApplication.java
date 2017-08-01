package com.huseyin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZeroCounterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ZeroCounterApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hello world from command line");
	}
}
