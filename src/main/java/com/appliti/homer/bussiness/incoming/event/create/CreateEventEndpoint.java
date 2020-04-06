package com.appliti.homer.bussiness.incoming.event.create;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "events")
@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
class CreateEventEndpoint {

    private final CreateEventService createEventService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/events")
    CreateEventResponse createEvent(@RequestBody final CreateEventRequest body) {
        final CreateEventEntity eventEntity = createEventService.createEvent(body);
        return eventEntity.toCreateEventResponse();
    }
}
