package com.wifi.adsdk.view.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.wifi.ad.core.utils.WifiLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiAdWebViewClient extends WebViewClient {
    private int deepNum = 0;
    private Handler handler;

    public void destroy() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        Message messageObtainMessage = this.handler.obtainMessage();
        messageObtainMessage.what = 3;
        this.handler.sendMessage(messageObtainMessage);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        Message messageObtainMessage = this.handler.obtainMessage();
        messageObtainMessage.what = 1;
        this.handler.sendMessage(messageObtainMessage);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        Message messageObtainMessage = this.handler.obtainMessage();
        messageObtainMessage.what = 4;
        this.handler.sendMessage(messageObtainMessage);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        WifiLog.d("WifiAdWebViewClient2 shouldOverrideUrlLoading deepNum " + this.deepNum + " url " + str + " hitTestResult " + hitTestResult);
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                if (hitTestResult == null) {
                    webView.loadUrl(str);
                    return true;
                }
            } else if (this.deepNum < 1) {
                try {
                    Intent uri = Intent.parseUri(str, 1);
                    if (uri != null) {
                        this.deepNum++;
                        webView.getContext().startActivity(uri);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
