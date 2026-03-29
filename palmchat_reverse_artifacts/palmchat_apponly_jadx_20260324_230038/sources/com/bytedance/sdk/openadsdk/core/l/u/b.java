package com.bytedance.sdk.openadsdk.core.l.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.d;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import defpackage.ll7;
import java.util.Map;
import java.util.function.LongSupplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends com.bytedance.sdk.openadsdk.core.bc.b implements DownloadMarketInterceptor, LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null && i == 223901) {
            if (!com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx)) {
                pluginValueSet = ll7.j((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).a();
            }
            if (pluginValueSet != null) {
                return (T) com.bytedance.sdk.openadsdk.my.b.u().u(223902, interceptObmMarket((Map) ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a().objectValue(223902, Map.class))).nr();
            }
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
