package com.appliti.homer.infractruture.persistence;

import com.appliti.homer.bussiness.shared.HashingConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class HashConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(final String attribute) {
        return HashingConverter.hash(attribute);
    }

    @Override
    public String convertToEntityAttribute(final String dbData) {
        return dbData;
    }
}
