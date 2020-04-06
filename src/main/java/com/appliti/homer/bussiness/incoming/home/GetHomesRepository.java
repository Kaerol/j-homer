package com.appliti.homer.bussiness.incoming.home;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.appliti.homer.infractruture.persistence.ReadOnlyRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(propagation = Propagation.NEVER)
interface GetHomesRepository extends ReadOnlyRepository<GetHomeEntity, UUID> {

    Optional<GetHomeEntity> findByToken(String token);
}
