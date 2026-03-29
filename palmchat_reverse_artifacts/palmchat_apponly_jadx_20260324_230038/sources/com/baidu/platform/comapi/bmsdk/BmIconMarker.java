package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Marker;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmIconMarker extends BmBaseMarker {
    private int w;
    private BmDrawableResource x;
    private Marker y;

    public BmIconMarker() {
        super(4, nativeCreate());
        this.w = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetAnimationType(long j, int i);

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    private static native boolean nativeSetDrawableResource(long j, long j2);

    public void a(Marker marker) {
        this.y = marker;
    }

    public BmDrawableResource d() {
        return this.x;
    }

    public Marker e() {
        return this.y;
    }

    public boolean o(int i) {
        return nativeSetAnimationType(this.nativeInstance, i);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.x = bmDrawableResource;
        this.w = 0;
        return bmDrawableResource != null ? nativeSetDrawableResource(this.nativeInstance, bmDrawableResource.getNativeInstance()) : nativeSetDrawableResource(this.nativeInstance, 0L);
    }
}
