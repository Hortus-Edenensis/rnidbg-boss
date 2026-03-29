package com.bytedance.sdk.openadsdk.my;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private PluginValueSet b;
    private String fx;
    private int nr;
    private boolean u;

    public u(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
            this.u = pluginValueSetA.booleanValue(-999903);
            this.nr = pluginValueSetA.intValue(-999900);
            this.fx = pluginValueSetA.stringValue(-999901);
            this.b = ll7.j((SparseArray) pluginValueSetA.objectValue(-999902, SparseArray.class)).a();
        }
    }

    public PluginValueSet b() {
        return this.b;
    }

    public String fx() {
        return this.fx;
    }

    public int nr() {
        return this.nr;
    }

    public boolean u() {
        return this.u;
    }
}
