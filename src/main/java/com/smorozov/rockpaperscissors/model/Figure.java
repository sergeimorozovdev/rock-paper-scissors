package com.smorozov.rockpaperscissors.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Figure {
    ROCK("PAPER"),
    PAPER("SCISSOR"),
    SCISSOR("ROCK");

    //for json serialization
    private final String value;
    private final Set<String> weaknesses;

    Figure(String... weaknesses) {
        value = this.name();
        this.weaknesses = new HashSet<>(Arrays.asList(weaknesses));
    }

    public boolean beats(Figure figure) {
        return !weaknesses.contains(figure.name());
    }
}
