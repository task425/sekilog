package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Timer;
import java.util.TimerTask;

public class DisplayActivity extends AppCompatActivity {

    public static final String KEY_1 = "1";
    public static final String KEY_2 = "2";
    private DocumentReference tensorflowA1 = FirebaseFirestore.getInstance().document("sekilog/tensorflowA1");
    private DocumentReference tensorflowA2 = FirebaseFirestore.getInstance().document("sekilog/tensorflowA2");
    private DocumentReference tensorflowA3 = FirebaseFirestore.getInstance().document("sekilog/tensorflowA3");
    private DocumentReference tensorflowA4 = FirebaseFirestore.getInstance().document("sekilog/tensorflowA4");
    private DocumentReference tensorflowA5 = FirebaseFirestore.getInstance().document("sekilog/tensorflowA5");
    private DocumentReference tensorflowB1 = FirebaseFirestore.getInstance().document("sekilog/tensorflowB1");
    private DocumentReference tensorflowB2 = FirebaseFirestore.getInstance().document("sekilog/tensorflowB2");
    private DocumentReference tensorflowB3 = FirebaseFirestore.getInstance().document("sekilog/tensorflowB3");
    private DocumentReference tensorflowB4 = FirebaseFirestore.getInstance().document("sekilog/tensorflowB4");
    private DocumentReference tensorflowB5 = FirebaseFirestore.getInstance().document("sekilog/tensorflowB5");
    private DocumentReference tensorflowC1 = FirebaseFirestore.getInstance().document("sekilog/tensorflowC1");
    private DocumentReference tensorflowC2 = FirebaseFirestore.getInstance().document("sekilog/tensorflowC2");
    private DocumentReference tensorflowC3 = FirebaseFirestore.getInstance().document("sekilog/tensorflowC3");
    private DocumentReference tensorflowC4 = FirebaseFirestore.getInstance().document("sekilog/tensorflowC4");
    private DocumentReference tensorflowC5 = FirebaseFirestore.getInstance().document("sekilog/tensorflowC5");

    private int[] anumber = new int[5];
    private int[] bnumber = new int[5];
    private int[] cnumber = new int[5];
    private boolean[] abooleans = new boolean[5];
    private boolean[] bbooleans = new boolean[5];
    private boolean[] cbooleans = new boolean[5];

