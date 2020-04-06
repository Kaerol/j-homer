package com.appliti.homer.bussiness.incoming.user.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface HomeRepository extends JpaRepository<HomeEntity, UUID> {

}
