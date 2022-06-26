package com.example.smabro_app.domain.model.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MatchingStatus {

    NOTHING(0, "対戦を希望していない状態"),
    WAITING(1, "対戦者待ち"),
    MATCHING(2, "対戦中"),
    CANCELED(3, "対戦中止");

    private final int code;

    private final String text;
}
