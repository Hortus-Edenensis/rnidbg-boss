package com.baidu.sec.privacy.b;

import android.content.Context;
import com.baidu.sec.privacy.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f4271a;
    public static boolean b;
    public static com.baidu.sec.privacy.a c;
    public static c d;
    public static boolean e;

    public static void a(Context context, String str, com.baidu.sec.privacy.a aVar) {
        c = aVar;
        a(context, str);
    }

    public static com.baidu.sec.privacy.a b() {
        return c;
    }

    public static c c() {
        return d;
    }

    public static boolean d() {
        return e;
    }

    public static void a(Context context, String str) {
        if (b) {
            return;
        }
        try {
            e = false;
            a(context, str, false, null);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    public static void a(Context context, String str, boolean z, c cVar) {
        if (b) {
            return;
        }
        try {
            b = true;
            f4271a = context.getApplicationContext();
            d = cVar;
            e = z;
            com.baidu.sec.privacy.d.b.a(str, z, cVar);
            com.baidu.sec.privacy.d.a.b(str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    public static a a(Context context) {
        return com.baidu.sec.privacy.e.a.a(context);
    }

    public static Context a() {
        return f4271a;
    }

    public static void a(boolean z) {
        try {
            com.baidu.sec.privacy.f.c.a(z);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }
}
