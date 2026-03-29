package defpackage;

import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class x46 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long[] f21875a = new long[37];
        public static final int[] b = new int[37];
        public static final int[] c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = i;
                f21875a[i] = x46.b(-1L, j);
                b[i] = (int) x46.e(-1L, j);
                c[i] = bigInteger.toString(i).length() - 1;
            }
        }

        public static boolean a(long j, int i, int i2) {
            if (j < 0) {
                return true;
            }
            long j2 = f21875a[i2];
            if (j < j2) {
                return false;
            }
            return j > j2 || i > b[i2];
        }
    }

    public static int a(long j, long j2) {
        return n73.d(c(j), c(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + ((long) (a(j - (j3 * j2), j2) < 0 ? 0 : 1));
    }

    public static long c(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static long d(String str, int i) {
        dm4.o(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        }
        int i2 = a.c[i] - 1;
        long j = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int iDigit = Character.digit(str.charAt(i3), i);
            if (iDigit == -1) {
                throw new NumberFormatException(str);
            }
            if (i3 > i2 && a.a(j, iDigit, i)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j = (j * ((long) i)) + ((long) iDigit);
        }
        return j;
    }

    public static long e(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (a(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static String f(long j) {
        return g(j, 10);
    }

    public static String g(long j, int i) {
        dm4.f(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= iNumberOfTrailingZeros;
            } while (j != 0);
        } else {
            long jB = (i & 1) == 0 ? (j >>> 1) / ((long) (i >>> 1)) : b(j, i);
            long j2 = i;
            int i4 = 63;
            cArr[63] = Character.forDigit((int) (j - (jB * j2)), i);
            while (jB > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (jB % j2), i);
                jB /= j2;
            }
            i2 = i4;
        }
        return new String(cArr, i2, 64 - i2);
    }
}
