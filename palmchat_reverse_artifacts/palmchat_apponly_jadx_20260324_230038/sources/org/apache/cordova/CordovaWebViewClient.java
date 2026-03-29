package org.apache.cordova;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.m.x.d;
import com.huawei.hms.ads.dynamicloader.b;
import com.tide.protocol.util.TdFileUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaWebViewClient extends WebViewClient {
    private static String JSSDK_PATH = null;
    private static final String TAG = "CordovaWebViewClient";
    public static final String ZX_LOCAL_RES = "/zx_local_res/";
    CordovaWebView appView;
    CordovaInterface cordova;
    CordovaUriHelper helper;
    boolean isCurrentlyLoading;
    private boolean doClearHistory = false;
    private Hashtable<String, AuthenticationToken> authenticationTokens = new Hashtable<>();

    @Deprecated
    public CordovaWebViewClient(CordovaInterface cordovaInterface) {
        this.cordova = cordovaInterface;
    }

    private String fixPath(String str) throws IOException {
        return new File(Uri.parse(str).getPath()).getCanonicalPath();
    }

    private boolean isNeedJumpToDownload(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(".zip");
        arrayList.add(".xps");
        arrayList.add(".xltx");
        arrayList.add(".xlsb");
        arrayList.add(".wpx");
        arrayList.add(".vsdx");
        arrayList.add(".tif");
        arrayList.add(".sql");
        arrayList.add(".rtf");
        arrayList.add(".rar");
        arrayList.add(".potx");
        arrayList.add(".msi");
        arrayList.add(".msg");
        arrayList.add(".mht");
        arrayList.add(".jfif");
        arrayList.add(".java");
        arrayList.add(TdFileUtils.PLUGIN_FILE_TAIL);
        arrayList.add(".ini");
        arrayList.add(".exe");
        arrayList.add(".eml");
        arrayList.add(".bz2");
        arrayList.add(b.b);
        arrayList.add(".md");
        arrayList.add(".7z");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("http://dl.lianwifi.com/");
        arrayList2.add("http://readfile.wifi.com");
        arrayList2.add("https://dl.lianwifi.com");
        arrayList2.add("https://cdnpalmchat.youni.im");
        arrayList2.add("https://mk.51y5.net");
        arrayList2.add("https://statics.jixiangjili.com");
        arrayList2.add("http://res.jili365.com");
        arrayList2.add("https://o1.wkanx.com");
        arrayList2.add("https://palmchat.cdn.lianxinapp.com");
        arrayList2.add("https://img.51hyclub.com");
        arrayList2.add("http://apk-internal.y5en.com:8080");
        arrayList2.add("http://images.zhulang.com");
        arrayList2.add("https://o1.wkanx.com");
        arrayList2.add("http://static.ergeyy.com");
        if (str.startsWith("https://m.zenmen.com")) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.endsWith((String) it.next())) {
                    return true;
                }
            }
            return false;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (str.startsWith((String) it2.next()) && str.endsWith(b.b)) {
                return true;
            }
        }
        return false;
    }

    public static void setJSSDKPath(String str) {
        JSSDK_PATH = str;
    }

    public void clearAuthenticationTokens() {
        this.authenticationTokens.clear();
    }

    public AuthenticationToken getAuthenticationToken(String str, String str2) {
        AuthenticationToken authenticationToken = this.authenticationTokens.get(str.concat(str2));
        if (authenticationToken != null) {
            return authenticationToken;
        }
        AuthenticationToken authenticationToken2 = this.authenticationTokens.get(str);
        if (authenticationToken2 == null) {
            authenticationToken2 = this.authenticationTokens.get(str2);
        }
        AuthenticationToken authenticationToken3 = authenticationToken2;
        return authenticationToken3 == null ? this.authenticationTokens.get("") : authenticationToken3;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.isCurrentlyLoading || str.startsWith("about:")) {
            this.isCurrentlyLoading = false;
            LOG.d(TAG, "onPageFinished(" + str + ")");
            if (this.doClearHistory) {
                webView.clearHistory();
                this.doClearHistory = false;
            }
            CordovaWebView cordovaWebView = this.appView;
            cordovaWebView.loadUrlTimeout++;
            cordovaWebView.stopErrorPageTimeout();
            this.appView.postMessage("onPageFinished", str);
            if (this.appView.getVisibility() == 4) {
                new Thread(new Runnable() { // from class: org.apache.cordova.CordovaWebViewClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Thread.sleep(2000L);
                            CordovaWebViewClient.this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaWebViewClient.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    CordovaWebViewClient.this.appView.postMessage("spinner", "stop");
                                }
                            });
                        } catch (InterruptedException unused) {
                        }
                    }
                }).start();
            }
            if (str.equals("about:blank")) {
                this.appView.postMessage(d.z, null);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.isCurrentlyLoading = true;
        LOG.d(TAG, "onPageStarted(" + str + ")");
        this.appView.bridge.reset(str);
        this.appView.postMessage("onPageStarted", str);
        PluginManager pluginManager = this.appView.pluginManager;
        if (pluginManager != null) {
            pluginManager.onReset();
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        CordovaWebView cordovaWebView = this.appView;
        PluginManager pluginManager = cordovaWebView.pluginManager;
        if (pluginManager == null || !pluginManager.onReceivedClientCertRequest(cordovaWebView, new CordovaClientCertRequest(clientCertRequest))) {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
            return;
        }
        CordovaWebView cordovaWebView2 = this.appView;
        cordovaWebView2.loadUrlTimeout++;
        cordovaWebView2.stopErrorPageTimeout();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.isCurrentlyLoading) {
            LOG.d(TAG, "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", Integer.valueOf(i), str, str2);
            CordovaWebView cordovaWebView = this.appView;
            cordovaWebView.loadUrlTimeout++;
            cordovaWebView.stopErrorPageTimeout();
            if (i == -10) {
                if (webView.canGoBack()) {
                    webView.goBack();
                    return;
                }
                super.onReceivedError(webView, i, str, str2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i);
                jSONObject.put("description", str);
                jSONObject.put("url", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.appView.postMessage("onReceivedError", jSONObject);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AuthenticationToken authenticationToken = getAuthenticationToken(str, str2);
        if (authenticationToken != null) {
            httpAuthHandler.proceed(authenticationToken.getUserName(), authenticationToken.getPassword());
            return;
        }
        CordovaWebView cordovaWebView = this.appView;
        PluginManager pluginManager = cordovaWebView.pluginManager;
        if (pluginManager == null || !pluginManager.onReceivedHttpAuthRequest(cordovaWebView, new CordovaHttpAuthHandler(httpAuthHandler), str, str2)) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            return;
        }
        CordovaWebView cordovaWebView2 = this.appView;
        cordovaWebView2.loadUrlTimeout++;
        cordovaWebView2.stopErrorPageTimeout();
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if ((this.cordova.getActivity().getPackageManager().getApplicationInfo(this.cordova.getActivity().getPackageName(), 128).flags & 2) != 0) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public AuthenticationToken removeAuthenticationToken(String str, String str2) {
        return this.authenticationTokens.remove(str.concat(str2));
    }

    public void setAuthenticationToken(AuthenticationToken authenticationToken, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        this.authenticationTokens.put(str.concat(str2), authenticationToken);
    }

    @Deprecated
    public void setWebView(CordovaWebView cordovaWebView) {
        this.appView = cordovaWebView;
        this.helper = new CordovaUriHelper(this.cordova, cordovaWebView);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str.contains(ZX_LOCAL_RES) && !TextUtils.isEmpty(JSSDK_PATH) && !str.contains("../..")) {
            try {
                String strFixPath = fixPath(JSSDK_PATH + File.separator + str.substring(str.indexOf(ZX_LOCAL_RES) + 14));
                if (str.endsWith(".css")) {
                    return new WebResourceResponse("text/css", "UTF-8", new FileInputStream(strFixPath));
                }
                if (str.endsWith(".js")) {
                    return new WebResourceResponse("application/javascript", "UTF-8", new FileInputStream(strFixPath));
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.log4ClientError("shouldInterceptRequest", null, e, true);
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.helper.shouldOverrideUrlLoading(webView, str);
    }

    public CordovaWebViewClient(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        this.cordova = cordovaInterface;
        this.appView = cordovaWebView;
        this.helper = new CordovaUriHelper(cordovaInterface, cordovaWebView);
    }
}
