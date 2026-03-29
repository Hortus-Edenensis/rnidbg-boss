package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmLineStyleOption extends BmObject {
    private BmLineStyleOption() {
        super(52, nativeCreate());
    }

    private static native boolean nativeBuildStyleOption(long j, int i, long j2);

    private static native long nativeCreate();

    public BmLineStyleOption(int i, BmLineStyle bmLineStyle) {
        super(52, nativeCreate());
        nativeBuildStyleOption(this.nativeInstance, i, bmLineStyle != null ? bmLineStyle.getNativeInstance() : 0L);
    }
}
