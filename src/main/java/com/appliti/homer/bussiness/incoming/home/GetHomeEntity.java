package com.appliti.homer.bussiness.incoming.home;

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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "GetHomeEntity")
@Table(name = "home")
class GetHomeEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(updatable = false)
    private String name;

    @Column(updatable = false)
    private String city;

    @Column(updatable = false)
    private String street;

    @Column(updatable = false)
    private String number;

    @Column(updatable = false)
    private String token;

    GetHomeResponse toGetHomeResponse() {
        return GetHomeResponse.builder()
                              .id(id)
                              .name(name)
                              .city(city)
                              .street(street)
                              .number(number)
                              .build();
    }
}
