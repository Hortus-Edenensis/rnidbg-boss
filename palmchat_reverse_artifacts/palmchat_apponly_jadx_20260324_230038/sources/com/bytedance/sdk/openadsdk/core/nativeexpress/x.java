package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.b.jk;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends com.bytedance.sdk.openadsdk.core.widget.u.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.s.n f5344a;
    private bc jk;
    private com.bytedance.sdk.component.adexpress.nr.mv l;
    private boolean t;
    public ArrayList<Integer> u;

    public x(Context context, ja jaVar, bc bcVar, com.bytedance.sdk.openadsdk.core.s.iz izVar, boolean z, com.bytedance.sdk.openadsdk.s.n nVar, com.bytedance.sdk.component.adexpress.nr.mv mvVar) {
        super(context, jaVar, bcVar.lk(), izVar);
        this.u = new ArrayList<>();
        this.jk = bcVar;
        this.t = z;
        this.f5344a = nVar;
        this.l = mvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        if (tk.iz(this.jk) != null) {
            return tk.iz(this.jk).t();
        }
        if (tk.x(this.jk) != null) {
            return "v3";
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.iz = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.x = false;
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.component.adexpress.nr.mv mvVar = this.l;
        if (mvVar == null || !mvVar.z()) {
            return;
        }
        com.bytedance.sdk.component.utils.s.u(webView, "javascript:window.SDK_INJECT_DATA=" + this.l.pn());
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int u() {
        for (Integer num : this.u) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(b()) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.bytedance.sdk.openadsdk.s.n nVar = this.f5344a;
            if (nVar != null) {
                nVar.n(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.u.nr.u uVarU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.u(webView, this.jk, str, new u.InterfaceC0277u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.x.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.InterfaceC0277u
                public boolean u() {
                    return true;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.InterfaceC0277u
                public com.bytedance.sdk.component.adexpress.u.nr.u u(String str2, jk.u uVar, String str3) {
                    return com.bytedance.sdk.component.adexpress.u.nr.nr.u(str2, uVar, str3, x.this.b());
                }
            });
            u(jCurrentTimeMillis, System.currentTimeMillis(), str, (uVarU == null || uVarU.u() == null) ? 2 : 1);
            if (uVarU != null && uVarU.getType() != 5) {
                this.u.add(Integer.valueOf(uVarU.getType()));
            }
            if (uVarU != null && uVarU.u() != null) {
                com.bytedance.sdk.openadsdk.s.n nVar2 = this.f5344a;
                if (nVar2 != null) {
                    nVar2.a(str);
                }
                return uVarU.u();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private void u(long j, long j2, String str, int i) {
        com.bytedance.sdk.openadsdk.core.s.iz izVar = this.pn;
        if (izVar == null || izVar.fx() == null) {
            return;
        }
        jk.u uVarU = com.bytedance.sdk.component.adexpress.b.jk.u(str);
        if (uVarU == jk.u.HTML) {
            this.pn.fx().u(str, j, j2, i);
        } else if (uVarU == jk.u.JS) {
            this.pn.fx().nr(str, j, j2, i);
        }
    }
}
