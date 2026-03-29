package com.opos.mobad.c.e;

import com.opos.mobad.c.e.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a<T, F extends c<T>> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private F f8597a;
    private d<F> b;
    private b<F> c;

    public a(F f, d<F> dVar, b<F> bVar) {
        this.f8597a = f;
        this.b = dVar;
        this.c = bVar;
    }

    private void a(F f) {
        this.c.a(f);
        f.a();
    }

    @Override // com.opos.mobad.c.e.b
    public void a(T t) {
        this.f8597a.a(t);
        if (this.b.a(this.f8597a)) {
            a((c) this.f8597a);
        }
    }
}
