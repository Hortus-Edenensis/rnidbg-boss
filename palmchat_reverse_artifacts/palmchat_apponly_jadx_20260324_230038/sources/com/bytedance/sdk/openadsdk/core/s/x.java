package com.bytedance.sdk.openadsdk.core.s;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private final bc nr;
    private volatile boolean u = false;
    private String fx = com.huawei.openalliance.ad.constant.x.df;
    private long b = 0;
    private long pn = 0;
    private long iz = 0;
    private long x = 0;
    private long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5368a = 0;
    private AtomicInteger jk = new AtomicInteger(0);
    private boolean t = false;
    private AtomicBoolean l = new AtomicBoolean(false);

    public x(bc bcVar) {
        this.nr = bcVar;
    }

    public void b() {
        if (this.l.get() || !this.u) {
            return;
        }
        b.u(this.nr, this.fx, "load", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.s.x.1
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (x.this.nr != null && com.bytedance.sdk.openadsdk.core.ugeno.jk.n(x.this.nr)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(x.this.nr.c()));
                }
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject2, x.this.nr);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put("duration", Math.min(System.currentTimeMillis() - x.this.f5368a, 600000L));
            }
        });
    }

    public void fx() {
        this.iz = System.currentTimeMillis();
        this.b = System.currentTimeMillis();
    }

    public void nr() {
        if (this.u) {
            return;
        }
        this.x = System.currentTimeMillis();
        this.f5368a = System.currentTimeMillis();
        this.u = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            bc bcVar = this.nr;
            if (bcVar != null && com.bytedance.sdk.openadsdk.core.ugeno.jk.n(bcVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.nr.c()));
            }
        } catch (Exception unused) {
        }
        u("load_start", jSONObject);
    }

    public x u(boolean z) {
        this.t = z;
        return this;
    }

    public void u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            bc bcVar = this.nr;
            if (bcVar != null && com.bytedance.sdk.openadsdk.core.ugeno.jk.n(bcVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.nr.c()));
            }
        } catch (JSONException unused) {
        }
        u("open_url_h5", jSONObject);
    }

    public void u(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            bc bcVar = this.nr;
            if (bcVar != null && com.bytedance.sdk.openadsdk.core.ugeno.jk.n(bcVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.nr.c()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("msg", str);
        } catch (JSONException unused) {
        }
        u("load_fail", jSONObject);
    }

    public void u(long j) {
        if (this.l.get()) {
            return;
        }
        this.l.set(true);
        this.n = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.n - this.x;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j);
            bc bcVar = this.nr;
            if (bcVar != null && com.bytedance.sdk.openadsdk.core.ugeno.jk.n(bcVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.nr.c()));
            }
        } catch (JSONException unused) {
        }
        u("load_finish", jSONObject, Math.min(j2, 600000L));
    }

    public void u(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.pn = jCurrentTimeMillis;
        long jMax = jCurrentTimeMillis - Math.max(this.b, this.iz);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.jk.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt("render_type", "ugen");
            bc bcVar = this.nr;
            if (bcVar != null && com.bytedance.sdk.openadsdk.core.ugeno.jk.n(bcVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.nr.c()));
            }
        } catch (JSONException unused) {
        }
        u("stay_page", jSONObject, Math.min(jMax, 600000L));
    }

    private void u(String str, JSONObject jSONObject) {
        u(str, jSONObject, -1L);
    }

    private void u(String str, JSONObject jSONObject, long j) {
        if (!this.t || this.nr == null || TextUtils.isEmpty(str)) {
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
        b.fx(this.nr, this.fx, str, jSONObject2);
    }
}
