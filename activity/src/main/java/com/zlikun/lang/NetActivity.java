package com.zlikun.lang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取文本输入框控件
                EditText et = (EditText) findViewById(R.id.et_url);
                // 获取输入文本
                String url = et.getText().toString() ;
                if (url == null) {
                    Log.w(NetActivity.class.toString() ,"未正确输入URL") ;
                    return ;
                }
                if (!url.toLowerCase().startsWith("http")) {
                    url = "http://" + url ;
                }
                Log.i(NetActivity.class.toString() ,"打开另一个URL(" + url + ") ...") ;
                // 打开一个网址，应用会打开可选择应用列表，以供打开URL(网页)
                startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse(url)));
            }
        });

    }

}
