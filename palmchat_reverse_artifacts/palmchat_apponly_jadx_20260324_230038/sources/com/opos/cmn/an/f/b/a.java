package com.opos.cmn.an.f.b;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f7750a;
    private static volatile Boolean b;

    public static synchronized void a(boolean z) {
        b = Boolean.valueOf(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0007, B:8:0x000d, B:9:0x000f, B:11:0x0014, B:13:0x0024), top: B:25:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(Context context) {
        if (f7750a == null) {
            try {
                if (Build.VERSION.SDK_INT > 29) {
                    if (context != null) {
                        Boolean bool = Settings.Global.getInt(context.getApplicationContext().getContentResolver(), "oplus_customize_system_stable_plan_switch") == 0 ? Boolean.FALSE : Boolean.TRUE;
                        f7750a = bool;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (f7750a == null) {
            f7750a = Boolean.TRUE;
        }
        return f7750a.booleanValue();
    }

    public static synchronized boolean a(Context context) {
        if (Build.VERSION.SDK_INT <= 29) {
            return true;
        }
        if (b != null) {
            return b.booleanValue();
        }
        return b(context);
    }
}
