package com.dn.webappinteraction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        webView.loadUrl("file:///android_asset/index.html");

//        <input type="button" value="Say hello" onClick="showAndroidToast('Hello!')" />
//        <script type="text/javascript">
//                        function showAndroidToast(toast) {
//                    Android.showToast(toast);
//                }
//        </script>
        webView.loadUrl("javascript:Android.showToast('Hello!');");
    }

}