package com.appliti.homer.bussiness.incoming.user.activate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class ActivateResponse {

    private final UUID id;
}
