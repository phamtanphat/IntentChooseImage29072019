package com.example.intentchooseimage29072019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> mangAlbum ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mangAlbum = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_Animal)));

    }
}
