package com.emindsblogapplication.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends  Throwable{


    private HttpStatus httpStatus;
    private String message;
}
