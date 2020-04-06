package com.appliti.homer.bussiness.incoming.user.register;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;
import java.util.UUID;

@ToString
@Getter
@ApiModel(value = "CardCreateInitData",
          description = "Details about initialized card card",
          parent = AbstractHome.class)
@EqualsAndHashCode(callSuper = true)
class ExistedHome extends AbstractHome {

    @ApiModelProperty(notes = "Home id", example = "id")
    private UUID id;

    @Override
    public Optional<UUID> getHomeId() {
        return Optional.of(id);
    }
}
