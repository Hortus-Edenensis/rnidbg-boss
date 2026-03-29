package defpackage;

import androidx.media3.muxer.MuxerUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class w46 {
    public static int a(long j) {
        dm4.h((j >> 32) == 0, "out of range: %s", j);
        return (int) j;
    }

    public static int b(int i, int i2) {
        return ku2.f(d(i), d(i2));
    }

    public static int c(int i, int i2) {
        return (int) (g(i) / g(i2));
    }

    public static int d(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static int e(String str, int i) {
        dm4.o(str);
        long j = Long.parseLong(str, i);
        if ((MuxerUtil.UNSIGNED_INT_MAX_VALUE & j) == j) {
            return (int) j;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int f(int i, int i2) {
        return (int) (g(i) % g(i2));
    }

    public static long g(int i) {
        return ((long) i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }

    public static String h(int i, int i2) {
        return Long.toString(((long) i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE, i2);
    }
}
