package com.whereq.common.audit;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.common.audit.entity.AuditRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditUtil {
	private AuditUtil(){}

	static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


	protected static TypeReference<Map<String, Object>> typeFormList = new TypeReference<Map<String, Object>>() {};

	public static <T> T getFromObject(String str, Class<T> clazz) {
		try {
			return mapper.readValue(str, clazz);
		} catch (Exception e) {
			log.error("(getFromObject) Error while parsing the db data : ", e.fillInStackTrace());
			return null;
		}
	}

	public static <T> T getFromObject(String str, TypeReference<T> clazz) {
		try {
			return mapper.readValue(str, clazz);
		} catch (Exception e) {
			log.error("(getFromObject) Error while parsing the db data : ", e.fillInStackTrace());
			return null;
		}
	}

	public static <T> T getFromObject(String str, String clazzName) {
		try {
			TypeReference<T> clazz = new TypeReference<T>(){
				@Override
				public Type getType() {
					try {
						return Class.forName(clazzName).getGenericSuperclass();
					} catch (ClassNotFoundException e) {
						return String.class.getGenericSuperclass();
					}
				}
			}; 
			return mapper.readValue(str, clazz);
		} catch (Exception e) {
			log.error("(getFromObject) Error while parsing the db data : ", e.fillInStackTrace());
			return null;
		}
	}

	public static AuditRecord getFromObject(String clazzNm, Object entity, Long idNbr) {
		AuditRecord audit = new AuditRecord();
		audit.setRecordIdNbr(idNbr);
		audit.setRecordTypeCd(clazzNm);
		audit.setAuditRecordData(getStringAsObject(entity));
		audit.setTransactionNbr(Instant.now().toEpochMilli());
		return audit;
	}

	public static String getStringAsObject(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("(convertToEntityAttribute) Error while parsing the db data : ", e.fillInStackTrace());
			return null;
		}
	}

}
