package org.atelier.tennisplayer.domain.model;

import java.util.Objects;

public class TennisPlayer {
    private final int id;
    private final String firstname;
    private final String lastname;
    private final String shortname;
    private final String sex;
    private final PlayerCountry playerCountry;
    private final String picture;
    private final AdditionalData additionalData;

    private TennisPlayer(Builder builder) {
        id = builder.id;
        firstname = builder.firstname;
        lastname = builder.lastname;
        shortname = builder.shortname;
        sex = builder.sex;
        playerCountry = builder.playerCountry;
        picture = builder.picture;
        additionalData = builder.additionalData;
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

    public PlayerCountry getCountry() {
        return playerCountry;
    }

    public String getPicture() {
        return picture;
    }

    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TennisPlayer player)) return false;
        return id == player.id &&
                Objects.equals(firstname, player.firstname) &&
                Objects.equals(lastname, player.lastname) &&
                Objects.equals(shortname, player.shortname) &&
                Objects.equals(sex, player.sex) &&
                Objects.equals(playerCountry, player.playerCountry) &&
                Objects.equals(picture, player.picture) &&
                Objects.equals(additionalData, player.additionalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, shortname, sex, playerCountry, picture, additionalData);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", shortname='" + shortname + '\'' +
                ", sex='" + sex + '\'' +
                ", country=" + playerCountry +
                ", picture='" + picture + '\'' +
                ", additionalData=" + additionalData +
                '}';
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
            return new TennisPlayer(this);
        }
    }
}
