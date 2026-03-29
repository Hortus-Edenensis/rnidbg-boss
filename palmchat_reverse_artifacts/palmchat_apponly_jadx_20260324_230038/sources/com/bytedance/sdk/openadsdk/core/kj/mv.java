package com.bytedance.sdk.openadsdk.core.kj;

import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5314a;
    private long b;
    private String fx;
    private int iz;
    private long jk;
    private String k;
    private int l;
    private long mv;
    private String my;
    private long n;
    private String nr;
    private String o;
    private boolean pn;
    private String s;
    private String sx;
    private long t;
    private long u;
    private int x;

    public static mv u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        mv mvVar = new mv();
        mvVar.u = jSONObject.optLong("user_id");
        mvVar.nr = jSONObject.optString("coupon_meta_id");
        mvVar.fx = jSONObject.optString("unique_id");
        mvVar.b = jSONObject.optLong("device_id");
        mvVar.pn = jSONObject.optBoolean("has_coupon");
        mvVar.iz = jSONObject.optInt("coupon_scene");
        mvVar.x = jSONObject.optInt("type");
        mvVar.n = jSONObject.optLong("threshold");
        mvVar.f5314a = jSONObject.optString("scene_key");
        mvVar.jk = jSONObject.optLong(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        mvVar.t = jSONObject.optLong("amount");
        mvVar.l = jSONObject.optInt("action");
        mvVar.mv = jSONObject.optLong("style");
        mvVar.s = jSONObject.optString(com.umeng.analytics.pro.f.p);
        mvVar.k = jSONObject.optString("expire_time");
        mvVar.my = jSONObject.optString("button_text");
        mvVar.o = jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
        mvVar.sx = jSONObject.optString("toast");
        return mvVar;
    }

    public String b() {
        return this.sx;
    }

    public int fx() {
        return this.iz;
    }

    public int getType() {
        return this.x;
    }

    public JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.u);
            jSONObject.put("coupon_meta_id", this.nr);
            jSONObject.put("unique_id", this.fx);
            jSONObject.put("device_id", this.b);
            jSONObject.put("type", this.x);
            jSONObject.put("scene_key", this.f5314a);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.jk);
            jSONObject.put(ActionUtils.PAYMENT_AMOUNT, this.t);
            jSONObject.put("threshold", this.n);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.o);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.u);
            jSONObject.put("coupon_meta_id", this.nr);
            jSONObject.put("unique_id", this.fx);
            jSONObject.put("device_id", this.b);
            jSONObject.put("has_coupon", this.pn);
            jSONObject.put("coupon_scene", this.iz);
            jSONObject.put("type", this.x);
            jSONObject.put("threshold", this.n);
            jSONObject.put("scene_key", this.f5314a);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.jk);
            jSONObject.put("amount", this.t);
            jSONObject.put("action", this.l);
            jSONObject.put("style", this.mv);
            jSONObject.put(com.umeng.analytics.pro.f.p, this.s);
            jSONObject.put("expire_time", this.k);
            jSONObject.put("button_text", this.my);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.o);
            jSONObject.put("toast", this.sx);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean u(boolean z) {
        int i;
        boolean z2 = this.pn && this.t > 0;
        if (z) {
            if (z2 && ((i = this.iz) == 0 || i == 5)) {
                return true;
            }
        } else if (z2 && this.iz == 5) {
            return true;
        }
        return false;
    }
}
