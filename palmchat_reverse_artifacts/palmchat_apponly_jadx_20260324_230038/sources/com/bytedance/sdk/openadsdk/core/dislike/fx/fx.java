package com.bytedance.sdk.openadsdk.core.dislike.fx;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends iz {
    private List<iz> b;
    private boolean fx;
    private String nr;
    private boolean pn;
    private String u;

    public fx(String str, String str2) {
        super(null);
        this.u = str;
        this.nr = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public List<iz> b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public boolean fx() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public boolean iz() {
        return (TextUtils.isEmpty(this.u) || TextUtils.isEmpty(this.nr)) ? false : true;
    }

    public JSONObject n() {
        try {
            if (!iz()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", u());
            jSONObject.put("name", nr());
            jSONObject.put("is_selected", fx());
            jSONObject.put("new_ui", this.pn);
            if (x()) {
                JSONArray jSONArray = new JSONArray();
                for (iz izVar : b()) {
                    if (izVar instanceof fx) {
                        jSONArray.put(((fx) izVar).n());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("options", jSONArray);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public String nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public String u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public boolean x() {
        List<iz> list = this.b;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void nr(String str) {
        this.nr = str;
    }

    public void u(String str) {
        this.u = str;
    }

    public void nr(boolean z) {
        this.pn = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public void u(boolean z) {
        this.fx = z;
    }

    public fx() {
        super(null);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.iz
    public void u(iz izVar) {
        if (izVar == null) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(izVar);
    }

    public static fx u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            fx fxVar = new fx();
            fxVar.u(jSONObject.optString("id"));
            fxVar.nr(jSONObject.optString("name"));
            fxVar.u(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    fx fxVarU = u(jSONArrayOptJSONArray.optJSONObject(i));
                    if (fxVarU != null && fxVarU.iz()) {
                        fxVar.u(fxVarU);
                    }
                }
            }
            return fxVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
