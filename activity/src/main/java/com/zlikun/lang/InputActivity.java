package com.zlikun.lang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private static final String TAG = InputActivity.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        findViewById(R.id.btn_request_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取文本输入框控件
                EditText et = (EditText) findViewById(R.id.et_text);
                // 获取输入文本
                String text = et.getText().toString() ;
                if (text == null) {
                    Log.w(InputActivity.class.toString() ,"未正确输入文本") ;
                    return ;
                }
                Intent intent = new Intent() ;
                intent.putExtra("text" ,text) ;
                // 设置结果码和参数
                setResult(1 ,intent);
                // 结束当前Activity
                finish();
            }
        });

    }

}
