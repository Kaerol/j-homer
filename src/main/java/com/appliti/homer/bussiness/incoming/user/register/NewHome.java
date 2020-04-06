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
class NewHome extends AbstractHome {

    @ApiModelProperty(notes = "Home Name", example = "namePassword")
    private String name;

    @ApiModelProperty(notes = "City", example = "city")
    private String city;

    @ApiModelProperty(notes = "Street", example = "street")
    private String street;

    @ApiModelProperty(notes = "Number", example = "number")
    private String number;

    @Override
    public Optional<UUID> getHomeId() {
        return Optional.empty();
    }
}
