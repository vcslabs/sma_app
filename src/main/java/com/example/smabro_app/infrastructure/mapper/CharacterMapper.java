package com.example.smabro_app.infrastructure.mapper;

import com.example.smabro_app.infrastructure.model.response.CharacterResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CharacterMapper {

    public List<CharacterResponse> getRanking();
}
