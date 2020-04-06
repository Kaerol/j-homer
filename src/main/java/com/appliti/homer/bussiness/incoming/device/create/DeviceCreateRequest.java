package com.appliti.homer.bussiness.incoming.device.create;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
class DeviceCreateRequest {

    @ApiModelProperty(notes = "Device idx", example = "6")
    private String idx;

    @ApiModelProperty(notes = "Device name", example = "name")
    private String name;

    @ApiModelProperty(notes = "Device description", example = "description")
    private String description;

    @ApiModelProperty(notes = "Home id", example = "id")
    private UUID homeId;
}
