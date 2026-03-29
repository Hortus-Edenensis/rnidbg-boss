package com.zenmen.palmchat.widget.advertisement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ZXWebView;
import defpackage.kp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.Config;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WebBanner extends FrameLayout implements CordovaInterface {
    public static final String TAG = "WebBanner";
    protected Whitelist externalWhitelist;
    protected Whitelist internalWhitelist;
    private int mHeight;
    private boolean mLoadCompleted;
    private boolean mLoadError;
    private String mUrl;
    protected ArrayList<PluginEntry> pluginEntries;
    protected CordovaPreferences preferences;
    private CordovaWebView webContent;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends IceCreamCordovaWebViewClient {
        public b(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LogUtil.i(WebBanner.TAG, "onPageFinished url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            LogUtil.i(WebBanner.TAG, "onPageStarted url:" + str);
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            System.out.println("跳转Sort：" + str);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebBanner.this.showBanner();
        }
    }

    public WebBanner(@NonNull Context context) {
        super(context, null);
        this.mHeight = 0;
    }

    private void init(Context context) {
        try {
            this.webContent = makeWebView();
            removeSystemJavaScriptInterface();
            this.webContent.setScrollBarStyle(33554432);
            this.webContent.setVerticalScrollBarEnabled(false);
            this.webContent.setOnScrollChangeListener(new a());
            this.webContent.setScrollBarSize((int) getResources().getDimension(R.dimen.webview_scrollbar_size));
            try {
                Field declaredField = View.class.getDeclaredField("mScrollCache");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this.webContent);
                Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj2, getResources().getDrawable(R.drawable.webview_scrollbar));
            } catch (Exception e) {
                e.printStackTrace();
            }
            createViews();
            addView(this.webContent);
            loadConfig();
            CordovaWebView cordovaWebView = this.webContent;
            if (cordovaWebView.pluginManager == null) {
                cordovaWebView.init(this, makeWebViewClient(cordovaWebView), makeChromeClient(this.webContent), this.pluginEntries, this.internalWhitelist, this.externalWhitelist, this.preferences);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void loadUrl(String str) {
        String str2 = this.mUrl;
        if (str2 == null || !str.equals(str2) || this.mLoadError) {
            this.mUrl = str;
            this.webContent.loadUrl(str);
            this.mLoadError = false;
            this.mLoadCompleted = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H191", null, null, jSONObject.toString());
        }
    }

    private void removeSystemJavaScriptInterface() {
        this.webContent.removeJavascriptInterface("accessibility");
        this.webContent.removeJavascriptInterface("accessibilityTraversal");
        this.webContent.removeJavascriptInterface("searchBoxJavaBridge_");
        this.webContent.getSettings().setSavePassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBanner() {
        if (getVisibility() == 0) {
            try {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mHeight);
                layoutParams.topMargin = (int) (getResources().getDisplayMetrics().density * 12.0f);
                layoutParams.bottomMargin = 0;
                setLayoutParams(layoutParams);
                this.webContent.requestFocusFromTouch();
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("H192", null, null, jSONObject.toString());
        }
    }

    public void createViews() {
        this.webContent.setId(100);
        this.webContent.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // org.apache.cordova.CordovaInterface
    public Activity getActivity() {
        return (Activity) getContext();
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return ZXWebView.getThreadPool();
    }

    public void handleDestroy() {
        CordovaWebView cordovaWebView = this.webContent;
        if (cordovaWebView != null) {
            cordovaWebView.handleDestroy();
        }
    }

    public void loadConfig() {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(getActivity());
        CordovaPreferences preferences = configXmlParser.getPreferences();
        this.preferences = preferences;
        preferences.setPreferencesBundle(getActivity().getIntent().getExtras());
        this.internalWhitelist = configXmlParser.getInternalWhitelist();
        this.externalWhitelist = configXmlParser.getExternalWhitelist();
        this.pluginEntries = configXmlParser.getPluginEntries();
        Config.parser = configXmlParser;
    }

    public CordovaChromeClient makeChromeClient(CordovaWebView cordovaWebView) {
        return new c(this, cordovaWebView);
    }

    public CordovaWebView makeWebView() {
        return new ZXWebView(getContext());
    }

    public CordovaWebViewClient makeWebViewClient(CordovaWebView cordovaWebView) {
        return new b(this, cordovaWebView);
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        if (!"onScrollChanged".equals(str)) {
            LOG.d(TAG, "onMessage(" + str + "," + obj + ")");
        }
        if (!"onReceivedError".equals(str)) {
            com.alipay.sdk.m.x.d.z.equals(str);
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            onReceivedError(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString("url"));
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onReceivedError(int i, String str, String str2) {
        this.mLoadError = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("H192", null, null, jSONObject.toString());
    }

    public void setHeight(int i) {
        this.mHeight = i;
        if (this.mLoadCompleted) {
            post(new d());
        }
    }

    public void update() {
        if (this.webContent == null) {
            setVisibility(8);
            return;
        }
        String strA = kp.a();
        if (TextUtils.isEmpty(strA)) {
            setVisibility(8);
        } else {
            loadUrl(strA);
            setVisibility(0);
        }
    }

    public WebBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeight = 0;
        init(context);
    }

    public WebBanner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeight = 0;
        init(context);
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends CordovaChromeClient {
        public c(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
            super(cordovaInterface, cordovaWebView);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            LogUtil.i(WebBanner.TAG, "onProgressChanged progress:" + i);
            if (i == 100) {
                WebBanner.this.mLoadCompleted = true;
                if (WebBanner.this.mHeight > 0) {
                    WebBanner.this.showBanner();
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CordovaWebView.OnScrollChangeListener {
        public a() {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onPageEnd(int i, int i2, int i3, int i4) {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onPageTop(int i, int i2, int i3, int i4) {
        }

        @Override // org.apache.cordova.CordovaWebView.OnScrollChangeListener
        public void onScrollChanged(int i, int i2, int i3, int i4) {
        }
    }
}
