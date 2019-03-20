package com.lcb.test.demo.vue;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.demo.vue.nextvue.VueNextActivity;
import com.lcb.test.demo.vue.nextvue2.VueNext2Activity;
import com.lcb.test.formal.base.BaseActivity;

public class VueActivity extends BaseActivity {

    WebView webview;
    LinearLayout titleLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue);
        findViewById(R.id.btn_next_vue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VueNextActivity.class));
            }
        });
        findViewById(R.id.btn_next_vue2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VueNext2Activity.class));
            }
        });
        webview = (WebView) findViewById(R.id.web);
        titleLinear = (LinearLayout) findViewById(R.id.title_linear);

//        webview.loadUrl("http://172.28.4.193:8080");
        WebSettings websettings = webview.getSettings();
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        //js交互
//        new MyJavascript();
        websettings.setJavaScriptEnabled(true);
        websettings.setDomStorageEnabled(true);
        //在js中调用java方法
        webview.addJavascriptInterface(new MyJavascript(), "android");
        webview.loadUrl("http://172.28.4.197:8080/");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Loading("正在加载VUE页面。。。");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                LoadSuccess("加载成功");
            }
        });

        //在java中调用js代码
        titleLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview.post(new Runnable() {
                    @Override
                    public void run() {
                        String msg = "在java中调用js代码";
                        webview.loadUrl("javascript:alertMessage()");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            webview.evaluateJavascript("javascript:alertMessage()", null);
                        }
                    }
                });
            }
        });
    }

    //暴露给js的功能接口
    public class MyJavascript {
        //显示吐司
        // 如果target 大于等于API 17，则需要加上如下注解
        @JavascriptInterface
        public void back() {
            Toast.makeText(VueActivity.this, "111", Toast.LENGTH_LONG).show();
        }

        //显示loading
        @JavascriptInterface
        public void showProgressDialog(String text) {
            LoadSuccess(text);
        }
    }

    //后退键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //菜单键
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "刷新");
        menu.add(0, 0, 1, "后退");
        menu.add(0, 0, 2, "前进");
        return super.onCreateOptionsMenu(menu);
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getOrder()) {
            case 0:
                webview.reload();
                break;
            case 1:
                if (webview.canGoBack()) {
                    webview.goBack();
                }
                break;
            case 2:
                if (webview.canGoForward()) {
                    webview.goForward();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initwebviewsetting() {
        //声明WebSettings子类
        WebSettings webSettings = webview.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
    }
}
