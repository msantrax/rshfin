package com.opus.rshfin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RshfinApplication {

	private static final Logger log = LoggerFactory.getLogger(RshfinApplication.class);

	public static void main(String[] args) {

		System.setProperty("illegal-access", "deny");

		log.info("Application is booting ......");
		SpringApplication.run(RshfinApplication.class, args);

	}

}
