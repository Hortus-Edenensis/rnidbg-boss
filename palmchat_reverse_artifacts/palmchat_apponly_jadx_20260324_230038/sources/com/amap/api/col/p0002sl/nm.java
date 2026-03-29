package com.amap.api.col.p0002sl;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class nm {
    private static long a(long j) {
        return j - b(j);
    }

    private static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long a(long j, long j2) {
        try {
            return Math.abs(j - j2) > 31536000000L ? b(j, j2) : j;
        } catch (Throwable unused) {
            return j;
        }
    }

    private static long b(long j, long j2) {
        long jB = b(j2) + a(j);
        long jAbs = Math.abs(jB - j2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(jB));
        int i = calendar.get(11);
        if (i == 23 && jAbs >= 82800000) {
            jB -= 86400000;
        }
        return (i != 0 || jAbs < 82800000) ? jB : jB + 86400000;
    }
}
