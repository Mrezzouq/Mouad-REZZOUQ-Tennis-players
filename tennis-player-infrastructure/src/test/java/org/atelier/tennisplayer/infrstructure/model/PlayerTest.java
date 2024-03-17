package org.atelier.tennisplayer.infrstructure.model;

import org.atelier.tennisplayer.domain.model.AdditionalData;
import org.atelier.tennisplayer.domain.model.PlayerCountry;
import org.atelier.tennisplayer.domain.model.TennisPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PlayerTest {

    private static PlayerCountry buildPlayerCountry() {
        return PlayerCountry.builder()
                .withCode("MAR")
                .withPicture("aPicture")
                .build();
    }

    private static AdditionalData buildAdditionalData() {
        return AdditionalData.builder()
                .withRank(100)
                .withAge(20)
                .withPoints(2000)
                .withHeight(199)
                .withWeight(67)
                .withLast(List.of(1, 2, 3, 4))
                .build();
    }

    private static TennisPlayer buildTennisPlayer() {
        return TennisPlayer.builder()
                .withId(33)
                .withFirstname("firstname")
                .withLastname("lastname")
                .withShortname("f.lastname")
                .withSex("M")
                .withCountry(buildPlayerCountry())
                .withPicture("aPicture")
                .withAdditionalData(buildAdditionalData())
                .build();
    }

    private static Country buildCountry() {
        return Country.builder()
                .withCode("MAR")
                .withPicture("aPicture")
                .build();
    }

    private static Data buildData() {
        return Data.builder()
                .withRank(100)
                .withAge(20)
                .withPoints(2000)
                .withHeight(199)
                .withWeight(67)
                .withLast(List.of(1, 2, 3, 4))
                .build();
    }

    private static Player buildPlayer() {
        return Player.builder()
                .withId(33)
                .withFirstname("firstname")
                .withLastname("lastname")
                .withShortname("f.lastname")
                .withSex("M")
                .withCountry(buildCountry())
                .withPicture("aPicture")
                .withData(buildData())
                .build();
    }

    @Test
    void should_map_to_tennis_player() {
        // Arrange & Act
        var actual = buildPlayer().toTennisPlayer();

        // Assert
        assertThat(actual).isEqualTo(buildTennisPlayer());
    }
}