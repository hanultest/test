package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    //소스작성은 onCreate에서 한다.
    //AppCompatActivity를 상속받았다.
    EditText edt_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //onCreate 부분은 인스턴스가 최초생성될때 무조건
        //View Wiget 들을 찾아서 이벤트를 연결할때 사용함

        //소스와 레이아웃 xml <-> java 연결부
        setContentView(R.layout.activity_main);
        Button btn_input = findViewById(R.id.btn_input);
        String msg = "안녕하세요";
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_naver = findViewById(R.id.btn_naver);
        btn_naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent 어떤 값을 다른 Activity나 Uri를 통해서 새창을 띄울때 사용
                Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });
        //전화걸기 이벤트
        //1.Button 선언 btn_call 변수명 입력
        //2.btn_call = findviewById(R.id.btn_call);
        //3.btn_call.setOnClickListener()
        //4.btn_call.setOnClickListener(new View.OnClickListener)
        //(new 띄어쓰기 -> ctrl + space ->메서드 목록에 이벤트가 안보이면 On침
        //5.@Overrid된 onClick 메소드 안에 코드작성

        Button btn_call = findViewById(R.id.btn_call);

        //전역변수 Edittext edt_num과 Layout.xml edt_num 연결
        edt_num = findViewById(R.id.edt_num);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                            //edt_num에 있는 텍스트를 받아와서
                                            //String 변수에 넣었음
                String phoneNum = "tel:" + edt_num.getText().toString();
                                            //ACTION_DIAL이라는 동작을 실행시키는데
                                            //PhoneNum이라는 String 변수를 넘겨서 사용함함
                Intent intent = new Intent(Intent.ACTION_DIAL
                                            ,Uri.parse(phoneNum));
                startActivity(intent);

            }
        });
        Button btn_New = findViewById(R.id.btn_New);
        btn_New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent로 새창을 띄울때는 시작하는 액티비티.this
                //새로 띄울 액티비티.class
                Intent intent = new Intent(MainActivity.this
                ,Sub_Activity.class);
                startActivity(intent);
            }
        });



    }//onCrate

}//Class












