package com.example.smabro_app.infrastructure.model.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class CharacterResponse {

    private Integer id;

    private String name;

    private Integer count;
}
