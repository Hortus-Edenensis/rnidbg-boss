package com.bytedance.sdk.openadsdk.core.l.u;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.d;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import defpackage.ll7;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx extends com.bytedance.sdk.openadsdk.core.bc.b implements DownloadStatusChangeListener, LongSupplier {
    private int mCurrentPercent;

    private void setCurrentPercent(int i) {
        this.mCurrentPercent = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.core.bc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (!com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx)) {
            pluginValueSet = ll7.j((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).a();
        }
        switch (i) {
            case 223600:
                onIdle();
                return null;
            case 223601:
                if (pluginValueSet != null) {
                    PluginValueSet pluginValueSetA = ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a();
                    onDownloadStart((Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(223203, Function.class));
                }
                return null;
            case 223602:
                if (pluginValueSet != null) {
                    PluginValueSet pluginValueSetA2 = ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a();
                    onDownloadActive((Function<SparseArray<Object>, Object>) pluginValueSetA2.objectValue(223607, Function.class), ((Integer) pluginValueSetA2.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223603:
                if (pluginValueSet != null) {
                    PluginValueSet pluginValueSetA3 = ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a();
                    onDownloadPaused((Function<SparseArray<Object>, Object>) pluginValueSetA3.objectValue(223607, Function.class), ((Integer) pluginValueSetA3.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223604:
                if (pluginValueSet != null) {
                    onDownloadFailed((Function<SparseArray<Object>, Object>) ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a().objectValue(223607, Function.class));
                }
                return null;
            case 223605:
                if (pluginValueSet != null) {
                    onInstalled((Function<SparseArray<Object>, Object>) ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a().objectValue(223607, Function.class));
                }
                return null;
            case 223606:
                if (pluginValueSet != null) {
                    onDownloadFinished((Function<SparseArray<Object>, Object>) ll7.j((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).a().objectValue(223607, Function.class));
                }
                return null;
            default:
                return null;
        }
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public int getCurrentPercent() {
        return this.mCurrentPercent;
    }

    public abstract void onDownloadActive(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadActive(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadFailed(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFailed(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadFinished(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFinished(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadPaused(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadPaused(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadStart();

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
        if (downloadModel == null) {
            return;
        }
        setCurrentPercent(0);
        onDownloadStart();
    }

    public abstract void onInstalled(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(100);
        String str = downloadShortInfo.fileName;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        onInstalled(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str);
    }

    private void onDownloadFailed(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetNr;
        if (function == null || (pluginValueSetNr = com.bytedance.sdk.openadsdk.my.fx.nr(function)) == null) {
            return;
        }
        onDownloadFailed(pluginValueSetNr.longValue(223704), pluginValueSetNr.longValue(223705), pluginValueSetNr.stringValue(223706));
    }

    private void onDownloadFinished(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetNr;
        if (function == null || (pluginValueSetNr = com.bytedance.sdk.openadsdk.my.fx.nr(function)) == null) {
            return;
        }
        onDownloadFinished(pluginValueSetNr.longValue(223704), pluginValueSetNr.longValue(223705), pluginValueSetNr.stringValue(223706));
    }

    private void onDownloadActive(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetNr;
        if (function == null || (pluginValueSetNr = com.bytedance.sdk.openadsdk.my.fx.nr(function)) == null) {
            return;
        }
        onDownloadActive(pluginValueSetNr.longValue(223704), pluginValueSetNr.longValue(223705), pluginValueSetNr.stringValue(223706));
    }

    private void onDownloadPaused(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetNr;
        if (function == null || (pluginValueSetNr = com.bytedance.sdk.openadsdk.my.fx.nr(function)) == null) {
            return;
        }
        onDownloadPaused(pluginValueSetNr.longValue(223704), pluginValueSetNr.longValue(223705), pluginValueSetNr.stringValue(223706));
    }

    private void onDownloadStart(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2) {
        if (function == null || com.bytedance.sdk.openadsdk.my.fx.nr(function) == null) {
            return;
        }
        onDownloadStart();
    }

    private void onInstalled(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetNr;
        if (function == null || (pluginValueSetNr = com.bytedance.sdk.openadsdk.my.fx.nr(function)) == null) {
            return;
        }
        long jLongValue = pluginValueSetNr.longValue(223704);
        long jLongValue2 = pluginValueSetNr.longValue(223705);
        String strStringValue = pluginValueSetNr.stringValue(223706);
        if (strStringValue == null) {
            strStringValue = "";
        }
        onInstalled(jLongValue, jLongValue2, strStringValue);
    }
}
