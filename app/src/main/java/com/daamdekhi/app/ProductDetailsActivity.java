package com.daamdekhi.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Product {
    String name;
    String price;
    String desc;
    String meta;
    String image;
    int rating;
};

class Seller {
    String name;
    String address;
    String phone;
    String email;
}

public class ProductDetailsActivity extends AppCompatActivity {

    public static TextView productPrice;
    public static TextView productDesc;
    public static TextView productName;
    public static TextView productMeta;
    public static ImageView productImage;
    public static RatingBar productRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productPrice = findViewById(R.id.productPrice);
        productDesc = findViewById(R.id.descriptionText);
        productName = findViewById(R.id.productName);
        productMeta = findViewById(R.id.metaText);
        productImage = findViewById(R.id.productImage);
        productRating = findViewById(R.id.productRating);

        Intent myIntent = getIntent();
        String name = myIntent.getStringExtra("ProductName");

        fetchProducts process = new fetchProducts(name);
        process.execute();
    }
}
