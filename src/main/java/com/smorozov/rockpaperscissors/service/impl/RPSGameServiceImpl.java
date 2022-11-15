package com.smorozov.rockpaperscissors.service.impl;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.client.OpponentClientFactory;
import com.smorozov.rockpaperscissors.model.Figure;
import com.smorozov.rockpaperscissors.model.PlayResult;
import com.smorozov.rockpaperscissors.model.ThrowRequest;
import com.smorozov.rockpaperscissors.model.ThrowResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.smorozov.rockpaperscissors.model.PlayResult.*;

@Service
@RequiredArgsConstructor
public class RPSGameServiceImpl implements RPSGameService {

    private final OpponentClientFactory clientFactory;

    @Override
    public ThrowResponse makeAThrow(ThrowRequest request) {
        OpponentClient client = clientFactory.getClient();
        Figure opponentThrow = client.getOpponentThrow();
        Figure playerThrow = request.getFigure();
        PlayResult playResult = DEFEAT;
        if (opponentThrow == playerThrow) {
            playResult = DRAW;
        }
        if (playerThrow.beats(opponentThrow)) {
            playResult = WIN;
        }
        String message = prepareMessage(opponentThrow, playResult);
        return new ThrowResponse(playResult, message);
    }

    private String prepareMessage(Figure opponentThrow, PlayResult playResult) {
        return playResult.getMessage() + ". Opponent chose a " + opponentThrow.getValue();
    }
}
