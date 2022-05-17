package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SatyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatyaApplication.class, args);
		System.out.println("app started");
	}

}
