package com.appliti.homer.bussiness.incoming.event.list;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appliti.homer.infractruture.http.RequestPage;
import com.appliti.homer.infractruture.http.ResponsePage;

@Api(tags = "events")
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
class GetEventsEndpoint {

    private final GetEventsService getEventsService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/events")
    ResponsePage<GetEventResponse> getEvents(@ModelAttribute final GetEventFilterRequest eventFilter,
                                             @ModelAttribute final RequestPage requestPage) {
        return getEventsService.getEvents(eventFilter, requestPage.toPageable());
    }
}
