package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class r36 {
    public static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f20384a = new int[4];
    public final StringBuilder b = new StringBuilder();

    public static int c(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == c[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    public static String e(String str) {
        String str2;
        String strValueOf;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                if ("90000".equals(str)) {
                    return null;
                }
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
            }
        } else {
            str2 = "$";
        }
        int i = Integer.parseInt(str.substring(1));
        String strValueOf2 = String.valueOf(i / 100);
        int i2 = i % 100;
        if (i2 < 10) {
            strValueOf = "0" + i2;
        } else {
            strValueOf = String.valueOf(i2);
        }
        return str2 + strValueOf2 + '.' + strValueOf;
    }

    public static Map<ResultMetadataType, Object> f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, strE);
        return enumMap;
    }

    public int a(et etVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f20384a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = etVar.k();
        int iJ = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iJ < iK; i2++) {
            int i3 = t36.i(etVar, iArr2, iJ, t36.h);
            sb.append((char) ((i3 % 10) + 48));
            for (int i4 : iArr2) {
                iJ += i4;
            }
            if (i3 >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iJ = etVar.j(etVar.i(iJ));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb.toString()) == c(i)) {
            return iJ;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public qx4 b(int i, et etVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(etVar, iArr, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> mapF = f(string);
        float f = i;
        qx4 qx4Var = new qx4(string, null, new sx4[]{new sx4((iArr[0] + iArr[1]) / 2.0f, f), new sx4(iA, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapF != null) {
            qx4Var.h(mapF);
        }
        return qx4Var;
    }
}
