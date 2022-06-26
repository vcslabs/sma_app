package com.example.smabro_app.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAccount {

    private String id;

    private String name;

    private String password;

    private int rate;

    private int mainCharacterId;

    private int sub1CharacterId;

    private int sub2CharacterId;
}
