package com.example.me.activitdataexsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText mEdt1,mEdt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdt1=(EditText)findViewById(R.id.et1);
        mEdt2=(EditText)findViewById(R.id.et2);

    }
//直接利用Intent putExtra系列函数传递数据到SecondActivity
    public void bt1Click(View v){
            Intent intent=new Intent();
            intent.setClass(this, SecondActivity.class);
            intent.putExtra("name", mEdt1.getText().toString()) ;  //putExtra(String,String)

            intent.putExtra("age", Integer.valueOf(mEdt2.getText().toString())) ;//putExtra(String,Integer)

            intent.putExtra("pass", true) ;//putExtra(String,Boolean)
            startActivity(intent);


    }
//利用Bundle封装数据后再利用Intent Extras进行传递
    public void bt2Click(View v){
        Bundle bundle=new Bundle();
        bundle.putString("name", mEdt1.getText().toString());
        bundle.putInt("age", Integer.valueOf(mEdt2.getText().toString()));
        bundle.putBoolean("pass",true);
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
//利用Application全局变量传递数据
    public void bt3Click(View v){
        Intent intent=new Intent();
        intent.setClass(this, SecondActivity.class);

        MyApplication ma=(MyApplication)getApplication();
        ma.setAge(Integer.valueOf(mEdt2.getText().toString()));
        ma.setName(mEdt1.getText().toString());
        intent.putExtra("name", ma.getName());  //putExtra(String,String)
        intent.putExtra("age", ma.getAge());
        intent.putExtra("pass", ma.getPass());
        startActivity(intent);
    }


}
