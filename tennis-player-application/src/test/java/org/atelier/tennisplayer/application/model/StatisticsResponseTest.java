package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.Statistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StatisticsResponseTest {
    private static StatisticsResponse buildStatisticsResponse() {
        return StatisticsResponse.builder()
                .withMedianHeight(BigDecimal.TEN)
                .withCountryWithHighestWinRatio("FR")
                .withAverageBmi(BigDecimal.TEN)
                .build();
    }

    private static Statistics buildStatistics() {
        return Statistics.builder()
                .withMedianHeight(BigDecimal.TEN)
                .withCountryWithHighestWinRatio("FR")
                .withAverageBmi(BigDecimal.TEN)
                .build();
    }

    @Test
    void should_map_statistics_from_domain() {
        // Arrange & Act
        var actual = StatisticsResponse.from(buildStatistics());

        // Assert
        assertThat(actual).isEqualTo(buildStatisticsResponse());
    }
}