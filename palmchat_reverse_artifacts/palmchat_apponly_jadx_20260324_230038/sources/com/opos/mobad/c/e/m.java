package com.opos.mobad.c.e;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8606a;
    private int b;
    private int c;
    private double d;
    private a e;
    private long f;
    private int g;
    private int h;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(m mVar);
    }

    public m(int i, int i2, int i3, double d, a aVar) {
        this.f8606a = i;
        this.b = i2;
        this.c = i3;
        this.d = d;
        this.e = aVar;
    }

    private void e() {
        int i;
        int i2;
        if (SystemClock.elapsedRealtime() - this.f >= this.f8606a && (i = this.g) >= this.b && (i2 = this.h) >= this.c && ((double) i) / ((double) i2) >= this.d) {
            this.e.a(this);
            f();
        }
    }

    private void f() {
        this.h = 0;
        this.g = 0;
        this.f = SystemClock.elapsedRealtime();
    }

    public void a() {
        this.g++;
        e();
    }

    public void b() {
        this.h++;
        e();
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public m(int i, int i2, a aVar) {
        this(i, 0, i2, 0.0d, aVar);
    }

    public void a(int i, int i2) {
        this.g += i;
        this.h += i2;
        e();
    }
}
