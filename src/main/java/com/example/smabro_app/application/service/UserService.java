package com.example.smabro_app.application.service;

import com.example.smabro_app.domain.model.User;
import com.example.smabro_app.domain.model.UserRateList;
import com.example.smabro_app.infrastructure.repository.UserRepository;
import com.example.smabro_app.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public int createUser(@Nonnull final User request) {

        return userRepository.createUser(request);
    }

    public int updateUser(@Nonnull final User request) {

        return userRepository.updateUser(request);
    }

    public User findByName(@Nonnull final String name) {

        return userRepository.findByUserName(name);
    }

    public int updateUserMatchingStatus(Integer status, int id) {

        return userRepository.updateUserMatchingStatus(status, id);
    }

    public List<UserResponse> getRateRanking() {

        return userRepository.getRateRanking();
    }

    public UserRateList getRateList(int userId) {

        return userRepository.getRateList(userId);
    }
}
