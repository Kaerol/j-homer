package com.appliti.homer.bussiness.incoming.user.register;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class RegisterResponse {

    private final UUID id;
    private final String token;
}
