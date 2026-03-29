package com.bytedance.sdk.openadsdk.core.bc;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends b implements LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 0) {
            u();
            return null;
        }
        if (i != 1) {
            return null;
        }
        nr();
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void nr();

    public abstract void u();
}
