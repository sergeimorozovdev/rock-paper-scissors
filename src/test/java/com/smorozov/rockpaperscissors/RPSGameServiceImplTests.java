package com.smorozov.rockpaperscissors;

import com.smorozov.rockpaperscissors.client.OpponentClient;
import com.smorozov.rockpaperscissors.client.OpponentClientFactory;
import com.smorozov.rockpaperscissors.model.Figure;
import com.smorozov.rockpaperscissors.model.PlayResult;
import com.smorozov.rockpaperscissors.model.ThrowRequest;
import com.smorozov.rockpaperscissors.model.ThrowResponse;
import com.smorozov.rockpaperscissors.service.impl.RPSGameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.smorozov.rockpaperscissors.model.PlayResult.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class RPSGameServiceImplTests {

    @Mock
    private OpponentClientFactory clientFactory;

    @Mock
    private OpponentClient client;

    @InjectMocks
    private RPSGameServiceImpl rpsGameServiceImpl;

    @BeforeEach
    void before() {
        when(clientFactory.getClient()).thenReturn(client);
    }

    @Test
    void makeAThrow_all_combination_test() {
        ThrowRequest request = new ThrowRequest();
        for (Figure figurePlayer : Figure.values()) {
            request.setFigure(figurePlayer);
            for (Figure figureOpponent : Figure.values()) {
                when(client.getOpponentThrow()).thenReturn(figureOpponent);
                PlayResult expectedPlayResult = DEFEAT;
                if (figurePlayer == figureOpponent) {
                    expectedPlayResult = DRAW;
                } else if (figurePlayer.beats(figureOpponent)) {
                    expectedPlayResult = WIN;
                }
                ThrowResponse throwResponse = rpsGameServiceImpl.makeAThrow(request);
                Assertions.assertEquals(expectedPlayResult, throwResponse.getThrowResult(), "Throw comparation is not correct");
            }
        }
    }

}
