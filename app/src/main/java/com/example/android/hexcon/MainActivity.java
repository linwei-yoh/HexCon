package com.example.android.hexcon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
            String DecVal,HexVal,BinVal;
            ET_dec.removeTextChangedListener(DecTextWatcher);
            ET_hex.removeTextChangedListener(HexTextWatcher);

            BinVal = charSequence.toString().replace(" ","");
            try {
                DecVal = Long.valueOf(BinVal,2).toString();
                HexVal = Long.toHexString(Long.valueOf(DecVal));
            }
            catch (NumberFormatException e)
            {
                DecVal = "";
                HexVal = "";
            }
            ET_dec.setText(DecFormat(DecVal));
            ET_hex.setText(HexFormat(HexVal));

            ET_bin.removeTextChangedListener(this);
            String DisVal = BinFormat(BinVal);
            ET_bin.setText(DisVal);
            ET_bin.setSelection(DisVal.length());
            ET_bin.addTextChangedListener(this);
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

            ET_bin.removeTextChangedListener(BinTextWatcher);
            ET_hex.removeTextChangedListener(HexTextWatcher);

            DecVal = charSequence.toString().replace(",","");
            try {
                BinVal = Long.toBinaryString((Long.valueOf(DecVal)));
                HexVal = Long.toHexString(Long.valueOf(DecVal)).toUpperCase();
            }
            catch (NumberFormatException e)
            {
                BinVal = "";
                HexVal = "";
            }
            ET_bin.setText(BinFormat(BinVal));
            ET_hex.setText(HexFormat(HexVal));

            ET_dec.removeTextChangedListener(this);
            String DisVal = DecFormat(DecVal);
            ET_dec.setText(DisVal);
            ET_dec.setSelection(DisVal.length());
            ET_dec.addTextChangedListener(this);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            ET_bin.addTextChangedListener(BinTextWatcher);
            ET_hex.addTextChangedListener(HexTextWatcher);
        }
    };

    TextWatcher HexTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String DecVal,BinVal,HexVal;
            ET_bin.removeTextChangedListener(BinTextWatcher);
            ET_dec.removeTextChangedListener(DecTextWatcher);

            HexVal = charSequence.toString().replace(" ","");
            try {
                DecVal = Long.valueOf(HexVal,16).toString();
                BinVal = Long.toBinaryString(Long.valueOf(DecVal));
            }
            catch (NumberFormatException e)
            {
                DecVal = "";
                BinVal = "";
            }

            ET_bin.setText(BinFormat(BinVal));
            ET_dec.setText(DecFormat(DecVal));

            ET_hex.removeTextChangedListener(this);
            String DisVal = HexFormat(HexVal.toUpperCase());
            ET_hex.setText(DisVal);
            ET_hex.setSelection(DisVal.length());
            ET_hex.addTextChangedListener(this);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            ET_bin.addTextChangedListener(BinTextWatcher);
            ET_dec.addTextChangedListener(DecTextWatcher);
        }
    };

    private String BinFormat(String string){
        StringBuffer buffer = new StringBuffer(string);
        StringBuffer Result = new StringBuffer();
        Result.append(buffer.reverse().toString().replaceAll("\\d{4}(?!$)","$0 "));
        return Result.reverse().toString();
    }

    private String DecFormat(String string){
        StringBuffer buffer = new StringBuffer(string);
        StringBuffer Result = new StringBuffer();
        Result.append(buffer.reverse().toString().replaceAll("\\d{3}(?!$)","$0,"));
        return Result.reverse().toString();
    }

    private String HexFormat(String string){
        StringBuffer buffer = new StringBuffer(string);
        StringBuffer Result = new StringBuffer();
        Result.append(buffer.reverse().toString().replaceAll("\\w{4}(?!$)","$0 "));
        return Result.reverse().toString().toUpperCase();
    }

}

