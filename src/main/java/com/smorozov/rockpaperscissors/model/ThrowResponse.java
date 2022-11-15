package com.smorozov.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThrowResponse {
    private PlayResult throwResult;
    private String message;
}
