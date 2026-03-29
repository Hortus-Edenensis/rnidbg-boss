package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.mapapi.map.bmsdk.ui.BaseUI;
import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;
import com.baidu.platform.comapi.bmsdk.style.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BmBaseUI extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4127a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;
    private BaseUI f;

    private BmBaseUI() {
        super(31, 0L);
        this.f4127a = 1;
        this.b = "";
        this.c = "";
        this.d = false;
        this.e = false;
    }

    private static native boolean nativeSetAlignParent(long j, int i);

    private static native boolean nativeSetBackground(long j, long j2);

    private static native boolean nativeSetBackgroundColor(long j, int i);

    private static native boolean nativeSetBackgroundResId(long j, int i);

    private static native boolean nativeSetBkColorOfLeft(long j, int i);

    private static native boolean nativeSetBkColorOfRight(long j, int i);

    private static native boolean nativeSetClickable(long j, boolean z);

    private static native boolean nativeSetGravity(long j, int i);

    private static native boolean nativeSetHeight(long j, int i);

    private static native boolean nativeSetLayoutWeight(long j, int i);

    private static native boolean nativeSetMargin(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetPadding(long j, int i, int i2, int i3, int i4);

    private static native boolean nativeSetVisibility(long j, int i);

    private static native boolean nativeSetWidth(long j, int i);

    public void a(BaseUI baseUI) {
        this.f = baseUI;
    }

    public boolean b(int i) {
        this.e = i != 0;
        return nativeSetBackgroundColor(this.nativeInstance, a.a(i));
    }

    public boolean c(int i) {
        this.e = i != 0;
        return nativeSetBkColorOfLeft(this.nativeInstance, a.a(i));
    }

    public boolean d(int i) {
        this.e = i != 0;
        return nativeSetBkColorOfRight(this.nativeInstance, a.a(i));
    }

    public boolean e(int i) {
        return nativeSetGravity(this.nativeInstance, i);
    }

    public boolean f(int i) {
        return nativeSetHeight(this.nativeInstance, i);
    }

    public boolean g(int i) {
        return nativeSetLayoutWeight(this.nativeInstance, i);
    }

    public boolean h(int i) {
        this.f4127a = i;
        return nativeSetVisibility(this.nativeInstance, i);
    }

    public boolean i(int i) {
        return nativeSetWidth(this.nativeInstance, i);
    }

    public BaseUI a() {
        return this.f;
    }

    public BmBaseUI a(long j) {
        if (this.nativeInstance == j) {
            return this;
        }
        return null;
    }

    public boolean b(int i, int i2, int i3, int i4) {
        return nativeSetPadding(this.nativeInstance, i, i2, i3, i4);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.d = bmDrawableResource != null;
        if (bmDrawableResource != null) {
            return nativeSetBackground(this.nativeInstance, bmDrawableResource.getNativeInstance());
        }
        return nativeSetBackground(this.nativeInstance, 0L);
    }

    public BmBaseUI(int i, long j) {
        super(i, j);
        this.f4127a = 1;
        this.b = "";
        this.c = "";
        this.d = false;
        this.e = false;
    }

    public boolean a(int i) {
        return nativeSetAlignParent(this.nativeInstance, i);
    }

    public boolean a(int i, int i2, int i3, int i4) {
        return nativeSetMargin(this.nativeInstance, i, i2, i3, i4);
    }

    public boolean a(boolean z) {
        return nativeSetClickable(this.nativeInstance, z);
    }

    public void a(String str) {
        this.b = str;
    }
}
