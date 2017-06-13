package com.zlikun.lang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zlikun.lang.domain.UserInfo;

import java.util.Date;

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
        findViewById(R.id.btn_open_aty_1).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.toString() ,"打开第一个Activity ...") ;
                // 启动一个Activity，Activity继承了Context，所以Intent构造方法第一个参数可以使用当前Activity对象，第二个参数表示要打开的Activity
                Intent intent = new Intent(MainActivity.this ,NetActivity.class) ;
                // 使用Intent传递值
                // 1、使用#putExtra()重载方法，添加多种类型值
                intent.putExtra("name" ,"zlikun") ;
                intent.putExtra("age" ,120) ;
                // 传递Object参数，对象必须实现 java.io.Serializable 接口，或 android.os.Parcelable 接口
                intent.putExtra("user" , new UserInfo("jinx" ,"12100000000" ,new Date())) ;
                // 使用Bundle，传递数据包
                Bundle bundle = new Bundle() ;
                bundle.putString("name2" ,"kevin");
                bundle.putInt("age2" ,18);
                // Bundle也可以存入一个Bundle
                bundle.putBundle("bundle" ,new Bundle());
                // 2、使用#putExtras()传递一个Bundle
                intent.putExtras(bundle) ;
                // 启动一个Activity
                startActivity(intent);
            }
        });

        // 打开另一个Activity，并接收返回值
        findViewById(R.id.btn_open_aty_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.toString() ,"打开第二个Activity ...") ;

                Intent intent = new Intent(MainActivity.this ,InputActivity.class) ;
                // 启动一个Activity并接收其返回值，参考：#onActivityResult()方法 实现
                // 传入一个请求状态码(第二个参数)
                startActivityForResult(intent ,0);
            }
        });

    }

    /**
     * 接收Activity返回状态码及信息
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(MainActivity.class.toString() ,String.format("Activity返回信息：requestCode = %d ,resultCode = %d ,data = %s"
                ,requestCode ,resultCode ,data.getStringExtra("text"))) ;
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
