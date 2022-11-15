package com.smorozov.rockpaperscissors.client.impl;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.model.Figure;

public class RemoteClientImpl implements OpponentClient {

    public RemoteClientImpl() {
        throw new IllegalStateException("Remote client not supported yet");
    }

    @Override
    public Figure getOpponentThrow() {
        return null;
    }
}
