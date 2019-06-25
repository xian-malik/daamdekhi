package com.daamdekhi.app;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    LinearLayout listView;
    SearchView inputSearch;

    public String[][] products = new String[][]{
        {"Best rice Dhaka", "Small desc", "100", "image"},
        {"Best rice Chittagong", "Small desc", "100", "image"},
        {"Best rice Comilla", "Small desc", "100", "image"},
    };
    View[] productsView = new View[4];
    Context context = this;
    String descHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = findViewById(R.id.searchResult);
        inputSearch = findViewById(R.id.inputSearch);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i=0; i<products.length; i++ ) {
            productsView[i] = layoutInflater.inflate(R.layout.search_item, null);
            TextView productName = productsView[i].findViewById(R.id.productName);
            productName.setText(products[i][0]);

            setOnClick(productsView[i], i);
            listView.addView(productsView[i], i);
        }

        inputSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return true; }
            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);
                return true;
            }
        });
    }

    private void callSearch(String query) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listView.removeAllViews();
        for (int i=0; i<products.length; i++ ) {
             if ( query == null || products[i][0].toLowerCase().contains(query.toLowerCase()) ) {
                productsView[i] = layoutInflater.inflate(R.layout.search_item, null);
                TextView productName = productsView[i].findViewById(R.id.productName);
                productName.setText(products[i][0]);
                descHolder = products[i][1];
                setOnClick(productsView[i], i);
                listView.addView(productsView[i], i);
            }
        }
    }

    private void setOnClick(@NonNull View v, final int i){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("ProductName", products[i][0]);
                startActivity(intent);
            }
        });
    }
}
