package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class on implements qo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f19797a = Charset.forName("ISO-8859-1");

    public static ht b(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(jm1.d(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    public static ht c(ln lnVar, int i, int i2) {
        ht htVarA = lnVar.a();
        if (htVarA == null) {
            throw new IllegalStateException();
        }
        int iK = htVarA.k();
        int iH = htVarA.h();
        int iMax = Math.max(i, iK);
        int iMax2 = Math.max(i2, iH);
        int iMin = Math.min(iMax / iK, iMax2 / iH);
        int i3 = (iMax - (iK * iMin)) / 2;
        int i4 = (iMax2 - (iH * iMin)) / 2;
        ht htVar = new ht(iMax, iMax2);
        int i5 = 0;
        while (i5 < iH) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < iK) {
                if (htVarA.e(i7, i5)) {
                    htVar.n(i6, i4, iMin, iMin);
                }
                i7++;
                i6 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return htVar;
    }

    @Override // defpackage.qo6
    public ht a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i3;
        int i4;
        Charset charsetForName = f19797a;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charsetForName = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int i5 = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charsetForName;
                i3 = i5;
                i4 = Integer.parseInt(map.get(encodeHintType3).toString());
                return b(str, barcodeFormat, i, i2, charset, i3, i4);
            }
            charset = charsetForName;
            i3 = i5;
        } else {
            charset = charsetForName;
            i3 = 33;
        }
        i4 = 0;
        return b(str, barcodeFormat, i, i2, charset, i3, i4);
    }
}
