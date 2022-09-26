package com.example.scannertest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.scannertest.bean.FinishPaymentResponse;
import com.example.scannertest.bean.HdPayCancle;
import com.example.scannertest.bean.HdPayMentRequest;
import com.example.webviewutils.WebViewActivity;
import com.google.gson.Gson;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;

import java.io.Serializable;
import java.math.BigDecimal;

public class WebTestActivity extends AppCompatActivity {

    private AgentWeb mAgentWeb;
    private android.webkit.ValueCallback<Uri[]> mFilePathCallback;
    private String acceptTypes;
    private RelativeLayout relativeLayout;
    public static final int REQUEST_CODE = 3;
    public static final int RESULT_CODE = 4;
    private TimeCount timeCount;
    private String requestStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.webviewutils.R.layout.activity_web_view);

        initView();
    }

    private void  initView() {
        relativeLayout = findViewById(R.id.rl_content);
        String url = getIntent().getStringExtra("url");
        String type = getIntent().getStringExtra("type");
        HdPayMentRequest request = (HdPayMentRequest) getIntent().getSerializableExtra("params");
        requestStr = GsonUtil.ser(request);
        Log.e("ser", requestStr);
        initWebView(url);
    }

    public void initWebView(String url) {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(relativeLayout, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go(url);
        mAgentWeb.getJsInterfaceHolder().addJavaObject("Android", new WebTestActivity.AndroidInterface());
        mAgentWeb.getAgentWebSettings().getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //清除缓存
        mAgentWeb.clearWebCache();
        AgentWebConfig.clearDiskCache(this);

        timeCount = new TimeCount(8000, 1000);
        timeCount.start();
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
//            Intent intent = new Intent(WebTestActivity.this, AppCompatActivity.class);
//            intent.putExtra("result", "{\"echoCode\":\"success\",\"status\":\"1\",\"voucherNum\":0,\"noVoucherNum\":0}");
//            setResult(RESULT_CODE, intent);
//            finish();
        }
    }

    /**
     * JS 调用 Android
     * 用于AgentWeb
     */
    public class AndroidInterface {
        //页面关闭
        @android.webkit.JavascriptInterface
        public void pageFinish(String result) {
            Intent intent = new Intent(WebTestActivity.this, AppCompatActivity.class);
            intent.putExtra("result", result);
            setResult(RESULT_CODE, intent);
            finish();
        }
    }

    //agentweb
    private com.just.agentweb.WebChromeClient mWebChromeClient = new com.just.agentweb.WebChromeClient() {
        @Override
        public void onProgressChanged(android.webkit.WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(android.webkit.WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.i("console", "[" + consoleMessage.messageLevel() + "] " + consoleMessage.message() + "(" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")");
            return super.onConsoleMessage(consoleMessage);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            return true;
        }
    };

    //agentweb
    private com.just.agentweb.WebViewClient mWebViewClient = new com.just.agentweb.WebViewClient() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
        }

        @Override
        public void onPageFinished(android.webkit.WebView view, String url) {
            mAgentWeb.getJsAccessEntrace().quickCallJs("setParams", requestStr);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onReceivedError(android.webkit.WebView view, WebResourceRequest request, WebResourceError error) {

        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onReceivedHttpError(android.webkit.WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {

        }
    };
}
