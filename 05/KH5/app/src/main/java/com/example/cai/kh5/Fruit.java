package com.example.cai.kh5;

/**
 * Created by Cai on 2016/1/3.
 */
public class Fruit {
    private int imageId;
    private String name;
    public Fruit(int imageId,String name)
    {
        this.imageId=imageId; this.name=name;
    }

    public int getImageId()
    {
        return imageId;
    }

    public String getName()
    {
        return name;
    }
}
