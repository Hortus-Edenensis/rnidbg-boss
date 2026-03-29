package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private List<JSONObject> nr;
    private com.bytedance.sdk.openadsdk.core.kj.bc u;

    public t(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, List<JSONObject> list) {
        this.u = bcVar;
        this.nr = list;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, List<JSONObject> list) {
        oVar.u("getAdsData", (com.bytedance.sdk.component.u.pn<?, ?>) new t(bcVar, list));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iOptInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (iOptInt < 0) {
            iOptInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.u.et()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.nr;
        if (list != null && list.size() > 0) {
            if (iOptInt > this.nr.size()) {
                iOptInt = this.nr.size();
            }
            int iMin = Math.min(iOptInt, 3);
            for (int i = 0; i < iMin; i++) {
                jSONArray.put(i, this.nr.get(i));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("data", jSONObject2);
        return jSONObject5;
    }
}
