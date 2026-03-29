package com.bytedance.sdk.openadsdk.core.l.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.d;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import defpackage.ll7;
import java.util.function.LongSupplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr extends com.bytedance.sdk.openadsdk.core.bc.b implements IDownloadButtonClickListener, LongSupplier {
    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (i == 223100) {
            if (!com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx)) {
                pluginValueSet = ll7.j((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).a();
            }
            handleComplianceDialog(ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a().booleanValue(223101));
        } else if (i == 223110) {
            handleMarketFailedComplianceDialog();
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
