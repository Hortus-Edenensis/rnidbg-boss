package com.bytedance.sdk.openadsdk.a.u;

import com.bytedance.sdk.component.u.o;
import com.bytedance.sdk.openadsdk.core.ja;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private WeakReference<ja> u;

    public iz(ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(o oVar, ja jaVar) {
        oVar.u("startVideoTransform", (com.bytedance.sdk.component.u.pn<?, ?>) new iz(jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        ja jaVar;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<ja> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null || jSONObject == null || (jaVar = this.u.get()) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo")) == null) {
            return jSONObject2;
        }
        jaVar.u((float) jSONObjectOptJSONObject.optDouble("toX"), (float) jSONObjectOptJSONObject.optDouble("toY"), (float) jSONObjectOptJSONObject.optDouble("pivotX"), (float) jSONObjectOptJSONObject.optDouble("pivotY"), jSONObject.optInt("duration"));
        return jSONObject2;
    }
}
