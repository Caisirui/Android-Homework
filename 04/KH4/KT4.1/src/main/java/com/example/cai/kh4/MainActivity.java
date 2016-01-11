package com.example.cai.kh4;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private int direction=2;
    private Button mbutton;
    private boolean On=false;
    private int posLeft,posRight;
    private int width;
    DisplayMetrics dm = new DisplayMetrics();

    private Thread thread;

    private Handler handler = new Handler(){
      public void handleMessage(Message msg){
          if(msg.what==1) {text.setPadding(text.getPaddingLeft()-10,text.getPaddingTop(),text.getPaddingRight(),text.getPaddingBottom());}
          if(msg.what==2) {text.setPadding(text.getPaddingLeft()+10,text.getPaddingTop(),text.getPaddingRight(),text.getPaddingBottom());}
      }
    };

    private class RollTask extends AsyncTask<Integer,Integer,Void>{

        protected Void doInBackground(Integer... args){
            try{
                while (On) {
                    Thread.sleep(100);
                    if (posLeft < width && direction==2) {
                        // message.what = 2;
                    }
                    else if(posRight==0 && direction == 2){
                        //message.what = 1;
                        direction = 1;
                    }
                    else if(posLeft == 0 && direction == 1){
                        //message.what = 2;
                        direction = 2;
                    }
                    else if(posLeft < width && direction == 1)
                    {
                        // message.what=1;
                    }
                    publishProgress();
            }
            }catch (InterruptedException e)
            {Thread.currentThread().interrupt();}

            return null;
        }
        protected void onProgressUpdate(Integer...args){
            if(direction==1) {text.setPadding(text.getPaddingLeft()-10,text.getPaddingTop(),text.getPaddingRight(),text.getPaddingBottom()); posLeft=text.getPaddingLeft(); posRight=text.getPaddingRight();}
            if(direction==2) {text.setPadding(text.getPaddingLeft()+10,text.getPaddingTop(),text.getPaddingRight(),text.getPaddingBottom()); posLeft=text.getPaddingLeft(); posRight=text.getPaddingRight();}
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        text = (TextView) findViewById(R.id.text1);

        mbutton = (Button) findViewById(R.id.bt);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //roll1();
                //roll2();
                roll3();
            }
        });
    }

    private void roll1(){
        if(On){thread.interrupt(); On = false;}
        else{thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (true) {
                        Message message = new Message();
                        Thread.sleep(100);
                        if (text.getPaddingLeft() < width && direction==2) {
                            message.what = 2;
                        }
                        else if(text.getPaddingRight() == 0 && direction == 2){
                            message.what = 1;
                            direction = 1;
                        }
                        else if(text.getPaddingLeft() == 0 && direction == 1){
                            message.what = 2;
                            direction = 2;
                        }
                        else if(text.getPaddingLeft() < width && direction == 1)
                        {
                            message.what=1;
                        }
                        handler.sendMessage(message);
                    }
                }catch(InterruptedException e){Thread.currentThread().interrupt();}
            }
        });
            thread.start();
            On = true;}
    }

    private void roll2(){
        if(On){thread.interrupt(); On = false;}
        else{thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (true) {
                       // Message message = new Message();
                        Thread.sleep(100);
                       if (text.getPaddingLeft() < width && direction==2) {
                           // message.what = 2;
                        }
                        else if(text.getPaddingRight() == 0 && direction == 2){
                            //message.what = 1;
                            direction = 1;
                        }
                        else if(text.getPaddingLeft() == 0 && direction == 1){
                            //message.what = 2;
                            direction = 2;
                        }
                        else if(text.getPaddingLeft() < width && direction == 1)
                        {
                           // message.what=1;
                        }
                        text.post(new Runnable() {
                            @Override
                            public void run() {
                                if (direction == 1) {
                                    text.setPadding(text.getPaddingLeft() - 10, text.getPaddingTop(), text.getPaddingRight(), text.getPaddingBottom());
                                }
                                if (direction == 2) {
                                    text.setPadding(text.getPaddingLeft() + 10, text.getPaddingTop(), text.getPaddingRight(), text.getPaddingBottom());
                                }
                            }
                        });
                    }
                }catch(InterruptedException e){Thread.currentThread().interrupt();}
            }
        });
            thread.start();
            On = true;}
    }

    private void roll3(){
        posLeft=text.getPaddingLeft();
        posRight=text.getPaddingRight();
        if(On) {On=false;}
        else{On=true; new RollTask().execute(text.getPaddingLeft(),text.getPaddingRight());}
    }

}
