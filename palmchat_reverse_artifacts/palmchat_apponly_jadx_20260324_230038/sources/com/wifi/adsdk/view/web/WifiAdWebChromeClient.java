package com.wifi.adsdk.view.web;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiAdWebChromeClient extends WebChromeClient {
    private Handler handler;
    private VideoWebFactory mVideoWebFactory;

    public WifiAdWebChromeClient(WifiWebView wifiWebView) {
        this.mVideoWebFactory = new VideoWebFactory(wifiWebView.getContext(), wifiWebView);
    }

    public void destroy() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        VideoWebFactory videoWebFactory = this.mVideoWebFactory;
        if (videoWebFactory != null) {
            videoWebFactory.hideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        Message messageObtainMessage = this.handler.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.arg1 = i;
        this.handler.sendMessage(messageObtainMessage);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        VideoWebFactory videoWebFactory = this.mVideoWebFactory;
        if (videoWebFactory != null) {
            videoWebFactory.showCustomView(view, customViewCallback);
        }
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
