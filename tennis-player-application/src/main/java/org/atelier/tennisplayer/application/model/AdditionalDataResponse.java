package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.AdditionalData;

import java.util.List;

public record AdditionalDataResponse(
        int rank,
        int points,
        int weight,
        int height,
        int age,
        List<Integer> last
) {

    public static AdditionalDataResponse from(AdditionalData additionalData) {
        return AdditionalDataResponse.builder()
                .withRank(additionalData.getRank())
                .withPoints(additionalData.getPoints())
                .withWeight(additionalData.getWeight())
                .withHeight(additionalData.getHeight())
                .withAge(additionalData.getAge())
                .withLast(additionalData.getLast())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int rank;
        private int points;
        private int weight;
        private int height;
        private int age;
        private List<Integer> last;

        private Builder() {}

        public Builder withRank(int rank) {
            this.rank = rank;
            return this;
        }

        public Builder withPoints(int points) {
            this.points = points;
            return this;
        }

        public Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder withHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withLast(List<Integer> last) {
            this.last = last;
            return this;
        }

        public AdditionalDataResponse build() {
            return new AdditionalDataResponse(rank, points, weight, height, age, last);
        }
    }
}
