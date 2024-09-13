package com.whereq.common.utils;

import java.io.IOException;

import jakarta.annotation.Resource;
import jakarta.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class StringToTypeConverter<T> implements AttributeConverter<T, String> {

    private TypeReference<T> typeReference;

    @Resource
    private ObjectMapper objectMapper;
	
    protected StringToTypeConverter(TypeReference<T> typeReference2) {
		this.typeReference = typeReference2;
	}

	@Override
    public String convertToDatabaseColumn(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public T convertToEntityAttribute(String json) {
        try {	
            return objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
		} 
    }
}