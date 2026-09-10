package com.instantsystem.parkingaroundme.mapper;

import com.instantsystem.parkingaroundme.client.dto.Poitiers.PoitiersParkingsDto;
import com.instantsystem.parkingaroundme.model.ParkingListResponse;
import com.instantsystem.parkingaroundme.model.ParkingResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PoitiersParkingMapper implements ParkingMapper {

    public String getCityName() { return "POITIERS"; }

    @Override
    public ParkingListResponse toParkingListResponse(com.instantsystem.parkingaroundme.client.dto.ICityParkingDto dto) {
        if (dto == null) {
            return new ParkingListResponse().total(0).parkings(Collections.emptyList());
        }
        PoitiersParkingsDto poitiers = (PoitiersParkingsDto) dto;

        List<ParkingResponse> parkings = (poitiers.results() == null) ? Collections.emptyList() :
                poitiers.results().stream()
                        .map(this::toParkingResponse)
                        .toList();

        return new ParkingListResponse()
                .total(poitiers.total())
                .parkings(parkings);
    }

    private ParkingResponse toParkingResponse(PoitiersParkingsDto.PoitiersParkingRecord record) {
        if (record == null) {
            return null;
        }

        return new ParkingResponse(
                String.valueOf(record.id()),
                record.nom(),
                record.capacite(),
                record.places()
        )
                .latitude(record.latitude())
                .longitude(record.longitude())
                .lastUpdated(record.derniereMiseAJourBase());
    }

}