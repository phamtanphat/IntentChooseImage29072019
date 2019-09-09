package com.example.intentchooseimage29072019;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    Integer valueHinhGoc = 0;
    int Request_Code_Image = 1;
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
        valueHinhGoc = getResources().getIdentifier(mangtenhinh.get(0),"drawable",getPackageName());
        imgRandom.setImageResource(valueHinhGoc);
        imgChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivityForResult(intent,Request_Code_Image);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Request_Code_Image && resultCode == RESULT_OK && data != null){
            int valueHinhchon = data.getIntExtra("valueHinh" , Integer.MIN_VALUE);
            imgChoose.setImageResource(valueHinhchon);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
