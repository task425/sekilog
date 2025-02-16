package com.example.myapplication;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysisConfig;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;


// MainActivity
public class Tensorflow extends AppCompatActivity {
    /*-- Cloud Firestore --*/
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


    MyGlobals myGlobals;

    /*-- tensorflow --*/
    // 定数
    private final int REQUEST_CODE_PERMISSIONS = 101;
    private final String[] REQUIRED_PERMISSIONS = new String[]{
            Manifest.permission.CAMERA};
    // UI
    private TextureView textureView;
    private ImageView imageView;
    // 推論
    //ObjectDetectionInterpriterクラスのインスタンス作成
    private ObjectDetectionInterpriter interpriter;

    //一定間隔の繰り返し処理
    private Timer timer;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private long delay, period;


    // 生成時に呼ばれる
    //OnCreate（書き足すならここに書く）
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        delay = 0;
        period = 10000;

    //アクションバーの非表示
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        /*-- データの転送 --*/

        myGlobals = (MyGlobals) this.getApplication();

        String sumaho = myGlobals.Text2.replace("台目", "");

        if(myGlobals.Text1.equals("A")){
            if(sumaho.equals("1")){
                // Timer インスタンスを生成
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        // handlerdを使って処理をキューイングする
                        handler.post(() -> {
                            tensorflowA1.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("2")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowA2.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("3")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowA3.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("4")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowA4.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("5")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowA5.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
        }


        if(myGlobals.Text1.equals("B")){
            if(sumaho.equals("1")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowB1.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("2")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowB2.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("3")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowB3.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("4")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowB4.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("5")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowB5.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
        }


        if(myGlobals.Text1.equals("C")){
            if(sumaho.equals("1")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowC1.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("2")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowC2.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("3")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowC3.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("4")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowC4.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
            if(sumaho.equals("5")){
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(() -> {
                            tensorflowC5.update(
                                    KEY_1,String.valueOf(ObjectDetectionInterpriter.count),
                                    KEY_2,true
                            );
                        });
                    }
                }, delay, period);
            }
        }

        /*-- デモ用のため、Cブロックまで。 --*/


        /*-- Tensorflowの機能 --*/
        // UI
        //Tensorflow関連のレイアウト。xmlのTextureViewとImageViewを連動させて表示してる
        this.textureView = findViewById(R.id.texture_view);
        this.imageView = findViewById(R.id.image_view);

        // 推論
        //ObjectDetectionInterpriterクラスと結合
        this.interpriter = new ObjectDetectionInterpriter(this);

        // パーミッションのチェック
        //カメラ機能が許可されているかの確認（tensorflowを使うための前準備）
        if (allPermissionsGranted()) {
            this.textureView.post(() -> startCamera());
        } else {
            ActivityCompat.requestPermissions(this,
                    REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

    }

    // パーミッション許可のリクエストの結果の取得
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera();
            } else {
                Toast.makeText(this, "ユーザーから権限が許可されていません。",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    // 全てのパーミッション許可
    private boolean allPermissionsGranted() {
        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /*tensorflowスタート*/
        // カメラの開始
        private void startCamera() {
            // プレビュー
            PreviewConfig previewConfig = new PreviewConfig.Builder().build();
            Preview preview = new Preview(previewConfig);
            preview.setOnPreviewOutputUpdateListener(
                    output -> {
                        // SurfaceTextureの更新
                        ViewGroup parent = (ViewGroup) this.textureView.getParent();
                        parent.removeView(this.textureView);
                        parent.addView(this.textureView, 0);

                        // SurfaceTextureをTextureViewに指定
                        //カメラ起動の設定
                        this.textureView.setSurfaceTexture(output.getSurfaceTexture());

                        // レイアウトの調整
                        Point point = new Point();
                        getWindowManager().getDefaultDisplay().getSize(point);
                        int w = point.x;
                        int h = point.x * 4 / 3;//カメラの比率
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w, h);
                        params.addRule(RelativeLayout.CENTER_IN_PARENT);
                        //比率の挿入
                        textureView.setLayoutParams(params);
                        params = new RelativeLayout.LayoutParams(w, w);
                        params.addRule(RelativeLayout.CENTER_IN_PARENT);
                        //フレームを表示
                        imageView.setLayoutParams(params);
                    });

            // 画像の解析
            //ObjectDetectionInterpriterクラスの内容
            ImageAnalysisConfig config = new ImageAnalysisConfig.Builder()
                    .setImageReaderMode(ImageAnalysis.ImageReaderMode.ACQUIRE_LATEST_IMAGE)
                    .build();
            ImageAnalysis imageAnalysis = new ImageAnalysis(config);
            imageAnalysis.setAnalyzer(Executors.newSingleThreadExecutor(),
                    (image, rotationDegrees) -> {
                        // 推論
                        Bitmap bitmap = imageToToBitmap(image.getImage(), rotationDegrees);
                        Bitmap result = this.interpriter.predict(bitmap);
                        bitmap.recycle();

                        // 結果の表示
                        this.imageView.post(() -> {
                            imageView.setImageBitmap(result);
                        });
                    });


            // バインド
            CameraX.bindToLifecycle(this, preview, imageAnalysis);

        }


    // ImageProxy → Bitmap
    private Bitmap imageToToBitmap(Image image, int rotationDegrees) {
        byte[] data = imageToByteArray(image);
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        if (rotationDegrees == 0) {
            return bitmap;
        } else {
            return rotateBitmap(bitmap, rotationDegrees);
        }
    }

    // Bitmapの回転
    private Bitmap rotateBitmap(Bitmap bitmap, int rotationDegrees) {
        Matrix mat = new Matrix();
        mat.postRotate(rotationDegrees);
        return Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), mat, true);
    }

    // Image → JPEGのバイト配列
    private byte[] imageToByteArray(Image image) {
        byte[] data = null;
        if (image.getFormat() == ImageFormat.JPEG) {
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            data = new byte[buffer.capacity()];
            buffer.get(data);
            return data;
        } else if (image.getFormat() == ImageFormat.YUV_420_888) {
            data = NV21toJPEG(YUV_420_888toNV21(image),
                    image.getWidth(), image.getHeight());
        }
        return data;
    }

    // YUV_420_888 → NV21
    private byte[] YUV_420_888toNV21(Image image) {
        byte[] nv21;
        ByteBuffer yBuffer = image.getPlanes()[0].getBuffer();
        ByteBuffer uBuffer = image.getPlanes()[1].getBuffer();
        ByteBuffer vBuffer = image.getPlanes()[2].getBuffer();
        int ySize = yBuffer.remaining();
        int uSize = uBuffer.remaining();
        int vSize = vBuffer.remaining();
        nv21 = new byte[ySize + uSize + vSize];
        yBuffer.get(nv21, 0, ySize);
        vBuffer.get(nv21, ySize, vSize);
        uBuffer.get(nv21, ySize + vSize, uSize);
        return nv21;
    }

    // NV21 → JPEG
    private byte[] NV21toJPEG(byte[] nv21, int width, int height) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        YuvImage yuv = new YuvImage(nv21, ImageFormat.NV21, width, height, null);
        yuv.compressToJpeg(new Rect(0, 0, width, height), 100, out);
        return out.toByteArray();
    }



}

