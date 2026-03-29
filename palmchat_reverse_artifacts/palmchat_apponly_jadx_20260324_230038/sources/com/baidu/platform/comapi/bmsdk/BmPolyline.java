package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmPolyline extends BmBaseLine {
    public BmPolyline() {
        super(8, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeUseGeodesic(long j, boolean z);
}
