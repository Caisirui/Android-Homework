package com.example.cai.kh4;

import android.content.Context;
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
    private int width;// = wm.getDefaultDisplay().getWidth();
    DisplayMetrics dm = new DisplayMetrics();
    private Handler handler = new Handler(){
      public void handleMessage(Message msg){
          if(msg.what==1) {text.setPadding(text.getPaddingLeft()-10,text.getPaddingTop(),text.getPaddingRight(),text.getPaddingBottom());}
          if(msg.what==2) {text.setPadding(text.getPaddingLeft()+10,text.getPaddingTop(),text.getPaddingRight(),text.getPaddingBottom());}
      }
    };
    private Thread thread;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        text = (TextView) findViewById(R.id.text1);
        mbutton = (Button) findViewById(R.id.bt);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
