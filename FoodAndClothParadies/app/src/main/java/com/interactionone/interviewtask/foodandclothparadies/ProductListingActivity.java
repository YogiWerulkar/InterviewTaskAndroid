package com.interactionone.interviewtask.foodandclothparadies;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interactionone.interviewtask.foodandclothparadies.models.ImageBitmapCache;
import com.interactionone.interviewtask.foodandclothparadies.models.Product;
import com.interactionone.interviewtask.foodandclothparadies.models.ProductImages;
import com.interactionone.interviewtask.foodandclothparadies.models.ProductType;
import com.interactionone.interviewtask.foodandclothparadies.models.SizeGuide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductListingActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
     private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean flag=true;
    ProgressDialog pDialog;
    private static ProductListingActivity productListingActivity;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
   // ProductRecyclerAdapter mAdapter = new ProductRecyclerAdapter();


    public ArrayList<Product> listOfProducts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productListingActivity=this;

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);



        sendRequestForFood();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ProductRecyclerAdapter(listOfProducts);
        mRecyclerView.setAdapter(mAdapter);


    }

    public static synchronized ProductListingActivity getInstance() {
        return productListingActivity;
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }
    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new ImageBitmapCache());
        }
        return this.mImageLoader;
    }

    private void sendRequestForFood(){

        String url="https://sky-firebase.firebaseapp.com/mobmerry/food.json";
       showpDialog();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray products = response.getJSONArray("products");

                  //  parseJsonResponse(products,"food");
                    jsonParseUsingGson(response.toString(),"food");

                   // mAdapter.notifyItemInserted(listOfProducts.size());

                }catch (JSONException e){
                    e.printStackTrace();
                }
              //  hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {
                hidepDialog();
            }
        });
        // Adding request to request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        sendRequestForCloths();
    }
public void jsonParseUsingGson(String jsonString,String type){
    int indexProduct=0;
    Gson gson = new GsonBuilder().create();
    ProductDataProvider productArrayList= gson.fromJson(jsonString, ProductDataProvider.class);
    ArrayList<Product> productsgson=productArrayList.getProductArrayList();
    Boolean myflag=true;
        for(int i=0;i<productsgson.size();i++){
            if(type.equals("cloth")){

                if(listOfProducts.size()>0 && myflag){

                    // listOfProducts.add(indexProduct+1,product);

                    if(listOfProducts.size()>indexProduct)
                        listOfProducts.add(indexProduct,productsgson.get(i));
                    indexProduct=indexProduct+2;


                }else{
                    myflag=false;
                    listOfProducts.add(productsgson.get(i));
                }

            }else{
                if(listOfProducts.size()>0 && myflag){

                    // listOfProducts.add(indexProduct+1,product);

                    if(listOfProducts.size()>indexProduct)
                        listOfProducts.add(indexProduct,productsgson.get(i));
                    indexProduct=indexProduct+2;


                }else{
                    myflag=false;
                    listOfProducts.add(productsgson.get(i));
                }
               //


            }

        }

    mAdapter.notifyDataSetChanged();
    //mAdapter.notifyItemInserted(listOfProducts.size());
}


    private void sendRequestForCloths(){
        String url = "https://sky-firebase.firebaseapp.com/mobmerry/cloths.json";

        //showpDialog();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", response.toString());
                try{
                    JSONArray products = response.getJSONArray("products");
                    //parseJsonResponse(products,"cloth");
                    jsonParseUsingGson(response.toString(),"cloth");
                    //mAdapter.notifyItemInserted(listOfProducts.size());

                }catch (JSONException e){
                    e.printStackTrace();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {
                hidepDialog();
            }
        });
        // Adding request to request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
