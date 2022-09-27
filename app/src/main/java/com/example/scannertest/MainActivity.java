package com.example.scannertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webviewutils.GsonUtil;
import com.example.webviewutils.WebViewActivity;
import com.example.webviewutils.bean.FinishPaymentResponse;
import com.example.webviewutils.bean.HdPayMentRequest;
import com.example.webviewutils.bean.PayMentCancleResponse;
import com.ljw.scannerutils.view.CaptureActivity;

import org.apache.log4j.Logger;


public class MainActivity extends AppCompatActivity {

    private Button btnScan;
    private Button btnWv;
    private TextView tvMsg;
    private TextView tvType;
    private FinishPaymentResponse paymentResponse;
    private PayMentCancleResponse cancleResponse;
    private String requestType = ""; //payment-支付，cancel-冲销
    protected static Logger logger = Logger.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScan = findViewById(R.id.btn_scan);
        btnWv = findViewById(R.id.btn_wv);
        tvMsg = findViewById(R.id.tv_msg);
        tvType = findViewById(R.id.tv_type);

        // 测试扫码
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), CaptureActivity.REQUEST_CODE);
            }
        });

        // 测试webview
        btnWv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestType = "payment"; //保存请求类型，onActivityResult中处理数据用到
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", "http://vouchertest.bpsinopec.com/voucher-web-app-test/test.html");
                intent.putExtra("type", "payment"); //请求类型
                //下面是请求参数，传HdPayMentRequest对象或HdPayCancle对象
                String params = "{\"amount\":2.00,\"orderNumber\":\"3211a220829112545\",\"posNo\":\"3211a\",\"retailOrder\":{\"amount\":2.00,\"flowNo\":\"202208290001\",\"lines\":[{\"amount\":2.00,\"bsort\":\"3\",\"code\":\"1077\",\"gid\":\"3000649\",\"iqty\":1,\"lineNumber\":\"1\",\"msort\":\"311\",\"name\":\"农夫山泉550ml\",\"qty\":1,\"realAmount\":2.00,\"rtlprc\":2.00,\"ssort\":\"31101\"}],\"memberInfo\":{},\"operatorCode\":\"3516720978\",\"operatorName\":\"周朗春\",\"payments\":[],\"posNo\":\"3211a\",\"storeNo\":\"3211\",\"tranType\":1},\"storeNo\":\"3211\",\"uuid\":\"8a373c2182e726160182e7a23cc7006b\"}";
                HdPayMentRequest request = GsonUtil.deser(params, HdPayMentRequest.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("params", request);
                intent.putExtras(bundle);
                startActivityForResult(intent, WebTestActivity.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫码
        if (requestCode == CaptureActivity.REQUEST_CODE && resultCode == CaptureActivity.RESULT_CODE && null != data) {
            Bundle extras = data.getExtras();
            String msg = extras.getString("msg").trim();
            tvMsg.setText(msg);
        }
        // webview
        if (requestCode == WebViewActivity.REQUEST_CODE && resultCode == WebViewActivity.RESULT_CODE && null != data) {
            Bundle extras = data.getExtras();
            String result = extras.getString("result");
            String requestType = extras.getString("type");
            logger.info("WebView返回结果：" + result);
            if (("payment").equals(requestType)) {
                paymentResponse = GsonUtil.deser(result, FinishPaymentResponse.class);
            } else if ("cancel".equals(requestType)) {
                cancleResponse = GsonUtil.deser(result, PayMentCancleResponse.class);
            }
            tvType.setText("类型：" + requestType);
            tvMsg.setText(result);
        }
    }
}
