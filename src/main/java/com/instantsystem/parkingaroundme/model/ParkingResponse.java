package com.instantsystem.parkingaroundme.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ParkingResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-10T15:10:34.653585300+02:00[Europe/Paris]", comments = "Generator version: 7.5.0")
public class ParkingResponse {

  private String id;

  private String name;

  private Integer capacity;

  private Integer availablePlaces;

  private Integer distanceInMeters = null;

  private Double latitude = null;

  private Double longitude = null;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastUpdated = null;

  public ParkingResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParkingResponse(String id, String name, Integer capacity, Integer availablePlaces) {
    this.id = id;
    this.name = name;
    this.capacity = capacity;
    this.availablePlaces = availablePlaces;
  }

  public ParkingResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of the Parking
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "1", description = "Id of the Parking", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ParkingResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Parking
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "NOTRE DAME", description = "Name of the Parking", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ParkingResponse capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Total Sum of places
   * @return capacity
  */
  @NotNull 
  @Schema(name = "capacity", example = "146", description = "Total Sum of places", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("capacity")
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public ParkingResponse availablePlaces(Integer availablePlaces) {
    this.availablePlaces = availablePlaces;
    return this;
  }

  /**
   * Available Sum of places
   * @return availablePlaces
  */
  @NotNull 
  @Schema(name = "availablePlaces", example = "74", description = "Available Sum of places", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("availablePlaces")
  public Integer getAvailablePlaces() {
    return availablePlaces;
  }

  public void setAvailablePlaces(Integer availablePlaces) {
    this.availablePlaces = availablePlaces;
  }

  public ParkingResponse distanceInMeters(Integer distanceInMeters) {
    this.distanceInMeters = distanceInMeters;
    return this;
  }

  /**
   * Distance Calculated in meters
   * @return distanceInMeters
  */
  
  @Schema(name = "distanceInMeters", example = "146", description = "Distance Calculated in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distanceInMeters")
  public Integer getDistanceInMeters() {
    return distanceInMeters;
  }

  public void setDistanceInMeters(Integer distanceInMeters) {
    this.distanceInMeters = distanceInMeters;
  }

  public ParkingResponse latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * GPS Latitude
   * @return latitude
  */
  
  @Schema(name = "latitude", example = "46.583498", description = "GPS Latitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("latitude")
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public ParkingResponse longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * GPS Longitude
   * @return longitude
  */
  
  @Schema(name = "longitude", example = "0.345002", description = "GPS Longitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("longitude")
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public ParkingResponse lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * last update Date
   * @return lastUpdated
  */
  @Valid 
  @Schema(name = "lastUpdated", example = "2026-09-09T19:21:02Z", description = "last update Date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastUpdated")
  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParkingResponse parkingResponse = (ParkingResponse) o;
    return Objects.equals(this.id, parkingResponse.id) &&
        Objects.equals(this.name, parkingResponse.name) &&
        Objects.equals(this.capacity, parkingResponse.capacity) &&
        Objects.equals(this.availablePlaces, parkingResponse.availablePlaces) &&
        Objects.equals(this.distanceInMeters, parkingResponse.distanceInMeters) &&
        Objects.equals(this.latitude, parkingResponse.latitude) &&
        Objects.equals(this.longitude, parkingResponse.longitude) &&
        Objects.equals(this.lastUpdated, parkingResponse.lastUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, capacity, availablePlaces, distanceInMeters, latitude, longitude, lastUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParkingResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    availablePlaces: ").append(toIndentedString(availablePlaces)).append("\n");
    sb.append("    distanceInMeters: ").append(toIndentedString(distanceInMeters)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

