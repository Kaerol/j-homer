package com.appliti.homer.bussiness.incoming.device.create;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import com.appliti.homer.infractruture.persistence.Metadata;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "DeviceCreateEntity")
@Table(name = "device")
class DeviceCreateEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String idx;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Type(type = "uuid-char")
    private UUID homeId;

    @Embedded
    private Metadata metadata;

    DeviceCreateResponse toDeviceCreateResponse() {
        return DeviceCreateResponse.builder()
                                   .id(id)
                                   .build();
    }

    @PrePersist
    void prePersist() {
        id = UUID.randomUUID();
        metadata = new Metadata();
    }
}
