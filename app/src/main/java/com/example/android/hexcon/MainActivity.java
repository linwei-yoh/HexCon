package com.example.android.hexcon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ET_bin =(EditText) findViewById(R.id.Input_Bin);
        EditText ET_dec =(EditText) findViewById(R.id.Input_Dec);
        EditText ET_hex =(EditText) findViewById(R.id.Input_Hex);

//        ET_bin.addTextChangedListener();
    }


}

