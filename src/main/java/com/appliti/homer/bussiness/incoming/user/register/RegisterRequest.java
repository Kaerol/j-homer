package com.appliti.homer.bussiness.incoming.user.register;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class RegisterRequest {

    @ApiModelProperty(notes = "User login", example = "login")
    private String login;

    @ApiModelProperty(notes = "User password", example = "password")
    private String password;

    @ApiModelProperty(notes = "User password", example = "confirmPassword")
    private String confirmPassword;

    @ApiModelProperty(notes = "User mail", example = "mail")
    private String mail;

    @ApiModelProperty(notes = "User home", example = "User home data")
    private AbstractHome home;

    boolean isHomeChosen() {
        return home instanceof ExistedHome;
    }
}
