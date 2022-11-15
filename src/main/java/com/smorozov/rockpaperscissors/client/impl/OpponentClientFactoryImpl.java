package com.smorozov.rockpaperscissors.client.impl;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.client.OpponentClientFactory;
import com.smorozov.rockpaperscissors.client.model.ClientType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.smorozov.rockpaperscissors.client.model.ClientType.APIARY;
import static com.smorozov.rockpaperscissors.client.model.ClientType.LOCAL;

@Component
public class OpponentClientFactoryImpl implements OpponentClientFactory {

    @Value("${rps.opponent.client}")
    private ClientType clientType = LOCAL;

    private OpponentClient opponentClient;

    @Override
    public OpponentClient getClient() {
        return opponentClient;
    }

    @PostConstruct
    public void postConstruct() {
        if (clientType == LOCAL) {
            opponentClient = new LocalClientImpl();
        } else if (clientType == APIARY) {
            opponentClient = new ApiaryClientImpl();
        }
    }
}
