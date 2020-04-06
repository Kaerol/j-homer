package com.appliti.homer.bussiness.incoming.user.logout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface UserLogoutRepository extends JpaRepository<UserLogoutEntity, UUID> {

    Optional<UserLogoutEntity> findByToken(UUID authorization);
}
