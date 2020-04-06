package com.appliti.homer.bussiness.incoming.user.register;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
class RegisterEndpoint {

    private final RegisterService registerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "users/register")
    RegisterResponse register(@RequestBody final RegisterRequest body) {
        return registerService.register(body);
    }
}
