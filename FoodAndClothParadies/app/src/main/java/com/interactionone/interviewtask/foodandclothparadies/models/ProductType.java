package com.interactionone.interviewtask.foodandclothparadies.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.interactionone.interviewtask.foodandclothparadies.ProductSize;
import com.interactionone.interviewtask.foodandclothparadies.ProductSize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankita on 27/11/16.
 */

public class ProductType implements Serializable{
@SerializedName("image")
    private ProductImages image;
    @SerializedName("sizes")
    private List<ProductSize> arrayOfProductSizes;

    public ProductImages getImage() {
        return image;
    }

    public void setImage(ProductImages image) {
        this.image = image;
    }

    public List<ProductSize> getArrayOfProductSizes() {
        return arrayOfProductSizes;
    }

    public void setArrayOfProductSizes(List<ProductSize> arrayOfProductSizes) {
        this.arrayOfProductSizes = arrayOfProductSizes;
    }

   /* @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(""+image);
        parcel.writeList(arrayOfProductSizes);
    }
    public static final Parcelable.Creator<ProductType> CREATOR
            = new Parcelable.Creator<ProductType>() {
        public ProductType createFromParcel(Parcel in) {
            return new ProductType(in);
        }

        public ProductType[] newArray(int size) {
            return new ProductType[size];
        }
    };

    private ProductType(Parcel in) {
        image = in.readString();
        arrayOfProductSizes = new ArrayList<>();
        in.readTypedList(arrayOfProductSizes, ProductSize.CREATOR);

    }*/
}
