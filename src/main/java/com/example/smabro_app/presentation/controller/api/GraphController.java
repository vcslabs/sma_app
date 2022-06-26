package com.example.smabro_app.presentation.controller.api;

import com.example.smabro_app.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {
    @GetMapping("/hello")
    public String createUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());

        return "ログインしました";
    }
}
