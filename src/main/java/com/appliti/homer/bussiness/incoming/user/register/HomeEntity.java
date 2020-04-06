package com.appliti.homer.bussiness.incoming.user.register;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "HomeEntity")
@Table(name = "home")
class HomeEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String city;

    @NotNull
    @Column
    private String street;

    @NotNull
    @Column
    private String number;

    @NotNull
    @Column
    private String token;

    @Builder
    public HomeEntity(final String name, final String city, final String street, final String number) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.number = number;
        token = RandomStringUtils.randomAlphabetic(50);
    }

    HomeResponse toHomeResponse() {
        return HomeResponse.builder()
                           .id(id)
                           .build();
    }

    @PrePersist
    void prePersist() {
        id = UUID.randomUUID();
    }
}
