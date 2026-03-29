package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class kp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2945a;
    public long b = 0;
    public long c = 0;
    public double d = 0.0d;
    public double e = 0.0d;
    public double f = 0.0d;
    public float g = 0.0f;
    public float h = 0.0f;
    public float i = 0.0f;
    public boolean j = false;

    public kp(String str) {
        this.f2945a = str;
    }

    public final double a(kp kpVar) {
        if (kpVar != null) {
            return la.a(this.e, this.d, kpVar.e, kpVar.d);
        }
        return 0.0d;
    }
}
