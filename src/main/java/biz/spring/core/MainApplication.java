package biz.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebSecurity
public class MainApplication {

    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        logger.info("SpringApplication.run...");
        SpringApplication.run(MainApplication.class, args);
        logger.info("SpringApplication.run...Ok");

    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        MainApplication.applicationContext = applicationContext;
    }
}
