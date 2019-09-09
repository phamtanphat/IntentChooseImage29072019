package com.example.intentchooseimage29072019;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        randomImage();
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
            if (valueHinhchon == valueHinhGoc){
                Toast.makeText(this, "Chinh xac", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomImage();
                    }
                },1000);
            }else{
                Toast.makeText(this, "Sai roi", Toast.LENGTH_SHORT).show();
            }
        }else if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Nguoi dung chua chon con vat", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void randomImage(){
        Collections.shuffle(mangtenhinh);
        valueHinhGoc = getResources().getIdentifier(mangtenhinh.get(0),"drawable",getPackageName());
        imgRandom.setImageResource(valueHinhGoc);
    }
}
