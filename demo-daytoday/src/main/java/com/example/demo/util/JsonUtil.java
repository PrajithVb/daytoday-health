package com.example.demo.util;


import java.io.IOException;
import java.text.DateFormat;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class JsonUtil {

	

static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

	public static String deepSerialize(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		try {
		  String json = mapper.writeValueAsString(o);
		  return json;
		  //System.out.println(json);
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		   return null;
		}
	}

	public static <T> T getJackson2DeserializedObject(String json, Class<T> clazz, boolean failOnUnknownProps){
		if(StringUtils.hasText(json)){
			com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
			om.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProps);
			om.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
			
			try {
				return om.readValue(json, clazz);
			} catch (IOException e) {
				log.error("Invalid Json: " + json, e);
			}
		}
		return null;
	}

	public static <T> T getJackson2DeserializedObject(String json, Class<T> clazz, DateFormat dateFormat, boolean failOnUnknownProps){
		if(StringUtils.hasText(json)){
			com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
			om.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProps);
			om.setDateFormat(dateFormat);
			try {
				return om.readValue(json, clazz);
			} catch (IOException e) {
				e.printStackTrace();
				log.error("Invalid Json: " + json, e);
			}
		}
		return null;
	}
	public static String getJackson2SerializedObject(Object object, Include inclusion){
		com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
		om.setSerializationInclusion(inclusion);
		try {
			return om.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			log.error("Can't parse json", e.getMessage());
		} catch (JsonMappingException e) {
			log.error("Can't parse json", e.getMessage());
		} catch (IOException e) {
			log.error("Can't parse json", e.getMessage());
		}
		return "";
	}
	
	public static boolean isValidJSON(final String json) {
		boolean valid = false;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.readTree(json);
			valid = true;
		} catch (Exception jpe) {
			jpe.printStackTrace();
		}
		return valid;
	}
//	public static void main (String args[]) {
//		
//	}

}

