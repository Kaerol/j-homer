package com.appliti.homer.bussiness.incoming.device.list;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class DeviceFilterRequest {

    @ApiModelProperty(notes = "Event subject", example = "subject")
    private String subject;

    @ApiModelProperty(notes = "Event message", example = "message")
    private String message;

    @ApiModelProperty(notes = "Event priority", example = "priority")
    private String priority;
}
