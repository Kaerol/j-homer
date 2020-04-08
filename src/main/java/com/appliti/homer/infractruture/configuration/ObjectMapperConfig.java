package com.appliti.homer.infractruture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ObjectMapperConfig {

    @Bean
    @Primary
    public static ObjectMapper getMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                     .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                     .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                     .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                     .setVisibility(mapper.getSerializationConfig()
                                          .getDefaultVisibilityChecker()
                                          .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                                          .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                                          .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                                          .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }
}
