package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polyline;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmBaseLine extends BmDrawItem {
    private Polyline i;

    private BmBaseLine() {
        super(7, 0L);
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native boolean nativeSetBloomAlpha(long j, float f);

    private static native boolean nativeSetBloomBlurTimes(long j, int i);

    private static native boolean nativeSetBloomGradientASpeed(long j, float f);

    private static native boolean nativeSetBloomWidth(long j, float f);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionTagId(long j, int i);

    private static native boolean nativeSetEndCapType(long j, int i);

    private static native boolean nativeSetGeoElement(long j, long j2);

    private static native boolean nativeSetHighPrecision(long j, boolean z);

    private static native boolean nativeSetJointType(long j, int i);

    private static native boolean nativeSetLineBloomDirection(long j, int i);

    private static native boolean nativeSetLineBloomMode(long j, int i);

    private static native boolean nativeSetLineDirectionCrossType(long j, int i);

    private static native boolean nativeSetSmooth(long j, int i);

    private static native boolean nativeSetSmoothFactor(long j, float f);

    private static native boolean nativeSetStartCapType(long j, int i);

    private static native boolean nativeSetThin(long j, int i);

    private static native boolean nativeSetThinFactor(long j, float f);

    public void a(Polyline polyline) {
        this.i = polyline;
    }

    public boolean b(float f) {
        return nativeSetBloomAlpha(this.nativeInstance, f);
    }

    public Polyline c() {
        return this.i;
    }

    public boolean d(float f) {
        return nativeSetBloomWidth(this.nativeInstance, f);
    }

    public boolean e(float f) {
        return nativeSetSmoothFactor(this.nativeInstance, f);
    }

    public boolean f(float f) {
        return nativeSetThinFactor(this.nativeInstance, f);
    }

    public boolean g(int i) {
        return nativeSetJointType(this.nativeInstance, i);
    }

    public boolean h(int i) {
        return nativeSetLineBloomDirection(this.nativeInstance, i);
    }

    public boolean i(int i) {
        return nativeSetLineBloomMode(this.nativeInstance, i);
    }

    public boolean j(int i) {
        return nativeSetLineDirectionCrossType(this.nativeInstance, i);
    }

    public boolean k(int i) {
        return nativeSetSmooth(this.nativeInstance, i);
    }

    public boolean l(int i) {
        return nativeSetStartCapType(this.nativeInstance, i);
    }

    public boolean m(int i) {
        return nativeSetThin(this.nativeInstance, i);
    }

    public BmBaseLine(int i, long j) {
        super(i, j);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean c(float f) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, f);
    }

    public boolean e(int i) {
        return nativeSetBloomBlurTimes(this.nativeInstance, i);
    }

    public boolean f(int i) {
        return nativeSetEndCapType(this.nativeInstance, i);
    }

    public boolean c(boolean z) {
        return nativeSetHighPrecision(this.nativeInstance, z);
    }
}
