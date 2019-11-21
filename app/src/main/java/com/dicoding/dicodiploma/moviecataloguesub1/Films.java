package com.dicoding.dicodiploma.moviecataloguesub1;

import android.os.Parcel;
import android.os.Parcelable;

public class Films implements Parcelable {

    private String tittle;
    private String score;
    private String relase;
    private String description;
    private String status;
    private String language;
    private String runtime;
    private String genre;
    private int poster;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRelase() {
        return relase;
    }

    public void setRelase(String relase) {
        this.relase = relase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tittle);
        dest.writeString(this.score);
        dest.writeString(this.relase);
        dest.writeString(this.description);
        dest.writeString(this.status);
        dest.writeString(this.language);
        dest.writeString(this.genre);
        dest.writeString(this.runtime);
        dest.writeInt(this.poster);
    }

    public Films() {
    }

    protected Films(Parcel in) {
        this.tittle = in.readString();
        this.score = in.readString();
        this.relase = in.readString();
        this.description = in.readString();
        this.status = in.readString();
        this.language = in.readString();
        this.genre = in.readString();
        this.runtime = in.readString();
        this.poster = in.readInt();
    }

    public static final Parcelable.Creator<Films> CREATOR = new Parcelable.Creator<Films>() {
        @Override
        public Films createFromParcel(Parcel source) {
            return new Films(source);
        }

        @Override
        public Films[] newArray(int size) {
            return new Films[size];
        }
    };
}