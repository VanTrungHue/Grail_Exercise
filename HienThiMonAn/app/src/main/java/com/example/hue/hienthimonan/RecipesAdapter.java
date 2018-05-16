package com.example.hue.hienthimonan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecipesAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Recipes> recipesList;

    public RecipesAdapter(Context context, int layout, List<Recipes> recipesList) {
        this.context = context;
        this.layout = layout;
        this.recipesList = recipesList;
    }

    @Override
    public int getCount() {
        return recipesList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh1,imgHinh2;
        TextView txtten;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtten = (TextView) convertView.findViewById(R.id.textViewTen);
            holder.imgHinh1 = (ImageView) convertView.findViewById(R.id.imageViewHinh1);
            holder.imgHinh2 = (ImageView) convertView.findViewById(R.id.imageViewHinhDetail);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }


        Recipes recipes = recipesList.get(position);
        holder.txtten.setText(recipes.getTenmon());
        holder.imgHinh1.setImageResource(recipes.getAnh1());
        holder.imgHinh2.setImageResource(recipes.getAnh2());

        return convertView;
    }
}
