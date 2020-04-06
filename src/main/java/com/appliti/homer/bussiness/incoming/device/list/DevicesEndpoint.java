package com.appliti.homer.bussiness.incoming.device.list;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "devices")
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
class DevicesEndpoint {

    private final DevicesService devicesService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/devices")
    List<DeviceResponse> getDevices() {
        final List<DeviceEntity> events = devicesService.getDevices();

        return events.stream()
                     .map(DeviceEntity::toDeviceResponse)
                     .collect(Collectors.toList());
    }
}
