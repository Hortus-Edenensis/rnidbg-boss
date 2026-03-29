package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class pj1 extends u36 {
    @Override // defpackage.b84, defpackage.qo6
    public ht a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // defpackage.b84
    public boolean[] c(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
        try {
            if (!t36.h(str)) {
                throw new IllegalArgumentException("Contents do not pass checksum");
            }
            int i = oj1.j[Integer.parseInt(str.substring(0, 1))];
            boolean[] zArr = new boolean[95];
            int iB = b84.b(zArr, 0, t36.d, true) + 0;
            int i2 = 1;
            while (i2 <= 6) {
                int i3 = i2 + 1;
                int i4 = Integer.parseInt(str.substring(i2, i3));
                if (((i >> (6 - i2)) & 1) == 1) {
                    i4 += 10;
                }
                iB += b84.b(zArr, iB, t36.h[i4], false);
                i2 = i3;
            }
            int iB2 = iB + b84.b(zArr, iB, t36.e, false);
            int i5 = 7;
            while (i5 <= 12) {
                int i6 = i5 + 1;
                iB2 += b84.b(zArr, iB2, t36.g[Integer.parseInt(str.substring(i5, i6))], true);
                i5 = i6;
            }
            b84.b(zArr, iB2, t36.d, true);
            return zArr;
        } catch (FormatException unused) {
            throw new IllegalArgumentException("Illegal contents");
        }
    }
}
