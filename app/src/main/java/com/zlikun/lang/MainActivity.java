package com.zlikun.lang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_vertical);     // 垂直布局
        setContentView(R.layout.activity_horizontal);   // 水平布局
    }
}
