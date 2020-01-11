package com.example.android.diabetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ColorsAdapter extends ArrayAdapter<Integer> {
    public  ColorsAdapter(Context context, ArrayList<Integer> colorList){
       super(context,0,colorList);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position,View converView,ViewGroup parent){
      if (converView==null)
          converView= LayoutInflater.from(getContext())
                  .inflate(R.layout.custom_spinner_items,parent,false);
        ImageView imageView=converView.findViewById(R.id.imageView);
        int current_item=getItem(position);
        imageView.setImageResource(current_item);
        return converView;
    }
}
