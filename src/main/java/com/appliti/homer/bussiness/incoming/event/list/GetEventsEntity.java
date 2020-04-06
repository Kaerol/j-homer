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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "GetEventsEntity")
@Table(name = "event")
class GetEventsEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "deviceId")
    private GetDeviceEntity deviceEntity;

    @Column
    private String description;

    @Column
    private String value;

    @Column
    private String lastUpdate;

    @Column
    private ZonedDateTime creationDate;

    GetEventResponse toCreateEventResponse() {
        return GetEventResponse.builder()
                               .id(id)
                               .device(deviceEntity.toGetDeviceResponse())
                               .description(description)
                               .value(value)
                               .lastUpdate(lastUpdate)
                               .creationDate(creationDate)
                               .build();
    }
}
