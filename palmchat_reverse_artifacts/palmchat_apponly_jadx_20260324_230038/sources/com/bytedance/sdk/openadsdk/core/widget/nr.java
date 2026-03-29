package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"SetJavaScriptEnabled"})
public class nr extends AlertDialog {
    protected static volatile AtomicInteger nr = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f5403a;
    private Button b;
    private Button fx;
    private ListView iz;
    private String jk;
    private List<fx> l;
    private boolean mv;
    private String n;
    private ImageView pn;
    private HashMap<String, String> t;
    protected Context u;
    private SSWebView x;

    /* JADX INFO: compiled from: SearchBox */
    public class fx {
        private String fx;
        private String nr;

        public fx(String str, String str2) {
            this.nr = str;
            this.fx = str2;
        }

        public String nr() {
            return this.fx;
        }

        public String u() {
            return this.nr;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0304nr extends ArrayAdapter<fx> {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.nr$nr$u */
        /* JADX INFO: compiled from: SearchBox */
        public class u {
            private ImageView b;
            private TextView fx;
            private TextView nr;

            public u() {
            }
        }

        public C0304nr(Context context, int i, List<fx> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            u uVar;
            View view2;
            fx fxVar = (fx) getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(nr.this.u);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, y.fx(nr.this.u, 17.0f));
                TextView textView = new TextView(nr.this.u);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int iFx = y.fx(nr.this.u, 16.0f);
                layoutParams.leftMargin = iFx;
                layoutParams.rightMargin = iFx;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, y.fx(nr.this.u, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(nr.this.u);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iFx, iFx);
                layoutParams2.topMargin = y.fx(nr.this.u, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                q.u(nr.this.u, "tt_open_app_detail_list_item", (View) imageView);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(nr.this.u);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = y.fx(nr.this.u, 8.0f);
                layoutParams3.topMargin = y.fx(nr.this.u, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                uVar = new u();
                uVar.nr = textView;
                uVar.fx = textView2;
                uVar.b = imageView;
                relativeLayout.setTag(uVar);
                view2 = relativeLayout;
            } else {
                uVar = (u) view.getTag();
                view2 = view;
            }
            uVar.b.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(fxVar.u())) {
                uVar.b.setVisibility(4);
            }
            uVar.nr.setText(fxVar.u());
            uVar.fx.setText(fxVar.nr());
            return view2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void fx(Dialog dialog);

        void nr(Dialog dialog);

        void u(Dialog dialog);
    }

    public nr(Context context, String str) {
        super(context, q.x(context, "tt_dialog_full"));
        this.l = new ArrayList();
        this.mv = false;
        this.u = context;
        this.jk = str;
    }

    private void b() {
        if (this.u == null) {
            this.u = dw.getContext();
        }
        if (this.u.getResources().getConfiguration().orientation == 1) {
            setContentView(u(1));
        } else {
            setContentView(u(0));
        }
    }

    private LinearLayout fx(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int iFx = y.fx(this.u, 16.0f);
        linearLayout2.setPadding(iFx, iFx, iFx, iFx);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.b = new Button(this.u);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iFx2 = y.fx(this.u, 7.0f);
        layoutParams2.leftMargin = iFx2;
        layoutParams2.rightMargin = iFx2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(y.fx(this.u, 3.0f));
        gradientDrawable.setStroke(y.fx(this.u, 0.5f), Color.parseColor("#E0161823"));
        this.b.setBackground(gradientDrawable);
        int iFx3 = y.fx(this.u, 12.0f);
        this.b.setText("上一步");
        this.b.setPadding(0, iFx3, 0, iFx3);
        this.b.setTextColor(Color.parseColor("#A8161823"));
        this.b.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.b);
        return u(i, linearLayout, relativeLayout, linearLayout2, iFx2, iFx3);
    }

