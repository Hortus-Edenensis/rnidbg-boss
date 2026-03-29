package com.bytedance.adsdk.lottie.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private float nr;
    private float u;

    public b(float f, float f2) {
        this.u = f;
        this.nr = f2;
    }

    public float nr() {
        return this.nr;
    }

    public String toString() {
        return u() + "x" + nr();
    }

    public float u() {
        return this.u;
    }

    public boolean nr(float f, float f2) {
        return this.u == f && this.nr == f2;
    }

    public void u(float f, float f2) {
        this.u = f;
        this.nr = f2;
    }

    public b() {
        this(1.0f, 1.0f);
    }
}
