package com.instantsystem.parkingaroundme.client;

import com.instantsystem.parkingaroundme.client.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "cityParkingClient",
        url = "http://localhost", // Feign need to have an initialized URL
        configuration = FeignConfig.class
)
public interface DynamicCityParkingClient extends ICityDataApiClient {
}
