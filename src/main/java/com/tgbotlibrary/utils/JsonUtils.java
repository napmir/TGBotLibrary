package com.tgbotlibrary.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import com.tgbotlibrary.response.TGResponse;

public class JsonUtils {

	private static final Logger LOG = Logger.getLogger(JsonUtils.class);

	public static TGResponse<?> parseJsonResponse(final String jsonResponse, final Class<?> resultTypeClass) {
		try {
			
			JavaType javaType = MapperHandler.INSTANCE.getObjectMapper().getTypeFactory()
					.constructParametricType(TGResponse.class, resultTypeClass);
			
			final TGResponse<?> telegramResponse = (TGResponse<?>) MapperHandler.INSTANCE.getObjectMapper()
					.readValue(jsonResponse, javaType);

			if(telegramResponse != null && telegramResponse.getOk() && !telegramResponse.getResult().isEmpty()){
				LOG.warn(jsonResponse);
			}
			
			return telegramResponse;

		} catch (IOException e) {
			LOG.error("something wrong parsing json...", e);
		}

		return null;
	}

	public enum MapperHandler {
		INSTANCE;

		private ObjectMapper objectMapper;

		private MapperHandler() {
			initMapper();
		}

		private void initMapper() {
			objectMapper = new ObjectMapper();
			objectMapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		}

		public ObjectMapper getObjectMapper() {
			if (objectMapper == null) {
				initMapper();
			}
			return objectMapper;
		}

	}

}
