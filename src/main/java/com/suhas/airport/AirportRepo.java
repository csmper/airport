package com.suhas.airport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, String> {
}
