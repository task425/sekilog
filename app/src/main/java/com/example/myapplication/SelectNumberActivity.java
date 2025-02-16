package com.example.myapplication;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelectNumberActivity extends AppCompatActivity {

    MyGlobals myGlobals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_number);

        myGlobals = (MyGlobals)this.getApplication();

        final String[] s2 = new String[1];



        //ポイント①「android.R.layout.simple_spinner_item」ではなく、自作のレイアウト「spinner_item.xml」を指定する
        //これによりスピナー内のtextSize等を個別に設定できるようになる。
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,getResources().getStringArray(R.array.spinner_number));

        //ポイント②「android.R.layout.simple_spinner_dropdown_item」ではなく、自作のレイアウト「spinner_dropdown_item.xml」を指定する
        //これによりスピナーを選択した際のドロップダウンリストのtextSize等を個別に設定出来るようになる。
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        spinner.setAdapter(adapter);

        // スピナーのアイテムが選択された時の動作を設定
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner spinner = (Spinner) parent;
                String item = (String) spinner.getSelectedItem();
                s2[0] = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //スピナーでは呼ばれない模様。ただし消せないので「おまじない」として残す。
            }
        });

        findViewById(R.id.button6).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myGlobals.Text2 = s2[0];
                        //Dialogの準備
                        YesNoDialogFragment dialog = new YesNoDialogFragment();
                        //「Down」というTagを付けてDialogを開く。
                        dialog.show(getSupportFragmentManager(), "\""+myGlobals.Text1+"の"+myGlobals.Text2+"\"");
                    }
                });




        //アクションバーの名前変更
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("初期設定２（撮影モード）");
        }


    }

    public void DialogYes(){
        Intent intent = new Intent(SelectNumberActivity.this, Tensorflow.class);
        startActivity(intent);
    }

}