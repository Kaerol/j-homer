package com.appliti.homer.bussiness.incoming.event.create;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.appliti.homer.bussiness.incoming.device.single.SingleDeviceFacade;
import com.appliti.homer.bussiness.incoming.device.single.SingleDeviceResponse;

@Service
@RequiredArgsConstructor
class CreateEventService {

    private final SingleDeviceFacade singleDeviceFacade;
    private final CreateEventRepository repository;

    CreateEventEntity createEvent(final CreateEventRequest body) {
        final SingleDeviceResponse device = singleDeviceFacade.getDevice(body.getIdx());

        final CreateEventEntity createEventEntity = CreateEventEntity.builder()
                                                                     .idx(body.getIdx())
                                                                     .deviceId(device.getId())
                                                                     .description(body.getDescription())
                                                                     .value(body.getValue())
                                                                     .lastUpdate(body.getLastUpdate())
                                                                     .build();
        return repository.save(createEventEntity);
    }
}
