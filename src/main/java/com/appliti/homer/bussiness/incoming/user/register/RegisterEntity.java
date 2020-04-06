package com.appliti.homer.bussiness.incoming.user.register;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

import com.appliti.homer.infractruture.persistence.HashConverter;
import com.appliti.homer.infractruture.persistence.UserStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "RegisterEntity")
@Table(name = "`user`")
class RegisterEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String login;

    @Column
    @Convert(converter = HashConverter.class)
    private String password;

    @Column
    private String mail;

    @Column
    private String registerToken;

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserStatus status;

    @Column
    @Type(type = "uuid-char")
    private UUID homeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private RoleRegisterEntity role;

    @PrePersist
    void prePersist() {
        id = UUID.randomUUID();
    }
}
