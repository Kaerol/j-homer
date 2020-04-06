package com.appliti.homer.bussiness.incoming.user.register;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = NewHome.class, name = "NEW"),
                @JsonSubTypes.Type(value = ExistedHome.class, name = "EXISTED") })
@interface AbstractHomeData {

}
