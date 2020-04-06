package com.appliti.homer.bussiness.incoming.device.list;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class DevicesService {

    private final DevicesRepository repository;

    List<DeviceEntity> getDevices() {
        return repository.findAll();
    }
}
