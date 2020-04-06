package com.appliti.homer.bussiness.incoming.home;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class GetHomeResponse {

    private final UUID id;
    private final String name;
    private final String city;
    private final String street;
    private final String number;
}