    //一定間隔の繰り返し処理
    private Timer timer;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private long delay1, period1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        delay1 = 0;
        period1 = 20000;
        //アクションバーを非表示にする
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        tensorflowA1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    anumber[0] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    abooleans[0] = documentSnapshot.getBoolean(KEY_2);
                    showA();
                }
            }
        });
        tensorflowA2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    anumber[1] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    abooleans[1] = documentSnapshot.getBoolean(KEY_2);
                    showA();
                }
            }
        });
        tensorflowA3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    anumber[2] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    abooleans[2] = documentSnapshot.getBoolean(KEY_2);
                    showA();
                }
            }
        });
        tensorflowA4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    anumber[3] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    abooleans[3] = documentSnapshot.getBoolean(KEY_2);
                    showA();
                }
            }
        });
        tensorflowA5.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    anumber[4] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    abooleans[4] = documentSnapshot.getBoolean(KEY_2);
                    showA();
                }
            }
        });

        tensorflowB1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    bnumber[0] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    bbooleans[0] = documentSnapshot.getBoolean(KEY_2);
                    showB();
                }
            }
        });
        tensorflowB2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    bnumber[1] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    bbooleans[1] = documentSnapshot.getBoolean(KEY_2);
                    showB();
                }
            }
        });
        tensorflowB3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    bnumber[2] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    bbooleans[2] = documentSnapshot.getBoolean(KEY_2);
                    showB();
                }
            }
        });
        tensorflowB4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    bnumber[3] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    bbooleans[3] = documentSnapshot.getBoolean(KEY_2);
                    showB();
                }
            }
        });
        tensorflowB5.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    bnumber[4] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    bbooleans[4] = documentSnapshot.getBoolean(KEY_2);
                    showB();
                }
            }
        });

        tensorflowC1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    cnumber[0] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    cbooleans[0] = documentSnapshot.getBoolean(KEY_2);
                    showC();
                }
            }
        });
        tensorflowC2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    cnumber[1] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    cbooleans[1] = documentSnapshot.getBoolean(KEY_2);
                    showC();
                }
            }
        });
        tensorflowC3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    cnumber[2] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    cbooleans[2] = documentSnapshot.getBoolean(KEY_2);
                    showC();
                }
            }
        });
        tensorflowC4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    cnumber[3] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    cbooleans[3] = documentSnapshot.getBoolean(KEY_2);
                    showC();
                }
            }
        });
        tensorflowC5.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot == null) return;
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.getString(KEY_1) == null) return;
                    if(documentSnapshot.getBoolean(KEY_2) == null) return;
                    cnumber[4] = Integer.parseInt(documentSnapshot.getString(KEY_1));
                    cbooleans[4] = documentSnapshot.getBoolean(KEY_2);
                    showC();
                }
            }
        });

        /*-- デモ用のため、Cブロックまで。 --*/


        /*-- 現在使用しているスマホの確認 --*/
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> {
                    tensorflowA1.update("2", FieldValue.delete());
                    tensorflowA2.update("2", FieldValue.delete());
                    tensorflowA3.update("2", FieldValue.delete());
                    tensorflowA4.update("2", FieldValue.delete());
                    tensorflowA5.update("2", FieldValue.delete());
                    tensorflowB1.update("2", FieldValue.delete());
                    tensorflowB2.update("2", FieldValue.delete());
                    tensorflowB3.update("2", FieldValue.delete());
                    tensorflowB4.update("2", FieldValue.delete());
                    tensorflowB5.update("2", FieldValue.delete());
                    tensorflowC1.update("2", FieldValue.delete());
                    tensorflowC2.update("2", FieldValue.delete());
                    tensorflowC3.update("2", FieldValue.delete());
                    tensorflowC4.update("2", FieldValue.delete());
                    tensorflowC5.update("2", FieldValue.delete());
                    abooleans[0] = false;
                    abooleans[1] = false;
                    abooleans[2] = false;
                    abooleans[3] = false;
                    abooleans[4] = false;
                    bbooleans[0] = false;
                    bbooleans[1] = false;
                    bbooleans[2] = false;
                    bbooleans[3] = false;
                    bbooleans[4] = false;
                    cbooleans[0] = false;
                    cbooleans[1] = false;
                    cbooleans[2] = false;
                    cbooleans[3] = false;
                    cbooleans[4] = false;
                });
            }
        }, delay1, period1);


    }
    private void showA(){
        TextView tv1 = (TextView)findViewById(R.id.tV1);
        TextView tv21 = (TextView) findViewById(R.id.tV21);
        TextView tv41 = (TextView) findViewById(R.id.tV41);

        int asum = 0;
        int adeno = 0;
        double aratio = 0;

        for (int i = 0; i < anumber.length; i++){
            asum += anumber[i];
            if(abooleans[i] == true){
                adeno +=10;
            }
        }
        Log.d("test1","adeno" + adeno);

        if(adeno != 0) {
            aratio = (double) asum / adeno;
        }

        Log.d("test2","aratio" + aratio);

        if(aratio >= 0.8){
            tv41.setText("A");
            tv21.setText("");
            tv1.setText("");
        }else if (aratio >=0.5){
            tv41.setText("");
            tv21.setText("A");
            tv1.setText("");
        }else {
            tv41.setText("");
            tv21.setText("");
            tv1.setText("A");
        }

    }

    private void showB() {
        TextView tv2 = (TextView) findViewById(R.id.tV2);
        TextView tv22 = (TextView) findViewById(R.id.tV22);
        TextView tv42 = (TextView) findViewById(R.id.tV42);

        int bsum = 0;
        int bdeno = 0;
        double bratio = 0;

        for (int i = 0; i < bnumber.length; i++) {
            bsum += bnumber[i];
            if (bbooleans[i] == true) {
                bdeno += 10;
            }
        }

        if (bdeno != 0) {
            bratio = (double) bsum / bdeno;
        }

        if (bratio >= 0.8) {
            tv42.setText("B");
            tv22.setText("");
            tv2.setText("");
        } else if (bratio >= 0.5) {
            tv42.setText("");
            tv22.setText("B");
            tv2.setText("");
        } else {
            tv42.setText("");
            tv22.setText("");
            tv2.setText("B");
        }

    }

    private void showC(){
        TextView tv3 = (TextView) findViewById(R.id.tV3);
        TextView tv23 = (TextView) findViewById(R.id.tV23);
        TextView tv43 = (TextView) findViewById(R.id.tV43);

        int csum = 0;
        int cdeno = 0;
        double cratio = 0;

        for (int i = 0; i < cnumber.length; i++){
            csum += cnumber[i];
            if(cbooleans[i] == true){
                cdeno +=10;
            }
        }

        if(cdeno != 0) {
            cratio = (double) csum / cdeno;
        }

        if(cratio >= 0.8){
            tv43.setText("C");
            tv23.setText("");
            tv3.setText("");
        }else if (cratio >=0.5){
            tv43.setText("");
            tv23.setText("C");
            tv3.setText("");
        }else {
            tv43.setText("");
            tv23.setText("");
            tv3.setText("C");
        }
    }
}