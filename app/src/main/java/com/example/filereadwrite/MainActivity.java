package com.example.filereadwrite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);

    }
    public void onSave(View v){
        try {
            FileOutputStream fout=openFileOutput(e1.getText().toString(),0);
            OutputStreamWriter osw=new OutputStreamWriter(fout);
            osw.write(e2.getText().toString());
            osw.flush();
            osw.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onRead(View v){
        try{
            FileInputStream fin=openFileInput(e1.getText().toString());
            InputStreamReader isr=new InputStreamReader(fin);
            char[] c=new char[30];
            int n=isr.read(c,0,30);
            String str=new String(c,0,n);
            e2.setText(str);
            isr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}