package com.neurotrack.backend.util;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private String message;
    private T data;
    private int status;
}
