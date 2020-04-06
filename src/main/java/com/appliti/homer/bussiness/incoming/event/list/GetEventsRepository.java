package com.appliti.homer.bussiness.incoming.event.list;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.appliti.homer.infractruture.persistence.ReadOnlyRepository;

import java.util.UUID;

@Repository
@Transactional(propagation = Propagation.NEVER)
interface GetEventsRepository extends ReadOnlyRepository<GetEventsEntity, UUID> {

}
