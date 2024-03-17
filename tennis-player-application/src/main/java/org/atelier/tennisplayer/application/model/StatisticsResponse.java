package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.Statistics;

import java.math.BigDecimal;

public record StatisticsResponse(
        String countryWithHighestWinRatio,
        BigDecimal averageBmi,
        BigDecimal medianHeight
) {

    public static StatisticsResponse from(Statistics statistics) {
        return StatisticsResponse.builder()
                .withCountryWithHighestWinRatio(statistics.countryWithHighestWinRatio())
                .withAverageBmi(statistics.averageBmi())
                .withMedianHeight(statistics.medianHeight())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String countryWithHighestWinRatio;
        private BigDecimal averageBmi;
        private BigDecimal medianHeight;

        private Builder() {}

        public Builder withCountryWithHighestWinRatio(String countryWithHighestWinRatio) {
            this.countryWithHighestWinRatio = countryWithHighestWinRatio;
            return this;
        }

        public Builder withAverageBmi(BigDecimal averageBmi) {
            this.averageBmi = averageBmi;
            return this;
        }

        public Builder withMedianHeight(BigDecimal medianHeight) {
            this.medianHeight = medianHeight;
            return this;
        }

        public StatisticsResponse build() {
            return new StatisticsResponse(countryWithHighestWinRatio, averageBmi, medianHeight);
        }
    }
}
