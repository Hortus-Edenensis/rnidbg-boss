package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11412a = false;

    private static void a(Class<?> cls, Context context) {
        if (f11412a) {
            return;
        }
        try {
            f11412a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m74a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> clsA = C1401r.a(context, "com.bun.miitmdid.core.JLibrary");
            if (clsA == null) {
                return false;
            }
            a(clsA, context);
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m74a("mdid:check error " + th);
            return false;
        }
    }
}
