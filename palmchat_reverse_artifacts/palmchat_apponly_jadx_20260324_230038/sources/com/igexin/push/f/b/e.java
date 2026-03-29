package com.igexin.push.f.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.push.core.e.f.AnonymousClass13;
import com.igexin.push.core.k;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e extends f {
    public static final int b = -2147483641;
    private static final String c = "RNTT";
    private static e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7341a;
    private long f;

    private e() {
        super(1200000L, (byte) 0);
        this.p = true;
        this.f = System.currentTimeMillis();
        this.f7341a = SystemClock.elapsedRealtime();
    }

    public static synchronized e g() {
        if (e == null) {
            e = new e();
        }
        return e;
    }

    private void i() {
        a(com.igexin.push.core.e.O);
    }

    public final void a(long j) {
        com.igexin.c.a.c.a.a("RNTT|refreshDelayTime, delay = ".concat(String.valueOf(j)), new Object[0]);
        a(j, TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return b;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
    }

    @Override // com.igexin.push.f.b.f
    public final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        boolean zA = com.igexin.push.g.c.a();
        com.igexin.push.core.e.n = com.igexin.push.g.c.e();
        com.igexin.c.a.c.a.a("RNTT|networkAvailable = " + com.igexin.push.core.e.n + "|,sdkOnline = " + com.igexin.push.core.e.u + ", sdkOn= " + com.igexin.push.core.e.p + ", pushOn =" + com.igexin.push.core.e.s + ", blockEndTime= " + zA, new Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.s || com.igexin.push.core.e.u || !zA) {
            com.igexin.c.a.c.a.a("RNTT reconnect timer task stop, connect interval = 20min #######", new Object[0]);
            a(1200000L, TimeUnit.MILLISECONDS);
            return;
        }
        if (!com.igexin.push.g.c.f() && TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            a(900000L, TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(c, "date is error, set connect interval = 15min");
            com.igexin.c.a.c.a.a("RNTT|date is error, set connect interval = 15min", new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("RNTT reconnect timer task isOnline = false, try login...", new Object[0]);
        if (System.currentTimeMillis() - this.f < 2500) {
            com.igexin.push.core.e.r++;
        }
        if (com.igexin.push.core.e.r > 30 && Math.abs(SystemClock.elapsedRealtime() - this.f7341a) < 72000.0d) {
            com.igexin.push.core.e.f.a();
            com.igexin.c.a.c.a.a(com.igexin.push.core.e.f.f7227a + "| found a duplicate cid " + com.igexin.push.core.e.A, new Object[0]);
            com.igexin.push.core.e.L = null;
            com.igexin.push.core.e.f.d();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass13(com.igexin.push.core.e.L), false, true);
            com.igexin.push.core.e.f.a().b();
            com.igexin.push.core.e.r = 0;
            g().f7341a = SystemClock.elapsedRealtime();
        }
        this.f = System.currentTimeMillis();
        k.a();
        k.b();
        a(1800000L, TimeUnit.MILLISECONDS);
    }

    private void c(long j) {
        this.f7341a = j;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }
}
