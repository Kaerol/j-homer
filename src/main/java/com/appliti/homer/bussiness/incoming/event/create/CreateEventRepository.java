package com.appliti.homer.bussiness.incoming.event.create;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CreateEventRepository extends JpaRepository<CreateEventEntity, UUID> {

}
