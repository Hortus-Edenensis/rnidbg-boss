package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ce3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f1965a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, -1}, new int[]{6, 34, 62, 90, 118, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 170}};
    public static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(et etVar, ErrorCorrectionLevel errorCorrectionLevel, t96 t96Var, int i, tv tvVar) throws WriterException {
        c(tvVar);
        d(t96Var, tvVar);
        l(errorCorrectionLevel, i, tvVar);
        s(t96Var, tvVar);
        f(etVar, i, tvVar);
    }

    public static int b(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i2);
        int iN2 = i << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i2 << (n(iN2) - iN);
        }
        return iN2;
    }

    public static void c(tv tvVar) {
        tvVar.a((byte) -1);
    }

    public static void d(t96 t96Var, tv tvVar) throws WriterException {
        j(tvVar);
        e(tvVar);
        r(t96Var, tvVar);
        k(tvVar);
    }

    public static void e(tv tvVar) throws WriterException {
        if (tvVar.b(8, tvVar.d() - 8) == 0) {
            throw new WriterException();
        }
        tvVar.f(8, tvVar.d() - 8, 1);
    }

    public static void f(et etVar, int i, tv tvVar) throws WriterException {
        boolean zG;
        int iE = tvVar.e() - 1;
        int iD = tvVar.d() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < tvVar.d()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = iE - i4;
                    if (o(tvVar.b(i5, iD))) {
                        if (i2 < etVar.k()) {
                            zG = etVar.g(i2);
                            i2++;
                        } else {
                            zG = false;
                        }
                        if (i != -1 && jd3.f(i, i5, iD)) {
                            zG = !zG;
                        }
                        tvVar.g(i5, iD, zG);
                    }
                }
                iD += i3;
            }
            i3 = -i3;
            iD += i3;
            iE -= 2;
        }
        if (i2 == etVar.k()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + '/' + etVar.k());
    }

    public static void g(int i, int i2, tv tvVar) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!o(tvVar.b(i4, i2))) {
                throw new WriterException();
            }
            tvVar.f(i4, i2, 0);
        }
    }

    public static void h(int i, int i2, tv tvVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                tvVar.f(i + i4, i2 + i3, b[i3][i4]);
            }
        }
    }

    public static void i(int i, int i2, tv tvVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                tvVar.f(i + i4, i2 + i3, f1965a[i3][i4]);
            }
        }
    }

    public static void j(tv tvVar) throws WriterException {
        int length = f1965a[0].length;
        i(0, 0, tvVar);
        i(tvVar.e() - length, 0, tvVar);
        i(0, tvVar.e() - length, tvVar);
        g(0, 7, tvVar);
        g(tvVar.e() - 8, 7, tvVar);
        g(0, tvVar.e() - 8, tvVar);
        m(7, 0, tvVar);
        m((tvVar.d() - 7) - 1, 0, tvVar);
        m(7, tvVar.d() - 7, tvVar);
    }

    public static void k(tv tvVar) {
        int i = 8;
        while (i < tvVar.e() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (o(tvVar.b(i, 6))) {
                tvVar.f(i, 6, i3);
            }
            if (o(tvVar.b(6, i))) {
                tvVar.f(6, i, i3);
            }
            i = i2;
        }
    }

    public static void l(ErrorCorrectionLevel errorCorrectionLevel, int i, tv tvVar) throws WriterException {
        et etVar = new et();
        p(errorCorrectionLevel, i, etVar);
        for (int i2 = 0; i2 < etVar.k(); i2++) {
            boolean zG = etVar.g((etVar.k() - 1) - i2);
            int[] iArr = d[i2];
            tvVar.g(iArr[0], iArr[1], zG);
            if (i2 < 8) {
                tvVar.g((tvVar.e() - i2) - 1, 8, zG);
            } else {
                tvVar.g(8, (tvVar.d() - 7) + (i2 - 8), zG);
            }
        }
    }

    public static void m(int i, int i2, tv tvVar) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!o(tvVar.b(i, i4))) {
                throw new WriterException();
            }
            tvVar.f(i, i4, 0);
        }
    }

    public static int n(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean o(int i) {
        return i == -1;
    }

    public static void p(ErrorCorrectionLevel errorCorrectionLevel, int i, et etVar) throws WriterException {
        if (!kp4.b(i)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i;
        etVar.c(bits, 5);
        etVar.c(b(bits, 1335), 10);
        et etVar2 = new et();
        etVar2.c(21522, 15);
        etVar.s(etVar2);
        if (etVar.k() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + etVar.k());
    }

    public static void q(t96 t96Var, et etVar) throws WriterException {
        etVar.c(t96Var.j(), 6);
        etVar.c(b(t96Var.j(), 7973), 12);
        if (etVar.k() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + etVar.k());
    }

    public static void r(t96 t96Var, tv tvVar) {
        if (t96Var.j() < 2) {
            return;
        }
        int[] iArr = c[t96Var.j() - 1];
        for (int i : iArr) {
            for (int i2 : iArr) {
                if (i2 != -1 && i != -1 && o(tvVar.b(i2, i))) {
                    h(i2 - 2, i - 2, tvVar);
                }
            }
        }
    }

    public static void s(t96 t96Var, tv tvVar) throws WriterException {
        if (t96Var.j() < 7) {
            return;
        }
        et etVar = new et();
        q(t96Var, etVar);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean zG = etVar.g(i);
                i--;
                tvVar.g(i2, (tvVar.d() - 11) + i3, zG);
                tvVar.g((tvVar.d() - 11) + i3, i2, zG);
            }
        }
    }
}
