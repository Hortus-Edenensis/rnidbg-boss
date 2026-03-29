package defpackage;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e10 {
    public static char a(long j) {
        char c = (char) j;
        dm4.h(((long) c) == j, "Out of range: %s", j);
        return c;
    }

    public static boolean b(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static char c(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & UByte.MAX_VALUE));
    }
}
