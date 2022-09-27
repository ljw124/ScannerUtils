package com.example.webviewutils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webviewutils.bean.HdPayCancle;
import com.example.webviewutils.bean.HdPayMentRequest;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;

public class WebViewActivity extends AppCompatActivity {

    private AgentWeb mAgentWeb;
    private RelativeLayout relativeLayout;
    public static final int REQUEST_CODE = 3;
    public static final int RESULT_CODE = 4;
    private HdPayMentRequest payMentRequest;
    private HdPayCancle payCancle;
    private String requestType = ""; //payment-支付，cancel-冲销
    private String webUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initView();
    }

    private void  initView() {
        relativeLayout = findViewById(R.id.rl_content);
        webUrl = getIntent().getStringExtra("url");
        requestType = getIntent().getStringExtra("type");

        initWebView();
    }

    public void initWebView() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(relativeLayout, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go(webUrl);
        mAgentWeb.getJsInterfaceHolder().addJavaObject("Android", new AndroidInterface());
        mAgentWeb.getAgentWebSettings().getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //清除缓存
        mAgentWeb.clearWebCache();
        AgentWebConfig.clearDiskCache(this);
    }

    /**
     * JS 调用 Android
     * 用于AgentWeb
     */
    public class AndroidInterface {
        //页面关闭
        @android.webkit.JavascriptInterface
        public void pageFinish(String result) {
            Intent intent = new Intent(WebViewActivity.this, AppCompatActivity.class);
            intent.putExtra("result", result);
            intent.putExtra("type", requestType);
            setResult(RESULT_CODE, intent);
            finish();
        }
    }

    //WebChromeClient
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
            return super.onConsoleMessage(consoleMessage);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            return true;
        }
    };

    //WebViewClient
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
            parseData();
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

    // 根据类型处理对应的数据
    private void parseData () {
        if (("payment").equals(requestType)) {
            payMentRequest = (HdPayMentRequest) getIntent().getSerializableExtra("params");
            String ser = GsonUtil.ser(payMentRequest);
            mAgentWeb.getJsAccessEntrace().quickCallJs("setParams", ser);
        } else if ("cancel".equals(requestType)) {
            payCancle = (HdPayCancle) getIntent().getSerializableExtra("params");
            String ser = GsonUtil.ser(payCancle);
            mAgentWeb.getJsAccessEntrace().quickCallJs("setParams", ser);
        }
    }
}
