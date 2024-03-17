package org.atelier.tennisplayer.domain.usecases;

import org.atelier.tennisplayer.domain.exception.TennisPlayerNotFoundException;
import org.atelier.tennisplayer.domain.model.AdditionalData;
import org.atelier.tennisplayer.domain.model.PlayerCountry;
import org.atelier.tennisplayer.domain.model.TennisPlayer;
import org.atelier.tennisplayer.domain.port.out.TennisPlayerRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TennisPlayerServiceTest {
    @Mock
    private TennisPlayerRepository tennisPlayerRepository;
    @InjectMocks
    private TennisPlayerService tennisPlayerService;

    private static PlayerCountry buildCountry(String code) {
        return PlayerCountry.builder()
                .withCode(code)
                .withPicture("aPicture")
                .build();
    }

    private static AdditionalData buildAdditionalData(int rank) {
        return AdditionalData.builder()
                .withRank(rank)
                .withPoints(500)
                .withWeight(69)
                .withAge(20)
                .withHeight(200)
                .withLast(Collections.emptyList())
                .build();
    }

    private static TennisPlayer.Builder buildTennisPlayer(int id, String firstname, String lastname) {
        return TennisPlayer.builder()
                .withId(id)
                .withFirstname(firstname)
                .withLastname(lastname)
                .withShortname("aShortname")
                .withSex("M")
                .withPicture("aPicture");
    }

    @Nested
    class SortedTennisPlayers {
        @Test
        void should_retrieve_sorted_players() {
            // Arrange
            var firstPlayer = buildTennisPlayer(11, "vlad", "last")
                    .withCountry(buildCountry("RUS"))
                    .withAdditionalData(buildAdditionalData(100))
                    .build();
            var secondPlayer = buildTennisPlayer(21, "Carlos", "Alcaraz")
                    .withCountry(buildCountry("ESP"))
                    .withAdditionalData(buildAdditionalData(2))
                    .build();
            when(tennisPlayerRepository.retrieveTennisPlayers()).thenReturn(List.of(firstPlayer, secondPlayer));

            // Act
            var actual = tennisPlayerService.retrieveSortedPlayers();

            // Act
            assertThat(actual)
                    .containsExactly(secondPlayer, firstPlayer);
        }

        @Test
        void should_return_empty_when_there_are_no_players() {
            // Arrange
            when(tennisPlayerRepository.retrieveTennisPlayers()).thenReturn(List.of());

            // Act
            var actual = tennisPlayerService.retrieveSortedPlayers();

            // Assert
            assertThat(actual).isEmpty();
        }
    }

    @Nested
    class retrieveTennisPlayerById {
        private static final int PLAYER_ID = 11;

        @Test
        void should_retrieve_player_when_found() {
            // Arrange
            var player = buildTennisPlayer(PLAYER_ID, "Jannik", "Sinner")
                    .withCountry(buildCountry("ITA"))
                    .withAdditionalData(buildAdditionalData(100))
                    .build();
            when(tennisPlayerRepository.retrievePlayerById(PLAYER_ID)).thenReturn(player);

            // Act
            var actual = tennisPlayerService.retrievePlayerById(PLAYER_ID);

            assertThat(actual).isPresent().contains(player);
        }

        @Test
        void should_return_empty_when_no_player_is_found() {
            // Arrange
            when(tennisPlayerRepository.retrievePlayerById(PLAYER_ID)).thenThrow(new TennisPlayerNotFoundException("No player found"));

            // Act
            var actual = tennisPlayerService.retrievePlayerById(PLAYER_ID);

            // Assert
            assertThat(actual).isEmpty();
        }
    }

    @Nested
    class RetrieveStatistics {

        @Test
        void should_correctly_calculate_statistics() {
            // Arrange
            var player1 = buildTennisPlayer(1, "Novak", "Djokovic")
                    .withCountry(buildCountry("SRB"))
                    .withAdditionalData(AdditionalData.builder()
                            .withRank(2)
                            .withPoints(2542)
                            .withWeight(80000)
                            .withHeight(188)
                            .withAge(31)
                            .withLast(List.of(1, 1, 1, 1, 1))
                            .build())
                    .build();
            var player2 = buildTennisPlayer(2, "Rafael", "Nadal")
                    .withCountry(buildCountry("ESP"))
                    .withAdditionalData(AdditionalData.builder()
                            .withRank(1)
                            .withPoints(1982)
                            .withWeight(85000)
                            .withHeight(185)
                            .withAge(33)
                            .withLast(List.of(1, 0, 0, 0, 1))
                            .build())
                    .build();
            when(tennisPlayerRepository.retrieveTennisPlayers()).thenReturn(List.of(player1, player2));

            // Act
            var actual = tennisPlayerService.retrieveStatistics();

            // Assert
            assertAll(
                    () -> assertThat(actual.countryWithHighestWinRatio()).isEqualTo("SRB"),
                    () -> assertThat(actual.averageBmi()).isEqualTo(new BigDecimal("23.74")),
                    () -> assertThat(actual.medianHeight()).isEqualTo(new BigDecimal("186.50"))
            );
        }

        @Test
        void should_calculate_statistics() {
            // Arrange
            var player1 = buildTennisPlayer(1, "Novak", "Djokovic")
                    .withCountry(buildCountry("SRB"))
                    .withAdditionalData(AdditionalData.builder()
                            .withRank(2)
                            .withPoints(2542)
                            .withWeight(80000)
                            .withHeight(188)
                            .withAge(31)
                            .withLast(List.of(1, 1, 1, 1, 1))
                            .build())
                    .build();
            var player2 = buildTennisPlayer(2, "Rafael", "Nadal")
                    .withCountry(buildCountry("ESP"))
                    .withAdditionalData(AdditionalData.builder()
                            .withRank(1)
                            .withPoints(1982)
                            .withWeight(85000)
                            .withHeight(185)
                            .withAge(33)
                            .withLast(List.of(1, 0, 0, 0, 1))
                            .build())
                    .build();

            var player3 = buildTennisPlayer(3, "Ugo", "Humbert")
                    .withCountry(buildCountry("FR"))
                    .withAdditionalData(AdditionalData.builder()
                            .withRank(14)
                            .withPoints(1982)
                            .withWeight(85000)
                            .withHeight(175)
                            .withAge(33)
                            .withLast(List.of(1, 0, 1, 0, 1))
                            .build())
                    .build();
            when(tennisPlayerRepository.retrieveTennisPlayers()).thenReturn(List.of(player1, player2, player3));

            // Act
            var actual = tennisPlayerService.retrieveStatistics();

            // Assert
            assertAll(
                    () -> assertThat(actual.countryWithHighestWinRatio()).isEqualTo("SRB"),
                    () -> assertThat(actual.averageBmi()).isEqualTo(new BigDecimal("25.08")),
                    () -> assertThat(actual.medianHeight()).isEqualTo(new BigDecimal("185"))
            );
        }

        @Test
        void should_handle_empty_player_list() {
            // Arrange
            when(tennisPlayerRepository.retrieveTennisPlayers()).thenReturn(List.of());

            // Act
            var actual = tennisPlayerService.retrieveStatistics();

            // Assert
            assertAll(
                    () -> assertThat(actual.countryWithHighestWinRatio()).isEqualTo("N/A"),
                    () -> assertThat(actual.averageBmi()).isEqualTo(BigDecimal.ZERO),
                    () -> assertThat(actual.medianHeight()).isEqualTo(BigDecimal.ZERO)
            );
        }
    }

}