package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Circle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmCircle extends BmDrawItem {
    private Circle i;

    public BmCircle() {
        super(11, nativeCreate());
    }

    private static native boolean nativeAddHoleGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native boolean nativeClearGradientColors(long j);

    private static native long nativeCreate();

    private static native boolean nativeDelGradientColors(long j, int i);

    private static native boolean nativeSetBloomAlpha(long j, float f);

    private static native boolean nativeSetBloomBlurTimes(long j, int i);

    private static native boolean nativeSetBloomGradientASpeed(long j, float f);

    private static native boolean nativeSetBloomWidth(long j, float f);

    private static native boolean nativeSetCenter(long j, double d, double d2, double d3);

    private static native boolean nativeSetGradientColorWeight(long j, float f);

    private static native boolean nativeSetGradientColors(long j, int i, int[] iArr, int i2);

    private static native boolean nativeSetGradientRadiusWeight(long j, float f);

    private static native boolean nativeSetIsGradientCircle(long j, boolean z);

    private static native boolean nativeSetLineBloomDirection(long j, int i);

    private static native boolean nativeSetLineBloomMode(long j, int i);

    private static native boolean nativeSetLineStyle(long j, long j2);

    private static native boolean nativeSetPixelRadius(long j, int i);

    private static native boolean nativeSetRadius(long j, double d);

    private static native boolean nativeSetSurfaceStyle(long j, long j2);

    private static native boolean nativeSetTrackBy(long j, int i);

    public void a(Circle circle) {
        this.i = circle;
    }

    public boolean b(float f) {
        return nativeSetBloomAlpha(this.nativeInstance, f);
    }

    public boolean c(boolean z) {
        return nativeSetIsGradientCircle(this.nativeInstance, z);
    }

    public boolean d() {
        return nativeClearGradientColors(this.nativeInstance);
    }

    public Circle e() {
        return this.i;
    }

    public boolean f(float f) {
        return nativeSetGradientRadiusWeight(this.nativeInstance, f);
    }

    public boolean g(int i) {
        return nativeSetLineBloomMode(this.nativeInstance, i);
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetCenter(this.nativeInstance, bVar.f4118a, bVar.b, 0.0d);
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public boolean d(float f) {
        return nativeSetBloomWidth(this.nativeInstance, f);
    }

    public boolean e(float f) {
        return nativeSetGradientColorWeight(this.nativeInstance, f);
    }

    public boolean f(int i) {
        return nativeSetLineBloomDirection(this.nativeInstance, i);
    }

    public boolean a(double d) {
        return nativeSetRadius(this.nativeInstance, d);
    }

    public boolean c(float f) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, f);
    }

    public boolean e(int i) {
        return nativeSetBloomBlurTimes(this.nativeInstance, i);
    }

    public void a(BmLineStyle bmLineStyle) {
        if (bmLineStyle != null) {
            nativeSetLineStyle(this.nativeInstance, bmLineStyle.nativeInstance);
        } else {
            nativeSetLineStyle(this.nativeInstance, 0L);
        }
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceStyle(this.nativeInstance, 0L);
        }
    }

    public boolean a(int i, List<Integer> list) {
        int[] iArr;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            iArr = null;
        } else {
            iArr = new int[list.size()];
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iArr[i2] = com.baidu.platform.comapi.bmsdk.style.a.a(it.next().intValue());
                i2++;
            }
        }
        return nativeSetGradientColors(this.nativeInstance, i, iArr, i2);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddHoleGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }
}
