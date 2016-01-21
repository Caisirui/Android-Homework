package com.example.cai.kh5;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cai on 2016/1/3.
 */
public class FruitAdapter extends ArrayAdapter<Fruit>
{
    private int resourceID;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects)
    {
        super(context,textViewResourceId,objects);
        resourceID=textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent)
    {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID, null);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.food_image);
        fruitImage.setImageResource(fruit.getImageId());
        TextView fruitname = (TextView) view.findViewById(R.id.food_name);
        fruitname.setText(fruit.getName());
        return view;
    }
}
