package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.PlayerCountry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PlayerCountryResponseTest {
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

    @Test
    void should_map_from_domain_player_country() {
        // Arrange & Act
        var actual = PlayerCountryResponse.from(buildPlayerCountry());

        // Assert
        assertThat(actual).isEqualTo(buildPlayerCountryResponse());
    }
}