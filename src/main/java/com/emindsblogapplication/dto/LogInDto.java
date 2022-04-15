package com.emindsblogapplication.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor@ApiModel(description = "LogIn Model Informations")

public class LogInDto {

    @ApiModelProperty(value = "Blog login usernameAndEmail")
    private String usernameOrEmail;
    @ApiModelProperty(value = "Blog login password")
    private String password;
}
