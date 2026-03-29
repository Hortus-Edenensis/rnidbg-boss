package com.bytedance.sdk.openadsdk.core.s;

import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.tm;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qiniu.android.collect.ReportItem;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk implements com.bytedance.sdk.openadsdk.iz.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5364a;
    private Boolean b;
    private Boolean fx;
    private JSONObject iz;
    private int jk;
    private JSONObject l;
    private volatile int mv;
    private JSONArray n;
    private bc nr;
    private Boolean pn;
    private volatile boolean s;
    private AtomicLong t;
    private String u;
    private JSONArray x;

    public jk(String str, bc bcVar, JSONObject jSONObject) {
        this.u = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.fx = bool;
        this.b = bool;
        this.pn = bool;
        this.f5364a = false;
        this.t = new AtomicLong();
        this.mv = 0;
        this.s = false;
        this.u = str;
        this.nr = bcVar;
        this.iz = jSONObject;
        this.x = new JSONArray();
        this.n = new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (this.pn.booleanValue()) {
            return true;
        }
        return this.b.booleanValue() && this.fx.booleanValue();
    }

    public void jk() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.14
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void k() {
        this.fx = Boolean.TRUE;
    }

    public void l() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.16
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "type", "native_enterForeground");
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.x, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.nr
    public void mv() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void my() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.25
                @Override // java.lang.Runnable
                public void run() {
                    if (jk.this.o() && !jk.this.f5364a) {
                        if (jk.this.x != null && jk.this.x.length() != 0) {
                            try {
                                jk.this.iz.put("native_switchBackgroundAndForeground", jk.this.x);
                            } catch (Exception unused) {
                            }
                        }
                        if (jk.this.n != null && jk.this.n.length() != 0) {
                            try {
                                jk.this.iz.put("intercept_source", jk.this.n);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("webview_time_track", jk.this.iz);
                        com.bytedance.sdk.openadsdk.core.n.o().tk();
                        b.x(jk.this.nr, jk.this.u, "webview_time_track", map);
                        jk.this.f5364a = true;
                    }
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.fx
    public void s() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.22
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void t() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.15
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "type", "native_enterBackground");
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.x, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void a() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.13
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void b(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.2
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.nr
    public void fx() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.27
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void iz() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.9
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void n() {
        nr((JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.fx
    public void nr() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.12
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "render_success", jSONObject);
                    if (jk.this.u.equals(WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || jk.this.u.equals("cache_splash_ad") || jk.this.iz.optInt("webview_source", -1) == 2) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", "h5_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void pn(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                    if (jk.this.u.equals(WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || jk.this.u.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void x() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void b() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.7
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void fx(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.30
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                    if (jk.this.u.equals(WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || jk.this.u.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void iz(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "jsb", str);
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void nr(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.29
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.nr
    public void pn() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.8
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "native_render_end", jSONObject);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    jk.this.u(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                    jk jkVar2 = jk.this;
                    jkVar2.u(jkVar2.iz, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void x(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "jsb", str);
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void b(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (jk.this.iz == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jk jkVar = jk.this;
                        jkVar.u(jkVar.iz, next, jSONObject.opt(next));
                    }
                    jk.this.b = Boolean.TRUE;
                    jk.this.my();
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void fx(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.4
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "code", Integer.valueOf(i));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                    if (jk.this.u.equals(WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || jk.this.u.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void nr(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.31
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "code", Integer.valueOf(i));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                    if (jk.this.u.equals(WifiNestConst.NestTypeConst.NEST_SPLASH_AD) || jk.this.u.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.rh.u.u().u("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.fx
    public void u() {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.1
                @Override // java.lang.Runnable
                public void run() {
                    jk.this.t.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    jk jkVar = jk.this;
                    jkVar.u(jSONObject, "ts", Long.valueOf(jkVar.t.get()));
                    jk jkVar2 = jk.this;
                    jkVar2.u(jSONObject, "render_sequence", Integer.valueOf(tk.nr(jkVar2.nr)));
                    jk jkVar3 = jk.this;
                    jkVar3.u(jSONObject, "render_timeout", Integer.valueOf(jkVar3.jk));
                    jk.this.u(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.pn.pn.u().pn()));
                    jk.this.u(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.pn.pn.u().fx()));
                    tm tmVarX = tk.x(jk.this.nr);
                    if (tmVarX != null) {
                        jk.this.u(jSONObject, "rule_id", tmVarX.n());
                    } else {
                        jk.this.u(jSONObject, "rule_id", "0");
                    }
                    jk jkVar4 = jk.this;
                    jkVar4.u(jkVar4.iz, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.fx
    public void fx(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.23
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    jk.this.u(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void nr(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    jk.this.u(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.fx
    public void u(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.26
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "code", Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        jk.this.u(jSONObject, "reason", str2);
                    }
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void nr(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "start_ts", Long.valueOf(j));
                    jk.this.u(jSONObject, "end_ts", Long.valueOf(j2));
                    jk.this.u(jSONObject, "intercept_type", Integer.valueOf(i));
                    jk.this.u(jSONObject, "type", "intercept_js");
                    jk.this.u(jSONObject, "url", str);
                    jk.this.u(jSONObject, "duration", Long.valueOf(j2 - j));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.n, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void u(final String str) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.28
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void nr(boolean z) {
        try {
            if (!this.s && this.nr != null) {
                this.s = true;
                if (tk.nr(this.nr) == 0 && this.mv != 0) {
                    if (this.l == null) {
                        this.l = new JSONObject();
                    }
                    this.l.put("render_sequence", tk.nr(this.nr));
                    this.l.put("render_control", tk.u(this.nr));
                    this.l.put("fetch_tpl_time_out", dw.nr().u(this.u, tk.nr(this.nr)));
                    this.l.put(ReportItem.RequestKeyRequestId, this.nr.xx());
                    this.l.put(MediationConstant.EXTRA_ADID, this.nr.lk());
                    this.l.put("ad_slot_type", jp.jk(this.nr));
                    if (z) {
                        this.l.put("webview_time_cost", System.currentTimeMillis() - this.t.get());
                        this.l.put("webview_result", 2);
                    }
                    s.u().u(this.l);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.u
    public void u(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.5
                @Override // java.lang.Runnable
                public void run() {
                    jk.this.u(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void u(final int i) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.6
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    jk.this.u(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (jk.this.nr != null) {
                        if (tk.n(jk.this.nr)) {
                            jk.this.u(jSONObject, "engine_version", "v3");
                        } else {
                            jk.this.u(jSONObject, "engine_version", "v1");
                        }
                    }
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.iz, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public jk() {
        this.u = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.fx = bool;
        this.b = bool;
        this.pn = bool;
        this.f5364a = false;
        this.t = new AtomicLong();
        this.mv = 0;
        this.s = false;
    }

    @Override // com.bytedance.sdk.openadsdk.iz.b.b
    public void u(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.s.jk.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jk.this.u(jSONObject, "start_ts", Long.valueOf(j));
                    jk.this.u(jSONObject, "end_ts", Long.valueOf(j2));
                    jk.this.u(jSONObject, "intercept_type", Integer.valueOf(i));
                    jk.this.u(jSONObject, "type", "intercept_html");
                    jk.this.u(jSONObject, "url", str);
                    jk.this.u(jSONObject, "duration", Long.valueOf(j2 - j));
                    jk jkVar = jk.this;
                    jkVar.u(jkVar.n, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void u(boolean z) {
        this.pn = Boolean.valueOf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void u(boolean z, int i) {
        try {
            if (this.l == null) {
                this.l = new JSONObject();
            }
            this.l.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
            this.l.put("webview_time_cost", System.currentTimeMillis() - this.t.get());
            this.l.put("webview_result", z ? 0 : 1);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.iz.u
    public void u(int i, int i2, String str) {
        try {
            this.mv = i;
            if (this.l == null) {
                this.l = new JSONObject();
            }
            this.l.put("render_type", i);
            this.l.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (Exception unused) {
        }
    }

    public void nr(int i) {
        this.jk = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e) {
                e.getMessage();
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void u(JSONObject jSONObject, String str, Object obj) {
        u(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
