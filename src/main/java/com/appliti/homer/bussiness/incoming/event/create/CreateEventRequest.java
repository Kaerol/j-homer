package com.appliti.homer.bussiness.incoming.event.create;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class CreateEventRequest {

    @ApiModelProperty(notes = "Device idx", example = "idx")
    private String idx;

    @ApiModelProperty(notes = "Event description", example = "description")
    private String description;

    @ApiModelProperty(notes = "Event value", example = "value")
    private String value;

    @ApiModelProperty(notes = "Event subject", example = "lastupdate")
    private String lastUpdate;
}
