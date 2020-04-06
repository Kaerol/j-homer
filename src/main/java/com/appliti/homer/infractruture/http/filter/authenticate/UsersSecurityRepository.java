package com.appliti.homer.infractruture.http.filter.authenticate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.appliti.homer.infractruture.persistence.ReadOnlyRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(propagation = Propagation.NEVER)
public interface UsersSecurityRepository extends ReadOnlyRepository<UserSecurityEntity, UUID> {

    Optional<UserSecurityEntity> findByToken(String token);
}
