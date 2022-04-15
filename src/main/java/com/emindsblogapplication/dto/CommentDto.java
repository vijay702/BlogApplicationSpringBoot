package com.emindsblogapplication.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Comment Model Informations")
public class CommentDto {
    @ApiModelProperty(value = "Blog comment id")
    private Long commentId;
    @ApiModelProperty(value = "Blog comment name")
    private String name;
    @ApiModelProperty(value = "Blog comment email")
    private String email;
    @ApiModelProperty(value = "Blog comment body")
    private String body;
}
