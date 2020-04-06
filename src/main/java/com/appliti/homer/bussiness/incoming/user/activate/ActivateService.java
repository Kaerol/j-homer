package com.appliti.homer.bussiness.incoming.user.activate;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class ActivateService {

    private final ActivateRepository repository;

    ActivateEntity activate(final UUID userId, final String token) {
        final Optional<ActivateEntity> userEntity = repository.findById(userId);

        final ActivateEntity activateEntity = userEntity.orElseThrow(() -> new EntityNotFoundException("User not "
                                                                                                       + "found"));

        if (activateEntity.getRegisterToken()
                          .equals(token)) {
            activateEntity.setActive();
            repository.save(activateEntity);
            return activateEntity;
        } else {
            throw new IllegalStateException("Activation token does not match.");
        }
    }
}
