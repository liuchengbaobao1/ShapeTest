package com.lcb.test.demo.vue.nextvue;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;
import android.webkit.WebChromeClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;

@SuppressLint("SetJavaScriptEnabled")
public class VueNextActivity extends BaseActivity {

    private WebView webView;
    private WVJBWebViewClient webViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_next);

        webView=(WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
//        webView.loadUrl("file:///android_asset/ExampleApp.html");
        webView.loadUrl("http://172.28.4.178:8080/");

        webViewClient = new MyWebViewClient(webView);
        webViewClient.enableLogging();
        webView.setWebViewClient(webViewClient);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                webViewClient.send("此条消息是 Android 发送到 JS", new WVJBWebViewClient.WVJBResponseCallback() {

                    @Override
                    public void callback(Object data) {
                        Toast.makeText(VueNextActivity.this, "sendMessage got response: " + data, Toast.LENGTH_LONG).show();
                    }
                });
            }

        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    webViewClient.callHandler("testJavascriptHandler", new JSONObject("{\"greetingFromAndroid\": \"Hi there, JS!\" }"), new WVJBWebViewClient.WVJBResponseCallback() {

                        @Override
                        public void callback(Object data) {
                            Toast.makeText(VueNextActivity.this, "testJavascriptHandler responded: " + data, Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    class MyWebViewClient extends WVJBWebViewClient {
        public MyWebViewClient(WebView webView) {

            // support js send
            super(webView, new WVJBWebViewClient.WVJBHandler() {

                @Override
                public void request(Object data, WVJBResponseCallback callback) {
                    Toast.makeText(VueNextActivity.this, "Android收到消息来自 JS:" + data, Toast.LENGTH_LONG).show();
                    callback.callback("Response for message from Android!");
                }
            });

			/*
			// not support js send
			super(webView);
			*/

            enableLogging();

            registerHandler("testAndroidCallback", new WVJBWebViewClient.WVJBHandler() {

                @Override
                public void request(Object data, WVJBResponseCallback callback) {
                    Toast.makeText(VueNextActivity.this, "方法testAndroidCallback收到消息:" + data, Toast.LENGTH_LONG).show();
                    callback.callback("Android收到了消息，来自JS的方法：testAndroidCallback!");
                }
            });

            send("A string sent from Android before Webview has loaded.", new WVJBResponseCallback() {

                @Override
                public void callback(Object data) {
                    Toast.makeText(VueNextActivity.this, "Android got response! :" + data, Toast.LENGTH_LONG).show();
                }
            });

            try {
                callHandler("testJavascriptHandler", new JSONObject("{\"foo\":\"before ready\" }"),new WVJBResponseCallback() {

                    @Override
                    public void callback(Object data) {
                        Toast.makeText(VueNextActivity.this, "Android call testJavascriptHandler got response! :" + data, Toast.LENGTH_LONG).show();
                    }
                });
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

    }
}
