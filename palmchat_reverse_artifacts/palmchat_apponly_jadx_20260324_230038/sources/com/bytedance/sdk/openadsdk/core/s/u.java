package com.bytedance.sdk.openadsdk.core.s;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.n.nr.b.u.nr {
    private static final AtomicLong fx = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5366a;
    private JSONObject b;
    private String iz;
    private com.bytedance.sdk.openadsdk.iz.u.u jk;
    private long l;
    private long mv;
    private String n;
    protected final JSONObject nr;
    private String pn;
    private AtomicBoolean s = new AtomicBoolean(false);
    private String t;
    public final String u;
    private String x;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.s.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0284u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f5367a;
        private String b;
        private String fx;
        private String iz;
        private com.bytedance.sdk.openadsdk.iz.u.nr jk;
        private String n;
        private String nr;
        private String pn;
        private com.bytedance.sdk.openadsdk.iz.u.u t;
        private String u;
        private String x;

        public C0284u b(String str) {
            this.pn = str;
            return this;
        }

        public C0284u fx(String str) {
            this.b = str;
            return this;
        }

        public C0284u iz(String str) {
            this.x = str;
            return this;
        }

        public C0284u nr(String str) {
            this.fx = str;
            return this;
        }

        public C0284u pn(String str) {
            this.iz = str;
            return this;
        }

        public C0284u x(String str) {
            this.n = str;
            return this;
        }

        public C0284u u(String str) {
            this.nr = str;
            return this;
        }

        public C0284u u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.f5367a = jSONObject;
            return this;
        }

        public void u(com.bytedance.sdk.openadsdk.iz.u.u uVar) {
            if (com.bytedance.sdk.openadsdk.core.qq.pn.u(this.fx, 1.0d)) {
                if (this.pn != null) {
                    com.bytedance.sdk.openadsdk.core.k.fx.pn().u(this.fx, this.iz, this.n, (JSONObject) null, this.pn);
                }
                this.t = uVar;
                u uVar2 = new u(this);
                try {
                    com.bytedance.sdk.openadsdk.iz.u.nr nrVar = this.jk;
                    if (nrVar != null) {
                        nrVar.u(uVar2.nr);
                    } else {
                        new com.bytedance.sdk.openadsdk.iz.u.fx().u(uVar2.nr);
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.core.qq.nr.u(uVar2, this.fx);
            }
        }
    }

    public u(C0284u c0284u) {
        this.b = new JSONObject();
        this.u = TextUtils.isEmpty(c0284u.u) ? UUID.randomUUID().toString() : c0284u.u;
        this.jk = c0284u.t;
        this.t = c0284u.pn;
        this.pn = c0284u.nr;
        this.iz = c0284u.fx;
        if (TextUtils.isEmpty(c0284u.b)) {
            this.x = "app_union";
        } else {
            this.x = c0284u.b;
        }
        this.n = c0284u.iz;
        this.f5366a = c0284u.x;
        this.b = c0284u.f5367a = c0284u.f5367a != null ? c0284u.f5367a : new JSONObject();
        this.mv = System.currentTimeMillis();
        this.nr = new JSONObject();
        try {
            x();
        } catch (Exception unused) {
        }
    }

    private void n() throws JSONException {
        this.nr.putOpt("tag", this.pn);
        this.nr.putOpt("label", this.iz);
        this.nr.putOpt(com.huawei.openalliance.ad.constant.x.cw, this.x);
        if (!TextUtils.isEmpty(this.n)) {
            try {
                this.nr.putOpt(ActionUtils.PAYMENT_AMOUNT, Long.valueOf(Long.parseLong(this.n)));
            } catch (NumberFormatException unused) {
                this.nr.putOpt(ActionUtils.PAYMENT_AMOUNT, 0L);
            }
        }
        if (!TextUtils.isEmpty(this.f5366a)) {
            this.nr.putOpt("ext_value", this.f5366a);
        }
        if (!TextUtils.isEmpty(this.t)) {
            this.nr.putOpt("log_extra", this.t);
        }
        if (!TextUtils.equals(this.iz, "pangle_live_sdk_monitor")) {
            this.nr.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
        }
        this.nr.putOpt("nt", Integer.valueOf(o.fx(dw.getContext())));
        this.nr.putOpt("tob_ab_sdk_version", com.bytedance.sdk.openadsdk.core.n.o().cj());
        Iterator<String> itKeys = this.b.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.nr.putOpt(next, this.b.opt(next));
        }
    }

    private void x() {
        this.l = fx.incrementAndGet();
    }

    public String b() {
        return this.u;
    }

    public String fx() {
        if (!TextUtils.isEmpty(this.iz)) {
            return this.iz;
        }
        JSONObject jSONObject = this.nr;
        return jSONObject != null ? jSONObject.optString("label") : "";
    }

    public boolean iz() {
        JSONObject jSONObject = this.nr;
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("label");
        if (!TextUtils.isEmpty(strOptString)) {
            return fx.u.contains(strOptString);
        }
        if (TextUtils.isEmpty(this.iz)) {
            return false;
        }
        return fx.u.contains(this.iz);
    }

    @Override // com.bytedance.sdk.component.n.nr.b.u.nr
    public long nr() {
        return this.l;
    }

    public JSONObject pn() {
        if (this.s.get()) {
            return this.nr;
        }
        try {
            n();
            com.bytedance.sdk.openadsdk.iz.u.u uVar = this.jk;
            if (uVar != null) {
                uVar.u(this.nr);
            }
            u(this.nr);
            this.s.set(true);
        } catch (Throwable unused) {
        }
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.n.nr.b.u.nr
    public long u() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.component.n.nr.b.u.nr
    public JSONObject u(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectPn = pn();
        try {
            String strOptString = jSONObjectPn.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject = new JSONObject();
                if (dw.nr().d() && !TextUtils.isEmpty(str)) {
                    jSONObject.put("will_save_labels", str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (dw.nr().d() && TextUtils.isEmpty(jSONObject2.optString("will_save_labels")) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put("will_save_labels", str);
                }
                jSONObject = jSONObject2;
            }
            String strX = com.bytedance.sdk.openadsdk.core.live.nr.u().x();
            if (strX != null) {
                jSONObject.putOpt("live_plugin_version", strX.replaceAll("\\.", ""));
            }
            if (com.bytedance.sdk.openadsdk.core.n.o().x()) {
                jSONObject.putOpt("first_of_two", 1);
            }
            jSONObjectPn.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
        } catch (Exception unused) {
        }
        return jSONObjectPn;
    }

    private void u(JSONObject jSONObject) {
        try {
            if (this.l != 0) {
                String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (jSONObject2.optInt("sdk_event_index") == 0) {
                        jSONObject2.put("sdk_event_index", this.l);
                    }
                    if (jSONObject2.optInt("sdk_event_self_count") == 0) {
                        jSONObject2.put("sdk_event_self_count", com.bytedance.sdk.component.n.nr.fx.u.u(this.iz));
                    }
                    jSONObject2.put("create_ts", System.currentTimeMillis());
                    jSONObject2.put("csj_type", com.bytedance.sdk.openadsdk.core.n.o().xw() ? 1 : 0);
                    jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.b.u.b());
                    jSONObject2.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.qq.nr.u);
                    if (!TextUtils.isEmpty(jp.f5411a)) {
                        jSONObject2.put("wrong_stats_url", jp.f5411a);
                    }
                    if (!TextUtils.isEmpty(jp.jk)) {
                        jSONObject2.put("wrong_applog_url", jp.jk);
                    }
                    com.bytedance.sdk.openadsdk.core.xw.u.u().u(jSONObject2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_event_index", this.l);
                jSONObject3.put("sdk_event_self_count", com.bytedance.sdk.component.n.nr.fx.u.u(this.iz));
                jSONObject3.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.qq.nr.u);
                jSONObject3.put("csj_type", com.bytedance.sdk.openadsdk.core.n.o().xw() ? 1 : 0);
                jSONObject3.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.b.u.b());
                jSONObject3.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(jp.f5411a)) {
                    jSONObject3.put("wrong_stats_url", jp.f5411a);
                }
                if (!TextUtils.isEmpty(jp.jk)) {
                    jSONObject3.put("wrong_applog_url", jp.jk);
                }
                com.bytedance.sdk.openadsdk.core.xw.u.u().u(jSONObject3);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
            }
        } catch (Exception unused) {
        }
    }
}
