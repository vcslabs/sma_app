package com.example.smabro_app.application.facade;

import com.example.smabro_app.application.service.UserService;
import com.example.smabro_app.domain.model.User;
import com.example.smabro_app.presentation.dto.request.UserRequest;
import com.example.smabro_app.presentation.dto.response.UserRateResponseList;
import com.example.smabro_app.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public int createUser(@Nonnull final UserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        return userService.createUser(User.from(request));
    }

    public int updateUser(@Nonnull final UserRequest request, final int id) {

        return userService.updateUser(User.createUpdateUserRequest(request, id));
    }

    public UserResponse findByName(@Nonnull final String name) {

        return UserResponse.from(userService.findByName(name));
    }

    public int updateUserMatchingStatus(Integer status, int id) {

        return userService.updateUserMatchingStatus(status, id);
    }

    public List<UserResponse> getRateRanking() {

        return userService.getRateRanking();
    }

    public UserRateResponseList getRateList(int userId) {

        return UserRateResponseList.from(userService.getRateList(userId));
    }
}
