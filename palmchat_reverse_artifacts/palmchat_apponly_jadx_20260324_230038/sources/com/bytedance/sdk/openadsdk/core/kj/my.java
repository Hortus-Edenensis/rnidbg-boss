package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my {
    private static volatile String u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5315a;
    private int b;
    private String fx;
    private int iz;
    private String n;
    private String nr;
    private JSONObject pn;
    private String x;

    public my() {
        this.x = "";
        this.n = "";
    }

    private String b(String str) {
        if (this.pn != null && !TextUtils.isEmpty(str) && this.nr != null) {
            String strOptString = this.pn.optString(str);
            if (!TextUtils.isEmpty(strOptString)) {
                String str2 = this.nr;
                String str3 = Constants.STRING_VALUE_UNSET;
                if (str2.contains(Constants.STRING_VALUE_UNSET)) {
                    str3 = ContainerUtils.FIELD_DELIMITER;
                }
                return this.nr + str3 + strOptString;
            }
        }
        return this.nr;
    }

    public static void u(String str) {
        u = str;
    }

    public int fx() {
        return this.iz;
    }

    public String iz() {
        return this.x;
    }

    public String nr() {
        return b(u);
    }

    public int pn() {
        return this.b;
    }

    public String x() {
        return this.n;
    }

    public void fx(String str) {
        this.fx = str;
    }

    public void nr(String str) {
        this.nr = str;
    }

    public void u(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(WfConstant.EXTRA_KEY_DEEPLINK_URL, nr());
            jSONObject2.put("fallback_url", b());
            jSONObject2.put("fallback_type", pn());
            jSONObject2.put("addon_params", this.pn);
            jSONObject2.put("fallback_landing", this.iz);
            jSONObject2.put("fallback_landing_ugen_url", this.x);
            jSONObject2.put("fallback_landing_ugen_md5", this.n);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public my(JSONObject jSONObject) {
        this.x = "";
        this.n = "";
        if (jSONObject == null) {
            return;
        }
        nr(jSONObject.optString(WfConstant.EXTRA_KEY_DEEPLINK_URL));
        fx(jSONObject.optString("fallback_url"));
        u(jSONObject.optInt("fallback_type"));
        this.pn = jSONObject.optJSONObject("addon_params");
        this.iz = jSONObject.optInt("fallback_landing");
        this.x = jSONObject.optString("fallback_landing_ugen_url");
        this.n = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public String b() {
        return this.fx;
    }

    public boolean u() {
        return this.f5315a;
    }

    public void u(boolean z) {
        this.f5315a = z;
    }

    public void u(int i) {
        this.b = i;
    }

    public void u(my myVar) {
        if (myVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(myVar.nr())) {
            nr(myVar.nr());
        }
        if (!TextUtils.isEmpty(myVar.b())) {
            fx(myVar.b());
        }
        if (myVar.pn() != 0) {
            u(myVar.pn());
        }
    }
}
