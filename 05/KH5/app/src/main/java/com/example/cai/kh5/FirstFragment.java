package com.example.cai.kh5;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cai on 2016/1/3.
 */
public class FirstFragment extends Fragment {

    private List<Fruit> fruitlist = new ArrayList<Fruit>();
    private GridView gridview;
    private FruitAdapter fruitadapter;




    //public class gridviewlistener  implements View.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        initFruits();
        fruitadapter = new FruitAdapter(getActivity(),R.layout.grid_item_first,fruitlist);
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        gridview = (GridView) view.findViewById(R.id.grid_view_first);
        gridview.setAdapter(fruitadapter);


        return view;
    }

    private void initFruits()
    {
        Fruit apple = new Fruit(R.mipmap.h1,"香辣芙蓉炒活蟹");
        fruitlist.add(apple);
        Fruit apricot = new Fruit(R.mipmap.h2,"西瓜饼干");
        fruitlist.add(apricot);
        Fruit banana = new Fruit(R.mipmap.h3,"香芹午餐肉厚烧蛋");
        fruitlist.add(banana);
        Fruit cherry = new Fruit(R.mipmap.h4,"豆花鱼片");
        fruitlist.add(cherry);
        Fruit kiwi = new Fruit(R.mipmap.h5,"蒜汁龙利鱼");
        fruitlist.add(kiwi);
        Fruit lemon = new Fruit(R.mipmap.h6,"火腿厚蛋烧");
        fruitlist.add(lemon);
        Fruit mango = new Fruit(R.mipmap.h7,"杂蔬金枪鱼意大利面");
        fruitlist.add(mango);
        Fruit orange = new Fruit(R.mipmap.h8,"韩式暖锅");
        fruitlist.add(orange);
        Fruit peach = new Fruit(R.drawable.peach512,"peach");
        fruitlist.add(peach);
    }

}
