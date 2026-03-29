package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Prism;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmPrism extends BmDrawItem {
    private Prism i;

    public BmPrism() {
        super(23, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j, long j2);

    private static native boolean nativeClearGeoElements(long j);

    private static native long nativeCreate();

    private static native boolean nativeSetAnimateType(long j, int i);

    private static native boolean nativeSetBuildingID(long j, String str);

    private static native boolean nativeSetFloorAnimateType(long j, int i);

    private static native boolean nativeSetFloorHeight(long j, float f);

    private static native boolean nativeSetHasFloor(long j, boolean z);

    private static native boolean nativeSetHeight(long j, float f);

    private static native boolean nativeSetIsAnimation(long j, boolean z);

    private static native boolean nativeSetIsBuilding(long j, boolean z);

    private static native boolean nativeSetIsRoundedCorner(long j, boolean z);

    private static native boolean nativeSetLastFloorHeight(long j, float f);

    private static native boolean nativeSetRoundedCornerRadius(long j, float f);

    private static native boolean nativeSetSurfaceFloorSideStyle(long j, long j2);

    private static native boolean nativeSetSurfaceFloorTopStyle(long j, long j2);

    private static native boolean nativeSetSurfaceSideStyle(long j, long j2);

    private static native boolean nativeSetSurfaceTopStyle(long j, long j2);

    public void a(Prism prism) {
        this.i = prism;
    }

    public void b(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceFloorTopStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceFloorTopStyle(this.nativeInstance, 0L);
        }
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public void d(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceTopStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceTopStyle(this.nativeInstance, 0L);
        }
    }

    public boolean e(boolean z) {
        return nativeSetHasFloor(this.nativeInstance, z);
    }

    public boolean f(int i) {
        return nativeSetFloorAnimateType(this.nativeInstance, i);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public void c(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceSideStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceSideStyle(this.nativeInstance, 0L);
        }
    }

    public boolean e(int i) {
        return nativeSetAnimateType(this.nativeInstance, i);
    }

    public boolean f(boolean z) {
        return nativeSetIsRoundedCorner(this.nativeInstance, z);
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceFloorSideStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceFloorSideStyle(this.nativeInstance, 0L);
        }
    }

    public boolean b(float f) {
        return nativeSetFloorHeight(this.nativeInstance, f);
    }

    public boolean d(float f) {
        return nativeSetLastFloorHeight(this.nativeInstance, f);
    }

    public boolean e(float f) {
        return nativeSetRoundedCornerRadius(this.nativeInstance, f);
    }

    public boolean c(float f) {
        return nativeSetHeight(this.nativeInstance, f);
    }

    public boolean d(boolean z) {
        return nativeSetIsBuilding(this.nativeInstance, z);
    }

    public boolean a(String str) {
        return nativeSetBuildingID(this.nativeInstance, str);
    }

    public boolean c(boolean z) {
        return nativeSetIsAnimation(this.nativeInstance, z);
    }
}
