package com.appliti.homer.bussiness.incoming.event.list;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class GetDeviceResponse {

    private final UUID id;
    private final String idx;
    private final String name;
}
