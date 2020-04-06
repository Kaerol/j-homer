package com.appliti.homer.bussiness.incoming.user.login;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import com.appliti.homer.infractruture.persistence.HashConverter;
import com.appliti.homer.infractruture.persistence.UserStatus;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "UserEntity")
@Table(name = "`user`")
class UserEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String login;

    @Column(updatable = false)
    @Convert(converter = HashConverter.class)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserStatus status;

    @Column
    @Type(type = "uuid-char")
    private UUID token;

    @Column
    @Type(type = "uuid-char")
    private UUID homeId;

    public void login() {
        token = UUID.randomUUID();
    }

    LoginResponse toLoginResponse() {
        return LoginResponse.builder()
                            .token(token)
                            .build();
    }
}
