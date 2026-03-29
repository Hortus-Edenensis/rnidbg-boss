package com.kwad.sdk.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class p {
    public static long bdV;
    public static long sLaunchTime;

    public static long RE() {
        return bdV - sLaunchTime;
    }

    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
    }

    public static void setInitStartTime(long j) {
        bdV = j;
    }

    public static void setLaunchTime(long j) {
        sLaunchTime = j;
    }
}
