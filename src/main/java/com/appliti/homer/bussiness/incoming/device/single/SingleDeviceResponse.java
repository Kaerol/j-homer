package com.appliti.homer.bussiness.incoming.device.single;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SingleDeviceResponse {

    private final UUID id;
    private final String idx;
    private final String name;
    private final String description;
    private final UUID homeId;
    private final ZonedDateTime creationDate;
    private final ZonedDateTime modificationDate;
}
