package com.smorozov.rockpaperscissors.service;

import com.smorozov.rockpaperscissors.model.ThrowRequest;
import com.smorozov.rockpaperscissors.model.ThrowResponse;

public interface RPSGameService {
    ThrowResponse makeAThrow(ThrowRequest request);
}
