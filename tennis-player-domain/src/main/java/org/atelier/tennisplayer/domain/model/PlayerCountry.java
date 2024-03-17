package org.atelier.tennisplayer.domain.model;

public record PlayerCountry(
        String picture,
        String code
) {

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

        public PlayerCountry build() {
            return new PlayerCountry(picture, code);
        }
    }
}
