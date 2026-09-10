package com.instantsystem.parkingaroundme.client.dto.Poitiers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.instantsystem.parkingaroundme.client.dto.ICityParkingDto;

import java.time.OffsetDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PoitiersParkingsDto(
    @JsonProperty("total")
    Integer total,

    @JsonProperty("results")
    List<PoitiersParkingRecord> results
)  implements ICityParkingDto {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record PoitiersParkingRecord(
                @JsonProperty("Id")
                Integer id,

                @JsonProperty("Nom")
                String nom,

                @JsonProperty("Capacite")
                Integer capacite,

                @JsonProperty("Places")
                Integer places,

                @JsonProperty("taux_doccupation")
                Double tauxDoccupation,

                @JsonProperty("_geopoint")
                String geopoint,

                @JsonProperty("Dernière_mise_à_jour_Base")
                OffsetDateTime derniereMiseAJourBase
        ) {
            public Double latitude() {
                if (geopoint == null || !geopoint.contains(",")) return null;
                try {
                    return Double.parseDouble(geopoint.split(",")[0].trim());
                } catch (NumberFormatException e) {
                    return null;
                }
            }

            public Double longitude() {
                if (geopoint == null || !geopoint.contains(",")) return null;
                try {
                    return Double.parseDouble(geopoint.split(",")[1].trim());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

}
