package com.example.intentchooseimage29072019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgRandom,imgChoose;
    ArrayList<String> mangtenhinh ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgChoose = findViewById(R.id.imageviewHinhChon);
        imgRandom = findViewById(R.id.imageviewHinhrandom);

        //Task 1 : xu ly lay hinh trong drawable
        //Lay ten hinh tu trong string resource
        mangtenhinh = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_Animal)));
        Collections.shuffle(mangtenhinh);
        int imgHinh = getResources().getIdentifier(mangtenhinh.get(0),"drawable",getPackageName());
        imgRandom.setImageResource(imgHinh);
    }
}
