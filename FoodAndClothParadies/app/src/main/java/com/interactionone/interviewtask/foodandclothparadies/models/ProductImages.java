package com.interactionone.interviewtask.foodandclothparadies.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ankita on 27/11/16.
 */

public class ProductImages implements Serializable{
    @SerializedName("height")
    private Integer imageHeight;
    @SerializedName("width")
    private Integer imageWidth;
    @SerializedName("url")
    private String imageUrl;

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(""+imageHeight);
        parcel.writeString(""+imageWidth);
        parcel.writeString(imageUrl);

    }
    public static final Parcelable.Creator<ProductImages> CREATOR
            = new Parcelable.Creator<ProductImages>() {
        public ProductImages createFromParcel(Parcel in) {
            return new ProductImages(in);
        }

        public ProductImages[] newArray(int size) {
            return new ProductImages[size];
        }
    };

    private ProductImages(Parcel in) {
        imageHeight = Integer.parseInt(in.readString());
        imageWidth = Integer.parseInt(in.readString());
        imageUrl = in.readString();
    }*/

    @Override
    public String toString() {
        return "ProductImages{" +
                "imageHeight=" + imageHeight +
                ", imageWidth=" + imageWidth +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
