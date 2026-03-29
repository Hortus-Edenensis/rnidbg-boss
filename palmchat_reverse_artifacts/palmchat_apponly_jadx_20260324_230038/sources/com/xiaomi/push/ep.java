package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f11549a = ei.PING_RTT.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f398a = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Hashtable<Integer, Long> f11550a = new Hashtable<>();
    }

    public static void a(String str, Exception exc) {
        try {
            em.a aVarB = em.b(exc);
            ej ejVarM408a = eo.m406a().m408a();
            ejVarM408a.a(aVarB.f11544a.a());
            ejVarM408a.c(aVarB.f387a);
            ejVarM408a.b(str);
            if (eo.a() != null && eo.a().f390a != null) {
                ejVarM408a.c(au.b(eo.a().f390a) ? 1 : 0);
            }
            eo.m406a().a(ejVarM408a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b(String str, Exception exc) {
        try {
            em.a aVarD = em.d(exc);
            ej ejVarM408a = eo.m406a().m408a();
            ejVarM408a.a(aVarD.f11544a.a());
            ejVarM408a.c(aVarD.f387a);
            ejVarM408a.b(str);
            if (eo.a() != null && eo.a().f390a != null) {
                ejVarM408a.c(au.b(eo.a().f390a) ? 1 : 0);
            }
            eo.m406a().a(ejVarM408a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, int i, Exception exc) {
        ej ejVarM408a = eo.m406a().m408a();
        if (eo.a() != null && eo.a().f390a != null) {
            ejVarM408a.c(au.b(eo.a().f390a) ? 1 : 0);
        }
        if (i > 0) {
            ejVarM408a.a(ei.GSLB_REQUEST_SUCCESS.a());
            ejVarM408a.b(str);
            ejVarM408a.b(i);
            eo.m406a().a(ejVarM408a);
            return;
        }
        try {
            em.a aVarA = em.a(exc);
            ejVarM408a.a(aVarA.f11544a.a());
            ejVarM408a.c(aVarA.f387a);
            ejVarM408a.b(str);
            eo.m406a().a(ejVarM408a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, f11549a, null, -1);
    }

    public static void a(XMPushService xMPushService, am.b bVar) {
        new el(xMPushService, bVar).a();
    }

    public static synchronized void a(int i, int i2) {
        if (i2 < 16777215) {
            a.f11550a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
        }
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i4 = (i << 24) | i2;
        if (a.f11550a.containsKey(Integer.valueOf(i4))) {
            ej ejVarM408a = eo.m406a().m408a();
            ejVarM408a.a(i2);
            ejVarM408a.b((int) (jCurrentTimeMillis - a.f11550a.get(Integer.valueOf(i4)).longValue()));
            ejVarM408a.b(str);
            if (i3 > -1) {
                ejVarM408a.c(i3);
            }
            eo.m406a().a(ejVarM408a);
            a.f11550a.remove(Integer.valueOf(i2));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
        }
    }

    public static void a() {
        if (f398a == 0 || SystemClock.elapsedRealtime() - f398a > com.heytap.mcssdk.constant.a.n) {
            f398a = SystemClock.elapsedRealtime();
            a(0, f11549a);
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ej ejVarM408a = eo.m406a().m408a();
        ejVarM408a.a((byte) i);
        ejVarM408a.a(i2);
        ejVarM408a.b(i3);
        ejVarM408a.b(str);
        ejVarM408a.c(i4);
        eo.m406a().a(ejVarM408a);
    }

    public static void a(int i) {
        ej ejVarM408a = eo.m406a().m408a();
        ejVarM408a.a(ei.CHANNEL_STATS_COUNTER.a());
        ejVarM408a.c(i);
        eo.m406a().a(ejVarM408a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m412a() {
        ek ekVarM409a = eo.m406a().m409a();
        if (ekVarM409a != null) {
            return hp.a(ekVarM409a);
        }
        return null;
    }
}
