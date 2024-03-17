package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(builder = Players.Builder.class)
public record Players(
        List<Player> players
) {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<Player> players;

        private Builder() {}

        public Builder withPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Players build() {
            return new Players(players);
        }
    }
}
