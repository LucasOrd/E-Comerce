package com.ecomerce.ecomerce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EComerceApplication {

	final static Logger logger = LogManager.getLogger(EComerceApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(EComerceApplication.class, args);
	}

	private void runMe(String parameter) {
		if (logger.isDebugEnabled()) {
			logger.debug("This is debug : {} ", parameter);
		}

		if (logger.isInfoEnabled()) {
			logger.info("This is info : {} ", parameter);
		}

		logger.warn("This is warn : {} ", parameter);
		logger.error("This is error : {} ", parameter);
	}

}
