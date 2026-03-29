package com.unicom.online.account.kernel;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11173a = false;

    public static boolean a(Context context) {
        if (f11173a) {
            return true;
        }
        Long lB = ae.b(context, "success_limit_time");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (lB == null) {
            ae.a(context, "success_limit_time", Long.valueOf(jCurrentTimeMillis));
            return true;
        }
        if (jCurrentTimeMillis - lB.longValue() > 600000) {
            ae.a(context, "success_limit_time", Long.valueOf(jCurrentTimeMillis));
            ae.a(context, "success_limit_count", (Long) 0L);
            return true;
        }
        Long lB2 = ae.b(context, "success_limit_count");
        if (lB2 != null) {
            return lB2.longValue() <= 50;
        }
        ae.a(context, "success_limit_count", (Long) 0L);
        return true;
    }

    public static void b(Context context) {
        Long lB = ae.b(context, "success_limit_count");
        ae.a(context, "success_limit_count", Long.valueOf(lB == null ? 0L : lB.longValue() + 1));
    }

    public static boolean c(Context context) {
        if (f11173a) {
            return true;
        }
        Long lB = ae.b(context, "failed_limit_time");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (lB == null) {
            ae.a(context, "failed_limit_time", Long.valueOf(jCurrentTimeMillis));
            return true;
        }
        if (jCurrentTimeMillis - lB.longValue() > 600000) {
            ae.a(context, "failed_limit_time", Long.valueOf(jCurrentTimeMillis));
            ae.a(context, "count_limit_count", (Long) 0L);
            return true;
        }
        Long lB2 = ae.b(context, "count_limit_count");
        if (lB2 != null) {
            return lB2.longValue() <= 50;
        }
        ae.a(context, "count_limit_count", (Long) 0L);
        return true;
    }

    public static void d(Context context) {
        Long lB = ae.b(context, "count_limit_count");
        ae.a(context, "count_limit_count", Long.valueOf(lB == null ? 0L : lB.longValue() + 1));
    }
}
