package com.zlikun.lang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Activity 生命周期
 * https://developer.android.google.cn/guide/components/activities.html
 * https://developer.android.google.cn/images/activity_lifecycle.png
 *
 * 第1次打开
     06-12 14:38:38.683 5104-5104/? I/System.out: onCreate ...
     06-12 14:38:38.683 5104-5104/? I/System.out: onStart ...
     06-12 14:38:38.684 5104-5104/? I/System.out: onResume ...
 * 按Home键
     06-12 14:39:05.987 5104-5104/com.zlikun.lang I/System.out: onPause ...
     06-12 14:39:06.073 5104-5104/com.zlikun.lang I/System.out: onStop ...
 * 按菜单键
     06-12 14:39:20.635 5104-5104/com.zlikun.lang I/System.out: onRestart ...
     06-12 14:39:20.635 5104-5104/com.zlikun.lang I/System.out: onStart ...
     06-12 14:39:20.635 5104-5104/com.zlikun.lang I/System.out: onResume ...
 * 按返回键
     06-12 14:39:41.899 5104-5104/com.zlikun.lang I/System.out: onPause ...
     06-12 14:39:42.614 5104-5104/com.zlikun.lang I/System.out: onStop ...
     06-12 14:39:42.614 5104-5104/com.zlikun.lang I/System.out: onDestroy ...
 * 按菜单键
     06-12 14:44:21.061 5104-5104/com.zlikun.lang I/System.out: onCreate ...
     06-12 14:44:21.061 5104-5104/com.zlikun.lang I/System.out: onStart ...
     06-12 14:44:21.062 5104-5104/com.zlikun.lang I/System.out: onResume ...
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置控件布局
        setContentView(R.layout.activity_main);

        System.out.println("onCreate ...");

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

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop ...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart ...");
    }
}
