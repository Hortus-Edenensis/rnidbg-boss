package com.ss.android.ttvecamera;

import android.os.Trace;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TETraceUtils {
    private static boolean sEnableTrace = false;

    public static void beginSection(String str) {
        if (sEnableTrace) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (sEnableTrace) {
            Trace.endSection();
        }
    }

    public static synchronized void init(boolean z) {
        sEnableTrace = z;
    }
}
