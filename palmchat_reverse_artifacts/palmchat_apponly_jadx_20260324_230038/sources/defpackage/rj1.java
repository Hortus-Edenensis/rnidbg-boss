package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class rj1 extends u36 {
    @Override // defpackage.b84, defpackage.qo6
    public ht a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // defpackage.b84
    public boolean[] c(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        boolean[] zArr = new boolean[67];
        int iB = b84.b(zArr, 0, t36.d, true) + 0;
        int i = 0;
        while (i <= 3) {
            int i2 = i + 1;
            iB += b84.b(zArr, iB, t36.g[Integer.parseInt(str.substring(i, i2))], false);
            i = i2;
        }
        int iB2 = iB + b84.b(zArr, iB, t36.e, false);
        int i3 = 4;
        while (i3 <= 7) {
            int i4 = i3 + 1;
            iB2 += b84.b(zArr, iB2, t36.g[Integer.parseInt(str.substring(i3, i4))], true);
            i3 = i4;
        }
        b84.b(zArr, iB2, t36.d, true);
        return zArr;
    }
}
