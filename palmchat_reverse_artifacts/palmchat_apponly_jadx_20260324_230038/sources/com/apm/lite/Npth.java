package com.apm.lite;

import com.apm.lite.runtime.ConfigManager;
import defpackage.cg7;
import defpackage.x97;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Npth {
    private static boolean sInit;

    public static void checkInnerNpth(boolean z) {
        cg7.j(z);
    }

    public static void enableAnrInfo(boolean z) {
        cg7.g(z);
    }

    public static void enableNativeDump(boolean z) {
        cg7.m(z);
    }

    public static ConfigManager getConfigManager() {
        return x97.o();
    }

    public static boolean hasCrash() {
        return cg7.x();
    }

    public static boolean hasCrashWhenJavaCrash() {
        return cg7.y();
    }

    public static boolean hasCrashWhenNativeCrash() {
        return cg7.z();
    }

    public static boolean isANREnable() {
        return cg7.n();
    }

    public static boolean isInit() {
        return sInit;
    }

    public static boolean isJavaCrashEnable() {
        return cg7.k();
    }

    public static boolean isNativeCrashEnable() {
        return cg7.o();
    }

    public static boolean isStopUpload() {
        return cg7.A();
    }

    public static void openANRMonitor() {
        cg7.u();
    }

    public static void openJavaCrashMonitor() {
        cg7.s();
    }

    public static boolean openNativeCrashMonitor() {
        return cg7.w();
    }

    public static void stopUpload() {
        cg7.B();
    }
}
