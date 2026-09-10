package com.instantsystem.parkingaroundme.service.Impl;

import com.instantsystem.parkingaroundme.client.dto.ICityParkingDto;
import com.instantsystem.parkingaroundme.client.provider.CityClientFactory;
import com.instantsystem.parkingaroundme.client.provider.ICityClientProvider;
import com.instantsystem.parkingaroundme.mapper.ParkingMapper;
import com.instantsystem.parkingaroundme.model.ParkingListResponse;
import com.instantsystem.parkingaroundme.model.ParkingResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParkingServiceImplTest {

    @Mock
    CityClientFactory cityClientFactory;

    @Mock
    ICityClientProvider provider;

    @Mock
    ParkingMapper mapper;

    @Mock
    ICityParkingDto dto;

    ParkingServiceImpl service;

    @BeforeEach
    void setup() {
        when(mapper.getCityName()).thenReturn("POITIERS");
        when(cityClientFactory.getProvider("poitiers")).thenReturn(provider);
        service = new ParkingServiceImpl(cityClientFactory, List.of(mapper));
    }

    @Test
    void getNearbyParkingsTest() {
        // two parkings at different coords
        ParkingResponse p1 = new ParkingResponse("1", "A", 100, 10).latitude(46.5802).longitude(0.3401);
        ParkingResponse p2 = new ParkingResponse("2", "B", 50, 5).latitude(46.5902).longitude(0.3501);

        ParkingListResponse mapped = new ParkingListResponse().total(2).parkings(List.of(p2, p1));

        when(provider.getParkings()).thenReturn(dto);
        when(mapper.toParkingListResponse(dto)).thenReturn(mapped);

        ParkingListResponse out = service.getNearbyParkings("poitiers", 46.5802, 0.3401, 2000);

        assertNotNull(out);
        assertEquals(2, out.getTotal());
        assertEquals(2, out.getParkings().size());

        // distances must be set and sorted so first is p1 (distance 0)
        ParkingResponse first = out.getParkings().get(0);
        ParkingResponse second = out.getParkings().get(1);

        assertNotNull(first.getDistanceInMeters());
        assertNotNull(second.getDistanceInMeters());
        assertTrue(first.getDistanceInMeters() <= second.getDistanceInMeters());
    }
}
