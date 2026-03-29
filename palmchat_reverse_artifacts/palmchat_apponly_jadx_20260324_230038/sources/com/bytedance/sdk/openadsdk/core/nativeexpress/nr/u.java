package com.bytedance.sdk.openadsdk.core.nativeexpress.nr;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.b.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0277u {
        com.bytedance.sdk.component.adexpress.u.nr.u u(String str, jk.u uVar, String str2);

        boolean u();
    }

    public static com.bytedance.sdk.component.adexpress.u.nr.u u(WebView webView, bc bcVar, String str, InterfaceC0277u interfaceC0277u) {
        rh next;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        jk.u uVarU = jk.u(str);
        boolean z = interfaceC0277u != null && interfaceC0277u.u();
        if (uVarU == jk.u.IMAGE || !z || bcVar == null) {
            next = null;
        } else {
            Iterator<rh> it = bcVar.zu().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (!TextUtils.isEmpty(next.u()) && !TextUtils.isEmpty(str)) {
                    String strU = next.u();
                    if (strU.startsWith(BaseConstants.SCHEME_HTTPS)) {
                        strU = strU.replaceFirst(BaseConstants.SCHEME_HTTPS, HttpHost.DEFAULT_SCHEME_NAME);
                    }
                    if ((str.startsWith(BaseConstants.SCHEME_HTTPS) ? str.replaceFirst(BaseConstants.SCHEME_HTTPS, HttpHost.DEFAULT_SCHEME_NAME) : str).equals(strU)) {
                        break;
                    }
                }
            }
            next = null;
        }
        if (uVarU == jk.u.IMAGE) {
            com.bytedance.sdk.component.adexpress.u.nr.u uVar = new com.bytedance.sdk.component.adexpress.u.nr.u();
            uVar.u(5);
            uVar.u(u(str, nr.nr(bcVar, str)));
            return uVar;
        }
        if (next == null) {
            if (interfaceC0277u == null) {
                return null;
            }
            return interfaceC0277u.u(str, uVarU, "");
        }
        com.bytedance.sdk.component.adexpress.u.nr.u uVar2 = new com.bytedance.sdk.component.adexpress.u.nr.u();
        uVar2.u(u(str, next.x()));
        uVar2.u(5);
        return uVar2;
    }

    private static WebResourceResponse u(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamU = com.bytedance.sdk.openadsdk.n.nr.u(str, str2);
            if (inputStreamU == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(jk.u.IMAGE.getType(), "utf-8", inputStreamU);
            try {
                Map<String, String> responseHeaders = webResourceResponse2.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("Access-Control-Allow-Origin", "*");
                webResourceResponse2.setResponseHeaders(responseHeaders);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        k.u("CacheInterceptUtil", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }
}
