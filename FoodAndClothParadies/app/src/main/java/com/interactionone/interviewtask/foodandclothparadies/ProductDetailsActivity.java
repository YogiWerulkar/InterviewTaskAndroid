package com.interactionone.interviewtask.foodandclothparadies;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.interactionone.interviewtask.foodandclothparadies.models.ImageBitmapCache;
import com.interactionone.interviewtask.foodandclothparadies.models.Product;
import com.interactionone.interviewtask.foodandclothparadies.models.ProductImages;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    TextView product_desc;
    LinearLayout linear_layout_product_offer;
    LinearLayout linear_layout_product_base_price_info;
    LinearLayout linear_layout_product_buyable;
    LinearLayout linear_layout_product_can_deliver;
LinearLayout linear_layout_product_can_pickable;
    LinearLayout linear_layout_product_sale_price;
LinearLayout linear_layout_product_base_price;
LinearLayout linear_layout_product_wrapper;
LinearLayout linear_layout_product_stock;
    LinearLayout linear_layout_product_brand;
LinearLayout linear_layout_product_store;

    TextView text_product_can_deliver;
    TextView text_product_can_pickable;
    TextView text_product_wrraper;
TextView text_product_stock;
TextView text_product_store;

    TextView product_title_details;
    TextView product_size_or_tag;
    TextView text_product_sale_price;
    TextView text_product_base_price;
    TextView   text_product_brand;
NetworkImageView product_store_logo;

    TextView text_product_base_price_info;
    TextView text_product_offer;
    ViewPager pager;
    private PagerAdapter mPagerAdapter;
    TextView text_product_buyable;
Product product=new Product();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
        //    setContentView(imv);
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
          //  setContentView(imv);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Product product = (Product) getIntent().getExtras().getSerializable("product");
        this.product=product;
        if(product.getProductListOfImages().size()==0){
            ProductImages productImages=new ProductImages();

            productImages.setImageUrl(product.getProductLogo().getImageUrl());
            product.getProductListOfImages().add(productImages);
        }

        linear_layout_product_offer=(LinearLayout)findViewById(R.id.linear_layout_product_offer);
        linear_layout_product_base_price_info=(LinearLayout)findViewById(R.id.linear_layout_product_base_price_info);
        linear_layout_product_buyable=(LinearLayout)findViewById(R.id.linear_layout_product_buyable);
        linear_layout_product_can_deliver=(LinearLayout)findViewById(R.id.linear_layout_product_can_deliver);
        linear_layout_product_can_pickable=(LinearLayout)findViewById(R.id.linear_layout_product_can_pickable);
        linear_layout_product_sale_price=(LinearLayout)findViewById(R.id.linear_layout_product_sale_price);
        linear_layout_product_base_price=(LinearLayout)findViewById(R.id.linear_layout_product_base_price);
        linear_layout_product_wrapper=(LinearLayout)findViewById(R.id.linear_layout_product_wrapper);
        linear_layout_product_stock=(LinearLayout)findViewById(R.id.linear_layout_product_stock);
        linear_layout_product_brand=(LinearLayout)findViewById(R.id.linear_layout_product_brand);
        linear_layout_product_store=(LinearLayout)findViewById(R.id.linear_layout_product_store);


        text_product_can_deliver=(TextView)findViewById(R.id.text_product_can_deliver);
         text_product_can_pickable=(TextView)findViewById(R.id.text_product_can_pickable);
        text_product_wrraper=(TextView)findViewById(R.id.text_product_wrraper);
        text_product_stock=(TextView)findViewById(R.id.text_product_stock);
        text_product_brand=(TextView)findViewById(R.id.text_product_brand);
        text_product_store=(TextView)findViewById(R.id.text_product_store);
        product_store_logo=(NetworkImageView)findViewById(R.id.product_store_logo);

        if(!product.getProductStoreName().equals("")){
            linear_layout_product_store.setVisibility(View.VISIBLE);
            text_product_store.setText(product.getProductStoreName());
            if(product.getProductStoreLogo()==null)
            product_store_logo.setImageUrl(product.getProductStoreLogo(), mImageLoader);

        }else{
            linear_layout_product_store.setVisibility(View.GONE);
        }

        if(!product.getProductBrandName().equals("")){
            linear_layout_product_brand.setVisibility(View.VISIBLE);
            text_product_brand.setText(product.getProductBrandName());

        }else{
            linear_layout_product_brand.setVisibility(View.GONE);
        }



        if(!product.getProductStockAvailable().equals("")){
            linear_layout_product_stock.setVisibility(View.VISIBLE);
            if(product.getProductStockAvailable()==true)
            text_product_stock.setText("Yes");
            else
                text_product_stock.setText("No");

        }else{
            linear_layout_product_stock.setVisibility(View.GONE);
        }

        if(product.getProductGiftWrapAmount()!=0){
            linear_layout_product_wrapper.setVisibility(View.VISIBLE);
            text_product_wrraper.setText("\u20B9"+product.getProductGiftWrapAmount());
        }else {
            linear_layout_product_wrapper.setVisibility(View.GONE);
        }
