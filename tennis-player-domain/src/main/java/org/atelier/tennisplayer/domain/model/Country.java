package org.atelier.tennisplayer.domain.model;

import java.util.Objects;

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
        if (!(o instanceof Country country)) return false;
        return Objects.equals(picture, country.picture) && Objects.equals(code, country.code);
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
