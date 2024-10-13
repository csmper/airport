package com.suhas.airport;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class PointConverter implements AttributeConverter<Point, String> {

    @Override
    public String convertToDatabaseColumn(Point point) {
        // Convert Point object to a String representation for the database
        return point != null ? point.getLat() + "," + point.getLon() : null;
    }

    @Override
    public Point convertToEntityAttribute(String dbData) {
        // Convert String representation from the database back to a Point object
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        String data = dbData.replace("(", "")
                            .replace(")", "");
        String[] coordinates = data.split(",");
        double lat = Double.parseDouble(coordinates[0]);
        double lon = Double.parseDouble(coordinates[1]);
        return new Point(lat, lon); // Using the new Point class
    }
}
