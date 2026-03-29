package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class k26 {
    public static int a(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static boolean b(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = -4; i5 <= 4; i5++) {
            int i6 = (i5 * 188) + i3;
            if (i6 < i || i6 >= i2 || bArr[i6] != 71) {
                i4 = 0;
            } else {
                i4++;
                if (i4 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(gc4 gc4Var, int i, int i2) {
        gc4Var.U(i);
        if (gc4Var.a() < 5) {
            return -9223372036854775807L;
        }
        int iQ = gc4Var.q();
        if ((8388608 & iQ) != 0 || ((2096896 & iQ) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((iQ & 32) != 0) && gc4Var.H() >= 7 && gc4Var.a() >= 7) {
            if ((gc4Var.H() & 16) == 16) {
                byte[] bArr = new byte[6];
                gc4Var.l(bArr, 0, 6);
                return d(bArr);
            }
        }
        return -9223372036854775807L;
    }

    public static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
