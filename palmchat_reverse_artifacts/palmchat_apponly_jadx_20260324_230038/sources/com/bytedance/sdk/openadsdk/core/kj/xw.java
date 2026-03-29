package com.bytedance.sdk.openadsdk.core.kj;

import com.huawei.openalliance.ad.constant.be;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5324a;
    private int b;
    private int fx;
    private long iz;
    private int jk = 0;
    private long n;
    private int nr;
    private int pn;
    bc u;
    private long x;

    public xw(bc bcVar) {
        this.u = bcVar;
    }

    public void b(int i) {
        this.f5324a = i;
        this.n = System.currentTimeMillis();
    }

    public void fx(int i) {
        this.b = i;
    }

    public void nr(int i) {
        this.fx = i;
        if (i == 2) {
            this.pn++;
        }
    }

    public void u(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ca_send_ts", this.u.ln());
            jSONObject.put("ca_bid_rst", this.b);
            jSONObject.put("ca_reuse_cnt", this.pn);
            jSONObject.put("ca_obj_ts", this.iz);
            jSONObject.put("ca_fnl_st", this.f5324a);
            jSONObject.put("ca_rpt_show_cnt", this.jk);
            jSONObject.put("ca_libra_group", n.u(com.bytedance.sdk.openadsdk.core.y.jp.jk(this.u)).mv());
            jSONObject.put("ca_ad_index", this.u.bv());
            if (z) {
                String str = this.u.xx() + this.u.lk();
                Integer numRemove = com.bytedance.sdk.openadsdk.core.pn.u.nr().remove(str);
                int iValueOf = numRemove == null ? 1 : Integer.valueOf(numRemove.intValue() + 1);
                com.bytedance.sdk.openadsdk.core.pn.u.nr().put(str, iValueOf);
                jSONObject.put("meta_show_count", iValueOf);
                String str2 = com.bytedance.sdk.openadsdk.core.y.jp.l(this.u) + this.u.lk();
                Integer numRemove2 = com.bytedance.sdk.openadsdk.core.pn.u.fx().remove(str2);
                int iValueOf2 = numRemove2 == null ? 1 : Integer.valueOf(numRemove2.intValue() + 1);
                com.bytedance.sdk.openadsdk.core.pn.u.fx().put(str2, iValueOf2);
                jSONObject.put("meta_origin_show_count", iValueOf2);
                JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.pn.fx.u(this.u);
                if (jSONObjectU != null) {
                    jSONObject.put("ca_interval_info", jSONObjectU);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void fx() {
        this.x = System.currentTimeMillis();
        this.jk++;
        b(1);
    }

    public void nr() {
        this.iz = System.currentTimeMillis();
    }

    public xw(bc bcVar, JSONObject jSONObject) {
        this.u = bcVar;
        if (jSONObject != null) {
            this.nr = jSONObject.optInt("req_type", 0);
            this.fx = jSONObject.optInt("load_type", 0);
            this.b = jSONObject.optInt(be.aW, 0);
            this.pn = jSONObject.optInt("reuse_count", 0);
            this.iz = jSONObject.optLong("object_create_time", 0L);
            this.x = jSONObject.optLong("show_time", 0L);
            this.n = jSONObject.optLong("final_ts", 0L);
            this.f5324a = jSONObject.optInt("final_status", 0);
        }
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_type", this.nr);
            jSONObject.put("load_type", this.fx);
            jSONObject.put(be.aW, this.b);
            jSONObject.put("reuse_count", this.pn);
            jSONObject.put("object_create_time", this.iz);
            jSONObject.put("show_time", this.x);
            jSONObject.put("final_ts", this.n);
            jSONObject.put("final_status", this.f5324a);
            jSONObject.put("show_count", this.jk);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void u(int i) {
        this.nr = i;
    }
}