if(!product.getProductCanDeliver().equals("")){
    linear_layout_product_can_deliver.setVisibility(View.VISIBLE);
    if(product.getProductCanDeliver()==true)
    text_product_can_deliver.setText("Yes");
    else
        text_product_can_deliver.setText("No");
}else {
    linear_layout_product_can_deliver.setVisibility(View.GONE);
}if(!product.getProductCanPickup().equals("")){
            linear_layout_product_can_pickable.setVisibility(View.VISIBLE);
            if(product.getProductCanPickup()==true)
            text_product_can_pickable.setText("Yes");
            else
                text_product_can_pickable.setText("No");
        }else {
            linear_layout_product_can_pickable.setVisibility(View.GONE);
        }
        product_title_details=(TextView)findViewById(R.id.product_title_details);
        product_title_details.setText(""+product.getProductTitle());
        text_product_buyable=(TextView)findViewById(R.id.text_product_buyable);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        product_desc=(TextView)findViewById(R.id.product_desc);
        product_size_or_tag=(TextView)findViewById(R.id.product_size_or_tag);
        text_product_sale_price = (TextView) findViewById(R.id.text_product_sale_prices);
        if(!product.getProductSalePrice().equals("")) {
            linear_layout_product_sale_price.setVisibility(View.VISIBLE);
            text_product_sale_price.setText("\u20B9"+product.getProductSalePrice());
        }else{

            linear_layout_product_sale_price.setVisibility(View.GONE);
        }
        text_product_base_price = (TextView) findViewById(R.id.text_product_base_price);
        if(!product.getProductBasePrice().equals("")) {
            linear_layout_product_base_price.setVisibility(View.VISIBLE);
            text_product_base_price.setText("\u20B9"+product.getProductBasePrice());
        }else{

            linear_layout_product_base_price.setVisibility(View.GONE);
        }
        if(!product.getProductBuyable().equals("")) {
            linear_layout_product_buyable.setVisibility(View.VISIBLE);
            if(product.getProductBuyable()==true)
            text_product_buyable.setText("Yes");
            else
                text_product_buyable.setText("No");
        }else{
            linear_layout_product_buyable.setVisibility(View.GONE);
        }
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(mPagerAdapter);
if(!product.getProductPriceInfo().equals(""))
{
    text_product_base_price_info=(TextView)findViewById(R.id.text_product_base_price_info);
    text_product_base_price_info.setText(product.getProductPriceInfo());

}else{
    linear_layout_product_base_price_info.setVisibility(View.GONE);
}
        if(!product.getProductOffer().equals(""))
        {
            text_product_offer=(TextView)findViewById(R.id.text_product_offer);
            text_product_offer.setText(product.getProductOffer());

        }else{
            linear_layout_product_offer.setVisibility(View.GONE);
        }
        Log.d("yogesh","===>"+product.getProductDescription());
        product_desc.setText(product.getProductDescription());
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter;
        if(product.getProductSizeList().size()!=0) {
            dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, product.getProductSizeList());
        }else{
            product_size_or_tag.setText("Tags:");
            dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, product.getProductArrayOfTags());
        }
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

       /* if(product.getProductListOfImages().size()>0){

        imageViewProduct.setImageUrl(product.getProductListOfImages().get(0).getImageUrl(), getImageLoader());


        }else{
            imageViewProduct.setImageUrl(product.getProductLogo().getImageUrl(), getImageLoader());
        }*/

    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);

         /* Fragment fragment1 = new ScreenSlidePageFragment();
            Fragment fragment2 = new ScreenSlidePageFragment();
            Fragment fragment3 = new ScreenSlidePageFragment();
            fragments.add(fragment1);
            fragments.add(fragment2);
            fragments.add(fragment3);*/
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.getNewInstance(product.getProductListOfImages().get(position));
        }

        @Override
        public int getCount() {
            return product.getProductListOfImages().size();
        }
    }



    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new ImageBitmapCache());
        }
        return this.mImageLoader;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
