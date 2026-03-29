package com.bytedance.sdk.component.t.fx;

import com.huawei.openalliance.ad.constant.bq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int fx;
    private String nr;
    private String u;
    private final Map<String, String> b = new HashMap();
    private List<C0230u> pn = new ArrayList();
    private final List<C0230u> iz = new ArrayList();
    private final List<C0230u> x = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.t.fx.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0230u {
        private String nr;
        private String u;

        public C0230u(String str, String str2) {
            this.u = str;
            this.nr = str2;
        }

        public String nr() {
            return this.nr;
        }

        public String u() {
            return this.u;
        }
    }

    public u(JSONObject jSONObject) {
        u(jSONObject);
    }

    public List<C0230u> b() {
        return this.pn;
    }

    public Map<String, String> fx() {
        return this.b;
    }

    public List<C0230u> iz() {
        return this.x;
    }

    public String nr() {
        return this.nr;
    }

    public List<C0230u> pn() {
        return this.iz;
    }

    public String u() {
        return this.u;
    }

    public void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.u = jSONObject.optString("name");
        this.fx = jSONObject.optInt("index");
        this.nr = jSONObject.optString("scheme");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.b.put(next, jSONObjectOptJSONObject.optString(next));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("next");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.pn.add(new C0230u(jSONObjectOptJSONObject2.optString("name"), jSONObjectOptJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("next");
            if (jSONObjectOptJSONObject3 != null) {
                this.pn.add(new C0230u(jSONObjectOptJSONObject3.optString("name"), jSONObjectOptJSONObject3.optString("condition")));
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(bq.f.L);
        if (jSONObjectOptJSONObject4 == null) {
            jSONObjectOptJSONObject4 = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("success");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
            if (jSONObjectOptJSONObject5 != null) {
                this.iz.add(new C0230u(jSONObjectOptJSONObject5.optString("name"), jSONObjectOptJSONObject5.optString("condition")));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("fail");
        if (jSONArrayOptJSONArray3 == null) {
            jSONArrayOptJSONArray3 = new JSONArray();
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
            if (jSONObjectOptJSONObject6 != null) {
                this.x.add(new C0230u(jSONObjectOptJSONObject6.optString("name"), jSONObjectOptJSONObject6.optString("condition")));
            }
        }
    }
}
