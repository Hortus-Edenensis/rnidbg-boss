package com.bytedance.sdk.component.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class kj extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5170a = true;
    protected com.bytedance.sdk.component.mv.fx n;
    protected String x;

    @SuppressLint({"AddJavascriptInterface"})
    public void b() {
        if (!f5170a && this.n == null) {
            throw new AssertionError();
        }
        com.bytedance.sdk.component.mv.fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.addJavascriptInterface(this, this.x);
        }
    }

    @Override // com.bytedance.sdk.component.u.u
    public void fx() {
        super.fx();
        pn();
    }

    @Override // com.bytedance.sdk.component.u.u
    public Context getContext(jk jkVar) {
        Context context = jkVar.pn;
        if (context != null) {
            return context;
        }
        com.bytedance.sdk.component.mv.fx fxVar = jkVar.u;
        if (fxVar != null) {
            View view = fxVar.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = jkVar.u.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.u.u
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    public void pn() {
        com.bytedance.sdk.component.mv.fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.removeJavascriptInterface(this.x);
        }
    }

    @Override // com.bytedance.sdk.component.u.u
    public String u() {
        return this.n.getUrl();
    }

    @Override // com.bytedance.sdk.component.u.u
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void u(jk jkVar) {
        this.n = jkVar.u;
        this.x = jkVar.fx;
        if (jkVar.s) {
            return;
        }
        b();
    }

    @Override // com.bytedance.sdk.component.u.u
    public void u(String str, my myVar) {
        if (myVar != null && !TextUtils.isEmpty(myVar.n)) {
            String str2 = myVar.n;
            u(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.u(str, myVar);
    }

    @Override // com.bytedance.sdk.component.u.u
    public void u(String str) {
        u(str, "javascript:" + this.x + "._handleMessageFromToutiao(" + str + ")");
    }

    private void u(String str, String str2) {
        if (this.pn || TextUtils.isEmpty(str2) || this.pn) {
            return;
        }
        try {
            this.n.evaluateJavascript(str2, null);
        } catch (Throwable unused) {
        }
    }
}
