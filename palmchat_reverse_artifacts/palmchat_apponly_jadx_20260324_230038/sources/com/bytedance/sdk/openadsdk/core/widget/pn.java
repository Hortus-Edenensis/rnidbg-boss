package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends AlertDialog {
    protected static volatile AtomicInteger fx = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f5404a;
    private SSWebView b;
    private ImageView iz;
    private Button n;
    protected String nr;
    private Context pn;
    protected String u;
    private Button x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void fx(Dialog dialog);

        void nr(Dialog dialog);

        void u(Dialog dialog);
    }

    public pn(Context context, String str, String str2, String str3) {
        super(context, q.x(context, "tt_dialog_full"));
        this.pn = context;
        this.u = str;
        this.nr = str3;
        if (TextUtils.isEmpty(str) || !(this.u.startsWith(BaseConstants.SCHEME_HTTPS) || this.u.startsWith(HttpHost.DEFAULT_SCHEME_NAME))) {
            this.u = str2;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        fx.set(0);
        u uVar = this.f5404a;
        if (uVar != null) {
            uVar.nr(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.pn == null) {
            this.pn = dw.getContext();
        }
        u();
    }

    private View u(int i) {
        LinearLayout linearLayout = new LinearLayout(this.pn);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.pn);
        LinearLayout.LayoutParams layoutParams2 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.pn);
        LinearLayout.LayoutParams layoutParams3 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(y.fx(this.pn, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.pn);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.pn);
        this.iz = imageView;
        imageView.setMaxHeight(y.fx(this.pn, 46.0f));
        this.iz.setMaxWidth(y.fx(this.pn, 46.0f));
        this.iz.setMinimumHeight(y.fx(this.pn, 46.0f));
        this.iz.setMinimumWidth(y.fx(this.pn, 46.0f));
        this.iz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.fx fxVar = new com.bytedance.sdk.openadsdk.res.fx(y.fx(this.pn, 14.0f));
        fxVar.u(-16777216);
        fxVar.u(y.fx(this.pn, 2.0f));
        this.iz.setImageDrawable(fxVar);
        relativeLayout.addView(this.iz);
        TextView textView = new TextView(this.pn);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.nr);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.pn);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.pn, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.b = new SSWebView(this.pn);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.b.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.b);
        View view3 = new View(this.pn);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.pn, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.pn);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iFx = y.fx(this.pn, 16.0f);
        linearLayout3.setPadding(iFx, iFx, iFx, iFx);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.n = new Button(this.pn);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int iFx2 = y.fx(this.pn, 7.0f);
        layoutParams7.leftMargin = iFx2;
        layoutParams7.rightMargin = iFx2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(y.fx(this.pn, 3.0f));
        gradientDrawable2.setStroke(y.fx(this.pn, 0.5f), Color.parseColor("#E0161823"));
        this.n.setBackground(gradientDrawable2);
        int iFx3 = y.fx(this.pn, 12.0f);
        this.n.setText("上一步");
        this.n.setPadding(0, iFx3, 0, iFx3);
        this.n.setTextColor(Color.parseColor("#A8161823"));
        this.n.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.n);
        this.x = new Button(this.pn);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = iFx2;
        layoutParams8.rightMargin = iFx2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(y.fx(this.pn, 3.0f));
        this.x.setBackground(gradientDrawable3);
        this.x.setText("立即下载");
        this.x.setPadding(0, iFx3, 0, iFx3);
        this.x.setTextColor(-1);
        this.x.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.x);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.pn);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.pn, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u() {
        if (this.pn.getResources().getConfiguration().orientation == 1) {
            setContentView(u(1));
        } else {
            setContentView(u(0));
        }
        this.iz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pn.fx.set(0);
                if (pn.this.f5404a != null) {
                    pn.this.f5404a.nr(pn.this);
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pn.fx.set(0);
                if (pn.this.f5404a != null) {
                    pn.this.f5404a.fx(pn.this);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.pn.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pn.fx.set(0);
                if (pn.this.f5404a != null) {
                    pn.this.f5404a.u(pn.this);
                }
            }
        });
        this.b.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.pn, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.pn.4
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
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
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
                this.n = pn.fx;
                return super.u(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, String str) {
                this.n = pn.fx;
                return super.u(webView, str);
            }
        });
        this.b.setJavaScriptEnabled(true);
        this.b.setDisplayZoomControls(false);
        this.b.setCacheMode(2);
        this.b.loadUrl(this.u);
    }

    public pn u(u uVar) {
        this.f5404a = uVar;
        return this;
    }
}
