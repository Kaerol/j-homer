package com.appliti.homer.bussiness.incoming.user.activate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface ActivateRepository extends JpaRepository<ActivateEntity, UUID> {

}
