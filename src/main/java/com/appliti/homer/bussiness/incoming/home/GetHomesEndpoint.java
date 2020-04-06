package com.appliti.homer.bussiness.incoming.home;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
class GetHomesEndpoint {

    private final GetHomesService getHomesService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/homes")
    List<GetHomeResponse> getHomes() {
        final List<GetHomeEntity> homes = getHomesService.getHomes();

        return homes.stream()
                    .map(GetHomeEntity::toGetHomeResponse)
                    .collect(Collectors.toList());
    }
}
