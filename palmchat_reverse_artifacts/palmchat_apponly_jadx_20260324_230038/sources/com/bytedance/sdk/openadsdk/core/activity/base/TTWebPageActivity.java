package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
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
import com.bytedance.sdk.openadsdk.core.kj.wq;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.l.fx.pn;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.l.nr.fx;
import com.bytedance.sdk.openadsdk.core.playable.nr.nr;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.xg;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.huawei.hms.framework.common.ContainerUtils;
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
public class TTWebPageActivity extends BaseLandingPageActivity implements rh.u, b {
    private static final String n = "TTWebPageActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSWebView f5212a;
    private boolean bc;
    private ImageView bg;
    private Context bq;
    private TTViewStub c;
    private nr cj;
    private ja d;
    private TTViewStub dw;
    private LinearLayout gi;
    private boolean h;
    com.bytedance.sdk.openadsdk.core.dislike.ui.nr iz;
    private ImageView jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.u.b f5213jp;
    private TextView k;
    private Button kj;
    private TextView l;
    private TextView mv;
    private TextView my;
    private TextView o;
    private int oa;
    private com.bytedance.sdk.openadsdk.l.b pb;
    private TTViewStub q;
    private TTViewStub qq;
    private String rh;
    private TextView s;
    private LinearLayout sx;
    private ImageView t;
    private Activity wq;
    iz x;
    private fx xg;
    private int xw;
    private boolean y;
    private TTProgressBar z;
    private AtomicBoolean ja = new AtomicBoolean(true);
    private JSONArray bf = null;
    private final Map<String, fx> m = DesugarCollections.synchronizedMap(new HashMap());
    private final rh w = new rh(Looper.getMainLooper(), this);
    private int tk = 0;
    private String wi = "立即下载";
    private com.bytedance.sdk.openadsdk.core.l.nr.u su = new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void fx(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.u("下载失败");
            if (j > 0) {
                u.C0239u.u(TTWebPageActivity.this.u, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void nr(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.u("暂停");
            if (j > 0) {
                u.C0239u.u(TTWebPageActivity.this.u, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.u(tTWebPageActivity.x());
            u.C0239u.u(TTWebPageActivity.this.u, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.u("下载中...");
            String unused = TTWebPageActivity.n;
            if (j > 0) {
                u.C0239u.u(TTWebPageActivity.this.u, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, String str, String str2) {
            TTWebPageActivity.this.u("点击安装");
            u.C0239u.u(TTWebPageActivity.this.u, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(String str, String str2) {
            TTWebPageActivity.this.u("点击打开");
            u.C0239u.u(TTWebPageActivity.this.u, 6, 100);
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements DownloadListener {
        private String b;
        private Context fx;
        private bc nr;
        private Map<String, fx> u;

        public u(Map<String, fx> map, bc bcVar, Context context, String str) {
            this.u = map;
            this.nr = bcVar;
            this.fx = context;
            this.b = str;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, fx> map = this.u;
            if (map == null || !map.containsKey(str)) {
                fx fxVarU = n.u(this.fx, str, this.nr, this.b);
                fxVarU.u(jk.u(this.nr));
                this.u.put(str, fxVarU);
                fxVarU.u(jp.dw(this.nr), false);
                return;
            }
            fx fxVar = this.u.get(str);
            if (fxVar != null) {
                fxVar.u(jp.dw(this.nr), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (s()) {
            this.w.removeMessages(10);
        }
    }

    private void l() {
        this.bc = yd.bg(this.pn);
        boolean z = yd.sx(this.pn) && !com.bytedance.sdk.openadsdk.core.n.b.fx;
        this.y = z;
        if (this.bc) {
            if (!com.bytedance.sdk.openadsdk.core.n.b.b) {
                this.y = false;
            } else if (z) {
                this.bc = false;
            }
        }
    }

    private void mv() {
        this.xw = 0;
        if (this.y) {
            this.xw = com.bytedance.sdk.openadsdk.core.n.b.u;
        } else if (this.bc && !com.bytedance.sdk.openadsdk.core.n.b.b) {
            this.xw = yd.s(this.pn);
        }
        nr(this.xw);
        if (this.xw > 0 && !this.w.hasMessages(10)) {
            if (this.y) {
                this.w.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.bc) {
                this.w.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        if (!s() || this.w.hasMessages(10)) {
            return;
        }
        this.w.sendEmptyMessageDelayed(10, 1000L);
    }

    private boolean s() {
        return this.y || this.bc;
    }

    private void t() {
        if (this.pn == null) {
            return;
        }
        JSONArray jSONArrayNr = nr(this.rh);
        int iT = jp.t(this.pn);
        int iJk = jp.jk(this.pn);
        qq<com.bytedance.sdk.openadsdk.core.s.u> qqVarU = dw.u();
        if (jSONArrayNr == null || qqVarU == null || iT <= 0 || iJk <= 0) {
            return;
        }
        oa oaVar = new oa();
        oaVar.pn = jSONArrayNr;
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = this.pn.tm();
        if (nrVarTm == null) {
            return;
        }
        qqVarU.u(h.nr(nrVarTm).fx(6).u(), oaVar, iJk, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
                TTWebPageActivity.this.u(0);
                nrVar.u(i);
                com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
                if (uVar != null) {
                    try {
                        TTWebPageActivity.this.ja.set(false);
                        TTWebPageActivity.this.d.u(uVar.fx());
                    } catch (Exception unused) {
                        TTWebPageActivity.this.u(0);
                    }
                }
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        nr nrVar = this.cj;
        if (nrVar != null) {
            nrVar.u(this.wq, this.pn);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if ((bc.fx(this.pn) || wq.u(this.pn)) && y.u(this.f5212a)) {
                return;
            }
            nr nrVar = this.cj;
            if (nrVar == null || !nrVar.nr(this.wq, this.pn)) {
                super.onBackPressed();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        iz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.pn == null) {
            return;
        }
        this.wq = this;
        this.bq = this;
        try {
            dw.u(this);
        } catch (Throwable unused) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        setContentView(n());
        Intent intent = getIntent();
        com.bytedance.sdk.openadsdk.core.playable.nr.u().u(this.pn);
        l();
        a();
        if (this.f5212a != null) {
            com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.bq).u(false).nr(false).u(this.f5212a);
        }
        this.h = intent.getBooleanExtra("is_outer_click", false);
        String stringExtra = intent.getStringExtra("url");
        this.rh = stringExtra;
        this.rh = jp.nr(this.pn, stringExtra);
        String stringExtra2 = intent.getStringExtra("title");
        bc bcVar = this.pn;
        if (bcVar != null && bcVar.vz() != null) {
            this.pn.vz().u("landing_page");
        }
        this.tk = intent.getIntExtra("get_phone_num_status", 0);
        fx(this.pn);
        SSWebView sSWebView = this.f5212a;
        if (sSWebView != null) {
            Context applicationContext = getApplicationContext();
            bc bcVar2 = this.pn;
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.m.nr.u(sSWebView, applicationContext, bcVar2 != null ? bcVar2.iz() : this.tk, this.pn), "CCWifiJSBridge");
            this.x = new iz(this.pn, this.f5212a).nr(true).nr(jCurrentTimeMillis).b(this.f5212a.getCreateDuration());
            b();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.u);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
            jSONObject.put("event_tag", this.fx);
        } catch (JSONException unused2) {
        }
        this.x.u(jSONObject);
        jk();
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = new com.bytedance.sdk.openadsdk.core.widget.u.b(this.bq, this.d, this.u, this.x, this.pb) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.z == null || TTWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTWebPageActivity.this.z.setVisibility(8);
                } catch (Throwable unused3) {
                }
            }
        };
        this.f5213jp = bVar;
        this.f5212a.setWebViewClient(bVar);
        SSWebView sSWebView2 = this.f5212a;
        if (sSWebView2 != null) {
            c.u(sSWebView2, d.fx, bc.b(this.pn));
        }
        this.f5212a.setMixedContentMode(0);
        this.f5212a.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.d, this.x) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.fx, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.z == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && TTWebPageActivity.this.z.isShown()) {
                    TTWebPageActivity.this.z.setVisibility(8);
                } else {
                    TTWebPageActivity.this.z.setProgress(i);
                }
            }
        });
        this.f5212a.setDownloadListener(new u(this.m, this.pn, this.bq, this.fx));
        TextView textView = this.l;
        if (textView != null && !this.y && !this.bc) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = q.u(this.wq, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        TextView textView2 = this.my;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.u(tTWebPageActivity.pn);
                }
            });
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.nr(tTWebPageActivity.pn);
                }
            });
        }
        iz();
        u(4);
        com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, getClass().getName());
        this.f5212a.setVisibility(0);
        this.x.fx(System.currentTimeMillis());
        this.f5212a.loadUrl(this.rh);
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.pn);
        if (this.y || this.bc) {
            mv();
        }
        this.cj = new nr(this.x.u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        iz izVar = this.x;
        if (izVar != null) {
            izVar.x();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.f5212a;
        if (sSWebView != null) {
            xg.u(this.bq, sSWebView);
            xg.u(this.f5212a);
        }
        this.f5212a = null;
        com.bytedance.sdk.openadsdk.l.b bVar = this.pb;
        if (bVar != null) {
            bVar.b();
        }
        ja jaVar = this.d;
        if (jaVar != null) {
            jaVar.rh();
        }
        fx fxVar = this.xg;
        if (fxVar != null) {
            fxVar.nr();
        }
        Map<String, fx> map = this.m;
        if (map != null) {
            for (Map.Entry<String, fx> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().nr();
                }
            }
            this.m.clear();
        }
        iz izVar2 = this.x;
        if (izVar2 != null) {
            izVar2.iz();
        }
        com.bytedance.sdk.openadsdk.core.playable.nr.u().nr(this.pn);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        nr nrVar = this.cj;
        if (nrVar != null) {
            nrVar.u(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ja jaVar = this.d;
        if (jaVar != null) {
            jaVar.h();
        }
        Map<String, fx> map = this.m;
        if (map != null) {
            for (Map.Entry<String, fx> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.f5213jp;
        if (bVar != null) {
            bVar.fx();
        }
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ja jaVar = this.d;
        if (jaVar != null) {
            jaVar.d();
            this.d.u(new SSWebView.nr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.4
                @Override // com.bytedance.sdk.component.widget.SSWebView.nr
                public void u(int i) {
                    TTWebPageActivity.this.d.u(i);
                }
            });
        }
        fx fxVar = this.xg;
        if (fxVar != null) {
            fxVar.u();
        }
        Map<String, fx> map = this.m;
        if (map != null) {
            for (Map.Entry<String, fx> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().u();
                }
            }
        }
        iz izVar = this.x;
        if (izVar != null) {
            izVar.b();
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.f5213jp;
        if (bVar != null) {
            bVar.nr(true);
        }
        t();
        my();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        iz izVar = this.x;
        if (izVar != null) {
            izVar.pn();
        }
    }

    private void a() {
        TTViewStub tTViewStub;
        if (this.y || this.bc) {
            TTViewStub tTViewStub2 = this.q;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.bg = (ImageView) findViewById(2114387843);
        } else {
            bc bcVar = this.pn;
            if (bcVar == null || !bcVar.s()) {
                int iH = com.bytedance.sdk.openadsdk.core.n.o().h();
                if (iH == 0) {
                    TTViewStub tTViewStub3 = this.dw;
                    if (tTViewStub3 != null) {
                        tTViewStub3.setVisibility(0);
                    }
                } else if (iH == 1 && (tTViewStub = this.c) != null) {
                    tTViewStub.setVisibility(0);
                }
            } else {
                TTViewStub tTViewStub4 = this.dw;
                if (tTViewStub4 != null) {
                    tTViewStub4.setVisibility(8);
                }
                TTViewStub tTViewStub5 = this.c;
                if (tTViewStub5 != null) {
                    tTViewStub5.setVisibility(8);
                }
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.jk = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (y.u(TTWebPageActivity.this.f5212a)) {
                        return;
                    }
                    if (TTWebPageActivity.this.cj != null) {
                        TTWebPageActivity.this.cj.u(0);
                    }
                    TTWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.t = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.l = (TextView) findViewById(2114387952);
        this.mv = (TextView) findViewById(2114387627);
        this.s = (TextView) findViewById(2114387610);
        this.k = (TextView) findViewById(2114387701);
        this.my = (TextView) findViewById(2114387598);
        this.o = (TextView) findViewById(2114387700);
        this.sx = (LinearLayout) findViewById(2114387676);
        TextView textView = this.mv;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.u();
                }
            });
        }
    }

    private void b() {
        bc bcVar = this.pn;
        if (bcVar == null) {
            return;
        }
        this.pb = com.bytedance.sdk.openadsdk.l.b.u(this.bq, bcVar, this.rh);
    }

    private void iz() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.qf() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.qq;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387729);
        this.kj = button;
        if (button != null) {
            u(x());
            if (this.xg == null) {
                fx fxVarU = n.u((Context) this.wq, this.pn, TextUtils.isEmpty(this.fx) ? jp.u(this.b) : this.fx, false);
                this.xg = fxVarU;
                fxVarU.u(jk.u(this.pn));
                this.xg.u(this.su, false);
            }
            this.xg.u(this.wq);
            fx fxVar = this.xg;
            if (fxVar instanceof pn) {
                ((pn) fxVar).iz(true);
            }
            com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.wq, this.pn, "embeded_ad_landingpage", this.b);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
            this.kj.setOnClickListener(uVar);
            this.kj.setOnTouchListener(uVar);
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.xg);
        }
    }

    private void jk() {
        if (this.f5212a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.pn);
        ja jaVar = new ja(this.wq);
        this.d = jaVar;
        jaVar.b(this.h);
        this.d.nr(this.f5212a).u(this.pn).fx(arrayList).nr(this.u).b(this.nr).fx(this.b).u(this.fx).pn(jp.sx(this.pn)).u(this.f5212a).u(true).nr(jk.u(this.pn)).u(this);
    }

    private View n() {
        Activity activity = this.wq;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        this.gi = new LinearLayout(this.wq);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.gi.setOrientation(1);
        this.gi.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.bq, new com.bytedance.sdk.openadsdk.res.layout.u.nr());
        this.dw = tTViewStub;
        tTViewStub.setId(2114387770);
        this.gi.addView(this.dw, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.bq, new com.bytedance.sdk.openadsdk.res.layout.u.fx());
        this.c = tTViewStub2;
        tTViewStub2.setId(2114387792);
        this.gi.addView(this.c, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.bq, new com.bytedance.sdk.openadsdk.res.layout.u.b());
        this.q = tTViewStub3;
        tTViewStub3.setId(2114387933);
        this.gi.addView(this.q, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.wq);
        this.gi.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.wq);
        this.f5212a = sSWebView;
        sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.y.xg.u(this.pn));
        this.f5212a.setId(2114387733);
        this.f5212a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.f5212a);
        TTViewStub tTViewStub4 = new TTViewStub(this.bq, new com.bytedance.sdk.openadsdk.res.layout.u.u());
        this.qq = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.qq, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.wq, null, R.style.Widget.ProgressBar.Horizontal);
        this.z = tTProgressBar;
        tTProgressBar.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.z.setLayoutParams(layoutParams3);
        this.z.setProgress(1);
        this.z.setProgressDrawable(q.fx(this.wq, "tt_browser_progress_style"));
        frameLayout.addView(this.z);
        return this.gi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void pn() {
        int iSx = bq.sx(this.pn);
        bc bcVar = this.pn;
        if (bcVar != null) {
            if (bcVar.qf() == 4 || iSx != 0) {
                if (this.xg == null) {
                    fx fxVarU = n.u((Context) this.wq, this.pn, TextUtils.isEmpty(this.fx) ? jp.u(this.b) : this.fx, false);
                    this.xg = fxVarU;
                    fxVarU.u(jk.u(this.pn));
                    this.xg.u(this.su, false);
                }
                this.xg.u(this.wq);
                fx fxVar = this.xg;
                if (fxVar instanceof pn) {
                    ((pn) fxVar).iz(true);
                    ((pn) this.xg).n().u(false);
                }
                com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.wq, this.pn, "embeded_ad_landingpage", this.b);
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
                this.xg.u(this.pn, false);
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.xg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x() {
        bc bcVar = this.pn;
        if (bcVar != null && !TextUtils.isEmpty(bcVar.yb())) {
            this.wi = this.pn.yb();
        }
        return this.wi;
    }

    private void fx(bc bcVar) {
        LinearLayout linearLayout = this.sx;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (this.pn == null) {
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
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
                strS = jk.nr(bcVar);
            }
            if (this.s != null) {
                this.s.setText(String.format(q.u(this.bq, "tt_open_app_detail_developer"), strX));
            }
            if (this.k != null) {
                this.k.setText(String.format(q.u(this.bq, "tt_open_landing_page_app_name"), strS, strPn));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        String strWu = bcVar.wu();
        k();
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.bq, bcVar.lk(), new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                TTWebPageActivity.this.my();
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                TTWebPageActivity.this.my();
                TTWebPageActivity.this.pn();
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                TTWebPageActivity.this.my();
            }
        }, strWu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        String strWu = bcVar.wu();
        k();
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.bq, bcVar.lk(), strWu, new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                TTWebPageActivity.this.my();
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                TTWebPageActivity.this.my();
                TTWebPageActivity.this.pn();
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                TTWebPageActivity.this.my();
            }
        });
    }

    private JSONArray nr(String str) {
        int i;
        JSONArray jSONArray = this.bf;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.bf;
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
    public void u(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.kj) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.kj == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.kj.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i) {
        if (bc.fx(this.pn)) {
            y.u((View) this.t, 4);
        } else if (bc.fx(this.pn)) {
            y.u((View) this.t, i);
        }
    }

    public void nr() {
        try {
            com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(this.wq, this.pn.vz(), this.fx, true, com.bytedance.sdk.openadsdk.n.nr.u());
            this.iz = nrVar;
            com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.wq, this.pn, nrVar);
            this.iz.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                public void nr() {
                    TTWebPageActivity.this.my();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                public void u() {
                    TTWebPageActivity.this.k();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                public void u(int i, String str, boolean z) {
                    TTWebPageActivity.this.my();
                }
            });
        } catch (Exception e) {
            k.u(e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.b
    public void u(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.bf = jSONArray;
        t();
    }

    public void u() {
        if (this.pn == null || isFinishing()) {
            return;
        }
        if (this.iz == null) {
            nr();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.iz;
        if (nrVar != null) {
            nrVar.u();
        }
    }

    private void nr(int i) {
        if (i > 0) {
            if (this.y) {
                y.u(this.l, i + "s后可领取奖励");
                return;
            }
            if (this.bc) {
                SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() + (-4), spannableString.length(), 17);
                y.u(this.l, spannableString);
                return;
            }
            return;
        }
        if (this.y) {
            y.u(this.l, "领取成功");
        } else if (this.bc) {
            y.u((View) this.bg, 8);
            y.u(this.l, "恭喜你！福利已领取");
        }
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what == 10 && s()) {
            int i = this.oa + 1;
            this.oa = i;
            if (this.y) {
                com.bytedance.sdk.openadsdk.core.n.b.nr = i;
            }
            int iMax = Math.max(0, this.xw - i);
            nr(iMax);
            if (iMax <= 0 && this.bc) {
                com.bytedance.sdk.openadsdk.core.n.b.b = true;
            }
            this.w.sendEmptyMessageDelayed(10, 1000L);
        }
    }
}
