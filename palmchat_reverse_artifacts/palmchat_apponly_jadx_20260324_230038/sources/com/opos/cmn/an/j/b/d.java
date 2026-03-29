package com.opos.cmn.an.j.b;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d<T, K> implements com.opos.cmn.an.j.a.b, com.opos.cmn.an.j.a.c<K>, com.opos.cmn.an.j.a.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.j.a.b f7809a;
    private com.opos.cmn.an.j.a.d<T> b;
    private com.opos.cmn.an.j.a.c<K> c;
    private Executor d;

    public d(Executor executor, com.opos.cmn.an.j.a.b bVar, com.opos.cmn.an.j.a.d<T> dVar, com.opos.cmn.an.j.a.c<K> cVar) {
        this.d = executor;
        this.f7809a = bVar;
        this.b = dVar;
        this.c = cVar;
    }

    @Override // com.opos.cmn.an.j.a.b
    public void a() {
        if (this.f7809a != null) {
            this.d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f7809a.a();
                }
            });
        }
    }

    @Override // com.opos.cmn.an.j.a.d
    public void b(final T t) {
        if (this.b != null) {
            this.d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    d.this.b.b(t);
                }
            });
        }
    }

    @Override // com.opos.cmn.an.j.a.c
    public void a(final K k) {
        if (this.c != null) {
            this.d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    d.this.c.a(k);
                }
            });
        }
    }
}
