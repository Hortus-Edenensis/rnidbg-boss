package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends AlertDialog {
    protected static volatile AtomicInteger b = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f5396a;
    protected u fx;
    private ImageView iz;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.nr jk;
    private TTViewStub k;
    private String l;
    private com.bytedance.sdk.openadsdk.core.dislike.fx.nr mv;
    private FrameLayout my;
    private TextView n;
    protected Context nr;
    private int o;
    private LinearLayout pn;
    private TTViewStub s;
    private Intent t;
    protected SSWebView u;
    private ImageView x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Dialog dialog);
    }

    public a(Context context, Intent intent) {
        super(context, q.x(context, "tt_dialog_full"));
        this.o = 0;
        this.nr = context;
        this.t = intent;
    }

    public static /* synthetic */ int fx(a aVar) {
        int i = aVar.o;
        aVar.o = i + 1;
        return i;
    }

    public static /* synthetic */ int nr(a aVar) {
        int i = aVar.o;
        aVar.o = i - 1;
        return i;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        b.set(0);
        u uVar = this.fx;
        if (uVar != null) {
            uVar.u(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        bc bcVar;
        super.onCreate(bundle);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.nr);
        this.pn = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.pn.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.pn.setOrientation(1);
        this.u = new SSWebView(this.nr);
        if (this.t != null && (bcVar = TTDelegateActivity.u) != null) {
            this.mv = bcVar.vz();
            this.l = this.t.getStringExtra("event_tag");
        }
        setContentView(com.bytedance.sdk.openadsdk.res.pn.m(this.nr));
        nr();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        getWindow().getAttributes().height = y.pn(this.nr) - y.fx(this.nr, 50.0f);
    }

    private void fx() {
        TTViewStub tTViewStub;
        this.my = (FrameLayout) findViewById(2114387634);
        this.s = (TTViewStub) findViewById(2114387770);
        this.k = (TTViewStub) findViewById(2114387792);
        this.my.addView(this.u, new LinearLayout.LayoutParams(-1, -1));
        int iH = com.bytedance.sdk.openadsdk.core.n.o().h();
        if (iH == 0) {
            TTViewStub tTViewStub2 = this.s;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (iH == 1 && (tTViewStub = this.k) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.iz = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.b.set(0);
                    SSWebView sSWebView = a.this.u;
                    if (sSWebView != null && sSWebView.canGoBack() && a.this.o > 1) {
                        a.this.u.goBack();
                        a.nr(a.this);
                        return;
                    }
                    a.this.dismiss();
                    a aVar = a.this;
                    u uVar = aVar.fx;
                    if (uVar != null) {
                        uVar.u(aVar);
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.x = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.b.set(0);
                    a.this.dismiss();
                    a aVar = a.this;
                    u uVar = aVar.fx;
                    if (uVar != null) {
                        uVar.u(aVar);
                    }
                }
            });
        }
        this.n = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.f5396a = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.u();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void nr() {
        bc bcVar;
        fx();
        if (this.n != null && (bcVar = TTDelegateActivity.u) != null && !TextUtils.isEmpty(bcVar.wf())) {
            this.n.setText(TTDelegateActivity.u.wf());
        }
        com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.nr).u(false).nr(false).u(this.u);
        this.u.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.nr, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.a.4
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
                    a.fx(a.this);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, WebResourceRequest webResourceRequest) {
                this.n = a.b;
                return super.u(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, String str) {
                this.n = a.b;
                return super.u(webView, str);
            }
        });
        this.u.setJavaScriptEnabled(true);
        this.u.setDisplayZoomControls(false);
        this.u.setCacheMode(2);
        this.u.loadUrl("https://phoniex.toutiao.com");
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar;
        Context context = this.nr;
        if (context == null || (nrVar = this.mv) == null) {
            return;
        }
        if (this.jk == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(context, nrVar, this.l, true, com.bytedance.sdk.openadsdk.n.nr.u());
            this.jk = nrVar2;
            com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.nr, TTDelegateActivity.u, nrVar2);
        }
        this.jk.u();
    }

    public a u(u uVar) {
        this.fx = uVar;
        return this;
    }
}
