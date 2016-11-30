package com.interactionone.interviewtask.foodandclothparadies;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.interactionone.interviewtask.foodandclothparadies.models.ProductImages;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends android.support.v4.app.Fragment {
    ProductImages images = new ProductImages();
    NetworkImageView networkImageView;
    private ImageLoader imageLoader= ProductListingActivity.getInstance().getImageLoader();
    public static ScreenSlidePageFragment getNewInstance(ProductImages images){
        ScreenSlidePageFragment screenSlidePageFragment=new ScreenSlidePageFragment();
        screenSlidePageFragment.images=images;
return screenSlidePageFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
       networkImageView=(NetworkImageView) v.findViewById(R.id.textviewImagesq);
        if (imageLoader==null)
            imageLoader= ProductListingActivity.getInstance().getImageLoader();
        networkImageView.setImageUrl(images.getImageUrl(), imageLoader);


        return v;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (imageLoader==null)
            imageLoader= ProductListingActivity.getInstance().getImageLoader();
        networkImageView.setImageUrl(images.getImageUrl(), imageLoader);

    }
}

