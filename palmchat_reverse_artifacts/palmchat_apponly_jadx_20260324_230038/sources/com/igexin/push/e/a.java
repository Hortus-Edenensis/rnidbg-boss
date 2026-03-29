package com.igexin.push.e;

import com.igexin.c.a.c.a.d;
import com.igexin.c.a.d.f;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.d;
import com.igexin.push.core.e;
import com.igexin.push.core.j;
import com.igexin.push.core.l;
import com.igexin.push.d.c;
import com.igexin.push.d.c.c;
import com.igexin.push.d.c.i;
import com.igexin.push.g.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7328a = "com.igexin.push.e.a";
    public boolean b;

    private int a(String str, c cVar) {
        return a(str, cVar, false);
    }

    public static void c() {
        e.b(c.b.f7311a.e.a());
        com.igexin.push.f.b.e.g().a(e.O);
    }

    public static void d() {
        j.a().a(j.a.d);
        boolean zE = com.igexin.push.g.c.e();
        com.igexin.c.a.c.a.a(f7328a, "network changed, available = " + zE + ", last = " + e.n);
        com.igexin.c.a.c.a.a(f7328a + "|network changed, available = " + zE + ", last = " + e.n, new Object[0]);
        c.b.f7311a.a();
        if (!zE) {
            com.igexin.c.a.c.a.a(f7328a + "|network changed, available = false, do nothing", new Object[0]);
            a(false);
        } else if (!e.n) {
            com.igexin.c.a.c.a.a(f7328a + "|network changed, try connect reset delay", new Object[0]);
            g();
        }
        if (zE) {
            com.igexin.push.c.c.a().c();
        }
        e.n = zE;
    }

    public static boolean e() {
        return (e.p && e.s) ? false : true;
    }

    private boolean f() {
        return this.b;
    }

    private static void g() {
        com.igexin.c.a.c.a.a(f7328a + "|call -> tryConnect and reset delay = 0", new Object[0]);
        a(true);
    }

    private static void h() {
        com.igexin.push.d.a.c.b = -1;
        if (e.q) {
            com.igexin.c.a.c.a.a(f7328a, "isAppidWrong = true");
            com.igexin.c.a.c.a.a(f7328a + "|isAppidWrong = true", new Object[0]);
            d.a().a("isAppidWrong = true");
            return;
        }
        if (!g.a()) {
            com.igexin.c.a.c.a.a(f7328a, "so error ++++++++");
            com.igexin.c.a.c.a.a(f7328a + "|so error ++++++++", new Object[0]);
            return;
        }
        if (e.az) {
            c();
            return;
        }
        com.igexin.c.a.c.a.a(f7328a, "initSuccess = false");
        com.igexin.c.a.c.a.a(f7328a + "|initSuccess = false", new Object[0]);
    }

    private static void i() {
        com.igexin.push.c.c.a().d().c();
        com.igexin.push.c.a aVarD = com.igexin.push.c.c.a().d();
        j.a().a(j.a.c);
        aVarD.f();
        if (e()) {
            com.igexin.c.a.c.a.a(f7328a, "sdkOn = false or pushOn = false, disconnect|user");
            com.igexin.c.a.c.a.a(f7328a + "|sdkOn = false or pushOn = false, disconnect|user", new Object[0]);
        } else {
            com.igexin.c.a.c.a.a(f7328a + "|disconnect by network", new Object[0]);
        }
        com.igexin.c.a.d.e<f> eVar = com.igexin.c.a.b.e.a().s;
        if (eVar != null) {
            eVar.a(com.igexin.c.a.b.a.a.f.class);
        }
        a(false);
    }

    public final void b() {
        b(false);
        if (e.u) {
            e.u = false;
            l.a().b();
        }
        com.igexin.c.a.c.a.a(f7328a + "|stop by user", new Object[0]);
        com.igexin.push.c.c.a().d().f();
    }

    private void b(boolean z) {
        com.igexin.c.a.c.a.a(f7328a, "call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + e.O);
        com.igexin.c.a.c.a.a(f7328a + "|call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + e.O, new Object[0]);
        boolean z2 = this.b;
        if (z2 == z) {
            if (!z2 || e.u || e.O <= com.igexin.push.config.c.j) {
                return;
            }
            com.igexin.c.a.c.a.a(f7328a + "|start active again, online = false, reset delay", new Object[0]);
            e.b(0L);
            c();
            return;
        }
        this.b = z;
        if (z) {
            com.igexin.c.a.c.a.a(f7328a + "|active = true, start connect~~~~", new Object[0]);
            g();
            return;
        }
        com.igexin.c.a.c.a.a(f7328a + "|active = false, disconnect...", new Object[0]);
        a(true);
    }

    public final int a(String str, com.igexin.push.d.c.c cVar, boolean z) {
        if (str == null || cVar == null) {
            return -1;
        }
        if (!e.u && !(cVar instanceof com.igexin.push.d.c.g) && !(cVar instanceof i) && !(cVar instanceof com.igexin.push.d.c.d)) {
            com.igexin.c.a.c.a.a("networkLayer|sendData|not online|" + cVar.getClass().getName(), new Object[0]);
            return -3;
        }
        if (this.b) {
            if (z) {
                int i = com.igexin.push.config.d.f;
                if (com.igexin.c.a.b.e.a().a(SDKUrlConfig.getConnectAddress(), d.a.f7200a.g, cVar, i > 0 ? i : 10, new com.igexin.push.d.f()) == null) {
                    return -2;
                }
            } else if (com.igexin.c.a.b.e.a().a(SDKUrlConfig.getConnectAddress(), d.a.f7200a.g, cVar) == null) {
                return -2;
            }
        }
        return 0;
    }

    public final void a() {
        boolean z = e.p;
        boolean z2 = e.s;
        boolean zA = com.igexin.push.g.c.a();
        if (z && z2 && zA) {
            b(true);
        }
    }

    public static void a(int i) {
        if (i == com.igexin.c.a.b.a.a.j.f7041a) {
            com.igexin.c.a.b.e.a().a(new com.igexin.push.d.b.b());
            com.igexin.c.a.b.e.a().b();
        } else if (i == com.igexin.c.a.b.a.a.j.b) {
            com.igexin.c.a.b.e.a().a(new com.igexin.push.d.b.a());
            com.igexin.c.a.b.e.a().b();
        }
    }

    public static void a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return;
        }
        com.igexin.push.core.a.b.d().a(cVar);
    }

    public static void a(boolean z) {
        com.igexin.c.a.c.a.a(f7328a + "|call -> disconnect, reset delay = " + z, new Object[0]);
        if (z) {
            e.b(0L);
        }
        com.igexin.c.a.b.a.a.d.a().d();
    }
}
