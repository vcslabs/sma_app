package com.example.smabro_app.infrastructure.model.response;

import com.example.smabro_app.domain.model.OpponentList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class OpponentResponse {

    private Integer id;

    private String name;

    private int rate;

    private int mainCharacterId;

    private int sub1CharacterId;

    private int sub2CharacterId;
}
