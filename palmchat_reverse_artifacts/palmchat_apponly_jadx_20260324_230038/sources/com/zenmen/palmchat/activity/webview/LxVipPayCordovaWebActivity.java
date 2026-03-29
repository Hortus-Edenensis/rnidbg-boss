package com.zenmen.palmchat.activity.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.av4;
import defpackage.ds0;
import defpackage.fg6;
import defpackage.il5;
import defpackage.jb3;
import defpackage.ma3;
import defpackage.mb3;
import defpackage.qm5;
import defpackage.sy5;
import defpackage.uj6;
import defpackage.yy3;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.jssdk.LxVipPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LxVipPayCordovaWebActivity extends CordovaWebActivity {
    public boolean Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends IceCreamCordovaWebViewClient {
        public a(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LxVipPayCordovaWebActivity.this.C0.stop();
            LxVipPayCordovaWebActivity.this.F0 = true;
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            LxVipPayCordovaWebActivity.this.C0.start();
            LxVipPayCordovaWebActivity.this.D0.setVisibility(8);
            LxVipPayCordovaWebActivity.this.F0 = false;
            LogUtil.i(CordovaWebActivity.M0, "onPageStarted url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                WebResourceResponse webResourceResponseB = new uj6().b(webView, webResourceRequest);
                if (webResourceResponseB != null) {
                    return webResourceResponseB;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public void E2(String str) {
        super.E2(str);
        CordovaWebView cordovaWebView = this.X;
        if (cordovaWebView != null) {
            cordovaWebView.setBackgroundColor(0);
        }
        boolean zB = av4.b(getIntent(), "web_url");
        this.T0 = zB;
        if (zB) {
            av4.i(str);
            av4.j(true);
        }
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public CordovaWebViewClient H2(CordovaWebView cordovaWebView) {
        return new a(this, cordovaWebView);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        LogUtil.i("RefundManager", "LxVipPayCordovaWebActivity finish");
        if (this.T0) {
            av4.j(false);
        }
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
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("RefundManager", "LxVipPayCordovaWebActivity onDestroy");
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Uri data;
        super.onNewIntent(intent);
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        String queryParameter = data.getQueryParameter("code");
        ma3.f("data = " + queryParameter);
        if (il5.l(queryParameter)) {
            return;
        }
        if (!"10000".equals(queryParameter)) {
            sy5.e(this, R.string.pay_cancel, 0).g();
            LxVipPlugin.report("vip_buy_fail", 2, "", "", 2, -1, data.toString(), fg6.j(getApplicationContext()));
        }
        ds0.a().b(new jb3(queryParameter));
        this.S0 = true;
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.Q0 && this.R0 && !this.S0) {
            sy5.e(this, R.string.pay_cancel, 0).g();
            LxVipPlugin.report("vip_buy_fail", 2, "", "", 2, -1, "", fg6.j(getApplicationContext()));
            this.R0 = false;
        }
        this.Q0 = true;
    }

    @qm5
    public void receivedVipCheckEvent(mb3 mb3Var) {
        if (mb3Var != null) {
            this.R0 = true;
        }
    }
}
