package com.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;       // Stores the error message
    private int status;           // Stores the HTTP status code
    private long timestamp;       // Stores the time when the error occurred

}