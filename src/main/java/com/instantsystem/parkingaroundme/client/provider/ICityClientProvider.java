package com.instantsystem.parkingaroundme.client.provider;

import com.instantsystem.parkingaroundme.client.dto.ICityParkingDto;

public interface ICityClientProvider {
    String getCityName();
    ICityParkingDto getParkings();
}
