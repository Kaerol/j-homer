package com.appliti.homer.bussiness.incoming.user.logout;

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
@Entity(name = "UserLogoutEntity")
@Table(name = "`user`")
class UserLogoutEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    @Type(type = "uuid-char")
    private UUID token;

    void logout() {
        token = null;
    }
}
