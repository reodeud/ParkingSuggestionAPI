package com.instantsystem.parkingaroundme.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.instantsystem.parkingaroundme.model.ParkingResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ParkingListResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-10T16:03:30.095292+02:00[Europe/Paris]", comments = "Generator version: 7.5.0")
public class ParkingListResponse {

  private Integer total;

  @Valid
  private List<@Valid ParkingResponse> parkings = new ArrayList<>();

  public ParkingListResponse total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  
  @Schema(name = "total", example = "9", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public ParkingListResponse parkings(List<@Valid ParkingResponse> parkings) {
    this.parkings = parkings;
    return this;
  }

  public ParkingListResponse addParkingsItem(ParkingResponse parkingsItem) {
    if (this.parkings == null) {
      this.parkings = new ArrayList<>();
    }
    this.parkings.add(parkingsItem);
    return this;
  }

  /**
   * Get parkings
   * @return parkings
  */
  @Valid 
  @Schema(name = "parkings", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parkings")
  public List<@Valid ParkingResponse> getParkings() {
    return parkings;
  }

  public void setParkings(List<@Valid ParkingResponse> parkings) {
    this.parkings = parkings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParkingListResponse parkingListResponse = (ParkingListResponse) o;
    return Objects.equals(this.total, parkingListResponse.total) &&
        Objects.equals(this.parkings, parkingListResponse.parkings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, parkings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParkingListResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    parkings: ").append(toIndentedString(parkings)).append("\n");
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

