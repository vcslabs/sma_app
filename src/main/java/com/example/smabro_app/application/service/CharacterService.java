package com.example.smabro_app.application.service;

import com.example.smabro_app.domain.model.Character;
import com.example.smabro_app.infrastructure.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public List<Character> getRanking() {

        return characterRepository.getRanking();
    }
}
