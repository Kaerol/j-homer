package com.appliti.homer.infractruture.http.filter.authenticate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "UserSecurityEntity")
@Table(name = "`user`")
class UserSecurityEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String login;

    @Column(updatable = false)
    private String password;

    @Column
    private String token;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private RoleSecurityEntity role;

    CustomUserDetails toCustomUserDetails() {
        return CustomUserDetails.builder()
                                .id(id)
                                .login(login)
                                .password(password)
                                .token(token)
                                .role(role)
                                .build();
    }
}
