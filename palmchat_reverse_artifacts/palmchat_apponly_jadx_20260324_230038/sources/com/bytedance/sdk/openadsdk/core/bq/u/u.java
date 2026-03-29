package com.bytedance.sdk.openadsdk.core.bq.u;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private Context nr;
    private String u;

    public u(String str, Context context) {
        this.u = str;
        this.nr = context;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, Context context) {
        oVar.u("closeView", (com.bytedance.sdk.component.u.pn<?, ?>) new u("closeView", context));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.u;
        str.hashCode();
        if (str.equals("closeView")) {
            Context context = this.nr;
            if (context != null) {
                ((Activity) context).finish();
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        }
        return jSONObject2;
    }
}
