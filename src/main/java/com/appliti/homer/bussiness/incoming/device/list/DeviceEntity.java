package com.appliti.homer.bussiness.incoming.device.list;

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
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "DeviceEntity")
@Table(name = "device")
class DeviceEntity {

    @Id
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

    DeviceResponse toDeviceResponse() {
        return DeviceResponse.builder()
                             .id(id)
                             .idx(idx)
                             .name(name)
                             .description(description)
                             .homeId(homeId)
                             .creationDate(metadata.getCreationDate())
                             .modificationDate(metadata.getModificationDate())
                             .build();
    }
}
