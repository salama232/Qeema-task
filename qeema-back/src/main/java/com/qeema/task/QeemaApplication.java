package com.qeema.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class QeemaApplication implements ApplicationRunner  {
    private static final Logger logger = LogManager.getLogger(QeemaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QeemaApplication.class, args);
	}


	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
					.allowedHeaders("*");
			}
		};
	}
	@Override
	 public void run(ApplicationArguments applicationArguments) throws Exception {
	        logger.debug("Test Debugging log");
	        logger.info("Test Info log");
	        logger.warn("Test warning!");
	        logger.error("Test Oops! We have an Error. OK");
	        logger.fatal("Test Damn! Fatal error. Please fix me.");
	    }
}
