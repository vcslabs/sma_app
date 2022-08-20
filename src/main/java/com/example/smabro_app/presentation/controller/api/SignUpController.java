package com.example.smabro_app.presentation.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpController {

    @PostMapping("/signUp")
    public String signUp() {



        return "登録完了しました。";
    }
}
