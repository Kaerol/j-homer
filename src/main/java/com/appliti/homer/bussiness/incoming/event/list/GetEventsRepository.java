package com.appliti.homer.bussiness.incoming.event.list;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Repository
@Transactional(propagation = Propagation.NEVER)
interface GetEventsRepository extends Repository<GetEventsEntity, Long>, QuerydslPredicateExecutor<GetEventsEntity> {

}
