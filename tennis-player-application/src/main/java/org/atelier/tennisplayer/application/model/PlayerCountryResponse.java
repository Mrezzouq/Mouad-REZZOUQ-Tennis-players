package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.PlayerCountry;

public record PlayerCountryResponse(
        String picture,
        String code
) {

    public static PlayerCountryResponse from(PlayerCountry country) {
        return PlayerCountryResponse.builder()
                .withCode(country.code())
                .withPicture(country.picture())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String picture;
        private String code;

        private Builder() {}

        public Builder withPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public PlayerCountryResponse build() {
            return new PlayerCountryResponse(picture, code);
        }
    }
}
