package com.appliti.homer.bussiness.incoming.user.activate;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ActivateEndpoint {

    private final ActivateService activateService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "users/{userId}")
    public ActivateResponse activate(@PathVariable final UUID userId, @RequestParam final String token) {
        final ActivateEntity eventEntity = activateService.activate(userId, token);
        return eventEntity.toActivateResponse();
    }
}
