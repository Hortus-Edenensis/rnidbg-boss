package com.bytedance.sdk.openadsdk.core.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.bg.b;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dislike.ui.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.wq;
import com.bytedance.sdk.openadsdk.core.l.fx.pn;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.playable.nr.nr;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.xg;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.sdk.PushConsts;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTVideoWebPageActivity extends BaseLandingPageActivity implements fx.InterfaceC0154fx, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSWebView f5210a;
    private Activity ay;
    private TextView bf;
    private Context bg;
    private ja bq;
    private FrameLayout c;
    private int cj;
    private RelativeLayout d;
    private RelativeLayout dw;
    private nr eh;
    private TextView h;
    com.bytedance.sdk.openadsdk.core.dislike.ui.nr iz;
    private TextView ja;
    private ImageView jk;
    private TextView k;
    private TextView l;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx m;
    private TextView mv;
    private TextView my;
    protected fx n;
    private TextView o;
    private Button pb;
    private long q;
    private RoundImageView rh;
    private TextView s;
    private com.bytedance.sdk.openadsdk.l.b su;
    private LinearLayout sx;
    private ImageView t;
    private u tk;
    private boolean v;
    private iz wi;
    private TTViewStub wq;
    protected NativeVideoTsView x;
    private TTProgressBar xg;
    private int qq = 0;
    private int kj = 0;
    private int z = 0;
    private int gi = 0;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> f5211jp = DesugarCollections.synchronizedMap(new HashMap());
    private boolean y = false;
    private boolean bc = false;
    private boolean xw = true;
    private boolean oa = false;
    private String w = null;
    private AtomicBoolean mh = new AtomicBoolean(true);
    private JSONArray yd = null;
    private int lf = 0;
    private String nb = "立即下载";
    private com.bytedance.sdk.openadsdk.core.l.nr.u gc = new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.16
        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void fx(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.nr("下载失败");
            if (j > 0) {
                u.C0239u.u(TTVideoWebPageActivity.this.u, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void nr(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.nr("暂停");
            if (j > 0) {
                u.C0239u.u(TTVideoWebPageActivity.this.u, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.nr(tTVideoWebPageActivity.s());
            u.C0239u.u(TTVideoWebPageActivity.this.u, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.nr("下载中...");
            if (j > 0) {
                u.C0239u.u(TTVideoWebPageActivity.this.u, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, String str, String str2) {
            TTVideoWebPageActivity.this.nr("点击安装");
            u.C0239u.u(TTVideoWebPageActivity.this.u, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(String str, String str2) {
            TTVideoWebPageActivity.this.nr("点击打开");
            u.C0239u.u(TTVideoWebPageActivity.this.u, 6, 100);
        }
    };
    private com.bytedance.sdk.openadsdk.core.nr.u mk = null;
    private final fx.nr p = new fx.nr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.5
        @Override // com.bykv.vk.openvk.component.video.api.b.fx.nr
        public void u(boolean z) {
            TTVideoWebPageActivity.this.y = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (!z) {
                y.u((View) TTVideoWebPageActivity.this.f5210a, 0);
                y.u((View) TTVideoWebPageActivity.this.dw, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.c.getLayoutParams();
                marginLayoutParams.width = TTVideoWebPageActivity.this.z;
                marginLayoutParams.height = TTVideoWebPageActivity.this.gi;
                marginLayoutParams.leftMargin = TTVideoWebPageActivity.this.kj;
                marginLayoutParams.topMargin = TTVideoWebPageActivity.this.qq;
                TTVideoWebPageActivity.this.c.setLayoutParams(marginLayoutParams);
                return;
            }
            y.u((View) TTVideoWebPageActivity.this.f5210a, 8);
            y.u((View) TTVideoWebPageActivity.this.dw, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.c.getLayoutParams();
            TTVideoWebPageActivity.this.kj = marginLayoutParams2.leftMargin;
            TTVideoWebPageActivity.this.qq = marginLayoutParams2.topMargin;
            TTVideoWebPageActivity.this.z = marginLayoutParams2.width;
            TTVideoWebPageActivity.this.gi = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            TTVideoWebPageActivity.this.c.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean kw = false;
    private final gi.u f = new gi.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7
        @Override // com.bytedance.sdk.component.utils.gi.u
        public void u(Context context, Intent intent, boolean z, int i) {
            if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.cj == 0 && i != 0 && TTVideoWebPageActivity.this.f5210a != null && TTVideoWebPageActivity.this.w != null) {
                    jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.f5210a != null) {
                                TTVideoWebPageActivity.this.f5210a.loadUrl(TTVideoWebPageActivity.this.w);
                            }
                        }
                    });
                }
                NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.x;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !TTVideoWebPageActivity.this.kj() && TTVideoWebPageActivity.this.cj != i) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.b) TTVideoWebPageActivity.this.x.getNativeVideoController()).u(context, i);
                }
                TTVideoWebPageActivity.this.cj = i;
            }
        }
    };

    private void bq() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.qf() != 4) {
            return;
        }
        y.u((View) this.d, 0);
        String strWf = !TextUtils.isEmpty(this.pn.wf()) ? this.pn.wf() : !TextUtils.isEmpty(this.pn.ym()) ? this.pn.ym() : !TextUtils.isEmpty(this.pn.j()) ? this.pn.j() : "";
        rh rhVarDd = this.pn.dd();
        if (rhVarDd != null && rhVarDd.u() != null) {
            y.u((View) this.rh, 0);
            y.u((View) this.h, 4);
            com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(this.rh);
        } else if (!TextUtils.isEmpty(strWf)) {
            y.u((View) this.rh, 4);
            y.u((View) this.h, 0);
            this.h.setText(strWf.substring(0, 1));
        }
        if (this.ja != null && !TextUtils.isEmpty(strWf)) {
            this.ja.setText(strWf);
        }
        if (!TextUtils.isEmpty(this.pn.yb())) {
            this.bf.setText(this.pn.yb());
        }
        y.u((View) this.ja, 0);
        if (z()) {
            y.u((View) this.bf, 8);
        } else {
            y.u((View) this.bf, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        int iSx = bq.sx(this.pn);
        bc bcVar = this.pn;
        if (bcVar != null) {
            if (bcVar.qf() == 4 || iSx != 0) {
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = n.u((Context) this.ay, this.pn, this.fx, false);
                this.m = fxVarU;
                fxVarU.u(this.ay);
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.m;
                if (fxVar instanceof pn) {
                    ((pn) fxVar).iz(true);
                    ((pn) this.m).n().u(false);
                }
                com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.ay, this.pn, "embeded_ad_landingpage", this.b);
                this.mk = uVar;
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.mk.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
                this.m.u(this.pn, false);
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.mk.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.m);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void dw() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.qf() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = n.u((Context) this.ay, this.pn, this.fx, false);
        this.m = fxVarU;
        fxVarU.u(this.ay);
        this.m.u(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(this.pn));
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.m;
        if (fxVar instanceof pn) {
            ((pn) fxVar).iz(true);
        }
        com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.ay, this.pn, "embeded_ad_landingpage", this.b);
        this.mk = uVar;
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.mk.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
        this.bf.setOnClickListener(this.mk);
        this.bf.setOnTouchListener(this.mk);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.mk.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kj() {
        NativeVideoTsView nativeVideoTsView = this.x;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.x.getNativeVideoController().bq();
    }

    private void q() {
        if (this.f5210a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.pn);
        ja jaVar = new ja(this.ay);
        this.bq = jaVar;
        jaVar.b(this.v);
        this.bq.nr(this.f5210a).u(this.pn).fx(arrayList).nr(this.u).u(this.fx).b(this.nr).nr(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(this.pn)).fx(this.b).u(this.f5210a).u(true).pn(jp.sx(this.pn));
    }

    private void qq() {
        if (this.pn == null) {
            return;
        }
        JSONArray jSONArrayFx = fx(this.w);
        int iT = jp.t(this.pn);
        int iJk = jp.jk(this.pn);
        qq<com.bytedance.sdk.openadsdk.core.s.u> qqVarU = dw.u();
        if (jSONArrayFx == null || qqVarU == null || iT <= 0 || iJk <= 0) {
            return;
        }
        oa oaVar = new oa();
        oaVar.pn = jSONArrayFx;
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = this.pn.tm();
        if (nrVarTm == null) {
            return;
        }
        qqVarU.u(h.nr(nrVarTm).fx(6).u(), oaVar, iJk, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
                TTVideoWebPageActivity.this.u(0);
                nrVar.u(i);
                com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
                if (uVar != null) {
                    try {
                        TTVideoWebPageActivity.this.mh.set(false);
                        TTVideoWebPageActivity.this.bq.u(uVar.fx());
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.u(0);
                    }
                }
            }
        });
    }

    private boolean z() {
        bc bcVar = this.pn;
        if (bcVar == null) {
            return false;
        }
        int iP = bcVar.p();
        return this.b == 1 && "embeded_ad_landingpage".equals(this.fx) && (iP == 1 || iP == 2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        nr nrVar = this.eh;
        if (nrVar != null) {
            nrVar.u(this.ay, this.pn);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if ((bc.fx(this.pn) || wq.u(this.pn)) && y.u(this.f5210a)) {
            return;
        }
        if (this.y && (nativeVideoTsView = this.x) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.b.u) this.x.getNativeVideoController()).pn(null, null);
            this.y = false;
            return;
        }
        nr nrVar = this.eh;
        if (nrVar == null || !nrVar.nr(this.ay, this.pn)) {
            u("detail_back");
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.pn == null) {
            return;
        }
        this.ay = this;
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            dw.u(this.ay);
        } catch (Throwable unused2) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.cj = o.fx(getApplicationContext());
        setContentView(com.bytedance.sdk.openadsdk.res.pn.u(this.ay, this.pn));
        this.bg = this.ay;
        Intent intent = getIntent();
        this.v = intent.getBooleanExtra("is_outer_click", false);
        this.lf = intent.getIntExtra("get_phone_num_status", 0);
        String stringExtra = intent.getStringExtra("title");
        this.oa = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.q = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_data");
        if (stringExtra2 != null) {
            try {
                this.tk = com.bytedance.sdk.openadsdk.core.multipro.nr.u.u(new JSONObject(stringExtra2));
            } catch (Exception unused3) {
            }
            com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = this.tk;
            if (uVar != null) {
                this.q = uVar.x;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.pn == null) {
                try {
                    this.pn = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(string));
                } catch (Throwable unused4) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.q = j;
            }
        }
        String stringExtra3 = intent.getStringExtra("url");
        this.w = stringExtra3;
        this.w = jp.nr(this.pn, stringExtra3);
        k();
        u(this.pn);
        dw();
        q();
        u(4);
        SSWebView sSWebView = this.f5210a;
        if (sSWebView != null) {
            Context applicationContext = getApplicationContext();
            bc bcVar = this.pn;
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.m.nr.u(sSWebView, applicationContext, bcVar != null ? bcVar.iz() : this.lf, this.pn), "CCWifiJSBridge");
            com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.bg).u(true).nr(false).u(this.f5210a);
            this.wi = new iz(this.pn, this.f5210a).nr(true).nr(jCurrentTimeMillis).b(this.f5210a.getCreateDuration());
            l();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.u);
            jSONObject.put("url", this.w);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
            jSONObject.put("event_tag", this.fx);
        } catch (JSONException unused5) {
        }
        this.wi.u(jSONObject);
        this.f5210a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(this.bg, this.bq, this.u, this.wi, this.su) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.xg == null || TTVideoWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTVideoWebPageActivity.this.xg.setVisibility(8);
                } catch (Throwable unused6) {
                }
            }
        });
        SSWebView sSWebView2 = this.f5210a;
        if (sSWebView2 != null) {
            c.u(sSWebView2, d.fx, bc.b(this.pn));
            this.f5210a.setMixedContentMode(0);
        }
        this.f5210a.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.bq, this.wi) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.fx, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.xg == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && TTVideoWebPageActivity.this.xg.isShown()) {
                    TTVideoWebPageActivity.this.xg.setVisibility(8);
                } else {
                    TTVideoWebPageActivity.this.xg.setProgress(i);
                }
            }
        });
        this.f5210a.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.11
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoWebPageActivity.this.f5211jp.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = (com.bytedance.sdk.openadsdk.core.l.nr.fx) TTVideoWebPageActivity.this.f5211jp.get(str);
                    if (fxVar != null) {
                        fxVar.u(jp.dw(TTVideoWebPageActivity.this.pn), false);
                        return;
                    }
                    return;
                }
                Activity activity = TTVideoWebPageActivity.this.ay;
                TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = n.u(activity, str, tTVideoWebPageActivity.pn, tTVideoWebPageActivity.fx);
                fxVarU.u(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(TTVideoWebPageActivity.this.pn));
                TTVideoWebPageActivity.this.f5211jp.put(str, fxVarU);
                fxVarU.u(jp.dw(TTVideoWebPageActivity.this.pn), false);
            }
        });
        TextView textView = this.l;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = q.u(this.ay, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        TextView textView2 = this.my;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.nr(tTVideoWebPageActivity.pn);
                }
            });
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.fx(tTVideoWebPageActivity.pn);
                }
            });
        }
        pn();
        o();
        mv();
        com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, getClass().getName());
        this.f5210a.setVisibility(0);
        this.wi.fx(System.currentTimeMillis());
        this.f5210a.loadUrl(this.w);
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.pn);
        this.eh = new nr(this.wi.u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        iz();
        iz izVar = this.wi;
        if (izVar != null) {
            izVar.x();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.f5210a;
        if (sSWebView != null) {
            xg.u(this.bg, sSWebView);
            xg.u(this.f5210a);
        }
        this.f5210a = null;
        com.bytedance.sdk.openadsdk.l.b bVar = this.su;
        if (bVar != null) {
            bVar.b();
        }
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.m;
        if (fxVar != null) {
            fxVar.nr();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> map = this.f5211jp;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().nr();
                }
            }
            this.f5211jp.clear();
        }
        ja jaVar = this.bq;
        if (jaVar != null) {
            jaVar.rh();
        }
        NativeVideoTsView nativeVideoTsView = this.x;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.x.getNativeVideoController().jk();
        }
        NativeVideoTsView nativeVideoTsView2 = this.x;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.bq();
            this.x = null;
        }
        this.pn = null;
        iz izVar2 = this.wi;
        if (izVar2 != null) {
            izVar2.iz();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        nr nrVar = this.eh;
        if (nrVar != null) {
            nrVar.u(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.bc && !t()) {
                this.bc = true;
                this.n.iz();
            }
        } catch (Throwable th) {
            k.nr("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        ja jaVar = this.bq;
        if (jaVar != null) {
            jaVar.h();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> map = this.f5211jp;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        if (kj() || ((nativeVideoTsView2 = this.x) != null && nativeVideoTsView2.getNativeVideoController() != null && this.x.getNativeVideoController().bq())) {
            com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("sp_multi_native_video_data");
            fxVarU.put("key_video_is_update_flag", true);
            fxVarU.put("key_native_video_complete", true);
            fxVarU.put("key_video_isfromvideodetailpage", true);
        }
        if (kj() || (nativeVideoTsView = this.x) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        u(this.x.getNativeVideoController());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.xw = false;
        if (this.bc && jk() && !t()) {
            this.bc = false;
            this.n.n();
        }
        ja jaVar = this.bq;
        if (jaVar != null) {
            jaVar.d();
            this.bq.u(new SSWebView.nr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6
                @Override // com.bytedance.sdk.component.widget.SSWebView.nr
                public void u(int i) {
                    TTVideoWebPageActivity.this.bq.u(i);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.m;
        if (fxVar != null) {
            fxVar.u();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> map = this.f5211jp;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().u();
                }
            }
        }
        iz izVar = this.wi;
        if (izVar != null) {
            izVar.b();
        }
        qq();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bc bcVar = this.pn;
        bundle.putString("material_meta", bcVar != null ? bcVar.et().toString() : null);
        bundle.putLong("video_play_position", this.q);
        bundle.putBoolean("is_complete", kj());
        long jT = this.q;
        NativeVideoTsView nativeVideoTsView = this.x;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jT = this.x.getNativeVideoController().t();
        }
        bundle.putLong("video_play_position", jT);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        iz izVar = this.wi;
        if (izVar != null) {
            izVar.pn();
        }
    }

    private int bg() {
        NativeVideoTsView nativeVideoTsView = this.x;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.x.getNativeVideoController().k();
    }

    private void k() {
        this.xg = (TTProgressBar) findViewById(2114387922);
        this.wq = (TTViewStub) findViewById(2114387956);
        this.f5210a = (SSWebView) findViewById(2114387733);
        this.jk = (ImageView) findViewById(2114387705);
        bc bcVar = this.pn;
        if (bcVar != null && bcVar.vz() != null) {
            this.pn.vz().u("landing_page");
        }
        ImageView imageView = this.jk;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (y.u(TTVideoWebPageActivity.this.f5210a)) {
                        return;
                    }
                    if (TTVideoWebPageActivity.this.eh != null) {
                        TTVideoWebPageActivity.this.eh.u(0);
                    }
                    TTVideoWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.t = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.u("detail_skip");
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387627);
        this.mv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.x();
                }
            });
        }
        this.l = (TextView) findViewById(2114387952);
        this.s = (TextView) findViewById(2114387886);
        this.k = (TextView) findViewById(2114387745);
        this.my = (TextView) findViewById(2114387647);
        this.o = (TextView) findViewById(2114387612);
        this.sx = (LinearLayout) findViewById(2114387890);
        this.c = (FrameLayout) findViewById(2114387708);
        this.dw = (RelativeLayout) findViewById(2114387943);
        this.d = (RelativeLayout) findViewById(2114387655);
        this.h = (TextView) findViewById(2114387957);
        this.ja = (TextView) findViewById(2114387764);
        this.bf = (TextView) findViewById(2114387686);
        this.rh = (RoundImageView) findViewById(2114387664);
        bq();
        my();
    }

    private void l() {
        bc bcVar = this.pn;
        if (bcVar == null) {
            return;
        }
        this.su = com.bytedance.sdk.openadsdk.l.b.u(this.bg, bcVar, this.w);
    }

    private void mv() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.qf() != 4) {
            return;
        }
        this.wq.setVisibility(0);
        Button button = (Button) findViewById(2114387729);
        this.pb = button;
        if (button != null) {
            nr(s());
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.m;
            if (fxVar != null) {
                fxVar.u(this.gc, false);
            }
            this.pb.setOnClickListener(this.mk);
            this.pb.setOnTouchListener(this.mk);
        }
    }

    private void my() {
        bc bcVar = this.pn;
        if (bcVar == null || this.dw == null || !bcVar.s()) {
            return;
        }
        this.dw.setVisibility(8);
    }

    private void o() {
        if (bc.nr(this.pn)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.x = new NativeVideoTsView(this.bg, this.pn, true, true);
                } else {
                    this.x = new NativeVideoTsView(this.bg, this.pn, true, false);
                }
                if (this.x.getNativeVideoController() != null) {
                    this.x.getNativeVideoController().u(false);
                    if (this.tk != null) {
                        this.x.getNativeVideoController().fx(this.tk.u);
                    }
                }
                this.x.setVideoAdInteractionListener(this);
                if (!this.oa) {
                    this.q = 0L;
                }
                if (this.tk != null && this.x.getNativeVideoController() != null) {
                    this.x.getNativeVideoController().fx(this.tk.x);
                    this.x.getNativeVideoController().b(this.tk.pn);
                }
                if (this.x.getNativeVideoController() != null) {
                    this.x.getNativeVideoController().u(false);
                    this.x.getNativeVideoController().u(this.p);
                    this.x.setIsQuiet(this.pn.jn() == 1);
                }
                if (this.x.u(this.q, this.xw, kj())) {
                    this.c.setVisibility(0);
                    this.c.removeAllViews();
                    this.c.addView(this.x);
                }
                if (kj()) {
                    this.x.b(true);
                }
                this.n = this.x.getNativeVideoController();
            } catch (Exception unused) {
            }
            if (o.fx(this.ay.getApplicationContext()) == 0) {
                try {
                    Activity activity = this.ay;
                    com.bytedance.sdk.component.utils.h.u(activity, q.u(activity, "tt_no_network"), 0);
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        bc bcVar = this.pn;
        if (bcVar != null && !TextUtils.isEmpty(bcVar.yb())) {
            this.nb = this.pn.yb();
        }
        return this.nb;
    }

    private long sx() {
        NativeVideoTsView nativeVideoTsView = this.x;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.x.getNativeVideoController().s();
    }

    public boolean a() {
        fx fxVar = this.n;
        return (fxVar == null || fxVar.o() == null || !this.n.o().mv()) ? false : true;
    }

    public boolean jk() {
        fx fxVar = this.n;
        return (fxVar == null || fxVar.o() == null || !this.n.o().s()) ? false : true;
    }

    public void n() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(this.ay, this.pn.vz(), this.fx, true, com.bytedance.sdk.openadsdk.n.nr.u());
        this.iz = nrVar;
        com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.ay, this.pn, nrVar);
        this.iz.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void nr() {
                if (TTVideoWebPageActivity.this.jk()) {
                    TTVideoWebPageActivity.this.n.n();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void u() {
                if (TTVideoWebPageActivity.this.a()) {
                    TTVideoWebPageActivity.this.n.iz();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void u(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.jk()) {
                    TTVideoWebPageActivity.this.n.n();
                }
            }
        });
    }

    public boolean t() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.iz;
        if (nrVar != null) {
            return nrVar.fx();
        }
        return false;
    }

    public void x() {
        if (isFinishing() || this.pn == null) {
            return;
        }
        if (this.iz == null) {
            n();
        }
        this.iz.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.bg, bcVar.lk(), new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        }, bcVar.wu());
    }

    public void iz() {
        try {
            gi.u(this.f);
        } catch (Exception unused) {
        }
    }

    public void pn() {
        gi.u(this.f, this.bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.bg, bcVar.lk(), bcVar.wu(), new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        });
    }

    private JSONArray fx(String str) {
        int i;
        JSONArray jSONArray = this.yd;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.yd;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER);
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.pb) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.17
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.pb == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.pb.setText(str);
            }
        });
    }

    private void u(bc bcVar) {
        LinearLayout linearLayout = this.sx;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (bcVar == null) {
            return;
        }
        String strWu = bcVar.wu();
        if (TextUtils.isEmpty(strWu)) {
            LinearLayout linearLayout2 = this.sx;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(strWu)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(strWu));
            if (izVarPn == null) {
                LinearLayout linearLayout3 = this.sx;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(izVarPn.mv())) {
                LinearLayout linearLayout4 = this.sx;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout5 = this.sx;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            String strPn = izVarPn.pn();
            String strX = izVarPn.x();
            String strS = izVarPn.s();
            if (TextUtils.isEmpty(strS)) {
                strS = com.bytedance.sdk.openadsdk.core.l.fx.jk.nr(bcVar);
            }
            if (this.s != null) {
                this.s.setText(String.format(q.u(this.bg, "tt_open_app_detail_developer"), strX));
            }
            if (this.k != null) {
                this.k.setText(String.format(q.u(this.bg, "tt_open_landing_page_app_name"), strS, strPn));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void D_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void o_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void q_() {
    }

    public void u(String str) {
        NativeVideoTsView nativeVideoTsView = this.x;
        com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, "embeded_ad", str, sx(), bg(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : jp.u(this.pn, this.x.getNativeVideoController().l(), this.x.getNativeVideoController().o()));
    }

    private void u(fx fxVar) {
        k.nr("mutilproces", "initFeedNaitiveControllerData-isComplete=" + fxVar.bq() + ",position=" + fxVar.t() + ",totalPlayDuration=" + (fxVar.s() + fxVar.l()) + ",duration=" + fxVar.s());
        com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("sp_multi_native_video_data");
        fxVarU.put("key_video_is_update_flag", true);
        fxVarU.put("key_video_isfromvideodetailpage", true);
        fxVarU.put("key_native_video_complete", fxVar.bq());
        fxVarU.put("key_video_current_play_position", fxVar.t());
        fxVarU.put("key_video_total_play_duration", fxVar.s() + fxVar.l());
        fxVarU.put("key_video_duration", fxVar.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i) {
        if (bc.fx(this.pn)) {
            y.u((View) this.t, 4);
        } else if (bc.fx(this.pn)) {
            y.u((View) this.t, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.b
    public void u(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.yd = jSONArray;
        qq();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void u(long j, long j2) {
        if (z()) {
            com.bytedance.sdk.openadsdk.core.n.o().u(j);
        }
    }
}