    private LinearLayout nr(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.u);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.u, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private void pn() {
        if (this.u == null) {
            this.u = dw.getContext();
        }
        if (this.u.getResources().getConfiguration().orientation == 1) {
            setContentView(nr(1));
        } else {
            setContentView(nr(0));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        nr.set(0);
        u uVar = this.f5403a;
        if (uVar != null) {
            uVar.nr(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nr();
        if (this.mv) {
            pn();
        } else {
            b();
        }
        fx();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private View u(int i) {
        LinearLayout linearLayout = new LinearLayout(this.u);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.u);
        LinearLayout.LayoutParams layoutParams2 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.u);
        LinearLayout.LayoutParams layoutParams3 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(y.fx(this.u, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.u);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return u(i, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout b(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.u);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.u, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    private View nr(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.u);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.u);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.u);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(y.fx(this.u, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return u(i, linearLayout, relativeLayout);
    }

    public void fx() {
        if (this.mv) {
            u();
        } else {
            SSWebView sSWebView = this.x;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.u());
            }
        }
        this.fx.setVisibility(0);
        this.fx.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.nr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr.nr.set(0);
                if (nr.this.f5403a != null) {
                    nr.this.f5403a.u(nr.this);
                }
            }
        });
        this.pn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.nr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr.nr.set(0);
                if (nr.this.f5403a != null) {
                    nr.this.f5403a.nr(nr.this);
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.nr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr.nr.set(0);
                if (nr.this.f5403a != null) {
                    nr.this.f5403a.fx(nr.this);
                }
            }
        });
        List<fx> list = this.l;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.iz.setAdapter((ListAdapter) new C0304nr(this.u, 0, this.l));
    }

    private LinearLayout nr(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.u);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.u, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.x = new SSWebView(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.x.setLayoutParams(layoutParams);
        relativeLayout.addView(this.x);
        View view2 = new View(this.u);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.u, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return fx(i, linearLayout, relativeLayout);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.u);
        this.pn = imageView;
        imageView.setMaxHeight(y.fx(this.u, 46.0f));
        this.pn.setMaxWidth(y.fx(this.u, 46.0f));
        this.pn.setMinimumHeight(y.fx(this.u, 46.0f));
        this.pn.setMinimumWidth(y.fx(this.u, 46.0f));
        this.pn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.fx fxVar = new com.bytedance.sdk.openadsdk.res.fx(y.fx(this.u, 14.0f));
        fxVar.u(-16777216);
        fxVar.u(y.fx(this.u, 2.0f));
        this.pn.setImageDrawable(fxVar);
        relativeLayout.addView(this.pn);
        TextView textView = new TextView(this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.u);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, y.fx(this.u, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return u(i, linearLayout, u(linearLayout2, view));
    }

    public void nr() {
        if (TextUtils.isEmpty(this.jk)) {
            u(this.t);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(this.jk));
            if (izVarPn != null) {
                HashMap<String, String> mapU = izVarPn.u();
                this.t = mapU;
                if (!mapU.isEmpty()) {
                    this.mv = false;
                    u(this.t);
                } else if (!TextUtils.isEmpty(izVarPn.nr())) {
                    this.n = izVarPn.nr();
                    this.mv = true;
                } else {
                    u(this.t);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private LinearLayout u(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.iz = new ListView(this.u);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = y.fx(this.u, 20.0f);
        int iFx = y.fx(this.u, 16.0f);
        this.iz.setPadding(iFx, 0, iFx, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(y.fx(this.u, 1.0f), Color.parseColor("#F0F0F0"));
        this.iz.setDivider(gradientDrawable);
        this.iz.setDividerHeight(y.fx(this.u, 24.0f));
        this.iz.setSelector(new ColorDrawable(0));
        this.iz.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.iz);
        View view2 = new View(this.u);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, y.fx(this.u, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout u(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iFx = y.fx(this.u, 16.0f);
        linearLayout3.setPadding(iFx, iFx, iFx, iFx);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.b = new Button(this.u);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iFx2 = y.fx(this.u, 7.0f);
        layoutParams2.leftMargin = iFx2;
        layoutParams2.rightMargin = iFx2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(y.fx(this.u, 3.0f));
        gradientDrawable.setStroke(y.fx(this.u, 0.5f), Color.parseColor("#E0161823"));
        this.b.setBackground(gradientDrawable);
        int iFx3 = y.fx(this.u, 12.0f);
        this.b.setText("上一步");
        this.b.setPadding(0, iFx3, 0, iFx3);
        this.b.setTextColor(Color.parseColor("#A8161823"));
        this.b.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.b);
        return u(iFx2, iFx3, linearLayout3, nr(i, linearLayout, linearLayout2));
    }

    private LinearLayout u(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.fx = new Button(this.u);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(y.fx(this.u, 3.0f));
        this.fx.setBackground(gradientDrawable);
        this.fx.setText("立即下载");
        this.fx.setPadding(0, i2, 0, i2);
        this.fx.setTextColor(-1);
        this.fx.setLayoutParams(layoutParams);
        linearLayout.addView(this.fx);
        return linearLayout2;
    }

    private LinearLayout u(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.u);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.u);
        this.pn = imageView;
        imageView.setMaxHeight(y.fx(this.u, 46.0f));
        this.pn.setMaxWidth(y.fx(this.u, 46.0f));
        this.pn.setMinimumHeight(y.fx(this.u, 46.0f));
        this.pn.setMinimumWidth(y.fx(this.u, 46.0f));
        this.pn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.fx fxVar = new com.bytedance.sdk.openadsdk.res.fx(y.fx(this.u, 14.0f));
        fxVar.u(-16777216);
        fxVar.u(y.fx(this.u, 2.0f));
        this.pn.setImageDrawable(fxVar);
        relativeLayout2.addView(this.pn);
        TextView textView = new TextView(this.u);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return nr(i, linearLayout, relativeLayout);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return u(i2, i3, linearLayout2, b(i, linearLayout, relativeLayout));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u() {
        this.x.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.u, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.nr.1
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
                this.n = nr.nr;
                return super.u(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b
            public boolean u(WebView webView, String str) {
                this.n = nr.nr;
                return super.u(webView, str);
            }
        });
        this.x.setJavaScriptEnabled(true);
        this.x.setDisplayZoomControls(false);
        this.x.setCacheMode(2);
        this.x.loadUrl(this.n);
    }

    private void u(HashMap<String, String> map) {
        List<fx> list = this.l;
        if (list != null && list.size() > 0) {
            this.l.clear();
        }
        if (this.l == null) {
            this.l = new ArrayList();
        }
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                this.l.add(new fx(str, map.get(str)));
            }
            return;
        }
        this.l.add(new fx("补充中，可于应用官网查看", ""));
    }

    public nr u(u uVar) {
        this.f5403a = uVar;
        return this;
    }
}
