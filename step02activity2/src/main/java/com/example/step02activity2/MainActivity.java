package com.example.step02activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이동하기2 버튼의 참조값 얻어오기
        Button moveBtn2=findViewById(R.id.moveBtn2);
        moveBtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        // id가 moveBtn3 인 Button 객체의 참조값 얻어오기
        Button moveBtn3 = findViewById(R.id.moveBtn3);
        // 버튼에 클릭 리스너 등록하기 ( 함수형태)
        moveBtn3.setOnClickListener(v->{
            Intent intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

        // MainActivity 를 view.OnclickListener type 으로 만들고
        // MainActivity 를 이동하기4 버튼을 눌렀을 때 리스너 인터페이스로 등록하고
        // 동일한 동작을 하도록 프로그래밍 해 보세요
        Button moveBtn4 = findViewById(R.id.moveBtn4);
        moveBtn4.setOnClickListener(this);
    }
    public void clicked(View v){
        //Activity 이동하기
        
        //SubActivity 로 이동할 의도(Intent) 를 가지고 있는 객체 생성하기
        Intent intent = new Intent(this, SubActivity.class);
        
        //부모의 메소드를 이용해서 Activity 이동하기
        startActivity(intent);
    }
    // implements View.OnclickListener 인터페이스를 구현했기 때문에 강제로 오버라이드 된 메소드
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,SubActivity.class);
        startActivity(intent);
    }
}