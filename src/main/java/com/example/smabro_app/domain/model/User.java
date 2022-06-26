package com.example.smabro_app.domain.model;

import com.example.smabro_app.infrastructure.model.response.UserResponseQuery;
import com.example.smabro_app.presentation.dto.request.UserRequest;
import com.example.smabro_app.security.UserAccount;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Nonnull;

/**
 * Table: Users
 */
@Data
@Builder(access = AccessLevel.PRIVATE)
public class User {

    /**
     * Column: name
     */
    private Integer id;

    /**
     * Column: name
     */
    private String name;

    /**
     * Column: password
     */
    private String password;

    /**
     * Column: rate
     */
    private Integer rate;

    /**
     * Column: main_character_id
     */
    private Integer mainCharacterId;

    /**
     * Column: sub1_character_id
     */
    private Integer sub1CharacterId;

    /**
     * Column: sub2_character_id
     */
    private Integer sub2CharacterId;

    public static User from(@Nonnull final UserRequest request) {

        return User.builder()
                .name(request.getName())
                .password(request.getPassword())
                .rate(request.getRate())
                .mainCharacterId(request.getMainCharacterId())
                .sub1CharacterId(request.getSub1CharacterId())
                .sub2CharacterId(request.getSub2CharacterId())
                .build();
    }

    public static User from(@Nonnull final UserResponseQuery responseQuery) {

        return User.builder()
                .name(responseQuery.getName())
                .rate(responseQuery.getRate())
                .mainCharacterId(responseQuery.getMainCharacterId())
                .sub1CharacterId(responseQuery.getSub1CharacterId())
                .sub2CharacterId(responseQuery.getSub2CharacterId())
                .build();
    }

    public static User from(@Nonnull final UserAccount userAccount) {

        return User.builder()
                .name(userAccount.getName())
                .rate(userAccount.getRate())
                .mainCharacterId(userAccount.getMainCharacterId())
                .sub1CharacterId(userAccount.getSub1CharacterId())
                .sub2CharacterId(userAccount.getSub2CharacterId())
                .build();
    }

    public static User createUpdateUserRequest(@Nonnull final UserRequest request, final int id) {

        return User.builder()
                .id(id)
                .name(request.getName())
                .password(request.getPassword())
                .rate(request.getRate())
                .mainCharacterId(request.getMainCharacterId())
                .sub1CharacterId(request.getSub1CharacterId())
                .sub2CharacterId(request.getSub2CharacterId())
                .build();
    }
}