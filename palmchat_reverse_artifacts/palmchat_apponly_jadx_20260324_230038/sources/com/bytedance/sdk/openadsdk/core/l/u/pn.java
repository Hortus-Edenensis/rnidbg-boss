package com.bytedance.sdk.openadsdk.core.l.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.d;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import defpackage.ll7;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class pn extends com.bytedance.sdk.openadsdk.core.bc.b implements OnItemClickListener, LongSupplier {
    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (!com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx)) {
            pluginValueSet = ll7.j((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).a();
        }
        if (i == 223200 && pluginValueSet != null) {
            PluginValueSet pluginValueSetA = ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a();
            onItemClick((Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(223202, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(223203, Function.class));
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onItemClick();

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        onItemClick();
    }
}
