package com.bytedance.sdk.openadsdk.core.z;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final Context b = dw.getContext();
    private nr fx;
    private JSONObject nr;
    private bc pn;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.nr u;

    public u(bc bcVar) {
        this.pn = bcVar;
    }

    public void fx() {
        com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar;
        if (z.u() && (nrVar = this.u) != null) {
            nrVar.nr();
        }
    }

    public Context getContext() {
        return this.b;
    }

    public JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        if (!z.u()) {
            return jSONObject;
        }
        try {
            com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar = this.u;
            if (nrVar != null) {
                JSONObject jSONObjectU = nrVar.u();
                this.nr = jSONObjectU;
                return jSONObjectU;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        this.u = nrVar;
    }

    public void u(nr nrVar) {
        this.fx = nrVar;
    }

    public bc u() {
        return this.pn;
    }

    public void u(bc bcVar) {
        if (this.u != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(z.b(bcVar)));
            } catch (JSONException unused) {
            }
            this.u.u(jSONObject);
        }
    }

    public void u(boolean z, JSONObject jSONObject, int i) {
        com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar;
        if (z.u() && (nrVar = this.u) != null) {
            if (z) {
                nrVar.nr(jSONObject);
                return;
            }
            HashMap map = new HashMap();
            map.put("estimatedArea", this.nr);
            map.put("realArea", this.fx.getMaxRectJson());
            map.put("exceedAreaRate", Double.valueOf(this.fx.getExceedAreaRate()));
            map.put("widgetArea", this.fx.getActualRectJson());
            a.u(this.pn, false, i, 100, (Map<String, Object>) map);
            this.u.fx(jSONObject);
        }
    }

    public static void u(bc bcVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            e.getMessage();
        }
        a.u(bcVar, false, i, 0, jSONObject);
    }
}
