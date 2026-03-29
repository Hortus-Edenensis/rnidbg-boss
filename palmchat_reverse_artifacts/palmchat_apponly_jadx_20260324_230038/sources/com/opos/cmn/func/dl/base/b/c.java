package com.opos.cmn.func.dl.base.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f7973a;
    private Executor b;
    private ThreadPoolExecutor c;
    private ThreadPoolExecutor d;
    private ThreadPoolExecutor e;

    public c(d dVar) {
        this.f7973a = dVar;
        this.b = dVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized Executor a() {
        return this.b;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized ThreadPoolExecutor b() {
        if (this.c == null) {
            this.c = this.f7973a.b();
        }
        return this.c;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized ThreadPoolExecutor c() {
        if (this.d == null) {
            this.d = this.f7973a.c();
        }
        return this.d;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final synchronized ThreadPoolExecutor d() {
        if (this.e == null) {
            this.e = this.f7973a.d();
        }
        return this.e;
    }
}
