package com.example.smabro_app.application.facade;

import com.example.smabro_app.application.service.CharacterService;
import com.example.smabro_app.presentation.dto.response.CharacterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterFacade {

    private final CharacterService characterService;


    public List<CharacterResponse> getRanking() {

        return characterService.getRanking().stream()
                .map(CharacterResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
