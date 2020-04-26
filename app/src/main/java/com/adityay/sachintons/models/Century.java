package com.adityay.sachintons.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Century implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("espnUrl")
    @Expose
    private String espnUrl;
    @SerializedName("matchFormat")
    @Expose
    private String matchFormat;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("ground")
    @Expose
    private String ground;
    @SerializedName("isNotOut")
    @Expose
    private Boolean isNotOut;
    @SerializedName("youtubeUrl")
    @Expose
    private String youtubeUrl;

    private String title;


    protected Century(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            score = null;
        } else {
            score = in.readInt();
        }
        description = in.readString();
        imageUrl = in.readString();
        date = in.readString();
        espnUrl = in.readString();
        matchFormat = in.readString();
        country = in.readString();
        ground = in.readString();
        byte tmpIsNotOut = in.readByte();
        isNotOut = tmpIsNotOut == 0 ? null : tmpIsNotOut == 1;
        youtubeUrl = in.readString();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (score == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(score);
        }
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(date);
        dest.writeString(espnUrl);
        dest.writeString(matchFormat);
        dest.writeString(country);
        dest.writeString(ground);
        dest.writeByte((byte) (isNotOut == null ? 0 : isNotOut ? 1 : 2));
        dest.writeString(youtubeUrl);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Century> CREATOR = new Creator<Century>() {
        @Override
        public Century createFromParcel(Parcel in) {
            return new Century(in);
        }

        @Override
        public Century[] newArray(int size) {
            return new Century[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }

    public String getEspnUrl() {
        return espnUrl;
    }

    public String getMatchFormat() {
        return matchFormat;
    }

    public String getCountry() {
        return country;
    }

    public String getGround() {
        return ground;
    }

    public Boolean getNotOut() {
        return isNotOut;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
