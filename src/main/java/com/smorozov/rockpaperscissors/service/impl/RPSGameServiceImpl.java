package com.smorozov.rockpaperscissors.service.impl;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.client.OpponentClientFactory;
import com.smorozov.rockpaperscissors.model.Figure;
import com.smorozov.rockpaperscissors.model.PlayResult;
import com.smorozov.rockpaperscissors.model.ThrowRequest;
import com.smorozov.rockpaperscissors.model.ThrowResponse;
import com.smorozov.rockpaperscissors.service.RPSGameService;
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

        PlayResult compareResult = getCompareResult(opponentThrow, playerThrow);
        String message = prepareMessage(opponentThrow, compareResult);
        return new ThrowResponse(compareResult, message);
    }

    private PlayResult getCompareResult(Figure opponentThrow, Figure playerThrow) {
        if (opponentThrow == playerThrow) {
            return DRAW;
        } else if (playerThrow.beats(opponentThrow)) {
            return WIN;
        } else {
            return DEFEAT;
        }
    }

    private String prepareMessage(Figure opponentThrow, PlayResult playResult) {
        return playResult.getMessage() + ". Opponent chose a " + opponentThrow.getValue();
    }
}
