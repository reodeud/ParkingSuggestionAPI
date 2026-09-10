package com.instantsystem.parkingaroundme.service.Impl;

import com.instantsystem.parkingaroundme.client.dto.ICityParkingDto;
import com.instantsystem.parkingaroundme.client.provider.CityClientFactory;
import com.instantsystem.parkingaroundme.mapper.ParkingMapper;
import com.instantsystem.parkingaroundme.model.ParkingListResponse;
import com.instantsystem.parkingaroundme.model.ParkingResponse;
import com.instantsystem.parkingaroundme.service.IParkingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements IParkingservice {

    private final CityClientFactory cityClientFactory;
    private final Map<String, ParkingMapper> mapperByCity;

    @Autowired
    public ParkingServiceImpl(CityClientFactory cityClientFactory, List<ParkingMapper> mappers) {
        this.cityClientFactory = cityClientFactory;
        this.mapperByCity = mappers.stream().collect(Collectors.toMap(m -> m.getCityName().toUpperCase(), m -> m));
    }

    @Override
    public ParkingListResponse getNearbyParkings(String city, Double latitude, Double longitude, Integer radiusInMeters) {
        var provider = cityClientFactory.getProvider(city);
        ICityParkingDto dto = provider.getParkings();
        ParkingMapper mapper = mapperByCity.get(city.toUpperCase());
        if (mapper == null) throw new IllegalArgumentException("No mapper for city: " + city);

        ParkingListResponse response = mapper.toParkingListResponse(dto);

        if (latitude == null || longitude == null) {
            return response;
        }


        // compute distance for each parking
        List<ParkingResponse> parkings = response.getParkings();
        List<ParkingResponse> updated = parkings.stream()
                .filter(p -> p != null && p.getLatitude() != null && p.getLongitude() != null)
                .map(p -> {
                    int dist = computeDistanceMeters(latitude, longitude, p.getLatitude(), p.getLongitude());
                    p.setDistanceInMeters(dist);
                    return p;
                })
                .collect(Collectors.toList());

        // if radius provided, filter
        if (radiusInMeters != null) {
            updated = updated.stream().filter(p -> p.getDistanceInMeters() != null && p.getDistanceInMeters() <= radiusInMeters)
                    .collect(Collectors.toList());
        }

        // sort by distance asc
        updated.sort(Comparator.comparingInt(p -> p.getDistanceInMeters() == null ? Integer.MAX_VALUE : p.getDistanceInMeters()));

        ParkingListResponse out = new ParkingListResponse()
                .total(updated.size())
                .parkings(updated);

        return out;
    }

    private static int computeDistanceMeters(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371000d; // earth radius in meters
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double dLat = lat2Rad - lat1Rad;
        double dLon = Math.toRadians(lon2 - lon1);
        double x = dLon * Math.cos((lat1Rad + lat2Rad) / 2.0);
        double dist = Math.sqrt(x * x + dLat * dLat) * R;
        return (int) Math.round(dist);
    }
}
