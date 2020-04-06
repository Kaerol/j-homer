package com.appliti.homer.bussiness.incoming.device.single;

import java.util.UUID;

public interface SingleDeviceFacade {

    SingleDeviceResponse getDevice(UUID deviceId);

    SingleDeviceResponse getDevice(String idx);
}
