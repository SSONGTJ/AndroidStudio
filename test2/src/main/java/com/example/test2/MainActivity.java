package com.example.test2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*
        판별하기 버튼을 눌렀을때, EditText 에 입력한 문자열을 읽어와서 int type 으로 바꾼다음

해당 숫자가 짝수이면 Toast 메세지로 "짝수입니다" 홀수이면 "홀수입니다" 가 출력되도록 프로그래밍 해 보세요.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText 참조값
        EditText inputNum = findViewById(R.id.inputNum);

        //Button 참조값
        Button btn = findViewById(R.id.testBtn);
        //Button 클릭 리스너 등록
        btn.setOnClickListener(v->{
            String iN = inputNum.getText().toString();
            int num = Integer.parseInt(iN);
            if(num % 2 == 0){
                Toast.makeText(this,"짝수입니다", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"홀수입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}