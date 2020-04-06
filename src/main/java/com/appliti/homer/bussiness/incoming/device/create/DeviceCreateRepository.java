package com.appliti.homer.bussiness.incoming.device.create;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DeviceCreateRepository extends JpaRepository<DeviceCreateEntity, Long> {

}
