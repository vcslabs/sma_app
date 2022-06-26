package com.example.smabro_app.presentation.dto.response;

import com.example.smabro_app.domain.model.OpponentList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class OpponentResponse {

    private Integer id;

    private String name;

    private int rate;

    private int mainCharacterId;

    private int sub1CharacterId;

    private int sub2CharacterId;

    public static OpponentResponse from(OpponentList.Opponent opponent) {

        return OpponentResponse.builder()
                .name(opponent.getName())
                .rate(opponent.getRate())
                .mainCharacterId(opponent.getMainCharacterId())
                .sub1CharacterId(opponent.getSub1CharacterId())
                .sub2CharacterId(opponent.getSub2CharacterId())
                .build();
    }
}
