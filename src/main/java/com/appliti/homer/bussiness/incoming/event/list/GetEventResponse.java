package com.appliti.homer.bussiness.incoming.event.list;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class GetEventResponse {

    private final UUID id;
    private final GetDeviceResponse device;
    private final String description;
    private final String value;
    private final String lastUpdate;
    private final ZonedDateTime creationDate;
}
