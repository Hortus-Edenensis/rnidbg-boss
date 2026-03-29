package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5297a;
    private List<u> b;
    private String fx;
    private String iz;
    private String jk;
    private String l;
    private JSONObject mv;
    private float n;
    private String nr;
    private String pn;
    private JSONArray t;
    private String u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final String nr;
        private final String u;

        public u(JSONObject jSONObject) {
            this.u = jSONObject.optString("permission_name");
            this.nr = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject u() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.nr);
            } catch (JSONException unused) {
            }
            try {
                jSONObject.put("permission_name", this.u);
            } catch (JSONException unused2) {
            }
            return jSONObject;
        }
    }

    public b(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("package");
            this.u = jSONObjectOptJSONObject.optString("app_name");
            this.nr = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.fx = jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME);
            this.b = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.b.add(new u(jSONArrayOptJSONArray.optJSONObject(i)));
                }
            }
            this.pn = jSONObjectOptJSONObject.optString("policy_url");
            String strOptString = jSONObjectOptJSONObject.optString("package");
            this.iz = strOptString;
            if (TextUtils.isEmpty(strOptString)) {
                this.iz = jSONObjectOptJSONObject.optString("package_name");
            }
            this.x = jSONObjectOptJSONObject.optString("icon_url");
            this.f5297a = jSONObjectOptJSONObject.optString("desc_url");
            this.jk = jSONObjectOptJSONObject.optString("reg_number");
            this.l = jSONObjectOptJSONObject.optString("reg_url");
            this.mv = jSONObjectOptJSONObject.optJSONObject("reg_info");
        } catch (Throwable unused) {
        }
    }

    public String b() {
        return this.f5297a;
    }

    public String fx() {
        return this.x;
    }

    public String iz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", this.u);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("app_version", this.nr);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put(WfConstant.EXTRA_KEY_DEVELOPER_NAME, this.fx);
        } catch (JSONException unused3) {
        }
        try {
            jSONObject.put("package_name", this.iz);
        } catch (JSONException unused4) {
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<u> it = this.b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().u());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException unused5) {
        }
        try {
            jSONObject.put("privacy_policy_url", this.pn);
        } catch (JSONException unused6) {
        }
        try {
            jSONObject.put("score", this.n);
        } catch (JSONException unused7) {
        }
        try {
            jSONObject.put("creative_tags", this.t);
        } catch (JSONException unused8) {
        }
        try {
            jSONObject.put("desc_url", this.f5297a);
        } catch (JSONException unused9) {
        }
        try {
            jSONObject.put("reg_number", this.jk);
        } catch (JSONException unused10) {
        }
        try {
            jSONObject.put("icon_url", this.x);
        } catch (JSONException unused11) {
        }
        try {
            jSONObject.put("reg_url", this.l);
        } catch (JSONException unused12) {
        }
        try {
            jSONObject.put("reg_info", this.mv);
        } catch (JSONException unused13) {
        }
        return jSONObject.toString();
    }

    public String nr() {
        return this.fx;
    }

    public boolean pn() {
        List<u> list;
        return (TextUtils.isEmpty(this.u) || TextUtils.isEmpty(this.nr) || TextUtils.isEmpty(nr()) || (list = this.b) == null || list.size() == 0 || TextUtils.isEmpty(this.pn) || TextUtils.isEmpty(this.f5297a)) ? false : true;
    }

    public String u() {
        return this.u;
    }

    public void u(float f) {
        this.n = f;
    }

    public void u(JSONArray jSONArray) {
        this.t = jSONArray;
    }
}
