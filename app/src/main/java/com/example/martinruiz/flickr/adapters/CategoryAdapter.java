package com.example.martinruiz.flickr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martinruiz.flickr.R;
import com.example.martinruiz.flickr.models.Category;

import java.util.List;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private int layoutReference;
    private List<Category> categories;

    public CategoryAdapter(Context context, int layoutReference, List<Category> categories) {
        this.context = context;
        this.layoutReference = layoutReference;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(layoutReference,null);

            viewHolder = new ViewHolder();
            //Referenciamos elemneto del layout a modificar
            viewHolder.textViewCategory    = (TextView) view.findViewById(R.id.textViewCategory);
            viewHolder.imageViewCategory = (ImageView)  view.findViewById(R.id.imageViewCategory);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String categoryName = categories.get(i).getName();
        int iconRef = categories.get(i).getReference();
        viewHolder.textViewCategory.setText(categoryName);
        viewHolder.imageViewCategory.setImageResource(iconRef);

        return view;
    }

    static class ViewHolder {
        private TextView textViewCategory;
        private ImageView imageViewCategory;
    }
}
