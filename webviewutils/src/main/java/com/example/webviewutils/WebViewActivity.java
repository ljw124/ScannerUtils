package com.example.webviewutils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;

public class WebViewActivity extends AppCompatActivity {

    private AgentWeb mAgentWeb;
    private android.webkit.ValueCallback<Uri[]> mFilePathCallback;
    private String acceptTypes;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initView();
    }

    private void  initView() {
        relativeLayout = findViewById(R.id.rl_content);
        initWebView("http://www.baidu.com/");
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
        //拍照
        @android.webkit.JavascriptInterface
        public void takePhoto() {
        }

        //获取地址总线
        @android.webkit.JavascriptInterface
        public String getAddressBus(){
            return "http://esb.ydjw.sc/service/api/e24503a8189147979974a9ba034c4e63/";
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
            mFilePathCallback = filePathCallback;
            acceptTypes = fileChooserParams.getAcceptTypes()[0];
            if (acceptTypes.equals("image/*")){
            } else if(acceptTypes.equals("picture/*")){
            } else {
            }
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
