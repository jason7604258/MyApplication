package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class Bookkeeping extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;

    TextView theDate,theTime;
    Button btSave;

    SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    //設定日期顯示的格式
    SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss a", Locale.US);
    //設定時間顯示的格式

    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookkeeping_constraintlayout);
        count++;    // ++ : 遞增運算子 : 等於 count = count +1

        Log.d(TAG, "enter onCreate(), #" + count);
        uiInit();


    }
    private void uiInit(){
        theDate = findViewById(R.id.textView7);
        theTime = findViewById(R.id.textView8);

        btSave = findViewById(R.id.button);
    }

    @Override
    protected void onStart() {
        super.onStart();

        varInit();
        setUiListener();
        Log.d(TAG, "enter onStart(), #" + count);
    }

    private void varInit() {
        c = Calendar.getInstance();

        theDate.setText(df2.format(c.getTime()));
        theTime.setText(df.format(c.getTime()));
    }

    private void setUiListener() {
        theDate.setOnClickListener(this);
        theTime.setOnClickListener(this);
        btSave.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);
        releaseUiListener();
        super.onStop();
    }

    private void releaseUiListener() {
        theDate.setOnClickListener(null);
        theTime.setOnClickListener(null);
        btSave.setOnClickListener(null);

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy(), #" + count);
        count --;
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "enter onPause(), #" + count);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "enter onResume(), #" + count);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "enter onRestart(), #" + count);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //帳務資料儲存

                //返回主畫面
                startActivity(new Intent(this, MainActivity.class));
                //Bookkeeping.this.finish();
                break;
        }

    }
}