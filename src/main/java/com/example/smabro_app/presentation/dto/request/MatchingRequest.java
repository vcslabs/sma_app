package com.example.smabro_app.presentation.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatchingRequest {

    private Integer userId;

    private Integer userRate;

    private Integer opponentId;

    private Integer opponentRate;

    private Integer statusCode;

    private Integer usedCharacter1Id;

    private Integer usedCharacter2Id;

    private Integer usedCharacter3Id;

    private Integer opponentCharacter1Id;

    private Integer opponentCharacter2id;

    private Integer opponentCharacter3Id;
}
