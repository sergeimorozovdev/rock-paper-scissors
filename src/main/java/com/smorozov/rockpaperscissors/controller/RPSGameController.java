package com.smorozov.rockpaperscissors.controller;

import com.smorozov.rockpaperscissors.model.AllowedFiguresResponse;
import com.smorozov.rockpaperscissors.model.ThrowRequest;
import com.smorozov.rockpaperscissors.model.ThrowResponse;
import com.smorozov.rockpaperscissors.service.RPSGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game/rps")
@RequiredArgsConstructor
public class RPSGameController {

    private final RPSGameService rpsGameService;

    private final AllowedFiguresResponse allowedFigures;

    @GetMapping("/figures")
    public AllowedFiguresResponse getAllowedFigures() {
        return allowedFigures;
    }

    @PostMapping(path = "/throw", consumes = "application/json")
    public ResponseEntity<ThrowResponse> makeAThrow(@RequestBody ThrowRequest request) {
        ThrowResponse throwResponse = rpsGameService.makeAThrow(request);
        return ResponseEntity.ok(throwResponse);
    }
}
