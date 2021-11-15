package com.tp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TimeSheetApplication {
	private static final Logger l = LogManager.getLogger(TimeSheetApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TimeSheetApplication.class, args);
		l.info("Application started Woohoo");
	}

}
