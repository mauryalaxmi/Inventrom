package com.example.maurya.androidproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadingActivity extends AppCompatActivity {
    EditText name,age,address,gender;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        address = (EditText) findViewById(R.id.address);
        gender = (EditText) findViewById(R.id.gender);
    }
    public void save (View view)
    {
        String text1=name.getText().toString();
        String text2=age.getText().toString();
        String text3=address.getText().toString();
        String text4=gender.getText().toString();
        String filename;
        File file=null;
        FileOutputStream  fileOutputStream=null;
        String filename1 = text1 +".txt";
        text1=text1 + "\n";text2=text2 + "\n";
        text3=text3 + "\n";text4=text4 + "\n";
        try {
            file =getFilesDir();
            fileOutputStream =openFileOutput(filename1, Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());
            fileOutputStream.write(text3.getBytes());
            fileOutputStream.write(text4.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "saved succesfully" + file+"/"+filename1 , Toast.LENGTH_SHORT).show();
    }
}
