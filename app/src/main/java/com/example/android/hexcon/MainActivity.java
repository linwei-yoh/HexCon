package com.example.android.hexcon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ET_bin,ET_dec,ET_hex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_bin =(EditText) findViewById(R.id.Input_Bin);
        ET_dec =(EditText) findViewById(R.id.Input_Dec);
        ET_hex =(EditText) findViewById(R.id.Input_Hex);
        ET_bin.addTextChangedListener(BinTextWatcher);
        ET_dec.addTextChangedListener(DecTextWatcher);
        ET_hex.addTextChangedListener(HexTextWatcher);
    }

    TextWatcher BinTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String DecVal,HexVal;
            ET_dec.removeTextChangedListener(DecTextWatcher);
            ET_hex.removeTextChangedListener(HexTextWatcher);
            try {
                DecVal = Integer.valueOf(charSequence.toString(),2).toString();
                HexVal = Integer.toHexString(Integer.valueOf(DecVal));
            }
            catch (NumberFormatException e)
            {
                DecVal = "";
                HexVal = "";
            }
            ET_dec.setText(DecVal);
            ET_hex.setText(HexVal);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            ET_dec.addTextChangedListener(DecTextWatcher);
            ET_hex.addTextChangedListener(HexTextWatcher);
        }
    };

    TextWatcher DecTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String BinVal,HexVal,DecVal;

            ET_dec.removeTextChangedListener(DecTextWatcher);
            ET_bin.removeTextChangedListener(BinTextWatcher);
            ET_hex.removeTextChangedListener(HexTextWatcher);
            Log.e("DEBUG","afterChanged");

            try {
                BinVal = Integer.toBinaryString((Integer.valueOf(charSequence.toString())));
                HexVal = Integer.toHexString(Integer.valueOf(charSequence.toString())).toUpperCase();
            }
            catch (NumberFormatException e)
            {
                BinVal = "";
                HexVal = "";
            }

            Log.e("DEBUG","转化完成" + "BinVal:" + BinVal +"\n" + "HexVal:" + HexVal);
            ET_bin.setText(BinVal);
            ET_hex.setText(HexVal);
            Log.e("DEBUG","赋值");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            ET_bin.addTextChangedListener(BinTextWatcher);
            ET_dec.addTextChangedListener(DecTextWatcher);
            ET_hex.addTextChangedListener(HexTextWatcher);
        }
    };

    TextWatcher HexTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String DecVal,BinVal;
            ET_bin.removeTextChangedListener(BinTextWatcher);
            ET_dec.removeTextChangedListener(DecTextWatcher);
            try {
                DecVal = Integer.valueOf(charSequence.toString(),16).toString();
                BinVal = Integer.toBinaryString(Integer.valueOf(charSequence.toString(),16));
            }
            catch (NumberFormatException e)
            {
                DecVal = "";
                BinVal = "";
            }

            ET_bin.setText(BinVal);
            ET_dec.setText(DecVal);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            ET_bin.addTextChangedListener(BinTextWatcher);
            ET_dec.addTextChangedListener(DecTextWatcher);
        }
    };




}

