package com.bytedance.sdk.component.nr.u;

import com.bytedance.sdk.component.fx.nr.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t {
    public long b;
    public long fx;
    public long iz;
    public long nr;
    public long pn;
    public long u;
    public long x;

    public t() {
        this.u = System.currentTimeMillis();
    }

    public void b() {
        this.nr = System.currentTimeMillis();
    }

    public void fx() {
        this.pn = System.currentTimeMillis();
    }

    public void nr() {
        this.b = System.currentTimeMillis();
    }

    public void u() {
        this.fx = System.currentTimeMillis();
    }

    public void nr(long j) {
        this.x = j;
    }

    public void u(long j) {
        this.iz = j;
    }

    public t(Object obj) {
        this.u = System.currentTimeMillis();
        try {
            if (obj instanceof d) {
                d dVar = (d) obj;
                this.u = dVar.b();
                this.nr = dVar.jk();
                this.fx = dVar.pn();
                this.b = dVar.iz();
                this.pn = dVar.x();
                this.iz = dVar.n();
                this.x = dVar.a();
            }
        } catch (Throwable unused) {
        }
    }
}
