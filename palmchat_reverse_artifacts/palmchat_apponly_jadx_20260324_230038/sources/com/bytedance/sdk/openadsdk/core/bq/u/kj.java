package com.bytedance.sdk.openadsdk.core.bq.u;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class kj extends com.bytedance.sdk.component.u.pn<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.kj.bc nr;
    private Context u;

    public kj(Context context, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        this.u = context;
        this.nr = bcVar;
    }

    public static void u(com.bytedance.sdk.component.u.o oVar, Context context, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        oVar.u("openNewCommonWebPage", (com.bytedance.sdk.component.u.pn<?, ?>) new kj(context, bcVar));
    }

    @Override // com.bytedance.sdk.component.u.pn
    public JSONObject u(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.u.iz izVar) throws Exception {
        try {
            String strOptString = jSONObject.optString("web_url");
            String strOptString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = "";
            }
            TTDelegateActivity.b(this.u, strOptString, strOptString2);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
