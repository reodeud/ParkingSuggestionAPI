package com.instantsystem.parkingaroundme.controller;

import com.instantsystem.parkingaroundme.api.ParkingsApi;
import com.instantsystem.parkingaroundme.model.ParkingListResponse;
import com.instantsystem.parkingaroundme.service.IParkingservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController implements ParkingsApi {

    private final IParkingservice parkingService;
    public ParkingController(IParkingservice parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public ResponseEntity<ParkingListResponse> getNearbyParkings(
            String city,
            Double latitude,
            Double longitude,
            Integer radiusInMeters
    ) {
        ParkingListResponse response = parkingService.getNearbyParkings(city, latitude, longitude, radiusInMeters);
        return ResponseEntity.ok(response);    }
}