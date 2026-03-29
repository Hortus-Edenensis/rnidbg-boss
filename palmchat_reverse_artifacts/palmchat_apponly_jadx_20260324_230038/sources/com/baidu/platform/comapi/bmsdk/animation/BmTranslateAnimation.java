package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.platform.comapi.bmsdk.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmTranslateAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f4117a;
    private double b;
    private double c;
    private double d;

    public BmTranslateAnimation(b bVar, b bVar2) {
        super(82, nativeCreate());
        double d = bVar.f4118a;
        this.f4117a = d;
        double d2 = bVar2.f4118a;
        this.b = d2;
        double d3 = bVar.b;
        this.c = d3;
        double d4 = bVar2.b;
        this.d = d4;
        nativeBuildAnimation(this.nativeInstance, d, d2, d3, d4);
    }

    private static native boolean nativeBuildAnimation(long j, double d, double d2, double d3, double d4);

    private static native long nativeCreate();
}
