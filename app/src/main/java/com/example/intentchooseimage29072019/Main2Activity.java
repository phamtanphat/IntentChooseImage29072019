package com.example.intentchooseimage29072019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> mangAlbum ;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tableLayout = findViewById(R.id.tableLayout);
        mangAlbum = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_Animal)));


//        cot = 3 => Imageview
//        dong = 6 => tableRow
        int dong = 6;
        int cot = 3;
        for (int i = 0 ; i < dong ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0 ; y < cot ; y++){
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }
    }
}
