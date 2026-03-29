package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ColorInt
    public int f4996a;
    public u b;
    public float fx;
    public float iz;
    public float jk;
    public PointF l;
    public PointF mv;

    @ColorInt
    public int n;
    public String nr;
    public int pn;
    public boolean t;
    public String u;
    public float x;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public nr(String str, String str2, float f, u uVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        u(str, str2, f, uVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.u.hashCode() * 31) + this.nr.hashCode()) * 31) + this.fx)) * 31) + this.b.ordinal()) * 31) + this.pn;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.iz);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.n;
    }

    public void u(String str, String str2, float f, u uVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.u = str;
        this.nr = str2;
        this.fx = f;
        this.b = uVar;
        this.pn = i;
        this.iz = f2;
        this.x = f3;
        this.n = i2;
        this.f4996a = i3;
        this.jk = f4;
        this.t = z;
        this.l = pointF;
        this.mv = pointF2;
    }

    public nr() {
    }
}
