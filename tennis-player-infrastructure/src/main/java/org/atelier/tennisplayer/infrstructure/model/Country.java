package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.PlayerCountry;

import java.util.Objects;

@JsonDeserialize(builder = Country.Builder.class)
public class Country {
    private final String picture;
    private final String code;

    private Country(Builder builder) {
        picture = builder.picture;
        code = builder.code;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getPicture() {
        return picture;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country that)) return false;
        return Objects.equals(picture, that.picture) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(picture, code);
    }

    @Override
    public String toString() {
        return "Country{" +
                "picture='" + picture + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public PlayerCountry toCountry() {
        return PlayerCountry.builder()
                .withCode(this.code)
                .withPicture(this.picture)
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
            return new Country(this);
        }
    }
}
