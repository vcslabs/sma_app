package com.example.smabro_app.presentation.controller.api;

import com.example.smabro_app.application.facade.CharacterFacade;
import com.example.smabro_app.presentation.dto.response.CharacterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterFacade characterFacade;

    @GetMapping("/ranking")
    public List<CharacterResponse> getRanking() {

        return characterFacade.getRanking();
    }
}
