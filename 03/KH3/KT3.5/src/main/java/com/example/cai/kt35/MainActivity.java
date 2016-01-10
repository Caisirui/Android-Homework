package com.example.cai.kt35;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //FragmentManager fragmentmanger = getFragmentManager();
                //Fragment fragment1 = fragmentmanger.findFragmentById(R.id.fragment1);
               // Fragment fragment2 = fragmentmanger.findFragmentById(R.id.fragment2);
                EditText edittext = (EditText) findViewById(R.id.edittext);
                TextView textview = (TextView) findViewById(R.id.text1);
                textview.setText(edittext.getText().toString());
            }
        });
    }


}
