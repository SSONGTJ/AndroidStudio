package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //버튼을 눌렀을때 호출되는 메소드
    @Override
    public void onClick(View view) {
        // PlayActivity.class 라는 액비티비를 활성화 시키기
        Intent intent = new Intent(this,PlayActivity.class);
        startActivity(intent);
    }
}