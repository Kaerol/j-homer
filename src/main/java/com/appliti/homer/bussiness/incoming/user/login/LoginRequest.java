package com.appliti.homer.bussiness.incoming.user.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class LoginRequest {

    @ApiModelProperty(notes = "User login", example = "login")
    private String login;

    @ApiModelProperty(notes = "User password", example = "password")
    private String password;
}
