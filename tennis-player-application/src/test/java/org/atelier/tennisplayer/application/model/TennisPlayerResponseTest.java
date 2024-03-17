package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.AdditionalData;
import org.atelier.tennisplayer.domain.model.PlayerCountry;
import org.atelier.tennisplayer.domain.model.TennisPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TennisPlayerResponseTest {

    private static TennisPlayerResponse buildTennisPlayerResponse() {
        return TennisPlayerResponse.builder()
                .withId(33)
                .withFirstname("firstname")
                .withLastname("lastname")
                .withShortname("f.lastname")
                .withSex("M")
                .withPlayerCountry(buildPlayerCountryResponse())
                .withPicture("aPicture")
                .withAdditionalData(buildAdditionalDataResponse())
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

    private static PlayerCountryResponse buildPlayerCountryResponse() {
        return PlayerCountryResponse.builder()
                .withCode("MAR")
                .withPicture("aPicture")
                .build();
    }

    private static PlayerCountry buildPlayerCountry() {
        return PlayerCountry.builder()
                .withCode("MAR")
                .withPicture("aPicture")
                .build();
    }

    private static AdditionalDataResponse buildAdditionalDataResponse() {
        return AdditionalDataResponse.builder()
                .withRank(100)
                .withAge(20)
                .withPoints(2000)
                .withHeight(199)
                .withWeight(67)
                .withLast(List.of(1, 2, 3, 4))
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

    @Test
    void should_map_tennis_player_from_domain() {
        // Arrange & Act
        var actual = TennisPlayerResponse.from(buildTennisPlayer());

        // Assert
        assertThat(actual).isEqualTo(buildTennisPlayerResponse());
    }
}