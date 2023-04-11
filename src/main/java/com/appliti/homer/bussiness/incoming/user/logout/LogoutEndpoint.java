package com.appliti.homer.bussiness.incoming.user.logout;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
class LogoutEndpoint {

    private final LogoutFacade logoutFacade;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "users/logout")
    void logout(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authorization) {
        logoutFacade.logout(authorization);
    }
}
