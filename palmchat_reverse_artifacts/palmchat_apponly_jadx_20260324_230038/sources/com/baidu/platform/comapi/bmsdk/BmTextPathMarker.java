package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmTextPathMarker extends BmDrawItem {
    private String i;
    private BmTextStyle j;

    public BmTextPathMarker() {
        super(6, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native long nativeCreate();

    private static native boolean nativeSetGeoElement(long j, long j2);

    private static native boolean nativeSetStyle(long j, long j2);

    private static native boolean nativeSetText(long j, String str);

    public boolean a(String str) {
        this.i = str;
        return nativeSetText(this.nativeInstance, str);
    }

    public boolean a(BmTextStyle bmTextStyle) {
        this.j = bmTextStyle;
        if (bmTextStyle != null) {
            return nativeSetStyle(this.nativeInstance, bmTextStyle.nativeInstance);
        }
        return nativeSetStyle(this.nativeInstance, 0L);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }
}
