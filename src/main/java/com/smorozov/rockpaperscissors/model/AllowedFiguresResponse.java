package com.smorozov.rockpaperscissors.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@Getter
public class AllowedFiguresResponse {

    private Set<Figure> figures = new HashSet<>(Arrays.asList(Figure.values()));
}
