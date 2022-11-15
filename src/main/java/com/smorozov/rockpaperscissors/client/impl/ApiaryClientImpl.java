package com.smorozov.rockpaperscissors.client.impl;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.model.Figure;

public class ApiaryClientImpl implements OpponentClient {

    public ApiaryClientImpl() {
        throw new IllegalStateException("Apiary client not supported yet");
    }

    @Override
    public Figure getOpponentThrow() {
        return null;
    }
}
