package com.appliti.homer.bussiness.incoming.user.login;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appliti.homer.infractruture.persistence.UserStatus;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class LoginService {

    private final UserRepository repository;

    @Transactional
    LoginResponse login(final LoginRequest body) {
        final Optional<UserEntity> optionalUserEntity = repository.findByLoginAndPasswordAndStatus(body.getLogin(),
                                                                                                   body.getPassword(),
                                                                                                   UserStatus.ACTIVE);
        final UserEntity userEntity = optionalUserEntity.orElseThrow(() -> new EntityNotFoundException(
                "Login or/and password not found"));

        userEntity.login();
        repository.save(userEntity);

        return userEntity.toLoginResponse();
    }
}
