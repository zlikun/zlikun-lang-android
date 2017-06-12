package com.zlikun.lang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置控件布局
        setContentView(R.layout.activity_main);

        // findViewById() 所有的可视化控件都可以用该方法获取(可能需要强转类型)
        // setOnClickListener() 用于设置点击事件
        findViewById(R.id.btn_open_another_activity).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.toString() ,"打开另一个Activity ...") ;
                // 启动一个Activity，Activity继承了Context，所以第一个参数可以使用当前Activity对象，第二个参数表示要打开的Activity
                startActivity(new Intent(MainActivity.this ,NetActivity.class));
            }
        });

    }
}
