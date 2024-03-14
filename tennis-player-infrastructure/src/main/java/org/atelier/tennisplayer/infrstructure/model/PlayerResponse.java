package org.atelier.tennisplayer.infrstructure.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.atelier.tennisplayer.domain.model.Player;

import java.util.Objects;

@JsonDeserialize(builder = PlayerResponse.Builder.class)
public class PlayerResponse {
    private final int id;
    private final String firstname;
    private final String lastname;
    private final String shortname;
    private final String sex;
    private final CountryResponse country;
    private final String picture;
    private DataResponse data;

    private PlayerResponse(Builder builder) {
        id = builder.id;
        firstname = builder.firstname;
        lastname = builder.lastname;
        shortname = builder.shortname;
        sex = builder.sex;
        country = builder.country;
        picture = builder.picture;
        data = builder.data;
    }

    public static Builder builder() {
        return new Builder();
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getShortname() {
        return shortname;
    }

    public String getSex() {
        return sex;
    }

    public CountryResponse getCountry() {
        return country;
    }

    public String getPicture() {
        return picture;
    }

    public DataResponse getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerResponse that)) return false;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(shortname, that.shortname) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(country, that.country) &&
                Objects.equals(picture, that.picture) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, shortname, sex, country, picture, data);
    }

    @Override
    public String toString() {
        return "PlayerResponse{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", shortname='" + shortname + '\'' +
                ", sex='" + sex + '\'' +
                ", country=" + country +
                ", picture='" + picture + '\'' +
                ", data=" + data +
                '}';
    }

    public Player toPlayer() {
        return Player.builder()
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
        private CountryResponse country;
        private String picture;
        private DataResponse data;

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

        public Builder withCountry(CountryResponse country) {
            this.country = country;
            return this;
        }

        public Builder withPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder withData(DataResponse data) {
            this.data = data;
            return this;
        }

        public PlayerResponse build() {
            return new PlayerResponse(this);
        }
    }
}
