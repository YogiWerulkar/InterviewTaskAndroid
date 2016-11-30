package com.interactionone.interviewtask.foodandclothparadies;

import com.google.gson.annotations.SerializedName;
import com.interactionone.interviewtask.foodandclothparadies.models.Product;

import java.util.ArrayList;

/**
 * Created by ankita on 27/11/16.
 */

public class ProductDataProvider {
    @SerializedName("products")
    private ArrayList<Product> productArrayList;


    public ProductDataProvider( ArrayList<Product> productArrayList){
        this.productArrayList=productArrayList;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }
}
