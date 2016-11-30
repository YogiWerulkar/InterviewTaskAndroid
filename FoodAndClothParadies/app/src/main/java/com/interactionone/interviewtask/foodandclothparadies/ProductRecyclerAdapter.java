package com.interactionone.interviewtask.foodandclothparadies;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.interactionone.interviewtask.foodandclothparadies.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankita on 27/11/16.
 */

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductRecyclerViewHolder>  {

    ArrayList<Product> products=new ArrayList<>();
ArrayList<Product> bookMarkList=new ArrayList<>();




CardView card_view;
    private ImageLoader imageLoader= ProductListingActivity.getInstance().getImageLoader();
    public ProductRecyclerAdapter(ArrayList<Product> products){
    this.products=products;
    }



    @Override
    public ProductRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view,parent,false);


        ProductRecyclerViewHolder productRecyclerViewHolder=new ProductRecyclerViewHolder(view,products);

        return productRecyclerViewHolder;
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void clear(){
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(ProductRecyclerViewHolder holder, final int position) {
        final Product product=products.get(position);
        holder.textView.setText(product.getProductTitle());
        if(!product.getProductSalePrice().equals(""))
        holder.productPrice.setText("\u20B9"+product.getProductBasePrice());
        else
            holder.productPrice.setText("\u20B9"+product.getProductBasePrice());
       if (imageLoader==null)
           imageLoader= ProductListingActivity.getInstance().getImageLoader();

        holder.imageView.setImageUrl(product.getProductLogo().getImageUrl(), imageLoader);
        if(bookMarkList.contains(product))
        holder.bookmark.setImageResource(R.drawable.images);
        else
            holder.bookmark.setImageResource(R.drawable.bookmark);
        if(position%2>0) {
            holder.product_tags.setVisibility(View.VISIBLE);
            holder.product_size.setVisibility(View.GONE);
        }else
        {
            holder.product_tags.setVisibility(View.GONE);
            holder.product_size.setVisibility(View.VISIBLE);
        }
        holder.product_size.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                List<String> list=products.get(position).getProductSizeList();
                CharSequence[] items = list.toArray(new CharSequence[list.size()]);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Select sizes");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        //mDoneButton.setText(items[item]);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        holder.product_tags.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                List<String> list=products.get(position).getProductArrayOfTags();
                CharSequence[] items = list.toArray(new CharSequence[list.size()]);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Select sizes");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        //mDoneButton.setText(items[item]);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                if (view.getId() != R.id.red){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                builder1.setMessage("Are you sure you want to add " + products.get(position).getProductTitle());
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                bookMarkList.add(products.get(position));
                                ImageView vieeee = (ImageView) view;
                                vieeee.setImageResource(R.drawable.images);
                                vieeee.setId(R.id.red);
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                    builder1.setMessage("Are you sure you want to remove " + products.get(position).getProductTitle());
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    bookMarkList.remove(products.get(position));
                                    ImageView vieeee = (ImageView) view;
                                    vieeee.setImageResource(R.drawable.bookmark);
                                    vieeee.setId(R.id.white);
                                    dialog.cancel();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public  class ProductRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textView;
TextView productPrice;
         NetworkImageView imageView;
        ArrayList<Product> products;
        TextView product_size;
        TextView product_tags;
    CardView card_view;
        ImageView bookmark;
        public ProductRecyclerViewHolder(View view,ArrayList<Product> products){
        super(view);
        textView=(TextView) view.findViewById(R.id.product_title);
            productPrice=(TextView) view.findViewById(R.id.product_price);
            imageView=(NetworkImageView) view.findViewById(R.id.product_image);
            bookmark=(ImageView)view.findViewById(R.id.bookmark);
            product_size=(TextView)view.findViewById(R.id.product_size);
            product_tags=(TextView)view.findViewById(R.id.product_tags);
            card_view=(CardView)view.findViewById(R.id.card_view);
            imageView.setClickable(false);
            view.setClickable(true);
            productPrice.setClickable(false);
            this.products=products;
            card_view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {


            //Toast.makeText(v.getContext(), "You clicked " + products.get(getAdapterPosition()).getProductTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                intent.putExtra("product", products.get(getAdapterPosition()));
                v.getContext().startActivity(intent);



    }
}}
