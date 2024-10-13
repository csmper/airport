package com.suhas.airport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false) // Optional: If you want to apply it to all JSONB columns
public class JsonbConverter implements AttributeConverter<Object, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        try {
            return attribute == null ? null : objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting to JSONB", e);
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            return dbData == null ? null : objectMapper.readValue(dbData, Object.class); // Replace Object.class with your target class
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting from JSONB", e);
        }
    }
}
