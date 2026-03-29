package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11487a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f228a = true;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    public static void b(final Context context, final long j, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.j(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("PowerStatsSP onReceiveMsg exception: " + e.getMessage());
                }
            }
        });
    }

    public static void c(final Context context, final long j, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.k(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("PowerStatsSP onPing exception: " + e.getMessage());
                }
            }
        });
    }

    public static void d(final Context context, final long j, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.l(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("PowerStatsSP onPong exception: " + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(Context context, long j, boolean z) {
        int i;
        ct.a("recordSendMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM282a = m282a(context);
        long j2 = sharedPreferencesM282a.getLong(com.umeng.analytics.pro.f.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM282a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM282a.getInt("on_up_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("on_up_count", i).apply();
        } else {
            i = sharedPreferencesM282a.getInt("off_up_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("off_up_count", i).apply();
        }
        a(context, j2, j, i, iA);
        ct.a("recordSendMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j(Context context, long j, boolean z) {
        int i;
        ct.a("recordReceiveMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM282a = m282a(context);
        long j2 = sharedPreferencesM282a.getLong(com.umeng.analytics.pro.f.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM282a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM282a.getInt("on_down_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("on_down_count", i).apply();
        } else {
            i = sharedPreferencesM282a.getInt("off_down_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("off_down_count", i).apply();
        }
        a(context, j2, j, i, iA);
        ct.a("recordReceiveMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context, long j, boolean z) {
        int i;
        ct.a("recordPing start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM282a = m282a(context);
        long j2 = sharedPreferencesM282a.getLong(com.umeng.analytics.pro.f.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM282a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM282a.getInt("on_ping_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("on_ping_count", i).apply();
        } else {
            i = sharedPreferencesM282a.getInt("off_ping_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("off_ping_count", i).apply();
        }
        a(context, j2, j, i, iA);
        ct.a("recordPing complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context, long j, boolean z) {
        int i;
        ct.a("recordPong start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM282a = m282a(context);
        long j2 = sharedPreferencesM282a.getLong(com.umeng.analytics.pro.f.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM282a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM282a.getInt("on_pong_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("on_pong_count", i).apply();
        } else {
            i = sharedPreferencesM282a.getInt("off_pong_count", 0) + 1;
            sharedPreferencesM282a.edit().putInt("off_pong_count", i).apply();
        }
        a(context, j2, j, i, iA);
        ct.a("recordPong complete");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m282a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    private static void b(Context context, long j, int i) {
        ct.a("reset");
        m282a(context).edit().clear().putLong(com.umeng.analytics.pro.f.p, j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    public static void a(final Context context, final long j, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.i(context, j, z);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("PowerStatsSP onSendMsg exception: " + e.getMessage());
                }
            }
        });
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j, int i) {
        ct.a("recordInit");
        sharedPreferences.edit().putLong(com.umeng.analytics.pro.f.p, j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j, long j2, int i, int i2) {
        if (j > 0) {
            if (m284a(context) || i >= 1073741823 || j2 - j >= 86400000) {
                m282a(context).edit().putLong(com.umeng.analytics.pro.f.q, j2).apply();
                a(context, j2, i2);
            }
        }
    }

    private static void a(Context context, long j, int i) {
        ct.a("upload");
        new cv().a(context, m283a(context));
        b(context, j, i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static cu m283a(Context context) {
        SharedPreferences sharedPreferencesM282a = m282a(context);
        cu cuVar = new cu();
        cuVar.a(sharedPreferencesM282a.getInt("off_up_count", 0));
        cuVar.b(sharedPreferencesM282a.getInt("off_down_count", 0));
        cuVar.c(sharedPreferencesM282a.getInt("off_ping_count", 0));
        cuVar.d(sharedPreferencesM282a.getInt("off_pong_count", 0));
        cuVar.a(sharedPreferencesM282a.getLong("off_duration", 0L));
        cuVar.e(sharedPreferencesM282a.getInt("on_up_count", 0));
        cuVar.f(sharedPreferencesM282a.getInt("on_down_count", 0));
        cuVar.g(sharedPreferencesM282a.getInt("on_ping_count", 0));
        cuVar.h(sharedPreferencesM282a.getInt("on_pong_count", 0));
        cuVar.b(sharedPreferencesM282a.getLong("on_duration", 0L));
        cuVar.c(sharedPreferencesM282a.getLong(com.umeng.analytics.pro.f.p, 0L));
        cuVar.d(sharedPreferencesM282a.getLong(com.umeng.analytics.pro.f.q, 0L));
        cuVar.i(sharedPreferencesM282a.getInt("xmsf_vc", 0));
        cuVar.j(sharedPreferencesM282a.getInt("android_vc", 0));
        return cuVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m284a(Context context) {
        boolean z = false;
        if (f228a) {
            f228a = false;
            SharedPreferences sharedPreferencesM282a = m282a(context);
            int i = sharedPreferencesM282a.getInt("xmsf_vc", 0);
            int i2 = sharedPreferencesM282a.getInt("android_vc", 0);
            if (i != 0 && i2 != 0 && (i != a(context) || i2 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        ct.a("isVcChanged = " + z);
        return z;
    }

    private static int a(Context context) {
        if (f11487a <= 0) {
            f11487a = j.b(context);
        }
        return f11487a;
    }
}
