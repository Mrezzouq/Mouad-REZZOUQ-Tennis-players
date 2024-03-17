package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.PlayerCountry;

import java.util.Objects;

@JsonDeserialize(builder = Country.Builder.class)
public record Country (
        String picture,
        String code
){

    public static Builder builder() {
        return new Builder();
    }

    public PlayerCountry toCountry() {
        return PlayerCountry.builder()
                .withCode(code)
                .withPicture(picture)
                .build();
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

        public Country build() {
            return new Country(picture, code);
        }
    }
}
