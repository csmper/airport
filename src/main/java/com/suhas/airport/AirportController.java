package com.suhas.airport;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("airport/v1")
@RequiredArgsConstructor
@Validated
public class AirportController {
    private final AirportService airportService;

    @SuppressWarnings("unused")
    @GetMapping("/")
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok().body(airportService.getAllAirports());
    }
}
