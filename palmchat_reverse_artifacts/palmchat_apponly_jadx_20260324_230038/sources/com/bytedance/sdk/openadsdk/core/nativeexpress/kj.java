package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.m;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.s.n;
import com.wifi.ad.core.p001const.WifiNestConst;
import j$.util.DesugarCollections;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class kj extends com.bytedance.sdk.component.adexpress.pn.u implements k, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bc f5341a;
    private long bg;
    private final Map<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> iz;
    private com.bytedance.sdk.openadsdk.iz.u jk;
    private com.bytedance.sdk.openadsdk.core.y.u k;
    private com.bytedance.sdk.openadsdk.core.s.iz l;
    private ja mv;
    private com.bytedance.sdk.openadsdk.s.n my;
    private String n;
    private x o;
    private int s;
    private com.bytedance.sdk.component.adexpress.nr.a sx;
    private String t;
    private Context x;

    public kj(Context context, com.bytedance.sdk.component.adexpress.nr.mv mvVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.iz.u uVar, bc bcVar, com.bytedance.sdk.component.adexpress.nr.a aVar) {
        super(context, mvVar, themeStatusBroadcastReceiver);
        this.iz = DesugarCollections.synchronizedMap(new HashMap());
        this.s = 8;
        this.bg = -1L;
        this.x = context;
        this.n = mvVar.iz();
        this.f5341a = bcVar;
        this.jk = uVar;
        this.u = mvVar.pn();
        String strU = u(bcVar);
        this.t = strU;
        this.sx = aVar;
        u(m.nr(strU));
        themeStatusBroadcastReceiver.u(this);
        l();
        mv();
        s();
    }

    private boolean my() {
        return !TextUtils.isEmpty(this.n) && this.n.equals(WifiNestConst.NestTypeConst.NEST_SPLASH_AD);
    }

    private void o() {
        if (this.mv == null || ((ViewGroup) this.fx.getParent()) == null) {
            return;
        }
        ja jaVar = this.mv;
        jaVar.u(new z(this.fx, jaVar, this.f5341a));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public ja F_() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void a() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        this.k = uVarB;
        uVarB.u(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.u
    public void b_(int i) {
        if (this.mv == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException unused) {
        }
        this.mv.nr("themeChange", jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void iz() {
        ja jaVar = this.mv;
        if (jaVar == null) {
            return;
        }
        jaVar.nr("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void jk() {
        super.jk();
        com.bytedance.sdk.openadsdk.core.y.u uVar = this.k;
        if (uVar != null) {
            uVar.nr(this);
        }
    }

    public x k() {
        return this.o;
    }

    public void l() {
        if (this.fx == null) {
            return;
        }
        ja jaVar = new ja(this.x);
        this.mv = jaVar;
        jaVar.nr(this.fx).u(this.f5341a).nr(this.f5341a.lk()).b(this.f5341a.ap()).u(this.n).fx(jp.nr(this.n)).pn(jp.sx(this.f5341a)).u(this).b(this.u).u(this.fx).u(this.jk);
    }

    public void mv() {
        SSWebView sSWebView = this.fx;
        if (sSWebView == null) {
            return;
        }
        sSWebView.setMaterialMeta(xg.u(this.f5341a));
        try {
            this.fx.setBackgroundColor(0);
            this.fx.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        u(this.fx);
        if (u() != null) {
            this.l = new com.bytedance.sdk.openadsdk.core.s.iz(this.f5341a, u()).nr(false);
        }
        this.l.u(this.jk);
        this.fx.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.mv, this.l));
        this.fx.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kj.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!kj.this.iz.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.l.n.u(kj.this.x, str, kj.this.f5341a, kj.this.n);
                    kj.this.iz.put(str, fxVarU);
                    fxVarU.u(jp.dw(kj.this.f5341a), false);
                } else {
                    com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = (com.bytedance.sdk.openadsdk.core.l.nr.fx) kj.this.iz.get(str);
                    if (fxVar != null) {
                        fxVar.u(jp.dw(kj.this.f5341a), false);
                    }
                }
            }
        });
        if ("rewarded_video".equals(this.n) || "fullscreen_interstitial_ad".equals(this.n)) {
            y.u((com.bytedance.sdk.component.mv.fx) this.fx);
        }
        com.bytedance.sdk.component.adexpress.pn.pn.u().u(this.fx, this.mv);
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u, com.bytedance.sdk.openadsdk.core.nativeexpress.s
    public void n() {
        super.n();
        if (this.mv == null) {
            return;
        }
        o();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.mv.nr("expressShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void s() {
        if (this.fx == null || this.my != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.fx fxVar = new com.bytedance.sdk.openadsdk.core.c.fx();
        com.bytedance.sdk.openadsdk.core.c.b bVar = new com.bytedance.sdk.openadsdk.core.c.b();
        com.bytedance.sdk.openadsdk.core.c.pn pnVar = new com.bytedance.sdk.openadsdk.core.c.pn(this.mv);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.f5341a.lk());
            jSONObject.put("log_extra", this.f5341a.ap());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        hashSet.add("sendReward");
        this.my = fxVar.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), this.fx, pnVar, bVar, hashSet, "embeded_ad".equals(this.n) ? n.u.FEED : n.u.OTHER).pn(this.t).b(com.bytedance.sdk.openadsdk.core.n.u.x()).u(com.bytedance.sdk.openadsdk.core.n.u.u()).pn(jSONObject).u("sdkEdition", com.bytedance.sdk.openadsdk.core.n.u.fx()).nr(com.bytedance.sdk.openadsdk.core.n.u.pn()).fx(com.bytedance.sdk.openadsdk.core.n.u.b()).fx(false);
        x xVar = new x(this.x, this.mv, this.f5341a, this.l, my(), this.my, t());
        this.o = xVar;
        this.fx.setWebViewClient(xVar);
        com.bytedance.sdk.component.adexpress.nr.a aVar = this.sx;
        if (aVar instanceof jk) {
            ((jk) aVar).u(this.my);
        }
        Set<String> setJk = this.my.jk();
        if (this.mv == null || setJk == null || setJk.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.my);
        Iterator<String> it = setJk.iterator();
        while (it.hasNext()) {
            this.mv.iz().u(it.next(), (com.bytedance.sdk.component.u.pn<?, ?>) new com.bytedance.sdk.component.u.pn<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kj.2
                @Override // com.bytedance.sdk.component.u.pn
                public JSONObject u(JSONObject jSONObject2, com.bytedance.sdk.component.u.iz izVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.s.n nVar = (com.bytedance.sdk.openadsdk.s.n) weakReference.get();
                        if (nVar == null) {
                            return null;
                        }
                        return nVar.b(u(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void b() {
        if (this.pn.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.iz izVar = this.l;
        if (izVar != null) {
            izVar.iz();
        }
        SSWebView sSWebView = this.fx;
        if (sSWebView != null) {
            sSWebView.K_();
            this.fx.setOnShakeListener(null);
        }
        ja jaVar = this.mv;
        if (jaVar != null) {
            jaVar.pn();
        }
        super.b();
        this.iz.clear();
        this.mv = null;
        com.bytedance.sdk.openadsdk.s.n nVar = this.my;
        if (nVar == null) {
            return;
        }
        nVar.wq();
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void pn() {
        if (u() == null) {
            return;
        }
        try {
            u().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u, com.bytedance.sdk.component.adexpress.nr.b
    public int fx() {
        return tk.nr(this.f5341a);
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u, com.bytedance.sdk.openadsdk.core.nativeexpress.s
    public void nr(final int i) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kj.3
            @Override // java.lang.Runnable
            public void run() {
                kj.this.fx(i);
                kj.this.b(i);
                if (i == kj.this.s) {
                    return;
                }
                kj.this.s = i;
                kj.this.nr(i == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(int i) {
        com.bytedance.sdk.openadsdk.s.n nVar = this.my;
        if (nVar == null) {
            return;
        }
        if (i == 0) {
            nVar.nr(true);
            this.my.u(false);
        } else {
            nVar.nr(false);
            this.my.u(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if (this.mv == null || this.fx == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.mv.nr("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public static String u(bc bcVar) {
        return com.bytedance.sdk.component.adexpress.u.nr.nr.nr(tk.n(bcVar) ? "v3" : null);
    }

    public static void u(Map<String, Object> map, bc bcVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (tk.iz(bcVar) != null && !TextUtils.isEmpty(tk.iz(bcVar).t())) {
                map.put("engine_version", tk.iz(bcVar).t());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.x).u(false).u(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            com.bytedance.sdk.openadsdk.core.y.c.u(sSWebView, d.fx, bc.b(this.f5341a));
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
            com.bytedance.sdk.component.utils.k.nr("WebViewRender", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        try {
            if (d.u() && i == 0) {
                long jXh = com.bytedance.sdk.openadsdk.core.dw.nr().xh();
                if (this.bg != -1 && System.currentTimeMillis() - this.bg > jXh) {
                    SSWebView sSWebViewU = u();
                    WebView webView = sSWebViewU.getWebView();
                    sSWebViewU.removeView(webView);
                    sSWebViewU.addView(webView);
                }
                this.bg = -1L;
                return;
            }
            this.bg = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public SSWebView u() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void u(boolean z, int i) {
        super.u(z, i);
        com.bytedance.sdk.openadsdk.iz.u uVar = this.jk;
        if (uVar != null) {
            uVar.u(z, i);
            this.jk.nr(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.u
    public void u(float f, float f2) {
        float f3 = this.x.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.u(y.nr(f3, y.u(f4, f)), y.nr(f3, y.u(f4, f2)));
    }
}
