package com.instantsystem.parkingaroundme.service;

import com.instantsystem.parkingaroundme.model.ParkingListResponse;


public interface IParkingservice {
    ParkingListResponse getNearbyParkings(String city, Double latitude, Double longitude, Integer radiusInMeters);
}