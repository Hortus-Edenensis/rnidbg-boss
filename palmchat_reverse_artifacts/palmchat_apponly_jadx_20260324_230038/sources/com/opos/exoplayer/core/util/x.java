package com.opos.exoplayer.core.util;

import android.annotation.TargetApi;
import android.os.Trace;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class x {
    public static void a() {
        if (y.f8407a >= 18) {
            b();
        }
    }

    @TargetApi(18)
    private static void b() {
        Trace.endSection();
    }

    public static void a(String str) {
        if (y.f8407a >= 18) {
            b(str);
        }
    }

    @TargetApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }
}
