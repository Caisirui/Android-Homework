package com.example.cai.kh5;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/4.
 */
public class DetailAdapter extends BaseAdapter {

    ArrayList<Detail> list;
    public DetailAdapter(Context context, ArrayList<Detail> list)
    {

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Detail getItem(int i) {


        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Detail detail=getItem(i);

        return view;
    }
}
