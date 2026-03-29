package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmTrackStyle extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4125a;
    private int b;
    private BmBitmapResource c;
    private float d;
    private BmBitmapResource e;
    private float f;
    private int g;

    public BmTrackStyle() {
        super(61, nativeCreate());
        this.f4125a = 0;
        this.b = 0;
        this.c = null;
        this.d = 0.0f;
        this.e = null;
        this.f = 0.0f;
        this.g = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j, long j2);

    private static native boolean nativeSetColor(long j, int i);

    private static native boolean nativeSetOpacity(long j, float f);

    private static native boolean nativeSetPaletteBitmapResource(long j, long j2);

    private static native boolean nativeSetPaletteOpacity(long j, float f);

    private static native boolean nativeSetTrackType(long j, int i);

    private static native boolean nativeSetWidth(long j, int i);

    public boolean a(int i) {
        this.g = i;
        return nativeSetColor(this.nativeInstance, a.a(i));
    }

    public boolean b(int i) {
        this.b = i;
        return nativeSetTrackType(this.nativeInstance, i);
    }

    public boolean c(int i) {
        this.f4125a = i;
        return nativeSetWidth(this.nativeInstance, i);
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.c = bmBitmapResource;
        return nativeSetBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }

    public boolean b(BmBitmapResource bmBitmapResource) {
        this.e = bmBitmapResource;
        return nativeSetPaletteBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }

    public boolean a(float f) {
        this.d = f;
        return nativeSetOpacity(this.nativeInstance, f);
    }

    public boolean b(float f) {
        this.f = f;
        return nativeSetPaletteOpacity(this.nativeInstance, f);
    }
}
