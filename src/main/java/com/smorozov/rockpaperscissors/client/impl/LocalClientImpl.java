package com.smorozov.rockpaperscissors.client.impl;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.model.Figure;

import java.util.Random;

public class LocalClientImpl implements OpponentClient {

    private final Random random = new Random();

    @Override
    public Figure getOpponentThrow() {
        int index = random.nextInt(Figure.values().length);
        return Figure.values()[index];
    }
}