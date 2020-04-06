package com.appliti.homer.bussiness.incoming.device.create;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class DeviceCreateResponse {

    private final UUID id;
}
