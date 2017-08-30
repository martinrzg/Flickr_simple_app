package com.example.martinruiz.flickr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.martinruiz.flickr.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public class GridPhotoAdapter extends BaseAdapter {

    private Context context;
    private int layoutReference;
    private List<String> urls;

    public GridPhotoAdapter(Context context, int layoutReference, List<String> urls) {
        this.context = context;
        this.layoutReference = layoutReference;
        this.urls = urls;
    }


    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
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
            viewHolder.imageViewPhoto = (ImageView)  view.findViewById(R.id.imageViewPhoto);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //viewHolder.imageViewPhoto.setImageResource(R.drawable.ic_car);
        String url = urls.get(i);
        System.out.println("URL Adapter: "+url);
        Picasso.with(context).load(url).into(viewHolder.imageViewPhoto);

        return view;

    }
    static class ViewHolder {
        private ImageView imageViewPhoto;
    }
}
