package com.example.smabro_app.application.facade;

import com.example.smabro_app.application.service.MatchingService;
import com.example.smabro_app.presentation.dto.request.MatchingRequest;
import com.example.smabro_app.presentation.dto.response.HistoryResponseList;
import com.example.smabro_app.presentation.dto.response.OpponentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;

@Service
@RequiredArgsConstructor
public class MatchingFacade {

    private final MatchingService matchingService;

    public OpponentResponse getOpponent(final int condition, final int userId) {

        return OpponentResponse.from(matchingService.getOpponent(condition, userId));
    }

    public void createMatching(@Nonnull MatchingRequest matchingRequest) {

        matchingService.createMatching(matchingRequest);
    }

    public HistoryResponseList getHistory(int userId) {

        return HistoryResponseList.from(matchingService.getHistory(userId));
    }
}
