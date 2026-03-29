package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmRotateAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4115a;
    private float b;

    public BmRotateAnimation(float f, float f2) {
        super(84, nativeCreate());
        this.f4115a = f;
        this.b = f2;
        nativeBuildAnimation(this.nativeInstance, f, f2);
    }

    private static native boolean nativeBuildAnimation(long j, float f, float f2);

    private static native long nativeCreate();
}
