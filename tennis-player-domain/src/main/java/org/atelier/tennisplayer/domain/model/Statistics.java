package org.atelier.tennisplayer.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Statistics {
    private final String countryWithHighestWinRatio;
    private final BigDecimal averageBmi;
    private final BigDecimal medianHeight;

    private Statistics(Builder builder) {
        countryWithHighestWinRatio = builder.countryWithHighestWinRatio;
        averageBmi = builder.averageBmi;
        medianHeight = builder.medianHeight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCountryWithHighestWinRatio() {
        return countryWithHighestWinRatio;
    }

    public BigDecimal getAverageBmi() {
        return averageBmi;
    }

    public BigDecimal getMedianHeight() {
        return medianHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistics that)) return false;
        return Objects.equals(countryWithHighestWinRatio, that.countryWithHighestWinRatio) &&
                Objects.equals(averageBmi, that.averageBmi) &&
                Objects.equals(medianHeight, that.medianHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryWithHighestWinRatio, averageBmi, medianHeight);
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "countryWithHighestWinRatio='" + countryWithHighestWinRatio + '\'' +
                ", averageBmi=" + averageBmi +
                ", medianHeight=" + medianHeight +
                '}';
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
            return new Statistics(this);
        }
    }
}
