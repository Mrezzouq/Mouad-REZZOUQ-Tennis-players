package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.TennisPlayer;

@JsonDeserialize(builder = Player.Builder.class)
public record Player(
        int id,
        String firstname,
        String lastname,
        String shortname,
        String sex,
        Country country,
        String picture,
        Data data
) {

    public static Builder builder() {
        return new Builder();
    }

    public TennisPlayer toTennisPlayer() {
        return TennisPlayer.builder()
                .withId(this.id)
                .withFirstname(this.firstname)
                .withLastname(this.lastname)
                .withShortname(this.shortname)
                .withSex(this.sex)
                .withCountry(this.country.toCountry())
                .withPicture(this.picture)
                .withAdditionalData(this.data.toAdditionalData())
                .build();
    }

    public static final class Builder {
        private int id;
        private String firstname;
        private String lastname;
        private String shortname;
        private String sex;
        private Country country;
        private String picture;
        private Data data;

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

        public Builder withCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder withPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder withData(Data data) {
            this.data = data;
            return this;
        }

        public Player build() {
            return new Player(id, firstname, lastname, shortname, sex, country, picture, data);
        }
    }
}
