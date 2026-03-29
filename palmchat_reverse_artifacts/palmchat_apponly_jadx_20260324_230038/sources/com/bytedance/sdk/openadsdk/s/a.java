package com.bytedance.sdk.openadsdk.s;

import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private static void nr(com.bytedance.sdk.component.mv.fx fxVar) {
        try {
            fxVar.removeJavascriptInterface("searchBoxJavaBridge_");
            fxVar.removeJavascriptInterface("accessibility");
            fxVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            x.u("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void u(com.bytedance.sdk.component.mv.fx fxVar) {
        nr(fxVar);
        try {
            fxVar.setJavaScriptEnabled(true);
            fxVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            x.u("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            fxVar.setSupportZoom(false);
        } catch (Throwable th2) {
            x.u("WebViewSettings", "setSupportZoom error", th2);
        }
        fxVar.setLoadWithOverviewMode(true);
        fxVar.setUseWideViewPort(true);
        fxVar.setDomStorageEnabled(true);
        fxVar.setAllowFileAccess(false);
        fxVar.setBlockNetworkImage(false);
        fxVar.setDisplayZoomControls(false);
        int i = Build.VERSION.SDK_INT;
        fxVar.setAllowFileAccessFromFileURLs(false);
        fxVar.setAllowUniversalAccessFromFileURLs(false);
        fxVar.setSavePassword(false);
        boolean z = i >= 28;
        try {
        } catch (Throwable th3) {
            x.u("WebViewSettings", "setLayerType error", th3);
        }
        if (z) {
            if (z) {
                fxVar.setLayerType(2, null);
            }
            fxVar.setMixedContentMode(0);
        }
        fxVar.setLayerType(0, null);
        fxVar.setMixedContentMode(0);
    }
}
