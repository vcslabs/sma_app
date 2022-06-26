package com.example.smabro_app.infrastructure.model.response;

import lombok.Data;

@Data
public class UserResponseQuery {

    private String name;

    private int rate;

    private int mainCharacterId;

    private int sub1CharacterId;

    private int sub2CharacterId;
}
