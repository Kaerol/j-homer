package com.appliti.homer.bussiness.incoming.user.activate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import com.appliti.homer.infractruture.persistence.UserStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "ActivateEntity")
@Table(name = "`user`")
class ActivateEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String registerToken;

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserStatus status;

    void setActive() {
        status = UserStatus.ACTIVE;
    }

    ActivateResponse toActivateResponse() {
        return ActivateResponse.builder()
                               .id(id)
                               .build();
    }
}
