package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmScaleAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4116a;
    private float b;
    private float c;
    private float d;

    public BmScaleAnimation(float f, float f2, float f3, float f4) {
        super(81, nativeCreate());
        this.f4116a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        nativeBuildAnimation(this.nativeInstance, f, f2, f3, f4);
    }

    private static native boolean nativeBuildAnimation(long j, float f, float f2, float f3, float f4);

    private static native long nativeCreate();

    public BmScaleAnimation(float f, float f2) {
        super(81, nativeCreate());
        this.f4116a = f;
        this.b = f2;
        this.c = f;
        this.d = f2;
        nativeBuildAnimation(this.nativeInstance, f, f2, f, f2);
    }
}
