package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import com.huawei.openalliance.ad.constant.be;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5224a;
    int b;
    int fx;
    boolean iz;
    int jk;
    boolean n;
    int nr;
    boolean pn;
    private boolean t;
    String u;
    JSONArray x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5225a;
        boolean b;
        int fx;
        boolean iz;
        com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u jk;
        int n;
        int nr;
        JSONArray pn;
        String u;
        int x;

        public u b(int i) {
            this.n = i;
            return this;
        }

        public u fx(int i) {
            this.x = i;
            return this;
        }

        public u nr(int i) {
            this.fx = i;
            return this;
        }

        public fx u() {
            return new fx(this.u, this.nr, this.fx, this.n, this.b, this.pn, this.iz, this.jk, this.x, this.f5225a);
        }

        public u fx(boolean z) {
            this.f5225a = z;
            return this;
        }

        public u nr(boolean z) {
            this.iz = z;
            return this;
        }

        public u u(String str) {
            this.u = str;
            return this;
        }

        public u u(int i) {
            this.nr = i;
            return this;
        }

        public u u(boolean z) {
            this.b = z;
            return this;
        }

        public u u(Set<Integer> set) {
            this.pn = new JSONArray((Collection) set);
            return this;
        }

        public u u(com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u uVar) {
            this.jk = uVar;
            return this;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.u);
            jSONObject.put("consume_time", this.nr);
            jSONObject.put("reduce_time", this.fx);
            jSONObject.put("is_video_completed", this.pn);
            jSONObject.put("is_user_interacted", this.iz);
            jSONObject.put("reward_verify_array", this.x);
            jSONObject.put(be.j, this.n);
            jSONObject.put("play_again_string", this.f5224a);
            jSONObject.put("carousel_type", this.jk);
            jSONObject.put("eternal_global_time", this.b);
            jSONObject.put("first_ad_is_video", this.t);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public boolean b() {
        return this.pn;
    }

    public int fx() {
        return this.fx;
    }

    public String iz() {
        return this.f5224a;
    }

    public int jk() {
        return this.b;
    }

    public Map<Integer, Boolean> n() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.x.length(); i++) {
            try {
                map.put((Integer) this.x.get(i), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return map;
    }

    public int nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.n;
    }

    public boolean t() {
        return this.t;
    }

    public String u() {
        return this.u;
    }

    public int x() {
        return this.jk;
    }

    private fx(String str, int i, int i2, int i3, boolean z, JSONArray jSONArray, boolean z2, com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u uVar, int i4, boolean z3) {
        this.u = str;
        this.nr = i;
        this.fx = i2;
        this.b = i3;
        this.pn = z;
        this.x = jSONArray;
        this.n = z2;
        this.f5224a = uVar.n();
        this.jk = i4;
        this.t = z3;
    }

    public fx(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.u = jSONObject.optString("meta_md5");
            this.nr = jSONObject.optInt("consume_time");
            this.fx = jSONObject.optInt("reduce_time");
            this.pn = jSONObject.optBoolean("is_video_completed");
            this.x = jSONObject.optJSONArray("reward_verify_array");
            this.n = jSONObject.optBoolean(be.j);
            this.f5224a = jSONObject.optString("play_again_string");
            this.jk = jSONObject.optInt("carousel_type");
            this.b = jSONObject.optInt("eternal_global_time");
            this.t = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }
}
