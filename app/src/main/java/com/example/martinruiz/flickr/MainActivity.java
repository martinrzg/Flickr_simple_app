package com.example.martinruiz.flickr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.martinruiz.flickr.API.API;
import com.example.martinruiz.flickr.API.APIServices.FlickrServices;
import com.example.martinruiz.flickr.activities.GridActivity;
import com.example.martinruiz.flickr.adapters.CategoryAdapter;
import com.example.martinruiz.flickr.models.Category;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listViewCategories) ListView listView;

    private ArrayList<Category> categories;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        categories = new ArrayList<>();
        setCategories();

        categoryAdapter = new CategoryAdapter(this,R.layout.item_category,categories);
        listView.setAdapter(categoryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                intent.putExtra("category",categories.get(i).getName());
                startActivity(intent);
            }
        });
    }

    private void setCategories() {
        categories.add(new Category("Food",R.drawable.ic_food));
        categories.add(new Category("Beach",R.drawable.ic_beach));
        categories.add(new Category("Cars",R.drawable.ic_car));
        categories.add(new Category("Mountain",R.drawable.ic_mountains));
        categories.add(new Category("Winter",R.drawable.ic_winter));
    }
}
