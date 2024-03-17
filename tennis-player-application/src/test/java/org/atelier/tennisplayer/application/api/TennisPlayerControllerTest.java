package org.atelier.tennisplayer.application.api;

import org.atelier.tennisplayer.application.model.AdditionalDataResponse;
import org.atelier.tennisplayer.application.model.PlayerCountryResponse;
import org.atelier.tennisplayer.application.model.PlayersResponse;
import org.atelier.tennisplayer.application.model.StatisticsResponse;
import org.atelier.tennisplayer.application.model.TennisPlayerResponse;
import org.atelier.tennisplayer.domain.model.AdditionalData;
import org.atelier.tennisplayer.domain.model.PlayerCountry;
import org.atelier.tennisplayer.domain.model.TennisPlayer;
import org.atelier.tennisplayer.domain.port.in.TennisPlayerUseCase;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TennisPlayerControllerTest {

    @Mock
    private TennisPlayerUseCase tennisPlayerUseCase;
    @InjectMocks
    private TennisPlayerController tennisPlayerController;

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

    private static PlayersResponse buildPlayersResponse(List<TennisPlayerResponse> tennisPlayers) {
        return PlayersResponse.builder()
                .withTennisPlayers(tennisPlayers)
                .build();
    }

    @Nested
    class SortedTennisPlayers {
        private static Stream<Arguments> provideTennisPlayers() {
            return Stream.of(
                    Arguments.of(Collections.emptyList(), buildPlayersResponse(Collections.emptyList())),
                    Arguments.of(List.of(buildTennisPlayer()), buildPlayersResponse(List.of(buildTennisPlayerResponse())))
            );
        }

        @ParameterizedTest
        @MethodSource("provideTennisPlayers")
        void should_return_sorted_tennis_player(List<TennisPlayer> tennisPlayers, PlayersResponse expected) {
            // Arrange
            when(tennisPlayerUseCase.retrieveSortedPlayers()).thenReturn(tennisPlayers);

            // Act
            var actual = tennisPlayerController.retrieveSortedPlayers();

            // Assert
            assertThat(actual)
                    .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                    .contains(HttpStatus.OK, expected);
        }
    }

    @Nested
    class TennisPlayerById {
        private static Stream<Arguments> providePlayerById() {
            return Stream.of(
                    Arguments.of(1, Optional.of(buildTennisPlayer()), HttpStatus.OK, buildTennisPlayerResponse()),
                    Arguments.of(99, Optional.empty(), HttpStatus.NOT_FOUND, TennisPlayerResponse.EMPTY)
            );
        }

        @ParameterizedTest
        @MethodSource("providePlayerById")
        void retrievePlayerByIdTest(int playerId, Optional<TennisPlayer> tennisPlayer, HttpStatus expectedStatus, TennisPlayerResponse expected) {
            // Arrange
            when(tennisPlayerUseCase.retrievePlayerById(playerId)).thenReturn(tennisPlayer);

            // Act
            var actual = tennisPlayerController.retrievePlayerById(playerId);

            // Assert
            assertThat(actual)
                    .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                    .contains(expectedStatus, expected);

        }
    }

    @Nested
    class Statistics {
        private static StatisticsResponse buildStatisticsResponse() {
            return StatisticsResponse.builder()
                    .withMedianHeight(BigDecimal.TEN)
                    .withCountryWithHighestWinRatio("FR")
                    .withAverageBmi(BigDecimal.TEN)
                    .build();
        }

        private static org.atelier.tennisplayer.domain.model.Statistics buildStatistics() {
            return org.atelier.tennisplayer.domain.model.Statistics.builder()
                    .withMedianHeight(BigDecimal.TEN)
                    .withCountryWithHighestWinRatio("FR")
                    .withAverageBmi(BigDecimal.TEN)
                    .build();
        }

        @Test
        void should_return_OK_with_statistics() {
            // Arrange
            when(tennisPlayerUseCase.retrieveStatistics()).thenReturn(buildStatistics());

            // Act
            var actual = tennisPlayerController.retrieveStatistics();

            // Assert
            var expected = buildStatisticsResponse();
            assertThat(actual)
                    .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                    .contains(HttpStatus.OK, expected);
        }
    }
}