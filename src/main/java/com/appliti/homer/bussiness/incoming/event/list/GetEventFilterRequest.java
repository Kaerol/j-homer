package com.appliti.homer.bussiness.incoming.event.list;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class GetEventFilterRequest {

    @ApiModelProperty(notes = "Event subject", example = "subject")
    private String subject;

    @ApiModelProperty(notes = "Event message", example = "message")
    private String message;

    @ApiModelProperty(notes = "Event priority", example = "priority")
    private String priority;
}
