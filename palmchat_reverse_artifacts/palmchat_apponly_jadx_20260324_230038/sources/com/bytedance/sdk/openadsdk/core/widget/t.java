package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.oplus.tblplayer.Constants;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends AlertDialog {
    protected static volatile AtomicInteger u = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f5406a;
    private TextView b;
    private Context fx;
    private u iz;
    private ImageView jk;
    private RelativeLayout n;
    private SSWebView nr;
    private String pn;
    private ImageView t;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Dialog dialog);
    }

    public t(Context context, String str) {
        super(context, q.x(context, "tt_dialog_full"));
        this.x = str;
        this.fx = context;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        u.set(0);
        u uVar = this.iz;
        if (uVar != null) {
            uVar.u(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.pn.bc(this.fx));
        nr();
        u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void nr() {
        this.nr = (SSWebView) findViewById(2114387763);
        TextView textView = (TextView) findViewById(2114387652);
        this.b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.iz != null) {
                    t.this.iz.u(t.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.nr.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.fx, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.t.2
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
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
                this.n = t.u;
                return super.u(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, String str) {
                this.n = t.u;
                return super.u(webView, str);
            }
        });
        this.nr.setJavaScriptEnabled(true);
        this.nr.setDisplayZoomControls(false);
        this.nr.setCacheMode(2);
        this.nr.loadUrl(this.pn);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387883);
        this.n = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387894);
        this.f5406a = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.b.setVisibility(8);
        this.jk = (ImageView) findViewById(2114387813);
        this.t = (ImageView) findViewById(2114387836);
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.iz != null) {
                    t.this.iz.u(t.this);
                    t.u.set(0);
                }
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.t.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) t.this.fx.getSystemService(DataType.CLIPBOARD)).setPrimaryClip(ClipData.newPlainText(null, t.this.pn));
                    h.u(t.this.fx, "链接复制成功", 1);
                } catch (Throwable unused) {
                    h.u(t.this.fx, "链接复制失败", 1);
                }
            }
        });
    }

    public void u() {
        String strKy = dw.nr().ky();
        if (TextUtils.isEmpty(strKy)) {
            this.pn = "https://www.pangle.cn/privacy/partner";
        } else {
            this.pn = strKy;
        }
        if (TextUtils.isEmpty(this.x)) {
            return;
        }
        if (this.pn.contains(Constants.STRING_VALUE_UNSET)) {
            this.pn += "&ad_info=" + this.x;
            return;
        }
        this.pn += "?ad_info=" + this.x;
    }

    public t u(u uVar) {
        this.iz = uVar;
        return this;
    }
}
