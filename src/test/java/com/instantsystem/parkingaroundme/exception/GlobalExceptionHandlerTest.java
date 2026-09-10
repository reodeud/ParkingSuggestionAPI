package com.instantsystem.parkingaroundme.exception;

import com.instantsystem.parkingaroundme.controller.ParkingController;
import com.instantsystem.parkingaroundme.service.IParkingservice;
import io.swagger.v3.oas.annotations.Hidden;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ParkingController.class)
@Import(GlobalExceptionHandler.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IParkingservice parkingService;

    @Test
    @Hidden
    void wrongCityNameTest() throws Exception {
        when(parkingService.getNearbyParkings(eq("poitier"), isNull(), isNull(), any(Integer.class)))
                .thenThrow(new CityNotSupportedException("poitier"));

        mockMvc.perform(get("/api/v1/parkings").param("city", "poitier"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("The City 'poitier' is not supported."))
                .andExpect(jsonPath("$.error").value("Not Found"));
    }

    @Test
    void illigalStateExceptionTest() throws Exception {
        when(parkingService.getNearbyParkings(eq("poitiers"), isNull(), isNull(), any(Integer.class)))
                .thenThrow(new IllegalStateException("Upstream parsing failed"));

        mockMvc.perform(get("/api/v1/parkings").param("city", "poitiers"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.status").value(500))
                .andExpect(jsonPath("$.message").value("Error : Upstream parsing failed"));
    }
}
