package com.bytedance.sdk.openadsdk.core.ugeno.x;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.u.fx.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.component.adexpress.u.fx.u {
    public nr() {
    }

    public static nr nr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        nr nrVar = new nr();
        nrVar.u(jSONObject.optString("name"));
        nrVar.nr(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    u.C0206u c0206u = new u.C0206u();
                    c0206u.u(jSONObjectOptJSONObject.optString("url"));
                    c0206u.nr(jSONObjectOptJSONObject.optString("md5"));
                    c0206u.u(jSONObjectOptJSONObject.optInt("level"));
                    arrayList.add(c0206u);
                }
            }
        }
        nrVar.u(arrayList);
        if (nrVar.iz()) {
            return nrVar;
        }
        return null;
    }

    public static nr pn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return nr(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.u.fx.u
    public boolean iz() {
        return (TextUtils.isEmpty(fx()) || TextUtils.isEmpty(nr())) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.u.fx.u
    public String n() {
        if (!iz()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", nr());
            jSONObject.putOpt("version", fx());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (u.C0206u c0206u : getResources()) {
                    if (c0206u != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", c0206u.u());
                        jSONObject2.putOpt("md5", c0206u.nr());
                        jSONObject2.putOpt("level", Integer.valueOf(c0206u.fx()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public nr(com.bytedance.sdk.component.adexpress.u.fx.u uVar) {
        if (uVar != null) {
            u(uVar.nr());
            nr(uVar.fx());
            u(uVar.getResources());
        }
    }
}
