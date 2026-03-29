package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmAlphaAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4114a;
    private float b;

    public BmAlphaAnimation(float f, float f2) {
        super(83, nativeCreate());
        this.f4114a = f;
        this.b = f2;
        nativeBuildAnimation(this.nativeInstance, f, f2);
    }

    private static native boolean nativeBuildAnimation(long j, float f, float f2);

    private static native long nativeCreate();
}
