package org.atelier.tennisplayer.application.model;

import java.util.List;

public record PlayersResponse(
        List<TennisPlayerResponse> tennisPlayers) {

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<TennisPlayerResponse> tennisPlayers;

        private Builder() {}

        public Builder withTennisPlayers(List<TennisPlayerResponse> tennisPlayers) {
            this.tennisPlayers = tennisPlayers;
            return this;
        }

        public PlayersResponse build() {
            return new PlayersResponse(tennisPlayers);
        }
    }
}
