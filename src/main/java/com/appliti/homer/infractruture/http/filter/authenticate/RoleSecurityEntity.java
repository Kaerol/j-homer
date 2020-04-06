package com.appliti.homer.infractruture.http.filter.authenticate;

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
@Entity(name = "RoleSecurityEntity")
@Table(name = "`role`")
class RoleSecurityEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String role;
}
