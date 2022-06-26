package com.example.smabro_app.presentation.dto.response;

import com.example.smabro_app.domain.model.UserRateList;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class UserRateResponseList {

    private List<Integer> userRateList;

    public static UserRateResponseList from(UserRateList userRateList) {

        return UserRateResponseList.builder()
                .userRateList(userRateList.getUserRateList())
                .build();
    }
}
