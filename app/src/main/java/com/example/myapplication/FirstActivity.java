package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //認識（tensorflowに移行する）ボタン（現在は人数入力画面に移行する）
        findViewById(R.id.button1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Dialogの準備
                        YesNoDialog1 dialog = new YesNoDialog1();
                        //「Down」というTagを付けてDialogを開く。
                        dialog.show(getSupportFragmentManager(), "");
                    }
                }
        );


        //表示（ディスプレイに色＋文字を出す画面）ボタン
        findViewById(R.id.button2).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Dialogの準備
                        YesNoDialog2 dialog = new YesNoDialog2();
                        //「Down」というTagを付けてDialogを開く。
                        dialog.show(getSupportFragmentManager(), "");
                    }
                }
        );

        findViewById(R.id.button3).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FirstActivity.this,ExplanationActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }

    public void DialogYes1(){
        Intent intent = new Intent(FirstActivity.this, SelectAlphabeticActivity.class);
        startActivity(intent);
    }

    public void DialogYes2(){
        Intent intent = new Intent(FirstActivity.this, DisplayActivity.class);
        startActivity(intent);
    }
}