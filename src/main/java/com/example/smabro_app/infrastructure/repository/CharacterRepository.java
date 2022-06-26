package com.example.smabro_app.infrastructure.repository;

import com.example.smabro_app.domain.model.Character;
import com.example.smabro_app.infrastructure.mapper.CharacterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CharacterRepository {

    private final CharacterMapper characterMapper;

    public List<Character> getRanking() {

        return characterMapper.getRanking().stream()
                .map(Character::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
