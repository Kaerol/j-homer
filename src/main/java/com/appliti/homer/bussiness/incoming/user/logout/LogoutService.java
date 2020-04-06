package com.appliti.homer.bussiness.incoming.user.logout;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class LogoutService {

    private final UserLogoutRepository repository;

    void logout(final String authorization) {
        final UserLogoutEntity userEntity = repository.findByToken(UUID.fromString(authorization))
                                                      .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userEntity.logout();

        repository.save(userEntity);
    }
}
