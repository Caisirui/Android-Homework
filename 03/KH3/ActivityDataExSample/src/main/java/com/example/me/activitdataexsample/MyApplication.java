package com.example.me.activitdataexsample;

import android.app.Application;

/**
 * Created by Administrator on 2015/12/7.
 */
public class MyApplication extends Application {
    private String name;
    private int age;
    private  boolean pass=true;

    public String getName(){return  name;}
    public void setName(String name){this.name=name;}
    public int getAge(){return age;}
    public void setAge(int age) {this.age=age;}
    public boolean getPass(){return pass;}
    public void setPass(boolean pass) {this.pass = pass;}
}
