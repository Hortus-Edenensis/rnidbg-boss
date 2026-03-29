package com.kwad.sdk.crash.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j {
    public static String aP(long j) {
        String strValueOf;
        String strValueOf2;
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        if (j2 < 10) {
            strValueOf = "0" + j2;
        } else {
            strValueOf = String.valueOf(j2);
        }
        if (j3 < 10) {
            strValueOf2 = "0" + j3;
        } else {
            strValueOf2 = String.valueOf(j3);
        }
        return strValueOf + ":" + strValueOf2;
    }
}
