package com.example.smabro_app.domain.model;

import com.example.smabro_app.infrastructure.model.response.HistoryResponseList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class HistoryInfoList {

    private final List<HistoryInfo> historyInfos;

    public static HistoryInfoList from(List<HistoryResponseList> historyResponseList) {

        return HistoryInfoList.builder()
                .historyInfos(historyResponseList.stream()
                        .map(HistoryInfo::from)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    public static class HistoryInfo {

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

        private static HistoryInfo from(HistoryResponseList history) {

            return HistoryInfo.builder()
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
