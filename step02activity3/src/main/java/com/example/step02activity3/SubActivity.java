package com.example.step02activity3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("activity_sub", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("activity_sub", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("activity_sub", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("activity_sub", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("activity_sub", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("activity_sub", "onDestroy()");
    }
}