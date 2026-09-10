package com.instantsystem.parkingaroundme.client;

import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

public interface ICityDataApiClient {

    // Pass the URL through Feign - return raw JSON to allow mapping to concrete DTO
    @GetMapping
    String getParkings(URI baseUrl);
}