package org.atelier.tennisplayer.domain.model;

import java.util.List;
import java.util.Objects;

public class AdditionalData {
    private final int rank;
    private final int points;
    private final int weight;
    private final int height;
    private final int age;
    private final List<Integer> last;

    private AdditionalData(Builder builder) {
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
        if (!(o instanceof AdditionalData that)) return false;
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
        return "AdditionalData{" +
                "rank=" + rank +
                ", points=" + points +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", last=" + last +
                '}';
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

        public AdditionalData build() {
            return new AdditionalData(this);
        }
    }
}
