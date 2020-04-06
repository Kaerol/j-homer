package com.appliti.homer.bussiness.incoming.device.single;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class SingleDeviceService implements SingleDeviceFacade {

    private final SingleDeviceRepository repository;

    @Override
    public SingleDeviceResponse getDevice(final UUID deviceId) {
        final SingleDeviceEntity deviceEntity = repository.findById(deviceId)
                                                          .orElseThrow(() -> new EntityNotFoundException("Device not "
                                                                                                         + "found"));
        return deviceEntity.toDeviceResponse();
    }

    @Override
    public SingleDeviceResponse getDevice(final String idx) {
        final SingleDeviceEntity deviceEntity = repository.findByIdx(idx)
                                                          .orElseThrow(() -> new EntityNotFoundException("Device not "
                                                                                                         + "found"));
        return deviceEntity.toDeviceResponse();
    }
}
