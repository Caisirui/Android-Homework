package com.example.cai.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView textview;
    Button B1;
    Button B2;
    Button B3;
    Button B4;
    Button B5;
    Button B6;
    Button B7;
    Button B8;
    Button B9;
    Button B0;
    Button B_PIN;
    Button B_PLUS;
    Button B_MINUS;
    Button B_MUL;
    Button B_DIV;
    Button B_EQU;
    Button B_C;
    int pointCount=0;
    double result=0;
    int option=0;
    String S="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textView);
        B0 = (Button) findViewById(R.id.button0);
        B1 = (Button) findViewById(R.id.button1);
        B2 = (Button) findViewById(R.id.button2);
        B3 = (Button) findViewById(R.id.button3);
        B4 = (Button) findViewById(R.id.button4);
        B5 = (Button) findViewById(R.id.button5);
        B6 = (Button) findViewById(R.id.button6);
        B7 = (Button) findViewById(R.id.button7);
        B8 = (Button) findViewById(R.id.button8);
        B9 = (Button) findViewById(R.id.button9);
        B_C = (Button) findViewById(R.id.Clear);
        B_PIN = (Button) findViewById(R.id.buttonPIN);
        B_PLUS = (Button) findViewById(R.id.buttonPLUS);
        B_MINUS = (Button) findViewById(R.id.buttonMINUS);
        B_MUL = (Button) findViewById(R.id.buttonMUL);
        B_DIV = (Button) findViewById(R.id.buttonDIV);
        B_EQU = (Button) findViewById(R.id.buttonEQU);

        B0.setOnClickListener(listener);
        B1.setOnClickListener(listener);
        B2.setOnClickListener(listener);
        B3.setOnClickListener(listener);
        B4.setOnClickListener(listener);
        B5.setOnClickListener(listener);
        B6.setOnClickListener(listener);
        B7.setOnClickListener(listener);
        B8.setOnClickListener(listener);
        B9.setOnClickListener(listener);
        B_C.setOnClickListener(listener);
        B_PIN.setOnClickListener(listener);
        B_PLUS.setOnClickListener(listener);
        B_MINUS.setOnClickListener(listener);
        B_MUL.setOnClickListener(listener);
        B_DIV.setOnClickListener(listener);
        B_EQU.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView text = (TextView) findViewById(R.id.textView);
            Button B = (Button) v;
            String content = text.getText().toString();
            String Btn = B.getText().toString();

            if(B.getId()==R.id.button0||B.getId()==R.id.button1||B.getId()==R.id.button2||B.getId()==R.id.button3||B.getId()==R.id.button4||B.getId()==R.id.button5||B.getId()==R.id.button6
                    ||B.getId()==R.id.button7||B.getId()==R.id.button8||B.getId()==R.id.button9||(B.getId()==R.id.buttonPIN&&pointCount==0)){
                if(B.getId()==R.id.buttonPIN){
                    if(content.equals("")) {content += "0"+Btn; S += "0"+Btn;}
                    else{content += Btn; S += Btn;}
                    pointCount=1;
                }
                else {content += Btn;  S += Btn;}
                text.setText(content);
            }
            if(B.getId()==R.id.buttonPLUS||B.getId()==R.id.buttonMUL||B.getId()==R.id.buttonMINUS||B.getId()==R.id.buttonDIV){
                if(!S.equals("")){
                    if(option==0){result += Double.valueOf(S);Log.d(TAG,""+result);}
                    if(option==1){result += Double.valueOf(S);Log.d(TAG,""+result);}
                    if(option==2){result -= Double.valueOf(S);Log.d(TAG,""+result);}
                    if(option==3){result *= Double.valueOf(S);Log.d(TAG,""+result);}
                    if(option==4){if(Double.valueOf(S) != 0) result /= Double.valueOf(S); else Toast.makeText(MainActivity.this, "0不能为除数", Toast.LENGTH_LONG).show();}
                    if(B.getId()==R.id.buttonPLUS) {option=1;}
                    if(B.getId()==R.id.buttonMINUS){option=2;}
                    if(B.getId()==R.id.buttonMUL)  {option=3;}
                    if(B.getId()==R.id.buttonDIV)  {option=4;}
                    content += Btn;
                    text.setText(content);
                    S = "";
                }
            }
            if(B.getId()==R.id.buttonEQU){
                if(option==0){result += Double.valueOf(S);Log.d(TAG,""+result);}
                if(option==1){result += Double.valueOf(S);Log.d(TAG,""+result);}
                if(option==2){result -= Double.valueOf(S);Log.d(TAG,""+result);}
                if(option==3){result *= Double.valueOf(S);Log.d(TAG,""+result);}
                if(option==4){if(Double.valueOf(S) != 0) result /= Double.valueOf(S); else Toast.makeText(MainActivity.this, "0不能为除数", Toast.LENGTH_LONG).show();}
                content = "" +  result;
                text.setText(content);
                S = "" + result;
                option = 0;
                result = 0;
                pointCount=0;
            }
            if(B.getId()==R.id.Clear){
                content="";
                S="";
                option=0;
                result=0;
                text.setText(content);
                pointCount=0;
            }
        }
    };

}
