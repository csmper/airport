package com.suhas.airport;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "airports_data")
public class Airport {
    @Id
    private String airport_code;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private Map<String, String> airport_name;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private Map<String, String> city;

    @Column(columnDefinition = "point")
    @Convert(converter = PointConverter.class)
    private Point coordinates;
    private String timezone;

}

