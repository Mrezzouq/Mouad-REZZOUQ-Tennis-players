package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = Players.Builder.class)
public class Players {
    private final List<Player> players;

    private Players(Builder builder) {players = builder.players;}

    public static Builder builder() {
        return new Builder();
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Players players1)) return false;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }

    public static final class Builder {
        private List<Player> players;

        private Builder() {}

        public Builder withPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Players build() {
            return new Players(this);
        }
    }
}
