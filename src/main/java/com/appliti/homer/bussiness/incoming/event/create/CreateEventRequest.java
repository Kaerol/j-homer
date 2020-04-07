package com.appliti.homer.bussiness.incoming.event.create;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class CreateEventRequest {

    @ApiModelProperty(notes = "Device idx", example = "4")
    private String idx;

    @ApiModelProperty(notes = "Event description", example = "Czujka salon")
    private String description;

    @ApiModelProperty(notes = "Event value", example = "On")
    private String value;

    @ApiModelProperty(notes = "Event subject", example = "2020-03-25 22:48:25")
    private String lastUpdate;
}
