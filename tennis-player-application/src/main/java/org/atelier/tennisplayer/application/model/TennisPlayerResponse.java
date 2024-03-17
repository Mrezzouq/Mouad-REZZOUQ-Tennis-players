package org.atelier.tennisplayer.application.model;

import org.atelier.tennisplayer.domain.model.TennisPlayer;

public record TennisPlayerResponse(
        int id,
        String firstname,
        String lastname,
        String shortname,
        String sex,
        PlayerCountryResponse playerCountry,
        String picture,
        AdditionalDataResponse additionalData
) {

    public static TennisPlayerResponse from(TennisPlayer player) {
        return TennisPlayerResponse.builder()
                .withId(player.id())
                .withFirstname(player.firstname())
                .withLastname(player.lastname())
                .withShortname(player.shortname())
                .withSex(player.sex())
                .withPlayerCountry(PlayerCountryResponse.from(player.playerCountry()))
                .withPicture(player.picture())
                .withAdditionalData(AdditionalDataResponse.from(player.additionalData()))
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private String firstname;
        private String lastname;
        private String shortname;
        private String sex;
        private PlayerCountryResponse playerCountry;
        private String picture;
        private AdditionalDataResponse additionalData;

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

        public Builder withPlayerCountry(PlayerCountryResponse playerCountry) {
            this.playerCountry = playerCountry;
            return this;
        }

        public Builder withPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder withAdditionalData(AdditionalDataResponse additionalData) {
            this.additionalData = additionalData;
            return this;
        }

        public TennisPlayerResponse build() {
            return new TennisPlayerResponse(id, firstname, lastname, shortname, sex, playerCountry, picture, additionalData);
        }
    }
}
