package com.baidu.mshield.b.a;

import android.content.Context;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static String a(Context context) {
        try {
            return com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            if (!com.baidu.sec.privacy.f.e.a(context, new String[]{com.kuaishou.weapon.p0.g.b})) {
                return true;
            }
            NetworkInfo networkInfoA = com.baidu.mshield.b.e.b.a(context);
            if (networkInfoA == null) {
                return false;
            }
            return networkInfoA.isConnected();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return false;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo networkInfoA;
        try {
            if (!com.baidu.sec.privacy.f.e.a(context, new String[]{com.kuaishou.weapon.p0.g.b}) || (networkInfoA = com.baidu.mshield.b.e.b.a(context)) == null) {
                return false;
            }
            return 1 == networkInfoA.getType();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        return false;
    }
}
