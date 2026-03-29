package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmRichView extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4128a;
    private int b;
    private BmAnimation c;
    private float d;
    private float e;
    private float f;
    private String g;
    private BmBaseUI h;

    public BmRichView() {
        super(30, nativeCreate());
        this.f4128a = 1;
        this.b = 2;
        this.c = null;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = 1.0f;
        this.g = "";
        this.h = null;
    }

    private static native boolean nativeAddRichUIOption(long j, long j2);

    private static native boolean nativeBuildRichViewByString(String str);

    private static native boolean nativeBuildRichViewByTemplete(String str);

    private static native long nativeCreate();

    private static native boolean nativeDelRichUIOption(long j, long j2);

    private static native boolean nativeSetAnimation(long j, long j2);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionBorder(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetCollisionLineTagId(long j, int i);

    private static native boolean nativeSetCollisionPriority(long j, int i);

    private static native boolean nativeSetCollisionPriority(long j, short s);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j, boolean z);

    private static native boolean nativeSetLocated(long j, int i);

    private static native boolean nativeSetOffsetX(long j, int i, int i2);

    private static native boolean nativeSetOffsetY(long j, int i, int i2);

    private static native boolean nativeSetOpacity(long j, float f);

    private static native boolean nativeSetScale(long j, float f);

    private static native boolean nativeSetScaleX(long j, float f);

    private static native boolean nativeSetScaleY(long j, float f);

    private static native boolean nativeSetShowLevel(long j, int i, int i2);

    private static native boolean nativeSetView(long j, long j2);

    private static native boolean nativeSetVisibility(long j, int i);

    public boolean a(BmBaseUI bmBaseUI) {
        this.h = bmBaseUI;
        return nativeSetView(this.nativeInstance, (bmBaseUI != null ? Long.valueOf(bmBaseUI.getNativeInstance()) : null).longValue());
    }

    public boolean b(int i) {
        this.b = i;
        return nativeSetLocated(this.nativeInstance, i);
    }

    public boolean c(int i) {
        this.f4128a = i;
        return nativeSetVisibility(this.nativeInstance, i);
    }

    public BmBaseUI a(long j) {
        BmBaseUI bmBaseUI = this.h;
        if (bmBaseUI != null) {
            return bmBaseUI.a(j);
        }
        return null;
    }

    public boolean b(float f) {
        this.e = f;
        return nativeSetScaleX(this.nativeInstance, f);
    }

    public boolean c(float f) {
        this.f = f;
        return nativeSetScaleY(this.nativeInstance, f);
    }

    public boolean a(int i, int i2) {
        return nativeSetShowLevel(this.nativeInstance, i, i2);
    }

    public boolean a(int i) {
        return nativeSetCollisionBehavior(this.nativeInstance, i);
    }

    public boolean a(short s) {
        return nativeSetCollisionPriority(this.nativeInstance, (int) s);
    }

    public boolean a(BmAnimation bmAnimation) {
        this.c = bmAnimation;
        return nativeSetAnimation(this.nativeInstance, bmAnimation == null ? 0L : bmAnimation.getNativeInstance());
    }

    public boolean a(float f) {
        this.e = f;
        this.f = f;
        return nativeSetScale(this.nativeInstance, f);
    }
}
