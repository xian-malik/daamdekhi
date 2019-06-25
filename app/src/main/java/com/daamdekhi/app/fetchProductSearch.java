package com.daamdekhi.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchProductSearch extends AsyncTask<Void, Void, Void> {
    private String _name = "";
    private String data = "";
    private String name = "";
    private String price = "";
    private String desc = "";
    private String meta = "";
    private String image = "";
    private Float rating = null;

    public fetchProductSearch(String _name) {
        super();
        this._name = _name;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://daamdekhi.com/api/testproducts.json");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
            String line = "";
            while ( line != null ) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray JA = new JSONArray(data);
            JSONObject JO =  new JSONObject();
            for (int i = 0; i < JA.length() ; i++ ) {
                JO = (JSONObject) JA.get(i);
                String el = (String) JO.get("name");
                if ( el.toLowerCase().equals(this._name.toLowerCase()) ) { break; }
            }
            name = (String) JO.get("name");
            price = Integer.toString( ( Integer ) JO.get("price") );
            desc = (String) JO.get("desc");
            meta = (String) JO.get("meta");
            image = (String) JO.get("image");
            rating = (Float) JO.get("rating");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ProductDetailsActivity.productPrice.setText(this.price);
        ProductDetailsActivity.productDesc.setText(this.desc);
        ProductDetailsActivity.productName.setText(this.name);
        ProductDetailsActivity.productMeta.setText(this.meta);
        ProductDetailsActivity.productRating.setStepSize(this.rating);
        URL url;
        Bitmap bmp;
        try {
            url = new URL(image);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ProductDetailsActivity.productImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
