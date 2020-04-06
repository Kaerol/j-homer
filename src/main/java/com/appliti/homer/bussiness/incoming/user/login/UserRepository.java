package com.appliti.homer.bussiness.incoming.user.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appliti.homer.infractruture.persistence.UserStatus;

import java.util.Optional;
import java.util.UUID;

@Repository
interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByLoginAndPasswordAndStatus(final String login,
                                                         final String password,
                                                         final UserStatus active);
}
