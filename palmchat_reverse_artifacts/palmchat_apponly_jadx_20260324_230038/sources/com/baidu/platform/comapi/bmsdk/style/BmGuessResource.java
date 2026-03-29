package com.baidu.platform.comapi.bmsdk.style;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmGuessResource extends BmDrawableResource {
    private BmGuessResource() {
        super(59, nativeCreate());
    }

    private static native boolean nativeBuildDefaultGradientBkImage(long j);

    private static native boolean nativeBuildResource(long j, String str, boolean z);

    private static native long nativeCreate();

    public BmGuessResource(String str) {
        super(59, nativeCreate());
        nativeBuildResource(this.nativeInstance, str, false);
    }
}
