package com.zlikun.lang.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_open_another_aty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                // 显式Intent
//                startActivity(new Intent(MainActivity.this ,AnotherActivity.class));

                // 使用 intent-filter 标签下的 action 名称，来启动一个Activity
//                startActivity(new Intent("com.zlikun.lang.intent.action.AnotherActivity"));
                startActivity(new Intent(AnotherActivity.ACTION));

                // 使用纯字符串的一个好处是，可以启动其它应的Activity
                // com.zlikun.lang.intent.action.HelloActivity 是app模块里的Activity
                // 注意，两个模块包名不能相同，否则无法同时安装在同一个模拟器上

//                try {
//                    startActivity(new Intent("com.zlikun.lang.intent.action.HelloActivity"));
//                } catch (Exception e) {
//                    // 处理要打开的Activity不存在或无法打开异常
//                    Toast.makeText(MainActivity.this ,"无法启动指定的Activity!" ,Toast.LENGTH_SHORT) ;
//                }

            }
        });

    }
}
