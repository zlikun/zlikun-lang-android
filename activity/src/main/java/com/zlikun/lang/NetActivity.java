package com.zlikun.lang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NetActivity extends AppCompatActivity {

    private static final String TAG = NetActivity.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        // 获取上一个Activity传递过来的参数
        Intent intent = getIntent() ;
        // 1、根据键获取值
        Log.i(TAG ,String.format("key = %s ,value = %s" ,"name" ,intent.getStringExtra("name"))) ;
        Log.i(TAG ,String.format("key = %s ,value = %s" ,"age" ,intent.getIntExtra("age" ,100))) ;
        // 根据序列化方式来获取对象数据
        Log.i(TAG ,String.format("key = %s ,value = %s" ,"user" ,intent.getParcelableExtra("user"))) ;
        // Log.i(TAG ,String.format("key = %s ,value = %s" ,"user" ,intent.getSerializableExtra("user"))) ;
        Log.i(TAG ,"=======================================> 1") ;

        // 2、直接获取一个Bundle，从输出结果得知：使用#putExtra()方法添加的数据，也包含在Bundle中
        Bundle bundle = intent.getExtras() ;
        for (String key : bundle.keySet()) {
            Log.i(TAG ,String.format("key = %s ,value = %s" ,key ,bundle.get(key))) ;
        }
        Log.i(TAG ,"=======================================> 2") ;

        // 3、获取命名的Bundle
        Bundle bundle2 = intent.getBundleExtra("bundle") ;
        Log.i(TAG ,String.format("key = %s ,value = %s" ,"bundle" ,bundle2)) ;
        Log.i(TAG ,String.format("从Bundle对象中取得的Bundle与从Intent中取得的Bundle相同：%s" ,bundle.getBundle("bundle").equals(bundle2))) ;
        Log.i(TAG ,"=======================================> 3") ;

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
