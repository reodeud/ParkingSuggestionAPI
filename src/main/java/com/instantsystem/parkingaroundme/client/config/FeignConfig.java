package com.instantsystem.parkingaroundme.client.config;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {
    /**
     * Level Feign log.
     * NONE
     * BASIC
     * HEADERS
     * FULL
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * - ConnectTimeout: max established connexion ex 5
     * - ReadTimeout: max time to read the data ex 10
     */
    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(
                5, TimeUnit.SECONDS,   // Connect timeout
                10, TimeUnit.SECONDS,  // Read timeout
                true                   // Follow redirects
        );
    }

    /**
     * Retry Strategy
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 1000, 3);
    }
}
