package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.AdditionalData;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = Data.Builder.class)
public class Data {
    private final int rank;
    private final int points;
    private final int weight;
    private final int height;
    private final int age;
    private final List<Integer> last;

    private Data(Builder builder) {
        rank = builder.rank;
        points = builder.points;
        weight = builder.weight;
        height = builder.height;
        age = builder.age;
        last = builder.last;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getRank() {
        return rank;
    }

    public int getPoints() {
        return points;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getLast() {
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data that)) return false;
        return rank == that.rank &&
                points == that.points &&
                weight == that.weight &&
                height == that.height &&
                age == that.age &&
                Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, points, weight, height, age, last);
    }

    @Override
    public String toString() {
        return "Data{" +
                "rank=" + rank +
                ", points=" + points +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", last=" + last +
                '}';
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
            return new Data(this);
        }
    }
}
