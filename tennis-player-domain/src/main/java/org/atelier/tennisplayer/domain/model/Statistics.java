package org.atelier.tennisplayer.domain.model;

import java.math.BigDecimal;

public record Statistics(
        String countryWithHighestWinRatio,
        BigDecimal averageBmi,
        BigDecimal medianHeight
) {
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

        public Statistics build() {
            return new Statistics(countryWithHighestWinRatio, averageBmi, medianHeight);
        }
    }
}
