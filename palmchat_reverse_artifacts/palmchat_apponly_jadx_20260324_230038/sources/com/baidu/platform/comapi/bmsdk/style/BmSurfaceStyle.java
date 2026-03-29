package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmSurfaceStyle extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4123a;
    private int b;
    private BmBitmapResource c;

    public BmSurfaceStyle() {
        super(53, nativeCreate());
        this.f4123a = 0;
        this.b = 0;
        this.c = null;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j, long j2);

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    public boolean a(int i) {
        this.b = i;
        return nativeSetColor(this.nativeInstance, a.a(i));
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.c = bmBitmapResource;
        this.f4123a = 0;
        return nativeSetBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }
}
