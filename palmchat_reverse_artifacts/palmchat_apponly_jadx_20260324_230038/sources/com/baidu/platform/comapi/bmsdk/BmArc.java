package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Arc;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmArc extends BmDrawItem {
    private Arc i;

    public BmArc() {
        super(12, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetCenter(long j, double d, double d2, double d3);

    private static native boolean nativeSetClockwise(long j, boolean z);

    private static native boolean nativeSetEndRadian(long j, double d);

    private static native boolean nativeSetLineStyle(long j, long j2);

    private static native boolean nativeSetPixelRadius(long j, int i);

    private static native boolean nativeSetRadius(long j, double d);

    private static native boolean nativeSetStartRadian(long j, double d);

    private static native boolean nativeSetTrackBy(long j, int i);

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetCenter(this.nativeInstance, bVar.f4118a, bVar.b, 0.0d);
    }

    public boolean b(double d) {
        return nativeSetRadius(this.nativeInstance, d);
    }

    public Arc c() {
        return this.i;
    }

    public void a(Arc arc) {
        this.i = arc;
    }

    public boolean c(double d) {
        return nativeSetStartRadian(this.nativeInstance, d);
    }

    public boolean a(double d) {
        return nativeSetEndRadian(this.nativeInstance, d);
    }

    public boolean c(boolean z) {
        return nativeSetClockwise(this.nativeInstance, z);
    }

    public void a(BmLineStyle bmLineStyle) {
        if (bmLineStyle != null) {
            nativeSetLineStyle(this.nativeInstance, bmLineStyle.nativeInstance);
        } else {
            nativeSetLineStyle(this.nativeInstance, 0L);
        }
    }
}
