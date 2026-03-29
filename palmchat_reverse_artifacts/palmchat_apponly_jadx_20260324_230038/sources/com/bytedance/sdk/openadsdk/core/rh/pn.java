package com.bytedance.sdk.openadsdk.core.rh;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends a {
    public pn(SparseArray<Object> sparseArray, int i) {
        super(sparseArray, i);
    }

    public x nr() {
        PluginValueSet pluginValueSetB;
        if (fx() == null || (pluginValueSetB = fx().b()) == null) {
            return null;
        }
        return new x((JSONObject) pluginValueSetB.objectValue(4, JSONObject.class));
    }

    public boolean u() {
        if (fx() != null) {
            return fx().u();
        }
        return false;
    }
}
