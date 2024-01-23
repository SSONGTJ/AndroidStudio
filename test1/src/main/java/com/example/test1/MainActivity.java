package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch switchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void on(View v){
        switchView = findViewById(R.id.switch1);
        switchView.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener(){
            ImageView img = findViewById(R.id.img);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    // 이미지를 보여라
                    System.out.println("이미지를 보여라");
                    img.setVisibility(View.VISIBLE);
                } else {
                    // 이미지를 가려라
                    System.out.println("이미지를 가려라");
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}