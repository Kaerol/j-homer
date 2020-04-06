package com.appliti.homer.bussiness.incoming.device.create;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "devices")
@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
class DeviceCreateEndpoint {

    private final DeviceCreateService deviceCreateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/devices")
    DeviceCreateResponse deviceCreate(@RequestBody final DeviceCreateRequest body) {
        final DeviceCreateEntity eventEntity = deviceCreateService.deviceCreate(body);
        return eventEntity.toDeviceCreateResponse();
    }
}
