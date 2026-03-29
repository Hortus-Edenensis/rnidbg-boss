package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MultiProcessFlag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10397a;
    private static boolean b;

    public static boolean isMultiProcess() {
        return f10397a;
    }

    public static void setMultiProcess(boolean z) {
        if (b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            b = true;
            f10397a = z;
        }
    }
}
