package com.example.smabro_app.domain.model;

import com.example.smabro_app.infrastructure.model.response.UserRateResponseList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class UserRateList {

    private final List<Integer> userRateList;

    public static UserRateList from(List<Integer> userRateResponseList) {

        return UserRateList.builder()
                .userRateList(userRateResponseList)
                .build();
    }
}
