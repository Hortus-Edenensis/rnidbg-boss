package com.bytedance.sdk.openadsdk.core.widget.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.gi.x;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private WeakReference<Context> u;
    private boolean nr = true;
    private boolean fx = true;
    private boolean b = true;
    private boolean pn = true;
    private boolean iz = true;
    private boolean x = true;
    private boolean n = true;

    private nr(Context context) {
        this.u = new WeakReference<>(context);
    }

    public static nr u(Context context) {
        return new nr(context);
    }

    public nr nr(boolean z) {
        this.fx = z;
        return this;
    }

    private void nr(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            k.u(th.toString());
        }
    }

    public nr u(boolean z) {
        this.n = z;
        return this;
    }

    public void u(final com.bytedance.sdk.component.mv.fx fxVar) {
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.u.nr.1
            @Override // java.lang.Runnable
            public void run() {
                nr.this.u(fxVar.getWebView());
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void u(WebView webView) {
        if (webView == null || this.u.get() == null) {
            return;
        }
        nr(webView);
        WebSettings settings = webView.getSettings();
        u(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        try {
            if (this.fx) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable unused2) {
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.b);
        settings.setDomStorageEnabled(this.pn);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.x);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.n = false;
        }
        try {
            boolean z = this.n;
            if (!z) {
                webView.setLayerType(0, null);
            } else if (z) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable unused3) {
        }
    }

    private void u(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            k.u(th.toString());
        }
    }

    public static String u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
