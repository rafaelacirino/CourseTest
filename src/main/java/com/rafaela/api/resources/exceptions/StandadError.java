package com.rafaela.api.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandadError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

}
