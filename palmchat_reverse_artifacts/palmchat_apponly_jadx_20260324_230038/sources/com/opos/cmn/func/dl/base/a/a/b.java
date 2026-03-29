package com.opos.cmn.func.dl.base.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f7961a = new Object();
    private a b;
    private int c;

    public final a a() {
        synchronized (f7961a) {
            a aVar = this.b;
            if (aVar == null) {
                return new a();
            }
            this.b = aVar.f;
            aVar.f = null;
            this.c--;
            return aVar;
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.d = 0L;
        aVar.f7960a = 0;
        aVar.b = 0;
        aVar.c = 0;
        aVar.f = null;
        synchronized (f7961a) {
            int i = this.c;
            if (i < 100) {
                aVar.f = this.b;
                this.b = aVar;
                this.c = i + 1;
            }
        }
    }
}
