package com.example.smabro_app.presentation.dto.response;

import com.example.smabro_app.domain.model.HistoryInfoList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class HistoryResponseList {

    private final List<History> histories;

    public static HistoryResponseList from(HistoryInfoList historyInfoList) {

        return HistoryResponseList.builder()
                .histories(historyInfoList.getHistoryInfos().stream()
                        .map(History::from)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    public static class History {

        private final Integer id;

        private final Integer userId;

        private final Integer userRate;

        private final Integer opponentId;

        private final Integer opponentRate;

        private final Integer statusCode;

        private final Integer usedCharacter1Id;

        private final Integer usedCharacter2Id;

        private final Integer usedCharacter3Id;

        private final Integer opponentCharacter1Id;

        private final Integer opponentCharacter2id;

        private final Integer opponentCharacter3Id;

        private static History from(HistoryInfoList.HistoryInfo history) {

            return History.builder()
                    .id(history.getId())
                    .userId(history.getUserId())
                    .userRate(history.getUserRate())
                    .opponentId(history.getOpponentId())
                    .opponentRate(history.getOpponentRate())
                    .statusCode(history.getStatusCode())
                    .usedCharacter1Id(history.getUsedCharacter1Id())
                    .usedCharacter2Id(history.getUsedCharacter2Id())
                    .usedCharacter3Id(history.getUsedCharacter3Id())
                    .opponentCharacter1Id(history.getOpponentCharacter1Id())
                    .opponentCharacter2id(history.getOpponentCharacter2id())
                    .opponentCharacter3Id(history.getOpponentCharacter3Id())
                    .build();
        }
    }
}
