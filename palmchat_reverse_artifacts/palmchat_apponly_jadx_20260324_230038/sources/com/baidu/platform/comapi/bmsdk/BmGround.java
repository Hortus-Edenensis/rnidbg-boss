package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.GroundOverlay;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmGround extends BmDrawItem {
    private BmDrawableResource i;
    private GroundOverlay j;

    public BmGround() {
        super(22, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetAnchorX(long j, float f);

    private static native boolean nativeSetAnchorY(long j, float f);

    private static native boolean nativeSetDrawableResource(long j, long j2);

    private static native boolean nativeSetHeight(long j, double d);

    private static native boolean nativeSetPosition(long j, double d, double d2, double d3);

    private static native boolean nativeSetWidth(long j, double d);

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetPosition(this.nativeInstance, bVar.f4118a, bVar.b, 0.0d);
    }

    public boolean b(double d) {
        return nativeSetWidth(this.nativeInstance, d);
    }

    public GroundOverlay c() {
        return this.j;
    }

    public void a(GroundOverlay groundOverlay) {
        this.j = groundOverlay;
    }

    public boolean b(float f) {
        return nativeSetAnchorX(this.nativeInstance, f);
    }

    public boolean c(float f) {
        return nativeSetAnchorY(this.nativeInstance, f);
    }

    public boolean a(double d) {
        return nativeSetHeight(this.nativeInstance, d);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.i = bmDrawableResource;
        if (bmDrawableResource != null) {
            return nativeSetDrawableResource(this.nativeInstance, bmDrawableResource.getNativeInstance());
        }
        return nativeSetDrawableResource(this.nativeInstance, 0L);
    }
}
