package org.apache.cordovaNew;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface CordovaWebViewEngine {

    /* JADX INFO: compiled from: SearchBox */
    public interface Client {
        void clearLoadTimeoutTimer();

        Boolean onDispatchKeyEvent(KeyEvent keyEvent);

        boolean onNavigationAttempt(String str);

        void onPageFinishedLoading(String str);

        void onPageStarted(String str);

        void onReceivedError(int i, String str, String str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface EngineView {
        CordovaWebView getCordovaWebView();
    }

    boolean canGoBack();

    void clearCache();

    void clearHistory();

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    ICordovaCookieManager getCookieManager();

    CordovaWebView getCordovaWebView();

    String getUrl();

    View getView();

    boolean goBack();

    void init(CordovaWebView cordovaWebView, CordovaInterface cordovaInterface, Client client, CordovaResourceApi cordovaResourceApi, PluginManager pluginManager, NativeToJsMessageQueue nativeToJsMessageQueue);

    void loadUrl(String str, boolean z);

    void setPaused(boolean z);

    void stopLoading();
}
