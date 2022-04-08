package com.emindsblogapplication.entity;

import com.emindsblogapplication.dto.PostDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {


    private List<PostDto> content;
    private Integer pageNo;
    private Integer pageSize;
    private Long totalElements;
    private  Integer totalPages;
    private Boolean last;
}
