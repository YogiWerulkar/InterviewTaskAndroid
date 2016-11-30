package com.interactionone.interviewtask.foodandclothparadies.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ankita on 27/11/16.
 */

public class Products implements Serializable{
    private ArrayList<Product> listOfProducts=new ArrayList<>();

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
