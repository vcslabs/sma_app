package com.example.smabro_app.infrastructure.model.request;

import com.example.smabro_app.domain.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class UserRequestQuery {

    private int id;

    private String name;

    private String password;

    private int rate;

    private int mainCharacterId;

    private int sub1CharacterId;

    private int sub2CharacterId;

    public static UserRequestQuery from(User request) {

        return UserRequestQuery.builder()
                .name(request.getName())
                .password(request.getPassword())
                .rate(request.getRate())
                .mainCharacterId(request.getMainCharacterId())
                .sub1CharacterId(request.getSub1CharacterId())
                .sub2CharacterId(request.getSub2CharacterId())
                .build();
    }

    public static UserRequestQuery createUpdateUserRequest(User request) {

        return UserRequestQuery.builder()
                .id(request.getId())
                .name(request.getName())
                .password(request.getPassword())
                .rate(request.getRate())
                .mainCharacterId(request.getMainCharacterId())
                .sub1CharacterId(request.getSub1CharacterId())
                .sub2CharacterId(request.getSub2CharacterId())
                .build();
    }
}
