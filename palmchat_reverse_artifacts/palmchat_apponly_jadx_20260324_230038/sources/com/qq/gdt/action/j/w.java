package com.qq.gdt.action.j;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Long f10539a;

    public static void a(long j) {
        if (j <= 0 || a()) {
            return;
        }
        f10539a = Long.valueOf(j - SystemClock.elapsedRealtime());
    }

    public static long b() {
        if (a()) {
            return SystemClock.elapsedRealtime() + f10539a.longValue();
        }
        return -1L;
    }

    public static boolean a() {
        return f10539a != null;
    }
}
