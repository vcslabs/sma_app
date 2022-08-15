package com.example.smabro_app.presentation.controller.api;

import com.example.smabro_app.application.facade.MatchingFacade;
import com.example.smabro_app.presentation.dto.request.MatchingRequest;
import com.example.smabro_app.presentation.dto.response.HistoryResponseList;
import com.example.smabro_app.presentation.dto.response.OpponentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/matches")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class MatchingController {

    private final MatchingFacade matchingFacade;

    @GetMapping("/{userId}")
    public OpponentResponse getOpponent(
            @RequestParam("condition") final int condition,
            @PathVariable("userId") final int userId
            ) {

        return matchingFacade.getOpponent(condition, userId);
    }

    // TODO 勝ち試合負け試合のみ取得,最新○件だけ取得するようにする？
    @GetMapping("/history/{userId}")
    public HistoryResponseList getHistory(
            @PathVariable("userId") final int userId
    ) {

        return matchingFacade.getHistory(userId);
    }

    @PostMapping("/")
    public void createMatching(@RequestBody final MatchingRequest matchingRequest) {

        // TODO URIにユーザーIDは含めずにセッションからユーザーIDを取得するようにする

        matchingFacade.createMatching(matchingRequest);
    }
}
