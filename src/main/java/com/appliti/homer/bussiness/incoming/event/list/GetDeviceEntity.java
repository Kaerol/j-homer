package com.appliti.homer.bussiness.incoming.event.list;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "GetDeviceEntity")
@Table(name = "device")
class GetDeviceEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String idx;

    @Column
    private String name;

    GetDeviceResponse toGetDeviceResponse() {
        return GetDeviceResponse.builder()
                                .id(id)
                                .idx(idx)
                                .name(name)
                                .build();
    }
}
