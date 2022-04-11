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
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private  int totalPages;
    private boolean last;
}
