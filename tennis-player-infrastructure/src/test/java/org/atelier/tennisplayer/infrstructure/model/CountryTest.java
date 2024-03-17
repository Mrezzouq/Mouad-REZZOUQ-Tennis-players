package org.atelier.tennisplayer.infrstructure.model;

import org.atelier.tennisplayer.domain.model.PlayerCountry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class CountryTest {

    @Test
    void should_map_to_player_country() {
        // Arrange & Act
        var actual = buildCountry().toCountry();

        // Assert
        assertThat(actual).isEqualTo(buildPlayerCountry());
    }
    private static PlayerCountry buildPlayerCountry() {
        return PlayerCountry.builder()
                .withCode("MAR")
                .withPicture("aPicture")
                .build();
    }

    private static Country buildCountry() {
        return Country.builder()
                .withCode("MAR")
                .withPicture("aPicture")
                .build();
    }
}