
package com.instantsystem.parkingaroundme.client.provider.Poitiers;

import com.instantsystem.parkingaroundme.client.DynamicCityParkingClient;
import com.instantsystem.parkingaroundme.client.dto.Poitiers.PoitiersParkingsDto;
import com.instantsystem.parkingaroundme.client.provider.ICityClientProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class PoitiersClientProvider implements ICityClientProvider {

    private final DynamicCityParkingClient feignClient;
    private final URI poitiersApiUrl;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    public PoitiersClientProvider(
            DynamicCityParkingClient feignClient,
            com.fasterxml.jackson.databind.ObjectMapper objectMapper,
            @Value("${cities.poitiers.url:https://data.grandpoitiers.fr/data-fair/api/v1/datasets/mobilites-stationnement-des-parkings-en-temps-reel/lines}") String url) {
        this.feignClient = feignClient;
        this.objectMapper = objectMapper;
        this.poitiersApiUrl = URI.create(url);
    }

    @Override
    public String getCityName() {
        return "POITIERS";
    }

    @Override
    public PoitiersParkingsDto getParkings() {
        try {
            String json = feignClient.getParkings(poitiersApiUrl);
            return objectMapper.readValue(json, PoitiersParkingsDto.class);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to retrieve or parse Poitiers parkings", e);
        }
    }

}
