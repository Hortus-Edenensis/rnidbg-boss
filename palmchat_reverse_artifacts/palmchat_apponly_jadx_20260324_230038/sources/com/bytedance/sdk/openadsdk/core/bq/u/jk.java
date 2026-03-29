package com.bytedance.sdk.openadsdk.core.bq.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.ClickAreaSource;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ja nr;
    private com.bytedance.sdk.openadsdk.core.kj.bc u;

    public jk(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        this.u = bcVar;
        this.nr = jaVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, com.bytedance.sdk.openadsdk.core.ja jaVar) {
        oVar.u("adViewInfo", (com.bytedance.sdk.component.u.pn<?, ?>) new jk(bcVar, jaVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    @Nullable
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.nr.u());
        jSONObject2.put(ClickAreaSource.CREATIVE, this.nr.nr());
        return jSONObject2;
    }
}
