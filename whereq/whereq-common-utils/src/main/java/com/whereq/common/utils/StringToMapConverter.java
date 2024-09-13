package com.whereq.common.utils;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.AttributeConverter;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StringToMapConverter implements AttributeConverter<Map<String, Object>, String> {
	ObjectMapper mapper = new ObjectMapper();
	protected static TypeReference<Map<String, Object>> typeMap = new TypeReference<Map<String, Object>>(){};

	@Override
	public String convertToDatabaseColumn(Map<String, Object> attribute) {
		if(attribute == null || attribute.isEmpty()) {
			return "";
		}
		
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			log.error("(convertToDatabaseColumn) Error while parsing the attribute : ", e.fillInStackTrace());
			return "";
		}
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String dbData) {
		if(!StringUtils.hasText(dbData)) {
			return new HashMap<>();
		}
		
		try {
			return mapper.readValue(dbData, typeMap);
		} catch (Exception e) {
			log.error("(convertToEntityAttribute) Error while parsing the db data : ", e.fillInStackTrace());
			return new HashMap<>();
		}
	}
	
}
