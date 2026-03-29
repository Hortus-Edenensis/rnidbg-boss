package com.bytedance.adsdk.lottie.iz;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.adsdk.lottie.iz;
import com.bytedance.component.sdk.annotation.FloatRange;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f4983a;
    public final Interpolator b;
    public final Interpolator fx;
    public final float iz;
    private final iz jk;
    private float k;
    private float l;
    private int mv;
    private float my;
    public PointF n;
    public T nr;
    public final Interpolator pn;
    private int s;
    private float t;
    public final T u;
    public Float x;

    public u(iz izVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.t = -3987645.8f;
        this.l = -3987645.8f;
        this.mv = 784923401;
        this.s = 784923401;
        this.k = Float.MIN_VALUE;
        this.my = Float.MIN_VALUE;
        this.n = null;
        this.f4983a = null;
        this.jk = izVar;
        this.u = t;
        this.nr = t2;
        this.fx = interpolator;
        this.b = null;
        this.pn = null;
        this.iz = f;
        this.x = f2;
    }

    public int a() {
        if (this.s == 784923401) {
            this.s = ((Integer) this.nr).intValue();
        }
        return this.s;
    }

    public float b() {
        if (this.jk == null) {
            return 1.0f;
        }
        if (this.my == Float.MIN_VALUE) {
            if (this.x == null) {
                this.my = 1.0f;
            } else {
                this.my = fx() + ((this.x.floatValue() - this.iz) / this.jk.sx());
            }
        }
        return this.my;
    }

    public float fx() {
        iz izVar = this.jk;
        if (izVar == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.iz - izVar.iz()) / this.jk.sx();
        }
        return this.k;
    }

    public float iz() {
        if (this.t == -3987645.8f) {
            this.t = ((Float) this.u).floatValue();
        }
        return this.t;
    }

    public int n() {
        if (this.mv == 784923401) {
            this.mv = ((Integer) this.u).intValue();
        }
        return this.mv;
    }

    public boolean pn() {
        return this.fx == null && this.b == null && this.pn == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.u + ", endValue=" + this.nr + ", startFrame=" + this.iz + ", endFrame=" + this.x + ", interpolator=" + this.fx + '}';
    }

    public u<T> u(T t, T t2) {
        return new u<>(t, t2);
    }

    public float x() {
        if (this.l == -3987645.8f) {
            this.l = ((Float) this.nr).floatValue();
        }
        return this.l;
    }

    public boolean u(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        return f >= fx() && f < b();
    }

    public u(iz izVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.t = -3987645.8f;
        this.l = -3987645.8f;
        this.mv = 784923401;
        this.s = 784923401;
        this.k = Float.MIN_VALUE;
        this.my = Float.MIN_VALUE;
        this.n = null;
        this.f4983a = null;
        this.jk = izVar;
        this.u = t;
        this.nr = t2;
        this.fx = null;
        this.b = interpolator;
        this.pn = interpolator2;
        this.iz = f;
        this.x = f2;
    }

    public u(iz izVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.t = -3987645.8f;
        this.l = -3987645.8f;
        this.mv = 784923401;
        this.s = 784923401;
        this.k = Float.MIN_VALUE;
        this.my = Float.MIN_VALUE;
        this.n = null;
        this.f4983a = null;
        this.jk = izVar;
        this.u = t;
        this.nr = t2;
        this.fx = interpolator;
        this.b = interpolator2;
        this.pn = interpolator3;
        this.iz = f;
        this.x = f2;
    }

    public u(T t) {
        this.t = -3987645.8f;
        this.l = -3987645.8f;
        this.mv = 784923401;
        this.s = 784923401;
        this.k = Float.MIN_VALUE;
        this.my = Float.MIN_VALUE;
        this.n = null;
        this.f4983a = null;
        this.jk = null;
        this.u = t;
        this.nr = t;
        this.fx = null;
        this.b = null;
        this.pn = null;
        this.iz = Float.MIN_VALUE;
        this.x = Float.valueOf(Float.MAX_VALUE);
    }

    private u(T t, T t2) {
        this.t = -3987645.8f;
        this.l = -3987645.8f;
        this.mv = 784923401;
        this.s = 784923401;
        this.k = Float.MIN_VALUE;
        this.my = Float.MIN_VALUE;
        this.n = null;
        this.f4983a = null;
        this.jk = null;
        this.u = t;
        this.nr = t2;
        this.fx = null;
        this.b = null;
        this.pn = null;
        this.iz = Float.MIN_VALUE;
        this.x = Float.valueOf(Float.MAX_VALUE);
    }
}
