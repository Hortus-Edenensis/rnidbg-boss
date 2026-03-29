package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends AlertDialog {
    protected static volatile AtomicInteger iz = new AtomicInteger(0);
    protected String b;
    protected TextView fx;
    protected Context nr;
    protected u pn;
    protected SSWebView u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Dialog dialog);
    }

    public b(Context context, String str, String str2) {
        super(context, q.x(context, "tt_dialog_full"));
        this.nr = context;
        this.x = str2;
        this.b = str;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        iz.set(0);
        u uVar = this.pn;
        if (uVar != null) {
            uVar.u(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.pn.ay(getContext()));
        u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u() {
        this.u = (SSWebView) findViewById(2114387839);
        this.fx = (TextView) findViewById(2114387912);
        ((TextView) findViewById(2114387696)).setText(this.x);
        this.fx.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.iz.set(0);
                b bVar = b.this;
                u uVar = bVar.pn;
                if (uVar != null) {
                    uVar.u(bVar);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.u.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.nr, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.b.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains(HttpHost.DEFAULT_SCHEME_NAME) && !lowerCase.contains(BaseConstants.SCHEME_HTTPS)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, WebResourceRequest webResourceRequest) {
                this.n = b.iz;
                return super.u(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, String str) {
                this.n = b.iz;
                return super.u(webView, str);
            }
        });
        this.u.setJavaScriptEnabled(true);
        this.u.setDisplayZoomControls(false);
        this.u.setCacheMode(2);
        this.u.loadUrl(this.b);
    }

    public b u(u uVar) {
        this.pn = uVar;
        return this;
    }
}
