package com.wifi.adsdk.view.web;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.wifi.adsdk.utils.InvokeUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiWebView extends WebView {
    public static final int ON_EVENT_ERROR = 4;
    public static final int ON_EVENT_FINISH = 3;
    public static final int ON_EVENT_PROGRESS = 2;
    public static final int ON_EVENT_START = 1;
    private Handler handler;
    private WebDelegate mWebDelegate;
    private WifiAdDownloadListener mWifiAdDownloadListener;
    private WifiAdWebChromeClient mWifiAdWebChromeClient;
    private WifiAdWebViewClient mWifiAdWebViewClient;

    public WifiWebView(Context context) {
        this(context, null);
    }

    private void init() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        InvokeUtils.invokeBooleanMethod(settings, "setSafeBrowsingEnabled", false);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAllowContentAccess(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(20971520L);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            settings.setMixedContentMode(0);
        } catch (Exception unused) {
        }
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        WifiAdWebChromeClient wifiAdWebChromeClient = new WifiAdWebChromeClient(this);
        this.mWifiAdWebChromeClient = wifiAdWebChromeClient;
        wifiAdWebChromeClient.setHandler(this.handler);
        WifiAdWebViewClient wifiAdWebViewClient = new WifiAdWebViewClient();
        this.mWifiAdWebViewClient = wifiAdWebViewClient;
        wifiAdWebViewClient.setHandler(this.handler);
        this.mWifiAdDownloadListener = new WifiAdDownloadListener();
        setWebChromeClient(this.mWifiAdWebChromeClient);
        setWebViewClient(this.mWifiAdWebViewClient);
        setDownloadListener(this.mWifiAdDownloadListener);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.handler.removeCallbacksAndMessages(null);
        this.mWifiAdWebChromeClient.destroy();
        this.mWifiAdWebViewClient.destroy();
    }

    public void setWebDelegate(WebDelegate webDelegate) {
        this.mWebDelegate = webDelegate;
    }

    public WifiWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WifiWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new Handler() { // from class: com.wifi.adsdk.view.web.WifiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1) {
                    WifiWebView.this.mWebDelegate.onPageStarted();
                    return;
                }
                if (i2 == 2) {
                    WifiWebView.this.mWebDelegate.onProgressChanged(message.arg1);
                } else if (i2 == 3) {
                    WifiWebView.this.mWebDelegate.onPageFinished();
                } else {
                    if (i2 != 4) {
                        return;
                    }
                    WifiWebView.this.mWebDelegate.onReceivedError();
                }
            }
        };
        init();
    }
}
