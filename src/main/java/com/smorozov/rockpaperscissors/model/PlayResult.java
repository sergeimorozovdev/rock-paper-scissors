package com.smorozov.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlayResult {
    WIN("You won"),
    DEFEAT("You lose"),
    DRAW("Draw");

    private final String message;
}
