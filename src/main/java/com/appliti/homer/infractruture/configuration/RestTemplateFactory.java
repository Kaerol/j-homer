package com.appliti.homer.infractruture.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Configuration
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class RestTemplateFactory {

    private final ObjectMapper objectMapper;

    @Bean
    public RestTemplate createRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        final List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        final MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        messageConverters.add(jsonConverter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
