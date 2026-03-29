package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.my;
import com.bytedance.sdk.component.fx.nr.z;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements bq.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5130a;
    private final com.bytedance.sdk.component.fx.nr.u.nr.fx b;
    private final fx fx;
    private final z iz;
    private final int jk;
    private int l;
    private final my n;
    private final com.bytedance.sdk.component.fx.nr.u.nr.x nr;
    private final int pn;
    private final int t;
    private final List<bq> u;
    private final com.bytedance.sdk.component.fx.nr.pn x;

    public x(List<bq> list, com.bytedance.sdk.component.fx.nr.u.nr.x xVar, fx fxVar, com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar2, int i, z zVar, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar, int i2, int i3, int i4) {
        this.u = list;
        this.b = fxVar2;
        this.nr = xVar;
        this.fx = fxVar;
        this.pn = i;
        this.iz = zVar;
        this.x = pnVar;
        this.n = myVar;
        this.f5130a = i2;
        this.jk = i3;
        this.t = i4;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq.u
    public int b() {
        return this.t;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq.u
    public com.bytedance.sdk.component.fx.nr.pn call() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq.u
    public int fx() {
        return this.jk;
    }

    public com.bytedance.sdk.component.fx.nr.u.nr.x iz() {
        return this.nr;
    }

    public my n() {
        return this.n;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq.u
    public int nr() {
        return this.f5130a;
    }

    public com.bytedance.sdk.component.fx.nr.a pn() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq.u
    public z u() {
        return this.iz;
    }

    public fx x() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq.u
    public h u(z zVar) throws IOException {
        return u(zVar, this.nr, this.fx, this.b);
    }

    public h u(z zVar, com.bytedance.sdk.component.fx.nr.u.nr.x xVar, fx fxVar, com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar2) throws IOException {
        if (this.pn < this.u.size()) {
            this.l++;
            if (this.fx != null && !this.b.u(zVar.u())) {
                throw new IllegalStateException("network interceptor " + this.u.get(this.pn - 1) + " must retain the same host and port");
            }
            if (this.fx != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.u.get(this.pn - 1) + " must call proceed() exactly once");
            }
            x xVar2 = new x(this.u, xVar, fxVar, fxVar2, this.pn + 1, zVar, this.x, this.n, this.f5130a, this.jk, this.t);
            bq bqVar = this.u.get(this.pn);
            h hVarU = bqVar.u(xVar2);
            if (fxVar != null && this.pn + 1 < this.u.size() && xVar2.l != 1) {
                throw new IllegalStateException("network interceptor " + bqVar + " must call proceed() exactly once");
            }
            if (hVarU != null) {
                if (hVarU.n() != null) {
                    return hVarU;
                }
                throw new IllegalStateException("interceptor " + bqVar + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + bqVar + " returned a null response");
        }
        throw new AssertionError();
    }
}
