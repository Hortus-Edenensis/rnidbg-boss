package com.bytedance.sdk.openadsdk.my.u.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements DownloadStatusController {
    private final Function<SparseArray<Object>, Object> u;

    public pn(Function<SparseArray<Object>, Object> function) {
        this.u = function == null ? wc7.e : function;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }
}
