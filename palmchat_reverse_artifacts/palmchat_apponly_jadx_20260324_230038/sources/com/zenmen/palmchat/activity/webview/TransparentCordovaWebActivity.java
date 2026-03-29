package com.zenmen.palmchat.activity.webview;

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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TransparentCordovaWebActivity extends CordovaWebActivity {
    public String Q0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends IceCreamCordovaWebViewClient {
        public a(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TransparentCordovaWebActivity.this.C0.stop();
            TransparentCordovaWebActivity.this.F0 = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page_index", TransparentCordovaWebActivity.this.Q0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("16", "1", "1", jSONObject.toString());
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            TransparentCordovaWebActivity.this.C0.start();
            TransparentCordovaWebActivity.this.D0.setVisibility(8);
            TransparentCordovaWebActivity.this.F0 = false;
            LogUtil.i(CordovaWebActivity.M0, "onPageStarted url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page_index", TransparentCordovaWebActivity.this.Q0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("16", "1", "2", jSONObject.toString());
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

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public void J2() {
        super.J2();
        if (getIntent().getExtras() != null) {
            this.Q0 = getIntent().getExtras().getString("page_index", null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_index", this.Q0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("H1616", "1", null, jSONObject.toString());
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity
    public void K2(int i, String str, String str2) {
        super.K2(i, str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_index", this.Q0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("16", "1", "2", jSONObject.toString());
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
    }
}
