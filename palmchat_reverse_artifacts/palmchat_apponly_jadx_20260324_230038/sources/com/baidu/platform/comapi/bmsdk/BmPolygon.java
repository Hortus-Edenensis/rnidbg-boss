package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polygon;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmPolygon extends BmDrawItem {
    private Polygon i;

    public BmPolygon() {
        super(10, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeAddHoleGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native long nativeCreate();

    private static native boolean nativeSetBloomAlpha(long j, float f);

    private static native boolean nativeSetBloomBlurTimes(long j, int i);

    private static native boolean nativeSetBloomGradientASpeed(long j, float f);

    private static native boolean nativeSetBloomWidth(long j, float f);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j, boolean z);

    private static native boolean nativeSetJointType(long j, int i);

    private static native boolean nativeSetLineBloomDirection(long j, int i);

    private static native boolean nativeSetLineBloomMode(long j, int i);

    private static native boolean nativeSetSurfaceStyle(long j, long j2);

    private static native boolean nativeSetThin(long j, int i);

    private static native boolean nativeSetThinFactor(long j, float f);

    public void a(Polygon polygon) {
        this.i = polygon;
    }

    public boolean b(BmGeoElement bmGeoElement) {
        return nativeAddHoleGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public Polygon d() {
        return this.i;
    }

    public boolean e(float f) {
        return nativeSetThinFactor(this.nativeInstance, f);
    }

    public boolean f(int i) {
        return nativeSetJointType(this.nativeInstance, i);
    }

    public boolean g(int i) {
        return nativeSetLineBloomDirection(this.nativeInstance, i);
    }

    public boolean h(int i) {
        return nativeSetLineBloomMode(this.nativeInstance, i);
    }

    public boolean i(int i) {
        return nativeSetThin(this.nativeInstance, i);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean b(float f) {
        return nativeSetBloomAlpha(this.nativeInstance, f);
    }

    public boolean c(float f) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, f);
    }

    public boolean d(float f) {
        return nativeSetBloomWidth(this.nativeInstance, f);
    }

    public boolean e(int i) {
        return nativeSetBloomBlurTimes(this.nativeInstance, i);
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceStyle(this.nativeInstance, 0L);
        }
    }
}
