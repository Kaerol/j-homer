package com.appliti.homer.bussiness.incoming.user.logout;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class LogoutService implements LogoutFacade {

    private final UserLogoutRepository repository;

    @Override
    public void logout(final String authorization) {
        repository.findByToken(UUID.fromString(authorization))
                  .ifPresent(u -> logoutUser(u));
    }

    @Override
    public void logoutByLogin(final String login) {
        repository.findByLogin(login)
                  .ifPresent(u -> logoutUser(u));
    }

    private void logoutUser(final UserLogoutEntity userEntity) {
        userEntity.logout();
        repository.save(userEntity);
    }
}
