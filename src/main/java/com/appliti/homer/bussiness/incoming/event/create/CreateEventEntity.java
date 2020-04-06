package com.appliti.homer.bussiness.incoming.event.create;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "CreateEventEntity")
@Table(name = "event")
class CreateEventEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    @Type(type = "uuid-char")
    private UUID deviceId;

    @Column
    private String idx;

    @Column
    private String description;

    @Column
    private String value;

    @Column
    private String lastUpdate;

    @Column
    private ZonedDateTime creationDate;

    CreateEventResponse toCreateEventResponse() {
        return CreateEventResponse.builder()
                                  .id(id)
                                  .build();
    }

    @PrePersist
    void prePersist() {
        id = UUID.randomUUID();
        creationDate = ZonedDateTime.now(ZoneOffset.UTC);
    }
}
