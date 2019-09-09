package com.example.intentchooseimage29072019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

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
                final int index =  cot * i + y;
                if (index >= mangAlbum.size()){
                    break;
                }else{
                    final int valueHinhChon = getResources().getIdentifier(mangAlbum.get(index),"drawable",getPackageName());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(350,350);
                    layoutParams.setMargins(10 ,0,0,0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(valueHinhChon);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("valueHinh",valueHinhChon);
                            setResult(RESULT_OK,intent);
                            finish();
                        }
                    });
                }
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }
    }
}
