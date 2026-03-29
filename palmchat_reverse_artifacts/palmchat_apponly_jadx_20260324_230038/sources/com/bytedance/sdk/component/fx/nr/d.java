package com.bytedance.sdk.component.fx.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    long b;
    long fx;
    long iz;
    long nr;
    long pn;
    long u = System.currentTimeMillis();
    long x;

    public long a() {
        return this.x;
    }

    public long b() {
        return this.u;
    }

    public void fx() {
        this.pn = System.currentTimeMillis();
    }

    public long iz() {
        return this.b;
    }

    public long jk() {
        return this.nr;
    }

    public long n() {
        return this.iz;
    }

    public void nr() {
        this.b = System.currentTimeMillis();
    }

    public long pn() {
        return this.fx;
    }

    public void t() {
        this.nr = System.currentTimeMillis();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.u + ", asyncCallExecTs=" + this.nr + ", requestStartExecTs=" + this.fx + ", requestConnectStartTs=" + this.b + ", requestConnectFinishTs=" + this.pn + ", reqCallServerStartTs=" + this.iz + ", reqCallServerFinishTs=" + this.x + '}';
    }

    public void u() {
        this.fx = System.currentTimeMillis();
    }

    public long x() {
        return this.pn;
    }

    public void nr(long j) {
        this.x = j;
    }

    public void u(long j) {
        this.iz = j;
    }
}
