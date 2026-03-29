package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class q36 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f20173a = new int[4];
    public final StringBuilder b = new StringBuilder();

    public static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    public int a(et etVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f20173a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = etVar.k();
        int iJ = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iJ < iK; i2++) {
            int i3 = t36.i(etVar, iArr2, iJ, t36.h);
            sb.append((char) ((i3 % 10) + 48));
            for (int i4 : iArr2) {
                iJ += i4;
            }
            if (i3 >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iJ = etVar.j(etVar.i(iJ));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i) {
            return iJ;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public qx4 b(int i, et etVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(etVar, iArr, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> mapC = c(string);
        float f = i;
        qx4 qx4Var = new qx4(string, null, new sx4[]{new sx4((iArr[0] + iArr[1]) / 2.0f, f), new sx4(iA, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapC != null) {
            qx4Var.h(mapC);
        }
        return qx4Var;
    }
}
