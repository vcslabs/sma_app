package com.example.smabro_app.domain.model;

import com.example.smabro_app.infrastructure.model.response.CharacterResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class Character {

    private Integer id;

    private String name;

    private Integer count;

    public static Character from(CharacterResponse characterResponse) {

        return Character.builder()
                .count(characterResponse.getCount())
                .id(characterResponse.getId())
                .name(characterResponse.getName())
                .build();
    }
}
