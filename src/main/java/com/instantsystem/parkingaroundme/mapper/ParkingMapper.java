package com.instantsystem.parkingaroundme.mapper;

import com.instantsystem.parkingaroundme.client.dto.ICityParkingDto;
import com.instantsystem.parkingaroundme.model.ParkingListResponse;

public interface ParkingMapper {
    String getCityName();
    ParkingListResponse toParkingListResponse(ICityParkingDto dto);
}