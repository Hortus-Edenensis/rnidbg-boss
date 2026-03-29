package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends WebViewClient {
    private boolean aRY = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.aRY = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.aRY || !e.Hu()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse webResourceResponseAb = com.kwad.sdk.core.webview.b.a.MN().ab(str, this.mUniqueId);
        return webResourceResponseAb == null ? super.shouldInterceptRequest(webView, str) : webResourceResponseAb;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aRY && e.Hu()) {
            String string = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + string);
            WebResourceResponse webResourceResponseAb = com.kwad.sdk.core.webview.b.a.MN().ab(string, this.mUniqueId);
            return webResourceResponseAb == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponseAb;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
