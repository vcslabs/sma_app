package com.example.smabro_app.presentation.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    private String name;

    private String password;

    private int rate;

    private int mainCharacterId;

    private int sub1CharacterId;

    private int sub2CharacterId;
}
