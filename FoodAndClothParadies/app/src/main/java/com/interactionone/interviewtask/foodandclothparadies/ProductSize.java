package com.interactionone.interviewtask.foodandclothparadies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.interactionone.interviewtask.foodandclothparadies.models.Products;

import java.io.Serializable;

/**
 * Created by ankita on 27/11/16.
 */

public class ProductSize implements Serializable{
    @SerializedName("color")
    private String color;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("available")
    private String available;
    @SerializedName("material")
    private String material;
    @SerializedName("size")
    private String size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

   /* @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(""+color);
        parcel.writeString(""+available);
        parcel.writeString(""+quantity);
        parcel.writeString(""+material);

        parcel.writeString(""+size);
    }

    public static final Parcelable.Creator<ProductSize> CREATOR
            = new Parcelable.Creator<ProductSize>() {
        public ProductSize createFromParcel(Parcel in) {
            return new ProductSize(in);
        }

        public ProductSize[] newArray(int size) {
            return new ProductSize[size];
        }
    };

    private ProductSize(Parcel in) {
        color = in.readString();
        available = in.readString();
        quantity = in.readString();
        material = in.readString();
        size = in.readString();

    }
*/
}
