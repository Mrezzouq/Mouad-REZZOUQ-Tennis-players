package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.AdditionalData;

import java.util.List;

@JsonDeserialize(builder = Data.Builder.class)
public record Data(
        int rank,
        int points,
        int weight,
        int height,
        int age,
        List<Integer> last
) {
    public static Builder builder() {
        return new Builder();
    }

    public AdditionalData toAdditionalData() {
        return AdditionalData.builder()
                .withRank(this.rank)
                .withPoints(this.points)
                .withWeight(this.weight)
                .withHeight(this.height)
                .withAge(this.age)
                .withLast(this.last)
                .build();
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

        public Data build() {
            return new Data(rank, points, weight, height, age, last);
        }
    }
}
