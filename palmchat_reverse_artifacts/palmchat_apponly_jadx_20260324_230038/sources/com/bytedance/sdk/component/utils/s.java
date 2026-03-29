package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.os.Looper;
import android.webkit.WebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
    private static final u u = new nr();

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(19)
    public static class nr extends u {
        private nr() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.s.u
        public void u(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            s.nr(new Runnable() { // from class: com.bytedance.sdk.component.utils.s.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    boolean z = false;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            z = true;
                        } catch (Throwable th) {
                            boolean z2 = th instanceof IllegalStateException;
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private u() {
        }

        public void u(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            s.nr(new Runnable() { // from class: com.bytedance.sdk.component.utils.s.u.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            jk.nr().post(runnable);
        }
    }

    @Deprecated
    public static void u(WebView webView, String str) {
        u.u(webView, str);
    }

    public static void u(com.bytedance.sdk.component.mv.fx fxVar, String str) {
        u.u(fxVar.getWebView(), str);
    }
}
