package com.appliti.homer.infractruture.persistence;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Getter
@Embeddable
public class Metadata {

    private final ZonedDateTime creationDate;
    private final ZonedDateTime modificationDate;

    public Metadata() {
        creationDate = ZonedDateTime.now(ZoneOffset.UTC);
        modificationDate = ZonedDateTime.now(ZoneOffset.UTC);
    }
}
