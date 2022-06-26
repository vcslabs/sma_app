package com.example.smabro_app.domain.model;

import com.example.smabro_app.infrastructure.model.response.OpponentResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class OpponentList {

    private final List<Opponent> opponentList;

    private final int myRate;

    public static OpponentList from(@Nonnull final List<OpponentResponse> response, final int myRate) {

        return OpponentList.builder()
                .opponentList(response.stream().map(Opponent::from).collect(Collectors.toList()))
                .myRate(myRate)
                .build();
    }

    public List<Opponent> filterOpponentListFromCondition(final int condition) {

        return this.opponentList.stream()
                .filter(opponent -> isWithinCondition(opponent.rate, condition))
                .collect(Collectors.toList());
    }

    private boolean isWithinCondition(final int opponentRate, final int condition) {

        if (condition == 0) {

            return true;
        }

        return this.myRate - condition <= opponentRate && this.myRate + condition >= opponentRate;
    }

    private static OpponentList.Opponent randomlyDecideOpponent(@Nonnull final List<Opponent> opponentList) {

        return opponentList.get(new Random().nextInt(opponentList.size()));
    }

    @Getter
    @Builder(access = AccessLevel.PRIVATE)
    public static class Opponent {

        private final Integer id;

        private final String name;

        private final int rate;

        private final int mainCharacterId;

        private final int sub1CharacterId;

        private final int sub2CharacterId;

        public static Opponent from(@Nonnull final OpponentResponse opponentResponse) {

            return Opponent.builder()
                    .id(opponentResponse.getId())
                    .name(opponentResponse.getName())
                    .rate(opponentResponse.getRate())
                    .mainCharacterId(opponentResponse.getMainCharacterId())
                    .sub1CharacterId(opponentResponse.getSub1CharacterId())
                    .sub2CharacterId(opponentResponse.getSub2CharacterId())
                    .build();
        }
    }
}
