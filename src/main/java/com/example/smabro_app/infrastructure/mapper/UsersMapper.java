package com.example.smabro_app.infrastructure.mapper;

import com.example.smabro_app.infrastructure.model.request.UserRequestQuery;
import com.example.smabro_app.infrastructure.model.response.UserRateResponseList;
import com.example.smabro_app.infrastructure.model.response.UserResponseQuery;
import com.example.smabro_app.presentation.dto.response.UserResponse;
import com.example.smabro_app.security.UserAccount;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Nonnull;
import java.util.List;

@Mapper
public interface UsersMapper {

    int insert(@Nonnull final UserRequestQuery record);

    UserAccount findByName(@Nonnull final String name);

    UserResponseQuery findById(final int id);

    int update(@Nonnull final UserRequestQuery record);

    int updateUserMatchingStatus(Integer status, int id);

    List<UserResponse> getRateRanking();

    List<Integer> getRateList(int userId);
}