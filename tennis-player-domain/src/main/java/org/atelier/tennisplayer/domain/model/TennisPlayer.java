package org.atelier.tennisplayer.domain.model;

public record TennisPlayer(
        int id,
        String firstname,
        String lastname,
        String shortname,
        String sex,
        PlayerCountry playerCountry,
        String picture,
        AdditionalData additionalData
) {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private String firstname;
        private String lastname;
        private String shortname;
        private String sex;
        private PlayerCountry playerCountry;
        private String picture;
        private AdditionalData additionalData;

        private Builder() {}

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withShortname(String shortname) {
            this.shortname = shortname;
            return this;
        }

        public Builder withSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder withCountry(PlayerCountry playerCountry) {
            this.playerCountry = playerCountry;
            return this;
        }

        public Builder withPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder withAdditionalData(AdditionalData additionalData) {
            this.additionalData = additionalData;
            return this;
        }

        public TennisPlayer build() {
            return new TennisPlayer(id, firstname, lastname, shortname, sex, playerCountry, picture, additionalData);
        }
    }
}
