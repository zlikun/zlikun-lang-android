package com.zlikun.lang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int index ;
    private int id ;

    public MainActivity() {
        this.id = ++ index ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 将taskId和实例名称(内存)输出到界面上
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(String.format("TaskId = %d\nIndex = %d\nInstance = %s" ,getTaskId() ,id ,this));

        // 监听点击事件，打开自己
        findViewById(R.id.btn_start_self).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this ,MainActivity.class));
            }
        });

    }

    public static final String TAG = MainActivity.class.toString() ;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG ,"Activity-" + id + " 启动了 ...") ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG ,"Activity-" + id + " 停止了 ...") ;
    }
}
