package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.Country;

import java.util.Objects;

@JsonDeserialize(builder = CountryResponse.Builder.class)
public class CountryResponse {
    private final String picture;
    private final String code;

    private CountryResponse(Builder builder) {
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
        if (!(o instanceof CountryResponse that)) return false;
        return Objects.equals(picture, that.picture) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(picture, code);
    }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "picture='" + picture + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Country toCountry() {
        return Country.builder()
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

        public CountryResponse build() {
            return new CountryResponse(this);
        }
    }
}
