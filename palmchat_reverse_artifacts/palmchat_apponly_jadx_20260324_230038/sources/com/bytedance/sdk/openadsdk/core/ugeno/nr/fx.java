package com.bytedance.sdk.openadsdk.core.ugeno.nr;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.ugeno.express.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends b {
    public fx(Context context, bc bcVar, com.bytedance.sdk.openadsdk.core.ugeno.express.nr nrVar, ViewGroup viewGroup) {
        super(context, bcVar, nrVar, viewGroup);
    }

    private JSONObject s() {
        try {
            return new JSONObject(u.u(this.iz, this.x).u(this.iz));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b, com.bytedance.sdk.component.adexpress.nr.b
    public int fx() {
        return 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.b
    public JSONObject u() {
        return s();
    }
}
