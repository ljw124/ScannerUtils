package com.example.scannertest;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scannertest.bean.FinishPaymentResponse;
import com.example.scannertest.bean.HdPayMentRequest;
import com.example.scannertest.bean.PayMentCancleResponse;
import com.ljw.scannerutils.view.CaptureActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnScan;
    private TextView tvMsg;
    private TimeCount timeCount;
    private FinishPaymentResponse paymentResponse;
    private PayMentCancleResponse cancleResponse;
    private String requestType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScan = findViewById(R.id.btn_scan);
        tvMsg = findViewById(R.id.tv_msg);

        // 测试扫码
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), CaptureActivity.REQUEST_CODE);
            }
        });

        // 测试webview
        timeCount = new MainActivity.TimeCount(5000, 1000);
        timeCount.start();
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
        if (requestCode == WebTestActivity.REQUEST_CODE && resultCode == WebTestActivity.RESULT_CODE && null != data) {
            Bundle extras = data.getExtras();
            String result = extras.getString("result").trim();
            if (("payment").equals(requestType)) {
                paymentResponse = GsonUtil.deser(result, FinishPaymentResponse.class);
            } else if ("cancel".equals(requestType)) {
                cancleResponse = GsonUtil.deser(result, PayMentCancleResponse.class);
            }
            tvMsg.setText(result);
            if (null != timeCount) {
                timeCount.cancel();
            }
        }
    }

    //计时器，执行定时任务
    public class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {  // 计时过程
        }

        @Override
        public void onFinish() {// 计时完毕
            timeCount.cancel();
            requestType = "payment";
            Intent intent = new Intent(MainActivity.this, WebTestActivity.class);
            intent.putExtra("url", "http://10.25.195.38:8081/dgDevice/spot/");
            intent.putExtra("type", "payment");
            String params = "{\"amount\":2.00,\"orderNumber\":\"3211a220829112545\",\"posNo\":\"3211a\",\"retailOrder\":{\"amount\":2.00,\"flowNo\":\"202208290001\",\"lines\":[{\"amount\":2.00,\"bsort\":\"3\",\"code\":\"1077\",\"gid\":\"3000649\",\"iqty\":1,\"lineNumber\":\"1\",\"msort\":\"311\",\"name\":\"农夫山泉550ml\",\"qty\":1,\"realAmount\":2.00,\"rtlprc\":2.00,\"ssort\":\"31101\"}],\"memberInfo\":{},\"operatorCode\":\"3516720978\",\"operatorName\":\"周朗春\",\"payments\":[],\"posNo\":\"3211a\",\"storeNo\":\"3211\",\"tranType\":1},\"storeNo\":\"3211\",\"uuid\":\"8a373c2182e726160182e7a23cc7006b\"}";
            HdPayMentRequest request = GsonUtil.deser(params, HdPayMentRequest.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("params", request);
            intent.putExtras(bundle);
            startActivityForResult(intent, WebTestActivity.REQUEST_CODE);
        }
    }
}
