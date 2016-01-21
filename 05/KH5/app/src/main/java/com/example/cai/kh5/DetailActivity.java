package com.example.cai.kh5;
import com.example.cai.kh5.DetailFragment.OnListFragmentInteractionListener;
import com.example.cai.kh5.dummy.DummyContent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class DetailActivity extends AppCompatActivity  implements OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] s=getResources().getStringArray(R.array.h1);
        int[] imgnum=getResources().getIntArray(R.array.h1_1);
        int[] imgnum1={R.mipmap.h1_1,R.mipmap.h1_2,R.mipmap.h1_3,R.mipmap.h1_4,R.mipmap.h1_5,R.mipmap.h1_6,R.mipmap.h1_7,R.mipmap.h1_8,};
        DummyContent D=new DummyContent(s.length,s,imgnum1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
