package com.example.smabro_app.infrastructure.repository;

import com.example.smabro_app.domain.model.HistoryInfoList;
import com.example.smabro_app.domain.model.OpponentList;
import com.example.smabro_app.infrastructure.mapper.MatchingMapper;
import com.example.smabro_app.presentation.dto.request.MatchingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MatchingRepository {

    private final MatchingMapper matchingMapper;

    public OpponentList getOpponent(final int myRate, final int userId) {

        return OpponentList.from(matchingMapper.getOpponent(userId), myRate);
    }

    public void createMatching(MatchingRequest matchingRequest) {

        matchingMapper.createMatching(matchingRequest);
    }

    public HistoryInfoList getHistory(Integer userId) {

        return HistoryInfoList.from(matchingMapper.getHistory(userId));
    }
}
