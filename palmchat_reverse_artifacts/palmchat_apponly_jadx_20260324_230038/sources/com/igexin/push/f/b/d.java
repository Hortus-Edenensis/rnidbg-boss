package com.igexin.push.f.b;

import com.igexin.push.d.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7339a = 20160629;
    public static final long b = 604800000;
    private static final String c = "PollingTimerTask";
    private long e;
    private AtomicBoolean f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f7340a = new d();

        private a() {
        }
    }

    public d() {
        super(b, (byte) 0);
        this.e = com.igexin.push.config.d.y;
        this.f = new AtomicBoolean(false);
        this.p = true;
    }

    private void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    private static d q() {
        return a.f7340a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return f7339a;
    }

    public final void g() {
        if (!this.f.getAndSet(true)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this, false, true);
        }
        a(this.e);
    }

    @Override // com.igexin.push.f.b.f
    public final void h() {
        com.igexin.push.d.b bVar;
        a(this.e, TimeUnit.MILLISECONDS);
        if (!com.igexin.push.core.e.u && com.igexin.push.core.e.n && com.igexin.push.core.e.p && com.igexin.push.core.e.s && com.igexin.push.g.c.a()) {
            com.igexin.c.a.c.a.a("PollingTimerTask|run = true", new Object[0]);
            com.igexin.push.d.c cVar = c.b.f7311a;
            if (cVar.b && (bVar = cVar.e) != null && !(bVar instanceof com.igexin.push.d.d)) {
                cVar.e = new com.igexin.push.d.d();
            }
            com.igexin.push.core.e.b(100L);
            e.g().a(com.igexin.push.core.e.O);
        }
    }

    public final void i() {
        a(b, TimeUnit.MILLISECONDS);
    }
}
