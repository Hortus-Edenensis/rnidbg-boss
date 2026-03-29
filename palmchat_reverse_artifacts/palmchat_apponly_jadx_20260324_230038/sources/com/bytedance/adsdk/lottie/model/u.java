package com.bytedance.adsdk.lottie.model;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class u {
    private final PointF fx;
    private final PointF nr;
    private final PointF u;

    public u() {
        this.u = new PointF();
        this.nr = new PointF();
        this.fx = new PointF();
    }

    public void fx(float f, float f2) {
        this.fx.set(f, f2);
    }

    public void nr(float f, float f2) {
        this.nr.set(f, f2);
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.fx.x), Float.valueOf(this.fx.y), Float.valueOf(this.u.x), Float.valueOf(this.u.y), Float.valueOf(this.nr.x), Float.valueOf(this.nr.y));
    }

    public void u(float f, float f2) {
        this.u.set(f, f2);
    }

    public PointF fx() {
        return this.fx;
    }

    public PointF nr() {
        return this.nr;
    }

    public PointF u() {
        return this.u;
    }

    public u(PointF pointF, PointF pointF2, PointF pointF3) {
        this.u = pointF;
        this.nr = pointF2;
        this.fx = pointF3;
    }
}
