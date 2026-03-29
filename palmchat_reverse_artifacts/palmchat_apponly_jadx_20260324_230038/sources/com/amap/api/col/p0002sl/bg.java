package com.amap.api.col.p0002sl;

import java.util.Locale;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bg {
    private static bg b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2637a = "http://tm.amap.com";

    private bg() {
    }

    public static synchronized bg a() {
        if (b == null) {
            b = new bg();
        }
        return b;
    }

    public static String b() {
        int iNextInt = new Random(System.currentTimeMillis()).nextInt(100000) % 4;
        return (z.m == 2 ? String.format(Locale.US, "http://wprd0%d.is.autonavi.com", Integer.valueOf(iNextInt + 1)) : String.format(Locale.US, "http://webrd0%d.is.autonavi.com", Integer.valueOf(iNextInt + 1))) + z.a();
    }

    public static String d() {
        return "http://grid.amap.com/grid/%d/%d/%d?ds=" + z.i;
    }

    public static String e() {
        return String.format(Locale.US, "http://mst0%d.is.autonavi.com", Integer.valueOf((new Random(System.currentTimeMillis()).nextInt(100000) % 4) + 1));
    }

    public final String c() {
        return this.f2637a;
    }
}
