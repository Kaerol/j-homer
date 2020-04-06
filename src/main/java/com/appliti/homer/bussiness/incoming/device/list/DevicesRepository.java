package com.appliti.homer.bussiness.incoming.device.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional(Transactional.TxType.NEVER)
interface DevicesRepository extends JpaRepository<DeviceEntity, UUID> {

}
