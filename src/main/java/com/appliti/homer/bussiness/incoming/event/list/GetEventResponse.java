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
    private GetDeviceResponse device;
    private String idx;
    private String lastUpdate;
    private String description;
    private String value;
    private final ZonedDateTime creationDate;
}
