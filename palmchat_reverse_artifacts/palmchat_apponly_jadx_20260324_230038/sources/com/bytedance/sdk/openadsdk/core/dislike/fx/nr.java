package com.bytedance.sdk.openadsdk.core.dislike.fx;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private final boolean b;
    private String fx;
    private final String iz;
    private boolean n;
    private final List<iz> nr = new ArrayList();
    private final String pn;
    private final int u;
    private String x;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public nr(JSONObject jSONObject, fx fxVar) {
        boolean z = false;
        this.u = jSONObject.optInt("dislike_control", 0);
        this.b = jSONObject.optBoolean("close_on_dislike", false);
        String strU = fxVar != null ? fxVar.u() : "";
        this.n = fxVar != null ? fxVar.pn() : false;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                fx fxVarU = fx.u(jSONArrayOptJSONArray.optJSONObject(i));
                fxVarU.nr(this.n);
                if (this.n) {
                    String strU2 = fxVarU.u();
                    if (!"8:1".equals(strU2) && !"99:1".equals(strU2)) {
                        if (fxVarU.iz()) {
                            this.nr.add(fxVarU);
                            if (!zEquals) {
                                zEquals = TextUtils.equals(fxVarU.u(), strU);
                            }
                        }
                    }
                }
            }
            z = zEquals;
        }
        if (fxVar != null && !z) {
            this.nr.add(fxVar);
        }
        this.pn = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.iz = jSONObject.optString("ext");
    }

    public boolean a() {
        return this.b;
    }

    public String b() {
        return this.pn;
    }

    public String fx() {
        return this.fx;
    }

    public boolean iz() {
        return this.u == 1;
    }

    public String n() {
        return this.x;
    }

    public boolean nr() {
        return this.n;
    }

    public String pn() {
        return this.iz;
    }

    public void u(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.u);
        jSONObject.put("filter_words", x());
        jSONObject.put("close_on_dislike", a());
    }

    public JSONArray x() {
        JSONObject jSONObjectN;
        JSONArray jSONArray = new JSONArray();
        List<iz> list = this.nr;
        if (list != null) {
            for (iz izVar : list) {
                if ((izVar instanceof fx) && (jSONObjectN = ((fx) izVar).n()) != null) {
                    jSONArray.put(jSONObjectN);
                }
            }
        }
        return jSONArray;
    }

    public void nr(String str) {
        this.x = str;
    }

    public List<iz> u() {
        return this.nr;
    }

    public void u(String str) {
        this.fx = str;
    }
}
