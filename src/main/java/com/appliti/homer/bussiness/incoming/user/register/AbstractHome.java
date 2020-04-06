package com.appliti.homer.bussiness.incoming.user.register;

import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Optional;
import java.util.UUID;

@ApiModel(value = "CardOrderDetails",
          description = "One of the card order details data.",
          subTypes = { NewHome.class, ExistedHome.class })
@Getter
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = NewHome.class, name = "NEW"),
                @JsonSubTypes.Type(value = ExistedHome.class, name = "EXISTED") })
abstract class AbstractHome {

    public abstract Optional<UUID> getHomeId();
}
