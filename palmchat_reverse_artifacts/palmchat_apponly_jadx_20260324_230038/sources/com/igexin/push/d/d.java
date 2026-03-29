package com.igexin.push.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7327a = "NormalModel";

    @Override // com.igexin.push.d.b
    public final long a() {
        long j;
        boolean zA = com.igexin.push.g.c.a();
        com.igexin.push.core.e.n = com.igexin.push.g.c.e();
        com.igexin.c.a.c.a.a("NormalModel|isSdkOn = " + com.igexin.push.core.e.p + " isPushOn = " + com.igexin.push.core.e.s + " isBlockEndTime = " + zA + " isNetworkAvailable = " + com.igexin.push.core.e.n, new Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.s || !zA) {
            com.igexin.c.a.c.a.a(f7327a, "reconnect stop, interval= 20min ++++++");
            com.igexin.c.a.c.a.a("NormalModel|reconnect stop, interval= 20min ++++", new Object[0]);
            return 1200000L;
        }
        long j2 = com.igexin.push.core.e.O;
        if (j2 <= 0) {
            j = 1;
        } else {
            j = j2 + (j2 <= 300 ? 150L : j2 <= 10000 ? 500L : j2 <= 30000 ? com.igexin.push.config.c.j : 120000L);
        }
        com.igexin.push.core.e.O = j;
        if (com.igexin.push.core.e.O > 1200000) {
            com.igexin.push.core.e.O = 1200000L;
        }
        long j3 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("NormalModel|after add auto reconnect delay time = ".concat(String.valueOf(j3)), new Object[0]);
        return j3;
    }
}
