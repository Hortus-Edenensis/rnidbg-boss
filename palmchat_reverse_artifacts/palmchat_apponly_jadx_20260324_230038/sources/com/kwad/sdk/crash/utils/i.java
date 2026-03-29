package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i {
    private static SimpleDateFormat aVY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String aO(long j) {
        return j <= 0 ? "unknown" : aVY.format(new Date(j));
    }
}
