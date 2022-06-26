package com.example.smabro_app.presentation.dto.response;

import com.example.smabro_app.domain.model.Character;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class CharacterResponse {

    private Integer id;

    private String name;

    private Integer count;

    public static CharacterResponse from(Character character) {

        return CharacterResponse.builder()
                .count(character.getCount())
                .id(character.getId())
                .name(character.getName())
                .build();
    }
}
