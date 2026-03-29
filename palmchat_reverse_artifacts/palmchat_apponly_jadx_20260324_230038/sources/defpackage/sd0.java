package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class sd0 extends a84 {
    public static final char[] d = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    public static final char[] f = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f20716a = new StringBuilder(20);
    public int[] b = new int[80];
    public int c = 0;

    public static boolean g(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.a84
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.b, 0);
        j(etVar);
        int i2 = i();
        this.f20716a.setLength(0);
        int i3 = i2;
        do {
            int iK = k(i3);
            if (iK == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.f20716a.append((char) iK);
            i3 += 8;
            if (this.f20716a.length() > 1 && g(f, d[iK])) {
                break;
            }
        } while (i3 < this.c);
        int i4 = i3 - 1;
        int i5 = this.b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.b[i3 + i7];
        }
        if (i3 < this.c && i5 < i6 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        l(i2);
        for (int i8 = 0; i8 < this.f20716a.length(); i8++) {
            StringBuilder sb = this.f20716a;
            sb.setCharAt(i8, d[sb.charAt(i8)]);
        }
        char cCharAt = this.f20716a.charAt(0);
        char[] cArr = f;
        if (!g(cArr, cCharAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = this.f20716a;
        if (!g(cArr, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.f20716a.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f20716a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f20716a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            i9 += this.b[i10];
        }
        float f2 = i9;
        while (i2 < i4) {
            i9 += this.b[i2];
            i2++;
        }
        float f3 = i;
        return new qx4(this.f20716a.toString(), null, new sx4[]{new sx4(f2, f3), new sx4(i9, f3)}, BarcodeFormat.CODABAR);
    }

    public final void h(int i) {
        int[] iArr = this.b;
        int i2 = this.c;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.b = iArr2;
        }
    }

    public final int i() throws NotFoundException {
        for (int i = 1; i < this.c; i += 2) {
            int iK = k(i);
            if (iK != -1 && g(f, d[iK])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.b[i3];
                }
                if (i == 1 || this.b[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void j(et etVar) throws NotFoundException {
        int i = 0;
        this.c = 0;
        int iJ = etVar.j(0);
        int iK = etVar.k();
        if (iJ >= iK) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = true;
        while (iJ < iK) {
            if (etVar.g(iJ) ^ z) {
                i++;
            } else {
                h(i);
                z = !z;
                i = 1;
            }
            iJ++;
        }
        h(i);
    }

    public final int k(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }

    public void l(int i) throws NotFoundException {
        int i2 = 0;
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f20716a.length() - 1;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = e[this.f20716a.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) << 1);
                iArr[i7] = iArr[i7] + this.b[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            int i10 = iArr[i9];
            int i11 = iArr2[i9];
            float f2 = ((iArr[i8] / iArr2[i8]) + (i10 / i11)) / 2.0f;
            fArr2[i9] = f2;
            fArr[i8] = f2;
            fArr[i9] = ((i10 * 2.0f) + 1.5f) / i11;
        }
        loop3: while (true) {
            int i12 = e[this.f20716a.charAt(i2)];
            for (int i13 = 6; i13 >= 0; i13--) {
                int i14 = (i13 & 1) + ((i12 & 1) << 1);
                float f3 = this.b[i + i13];
                if (f3 < fArr2[i14] || f3 > fArr[i14]) {
                    break loop3;
                }
                i12 >>= 1;
            }
            if (i2 >= length) {
                return;
            }
            i += 8;
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
