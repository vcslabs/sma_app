package com.example.smabro_app.infrastructure.repository;

import com.example.smabro_app.domain.model.User;
import com.example.smabro_app.domain.model.UserRateList;
import com.example.smabro_app.infrastructure.mapper.UsersMapper;
import com.example.smabro_app.infrastructure.model.request.UserRequestQuery;
import com.example.smabro_app.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UsersMapper userMapper;

    public int createUser(@Nonnull final User request) {

        return userMapper.insert(UserRequestQuery.from(request));
    }

    public User findByUserId(final int id) {

        return User.from(userMapper.findById(id));
    }

    public User findByUserName(final String name) {

        return User.from(userMapper.findByName(name));
    }

    public int updateUser(@Nonnull final User request) {

        return userMapper.update(UserRequestQuery.createUpdateUserRequest(request));
    }

    public int updateUserMatchingStatus(Integer status, int id) {

        return userMapper.updateUserMatchingStatus(status, id);
    }

    public List<UserResponse> getRateRanking() {

        return userMapper.getRateRanking();
    }

    public UserRateList getRateList(int userId) {

        return UserRateList.from(userMapper.getRateList(userId));
    }
}
