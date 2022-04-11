package com.emindsblogapplication.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long commentId;
    private String name;
    private String email;
    private String body;
}
