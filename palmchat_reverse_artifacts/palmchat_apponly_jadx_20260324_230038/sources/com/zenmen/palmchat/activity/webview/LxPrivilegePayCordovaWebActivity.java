package com.zenmen.palmchat.activity.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.yy3;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LxPrivilegePayCordovaWebActivity extends CordovaWebActivity {
    public String Q0 = "";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends IceCreamCordovaWebViewClient {
        public a(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LxPrivilegePayCordovaWebActivity.this.C0.stop();
            LxPrivilegePayCordovaWebActivity.this.F0 = true;
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            LxPrivilegePayCordovaWebActivity.this.C0.start();
            LxPrivilegePayCordovaWebActivity.this.D0.setVisibility(8);
            LxPrivilegePayCordovaWebActivity.this.F0 = false;
            LogUtil.i(CordovaWebActivity.M0, "onPageStarted url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public void E2(String str) {
        super.E2(str);
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null) {
            cordovaWebView.setBackgroundColor(0);
        }
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public CordovaWebViewClient H2(CordovaWebView cordovaWebView) {
        return new a(this, cordovaWebView);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public void l2() {
        super.l2();
        this.A0.setBackgroundColor(0);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yy3.a(this);
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        this.Q0 = getIntent().getExtras().getString("privilege_from_source");
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
