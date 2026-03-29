package com.opos.cmn.a;

import android.text.TextUtils;
import defpackage.g23;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f7731a = new AtomicBoolean(false);
    private static volatile boolean b = false;
    private static AtomicReference<String> c = new AtomicReference<>(null);
    private static AtomicBoolean d = new AtomicBoolean(false);

    public static void a(boolean z, String str) {
        if (f7731a.compareAndSet(false, true)) {
            b = z;
        }
        g23.a(c, null, str);
    }

    public static String b() {
        String str = c.get();
        return TextUtils.isEmpty(str) ? "CN" : str;
    }

    public static void c() {
        d.compareAndSet(false, true);
    }

    public static boolean a() {
        a(false, "CN");
        return b;
    }
}
