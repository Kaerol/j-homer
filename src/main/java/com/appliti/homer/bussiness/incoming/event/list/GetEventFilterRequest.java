package com.appliti.homer.bussiness.incoming.event.list;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
class GetEventFilterRequest {

    @ApiModelProperty(notes = "Device index", example = "1")
    private String deviceIdx;

    @ApiModelProperty(notes = "Device name", example = "Kitchen sensor")
    private String deviceName;

    @ApiModelProperty(notes = "Event description", example = "subject")
    private String description;

    @ApiModelProperty(notes = "Event value", example = "On")
    private String value;

    @ApiModelProperty(notes = "Event creation date after", example = "2020-03-26T00:00:00+00:00")
    private ZonedDateTime creationDateAfter;

    @ApiModelProperty(notes = "Event creation date before", example = "2020-01-31T23:59:59+00:00")
    private ZonedDateTime creationDateBefore;
}
