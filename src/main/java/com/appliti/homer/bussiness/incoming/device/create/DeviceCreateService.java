package com.appliti.homer.bussiness.incoming.device.create;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class DeviceCreateService {

    private final DeviceCreateRepository repository;

    @Transactional
    DeviceCreateEntity deviceCreate(final DeviceCreateRequest body) {
        final DeviceCreateEntity deviceEntity = DeviceCreateEntity.builder()
                                                                  .idx(body.getIdx())
                                                                  .homeId(body.getHomeId())
                                                                  .name(body.getName())
                                                                  .description(body.getDescription())
                                                                  .build();

        return repository.save(deviceEntity);
    }
}
