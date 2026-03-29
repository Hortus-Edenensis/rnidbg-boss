package org.apache.cordova;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.cordova.CordovaResourceApi;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@TargetApi(11)
public class IceCreamCordovaWebViewClient extends CordovaWebViewClient {
    private static final String TAG = "IceCreamCordovaWebViewClient";
    private CordovaUriHelper helper;

    public IceCreamCordovaWebViewClient(CordovaInterface cordovaInterface) {
        super(cordovaInterface);
    }

    private boolean isUrlHarmful(String str) {
        return ((str.startsWith("http:") || str.startsWith("https:")) && !this.appView.getWhitelist().isUrlWhiteListed(str)) || str.contains("app_webview");
    }

    private static boolean needsKitKatContentUrlFix(Uri uri) {
        return "content".equals(uri.getScheme());
    }

    private static boolean needsSpecialsInAssetUrlFix(Uri uri) {
        if (CordovaResourceApi.getUriType(uri) != 1) {
            return false;
        }
        if (uri.getQuery() != null || uri.getFragment() != null) {
            return true;
        }
        uri.toString().contains("%");
        return false;
    }

    @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (isUrlHarmful(str)) {
                LOG.w(TAG, "URL blocked by whitelist: " + str);
                return new WebResourceResponse(HTTP.PLAIN_TEXT_TYPE, "UTF-8", null);
            }
            CordovaResourceApi resourceApi = this.appView.getResourceApi();
            Uri uri = Uri.parse(str);
            Uri uriRemapUri = resourceApi.remapUri(uri);
            if (uri.equals(uriRemapUri) && !needsSpecialsInAssetUrlFix(uri) && !needsKitKatContentUrlFix(uri)) {
                return super.shouldInterceptRequest(webView, str);
            }
            CordovaResourceApi.OpenForReadResult openForReadResultOpenForRead = resourceApi.openForRead(uriRemapUri, true);
            return new WebResourceResponse(openForReadResultOpenForRead.mimeType, "UTF-8", openForReadResultOpenForRead.inputStream);
        } catch (IOException e) {
            if (!(e instanceof FileNotFoundException)) {
                LOG.e(TAG, "Error occurred while loading a file (returning a 404).", e);
            }
            return new WebResourceResponse(HTTP.PLAIN_TEXT_TYPE, "UTF-8", null);
        }
    }

    public IceCreamCordovaWebViewClient(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super(cordovaInterface, cordovaWebView);
    }
}
