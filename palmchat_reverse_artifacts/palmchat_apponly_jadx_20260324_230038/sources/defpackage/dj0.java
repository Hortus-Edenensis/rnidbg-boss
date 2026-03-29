package defpackage;

import java.util.Arrays;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class dj0 {
    public static Object a(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i);
    }

    public static int b(int i, int i2) {
        return i & (~i2);
    }

    public static int c(int i, int i2) {
        return i & i2;
    }

    public static int d(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    public static int e(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    public static int f(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i2;
        int i3;
        int iD = vg2.d(obj);
        int i4 = iD & i;
        int iH = h(obj3, i4);
        if (iH == 0) {
            return -1;
        }
        int iB = b(iD, i);
        int i5 = -1;
        while (true) {
            i2 = iH - 1;
            i3 = iArr[i2];
            if (b(i3, i) == iB && m54.a(obj, objArr[i2]) && (objArr2 == null || m54.a(obj2, objArr2[i2]))) {
                break;
            }
            int iC = c(i3, i);
            if (iC == 0) {
                return -1;
            }
            i5 = i2;
            iH = iC;
        }
        int iC2 = c(i3, i);
        if (i5 == -1) {
            i(obj3, i4, iC2);
        } else {
            iArr[i5] = d(iArr[i5], iC2, i);
        }
        return i2;
    }

    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int h(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & UByte.MAX_VALUE : obj instanceof short[] ? ((short[]) obj)[i] & UShort.MAX_VALUE : ((int[]) obj)[i];
    }

    public static void i(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    public static int j(int i) {
        return Math.max(4, vg2.a(i + 1, 1.0d));
    }
}
