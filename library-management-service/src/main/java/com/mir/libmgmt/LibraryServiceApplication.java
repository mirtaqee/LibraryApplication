package com.mir.libmgmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(LibraryServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Starting Library Service...");
		SpringApplication.run(LibraryServiceApplication.class, args);
	}
}
