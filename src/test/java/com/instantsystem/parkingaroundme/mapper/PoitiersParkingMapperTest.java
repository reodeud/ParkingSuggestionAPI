package com.instantsystem.parkingaroundme.mapper;

import com.instantsystem.parkingaroundme.client.dto.Poitiers.PoitiersParkingsDto;
import com.instantsystem.parkingaroundme.model.ParkingListResponse;
import com.instantsystem.parkingaroundme.model.ParkingResponse;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoitiersParkingMapperTest {

    @Test
    void potierMapperTest() {

        ParkingListResponse resp = getParkingListResponse();

        assertNotNull(resp);
        assertEquals(1, resp.getTotal());
        assertNotNull(resp.getParkings());
        assertEquals(1, resp.getParkings().size());

        ParkingResponse p = resp.getParkings().get(0);
        assertEquals("1", p.getId());
        assertEquals("TEST NAME", p.getName());
        assertEquals(120, p.getCapacity());
        assertEquals(30, p.getAvailablePlaces());
        assertEquals(46.5802, p.getLatitude(), 1e-6);
        assertEquals(0.3401, p.getLongitude(), 1e-6);
        assertEquals(OffsetDateTime.parse("2026-09-09T19:21:02Z"), p.getLastUpdated());
    }

    private static ParkingListResponse getParkingListResponse() {
        PoitiersParkingsDto.PoitiersParkingRecord rec = new PoitiersParkingsDto.PoitiersParkingRecord(
                1,
                "TEST NAME",
                120,
                30,
                0.25,
                "46.5802, 0.3401",
                OffsetDateTime.parse("2026-09-09T19:21:02Z")
        );

        PoitiersParkingsDto dto = new PoitiersParkingsDto(1, List.of(rec));

        PoitiersParkingMapper mapper = new PoitiersParkingMapper();
        ParkingListResponse resp = mapper.toParkingListResponse(dto);
        return resp;
    }
}
