package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class t36 extends a84 {
    public static final int[] d = {1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1};
    public static final int[] f = {1, 1, 1, 1, 1, 1};
    public static final int[][] g;
    public static final int[][] h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f20895a = new StringBuilder(20);
    public final s36 b = new s36();
    public final sj1 c = new sj1();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        g = iArr;
        int[][] iArr2 = new int[20][];
        h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = g[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            h[i] = iArr4;
        }
    }

    public static boolean h(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += iCharAt2;
        }
        return i3 % 10 == 0;
    }

    public static int i(et etVar, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        a84.e(etVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fD = a84.d(iArr, iArr2[i3], 0.7f);
            if (fD < f2) {
                i2 = i3;
                f2 = fD;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] m(et etVar, int i, boolean z, int[] iArr) throws NotFoundException {
        return n(etVar, i, z, iArr, new int[iArr.length]);
    }

    public static int[] n(et etVar, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int length = iArr.length;
        int iK = etVar.k();
        int iJ = z ? etVar.j(i) : etVar.i(i);
        boolean z2 = z;
        int i2 = 0;
        int i3 = iJ;
        while (iJ < iK) {
            if (etVar.g(iJ) ^ z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                int i4 = length - 1;
                if (i2 != i4) {
                    i2++;
                } else {
                    if (a84.d(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, iJ};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iJ++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] o(et etVar) throws NotFoundException {
        int[] iArr = new int[d.length];
        int[] iArrN = null;
        boolean zM = false;
        int i = 0;
        while (!zM) {
            int[] iArr2 = d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrN = n(etVar, i, false, iArr2, iArr);
            int i2 = iArrN[0];
            int i3 = iArrN[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zM = etVar.m(i4, i2, false);
            }
            i = i3;
        }
        return iArrN;
    }

    @Override // defpackage.a84
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return l(i, etVar, o(etVar), map);
    }

    public boolean g(String str) throws FormatException {
        return h(str);
    }

    public int[] j(et etVar, int i) throws NotFoundException {
        return m(etVar, i, false, d);
    }

    public abstract int k(et etVar, int[] iArr, StringBuilder sb) throws NotFoundException;

    public qx4 l(int i, et etVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strC;
        tx4 tx4Var = map == null ? null : (tx4) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (tx4Var != null) {
            tx4Var.a(new sx4((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f20895a;
        sb.setLength(0);
        int iK = k(etVar, iArr, sb);
        if (tx4Var != null) {
            tx4Var.a(new sx4(iK, i));
        }
        int[] iArrJ = j(etVar, iK);
        if (tx4Var != null) {
            tx4Var.a(new sx4((iArrJ[0] + iArrJ[1]) / 2.0f, i));
        }
        int i2 = iArrJ[1];
        int i3 = (i2 - iArrJ[0]) + i2;
        if (i3 >= etVar.k() || !etVar.m(i2, i3, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!g(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat barcodeFormatP = p();
        float f2 = i;
        qx4 qx4Var = new qx4(string, null, new sx4[]{new sx4((iArr[1] + iArr[0]) / 2.0f, f2), new sx4((iArrJ[1] + iArrJ[0]) / 2.0f, f2)}, barcodeFormatP);
        try {
            qx4 qx4VarA = this.b.a(i, etVar, iArrJ[1]);
            qx4Var.i(ResultMetadataType.UPC_EAN_EXTENSION, qx4VarA.g());
            qx4Var.h(qx4VarA.e());
            qx4Var.a(qx4VarA.f());
            length = qx4VarA.g().length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z = false;
                    break;
                }
                if (length == iArr2[i4]) {
                    break;
                }
                i4++;
            }
            if (!z) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if ((barcodeFormatP == BarcodeFormat.EAN_13 || barcodeFormatP == BarcodeFormat.UPC_A) && (strC = this.c.c(string)) != null) {
            qx4Var.i(ResultMetadataType.POSSIBLE_COUNTRY, strC);
        }
        return qx4Var;
    }

    public abstract BarcodeFormat p();
}
