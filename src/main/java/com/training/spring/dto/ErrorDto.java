package com.training.spring.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class ErrorDto {
    private int status;
    private String message;

}
