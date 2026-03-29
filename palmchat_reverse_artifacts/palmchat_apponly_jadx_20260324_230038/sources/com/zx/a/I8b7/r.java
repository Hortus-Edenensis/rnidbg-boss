package com.zx.a.I8b7;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f16851a = true;

    public static void a(String str) {
        if (f16851a) {
            StringBuilder sbA = f3.a("--- ");
            sbA.append(str == null ? com.igexin.push.core.b.m : str);
            sbA.append(" ---");
            Log.d("zx-DebugMode", sbA.toString());
        }
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        r2.a(str);
    }

    public static void b(String str) {
        if (f16851a) {
            StringBuilder sbA = f3.a("--- ");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sbA.append(str);
            sbA.append(" ---");
            Log.e("zx-DebugMode", sbA.toString());
        }
    }
}
