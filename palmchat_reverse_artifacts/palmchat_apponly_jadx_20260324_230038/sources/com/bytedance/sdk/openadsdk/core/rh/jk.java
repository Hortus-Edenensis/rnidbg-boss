package com.bytedance.sdk.openadsdk.core.rh;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class jk {
    public abstract JSONObject nr(Context context);

    public abstract void u(int i, a aVar);

    public void u(Context context) {
        fx fxVar;
        if (u() && (fxVar = (fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya")) != null && fxVar.isPitayaEnvAvailable()) {
            final JSONObject jSONObjectNr = nr(context);
            fxVar.runTask("common", jSONObjectNr, new com.bytedance.sdk.openadsdk.core.bc.b() { // from class: com.bytedance.sdk.openadsdk.core.rh.jk.1
                @Override // com.bytedance.sdk.openadsdk.core.bc.b
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
                    com.bytedance.sdk.openadsdk.core.qq.s.u();
                    com.bytedance.sdk.openadsdk.core.qq.s.u((SparseArray<Object>) sparseArray, jSONObjectNr);
                    jk.this.u(i, new a(sparseArray, i));
                    return null;
                }
            });
        }
    }

    public abstract boolean u();
}
