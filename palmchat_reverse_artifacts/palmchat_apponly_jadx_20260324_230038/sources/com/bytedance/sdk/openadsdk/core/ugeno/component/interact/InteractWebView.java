package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.sdk.component.adexpress.b.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class InteractWebView extends SSWebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f5377a;
    private ja iz;
    private bc n;
    private Context pn;
    private Map<String, Object> x;

    public InteractWebView(Context context) {
        super(context);
        this.pn = context;
    }

    private void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.pn).u(false).u(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            c.u(sSWebView, d.fx, bc.b(this.n));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            k.nr("InteractWebView", e.toString());
        }
    }

    public s getUGenContext() {
        return this.f5377a;
    }

    public void iz() {
        Map<String, Object> map = this.x;
        if (map == null || map.size() <= 0 || !this.x.containsKey("key_material")) {
            return;
        }
        Object obj = this.x.get("key_material");
        if (obj instanceof bc) {
            this.n = (bc) obj;
            this.iz = (ja) this.x.get("key_js_object");
            if (this.x.containsKey("key_data_list") && (this.x.get("key_data_list") instanceof List)) {
                this.iz.nr((List<JSONObject>) this.x.get("key_data_list"));
            }
            this.iz.nr(this).u(this.n).u(jp.nr(this.n)).nr(this.n.lk()).b(this.n.ap()).pn(jp.sx(this.n)).u((SSWebView) this);
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.mv.fx
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setUGenContext(s sVar) {
        this.f5377a = sVar;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.x = map;
    }

    public void x() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        u((SSWebView) this);
        if (this.n != null) {
            Context context = this.pn;
            ja jaVar = this.iz;
            bc bcVar = this.n;
            setWebViewClient(new u(context, jaVar, bcVar, bcVar.lk()));
        } else {
            setWebViewClient(new SSWebView.u());
        }
        com.bytedance.sdk.component.adexpress.pn.pn.u().u(this, this.iz);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.iz));
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.bytedance.sdk.openadsdk.core.widget.u.b {
        private bc u;

        public u(Context context, ja jaVar, bc bcVar, String str) {
            super(context, jaVar, str);
            this.u = bcVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.u.nr.u uVarU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.u(webView, this.u, str, new u.InterfaceC0277u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.InteractWebView.u.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.InterfaceC0277u
                    public boolean u() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.InterfaceC0277u
                    public com.bytedance.sdk.component.adexpress.u.nr.u u(String str2, jk.u uVar, String str3) {
                        com.bytedance.sdk.component.adexpress.u.nr.u uVar2 = new com.bytedance.sdk.component.adexpress.u.nr.u();
                        uVar2.u(5);
                        uVar2.u(com.bytedance.sdk.openadsdk.core.ugeno.iz.u.nr().u(webView, uVar, str2));
                        return uVar2;
                    }
                });
                if (uVarU != null && uVarU.u() != null) {
                    return uVarU.u();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                k.u("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }
}
