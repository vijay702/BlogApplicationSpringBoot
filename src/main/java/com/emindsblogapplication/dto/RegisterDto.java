package com.emindsblogapplication.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Register Model Informations")
public class RegisterDto {
    @ApiModelProperty(value = "Blog Register id")
    private String name;
    @ApiModelProperty(value = "Blog Register username")
    private String username;
    @ApiModelProperty(value = "Blog register email")
    private  String email;
    @ApiModelProperty(value = "Blog Register  password")
    private String password;
}
