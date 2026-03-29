package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmLineStyle extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4122a;
    private int b;
    private int c;
    private BmBitmapResource d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public BmLineStyle() {
        super(51, nativeCreate());
        this.f4122a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j, long j2);

    private static native boolean nativeSetBmpResId(long j, int i);

    private static native boolean nativeSetColor(long j, int i);

    private static native boolean nativeSetLineResId(long j, int i);

    private static native boolean nativeSetLineType(long j, int i);

    private static native boolean nativeSetStrokeColor(long j, int i);

    private static native boolean nativeSetStrokeWidth(long j, int i);

    private static native boolean nativeSetTextureOption(long j, int i);

    private static native boolean nativeSetWidth(long j, int i);

    public boolean a(int i) {
        this.c = i;
        return nativeSetColor(this.nativeInstance, a.a(i));
    }

    public boolean b(int i) {
        this.i = i;
        return nativeSetLineType(this.nativeInstance, i);
    }

    public boolean c(int i) {
        this.h = i;
        return nativeSetTextureOption(this.nativeInstance, i);
    }

    public boolean d(int i) {
        int i2 = i / 2;
        this.e = i2;
        return nativeSetWidth(this.nativeInstance, i2);
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.d = bmBitmapResource;
        this.b = 0;
        this.f4122a = 0;
        return nativeSetBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }
}
