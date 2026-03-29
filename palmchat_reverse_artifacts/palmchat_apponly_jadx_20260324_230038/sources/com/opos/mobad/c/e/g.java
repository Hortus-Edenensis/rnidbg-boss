package com.opos.mobad.c.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d<T> f8600a;
    private boolean b = false;

    public g(d<T> dVar) {
        this.f8600a = dVar;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(T t) {
        if (this.b) {
            return false;
        }
        boolean zA = this.f8600a.a(t);
        this.b = zA;
        return zA;
    }
}
