package com.appliti.homer.bussiness.incoming.user.register;

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
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "RoleRegisterEntity")
@Table(name = "`role`")
class RoleRegisterEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String role;

    @PrePersist
    void prePersist() {
        id = UUID.randomUUID();
    }
}
