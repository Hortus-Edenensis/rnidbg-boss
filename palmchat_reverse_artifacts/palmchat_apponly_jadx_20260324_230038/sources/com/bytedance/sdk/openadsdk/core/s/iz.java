package com.bytedance.sdk.openadsdk.core.s;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.sx.u;
import com.bytedance.sdk.openadsdk.core.y.oa;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private String b;
    private WeakReference<nr> bf;
    private com.bytedance.sdk.component.mv.fx bq;
    private JSONObject c;
    private Runnable d;
    private long gi;
    private final bc iz;
    private String pn;
    private com.bytedance.sdk.openadsdk.iz.u q;
    private String rh;
    private int u = 0;
    private volatile boolean nr = false;
    private int fx = -1;
    private String x = com.huawei.openalliance.ad.constant.x.df;
    private long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5363a = 0;
    private long jk = 0;
    private long t = 0;
    private long l = 0;
    private boolean mv = false;
    private long s = 0;
    private long k = 0;
    private long my = 0;
    private long o = -1;
    private boolean sx = false;
    private AtomicInteger bg = new AtomicInteger(0);
    private boolean dw = false;
    private AtomicBoolean qq = new AtomicBoolean(false);
    private boolean kj = false;
    private boolean z = true;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final Map<String, oa.u> ja = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(String str);
    }

    public iz(bc bcVar, com.bytedance.sdk.component.mv.fx fxVar) {
        this.iz = bcVar;
        this.bq = fxVar;
        if (fxVar != null) {
            fxVar.addJavascriptInterface(new u(this.bg, this.bf), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.gi = System.currentTimeMillis();
        this.rh = String.valueOf(SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.sx.u.u) && this.iz != null) {
                StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.sx.u.u);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.iz.lk());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.iz.en());
                jSONObject.put("log_extra", this.iz.ap());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.my);
                jSONObject2.put("click_time", this.k);
                jSONObject2.put("web_url", this.iz.jf());
                jSONObject.put("client_info", jSONObject2);
                com.bytedance.sdk.openadsdk.core.sx.u.u(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                String strConcat = "javascript:".concat(String.valueOf(string));
                com.bytedance.sdk.component.mv.fx fxVar = this.bq;
                if (fxVar != null) {
                    s.u(fxVar, strConcat);
                }
            }
        } catch (Throwable th) {
            k.u(th.getMessage());
        }
    }

    public iz b(long j) {
        this.o = j;
        return this;
    }

    public void iz() {
        com.bytedance.sdk.component.mv.fx fxVar = this.bq;
        if (fxVar != null) {
            fxVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.bq = null;
        if (!this.qq.get() && this.nr) {
            b.fx(this.iz, this.x, System.currentTimeMillis() - this.s);
        }
        if (com.huawei.openalliance.ad.constant.x.df.equals(this.x) || "landingpage_endcard".equals(this.x)) {
            com.bytedance.sdk.openadsdk.core.k.fx.pn().u("landingFinish", this.iz, this.rh);
        }
        this.d = null;
        if (this.ja.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.iz.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("web_cache_hit_report");
                if (iz.this.iz != null) {
                    nrVarU.iz(iz.this.iz.xx());
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (oa.u uVar : iz.this.ja.values()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", uVar.fx());
                        jSONObject2.put("hit", uVar.b());
                        jSONObject2.put("miss", uVar.pn());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                nrVarU.nr(jSONObject.toString());
                return nrVarU;
            }
        }, "web_cache_hit_report");
    }

    public Map<String, oa.u> n() {
        return this.ja;
    }

    public void pn() {
        if (this.z) {
            this.z = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.gi);
                jSONObject.put("end", System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, this.iz);
            } catch (JSONException unused) {
            }
            b.u(this.iz, com.huawei.openalliance.ad.constant.x.df, "agg_stay_page", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.iz.1
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
        if (this.u == 2) {
            if (this.jk > 0 || !nr()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f5363a = jCurrentTimeMillis;
                long jMax = jCurrentTimeMillis - Math.max(this.n, this.jk);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.u);
                    jSONObject2.put("max_scroll_percent", this.bg.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused2) {
                }
                u("stay_page", jSONObject2, Math.min(jMax, 600000L));
                com.bytedance.sdk.openadsdk.core.k.fx.pn().u("landingPause", this.iz, this.rh);
            }
        }
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.sx.u.u uVarZa;
        com.bytedance.sdk.component.mv.fx fxVar;
        if (!(this.u == 2 && this.mv) || (uVarZa = dw.nr().za()) == null || (fxVar = this.bq) == null) {
            return;
        }
        uVarZa.u(fxVar.getWebView(), this.iz);
    }

    public void b() {
        this.n = System.currentTimeMillis();
        if (this.s == 0) {
            this.s = System.currentTimeMillis();
        }
        if (com.huawei.openalliance.ad.constant.x.df.equals(this.x) || "landingpage_endcard".equals(this.x)) {
            if (this.h.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.core.k.fx.pn().u("landingStart", this.iz, this.rh);
            } else {
                com.bytedance.sdk.openadsdk.core.k.fx.pn().u("landingContinue", this.iz, this.rh);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.iz.u fx() {
        return this.q;
    }

    public boolean nr() {
        return this.kj;
    }

    public void u(nr nrVar) {
        this.bf = new WeakReference<>(nrVar);
    }

    public iz fx(long j) {
        this.my = j;
        return this;
    }

    public iz nr(boolean z) {
        this.dw = z;
        return this;
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.x = str;
    }

    public iz nr(long j) {
        this.k = j;
        return this;
    }

    public void nr(String str) {
        if (this.dw) {
            if ("load_finish".equals(str) && com.huawei.openalliance.ad.constant.x.df.equals(this.x)) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.iz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        iz.this.a();
                    }
                };
                this.d = runnable;
                com.bytedance.sdk.openadsdk.core.sx.u.u(new u.RunnableC0286u(runnable));
            }
            long j = this.l - this.t;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.fx);
                jSONObject.put("error_msg", this.b);
                jSONObject.put("error_url", this.pn);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j2 = this.k;
                if (j2 > 0) {
                    jSONObject.put("exp_duration", this.l - j2);
                }
                long j3 = this.my;
                if (j3 > 0) {
                    jSONObject.put("web_duration", this.l - j3);
                }
                long j4 = this.o;
                if (j4 >= 0) {
                    jSONObject.put("webview_duration", j4);
                }
            } catch (Exception unused) {
            }
            u(str, jSONObject, Math.min(j, 600000L));
        }
    }

    public String u() {
        return this.x;
    }

    public void u(long j) {
        this.jk = j;
    }

    public void u(boolean z) {
        this.kj = z;
    }

    public void u(com.bytedance.sdk.openadsdk.iz.u uVar) {
        this.q = uVar;
    }

    public void u(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void u(WebView webView, int i) {
        if (this.t == 0 && i > 0) {
            this.u = 1;
            this.t = System.currentTimeMillis();
        } else {
            if (i != 100 || this.mv) {
                return;
            }
            this.mv = true;
            this.l = System.currentTimeMillis();
            if (!com.huawei.openalliance.ad.constant.x.df.equals(this.x) || this.u == 3) {
                return;
            }
            nr("landingpage_load_hundred");
        }
    }

    public void u(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.iz.u uVar = this.q;
        if (uVar != null) {
            uVar.iz();
        }
        if (this.nr) {
            return;
        }
        this.s = System.currentTimeMillis();
        this.nr = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        u("load_start", jSONObject);
    }

    public void u(WebView webView) {
        com.bytedance.sdk.openadsdk.iz.u uVar = this.q;
        if (uVar != null) {
            uVar.x();
        }
        if (this.l <= 0) {
            this.l = System.currentTimeMillis();
        }
        if (webView != null && !this.sx && this.dw) {
            this.sx = true;
            s.u(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.qq.get()) {
            return;
        }
        if (this.u != 3) {
            this.u = 2;
        }
        this.qq.set(true);
        this.n = System.currentTimeMillis();
        if (this.u == 2) {
            nr("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.fx);
            jSONObject.put("error_msg", this.b);
            jSONObject.put("error_url", this.pn);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        u("load_fail", jSONObject);
    }

    public void u(int i, String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.iz.u uVar = this.q;
        if (uVar != null) {
            uVar.n();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.u != 2) {
            this.u = 3;
        }
        this.fx = i;
        this.b = str;
        this.pn = str2;
    }

    private void u(String str, JSONObject jSONObject) {
        u(str, jSONObject, -1L);
    }

    private void u(String str, JSONObject jSONObject, long j) {
        if (!this.dw || this.iz == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        b.fx(this.iz, this.x, str, jSONObject2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final WeakReference<nr> nr;
        private final AtomicInteger u;

        public u(AtomicInteger atomicInteger, WeakReference<nr> weakReference) {
            this.u = atomicInteger;
            this.nr = weakReference;
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i = 100;
                } else if (iIntValue >= 0) {
                    i = iIntValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.u;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<nr> weakReference = this.nr;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.nr.get().u(str);
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }
    }
}
