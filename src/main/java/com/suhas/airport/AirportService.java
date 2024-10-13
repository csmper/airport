package com.suhas.airport;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirportService {
    private final AirportRepo airportRepo;

    public List<Airport> getAllAirports() {
        return airportRepo.findAll();
    }
}
