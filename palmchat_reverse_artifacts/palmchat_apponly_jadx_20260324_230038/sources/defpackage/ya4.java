package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ya4 implements qo6 {
    public static ht b(pa4 pa4Var, String str, int i, int i2, int i3, int i4) throws WriterException {
        boolean z;
        pa4Var.e(str, i);
        byte[][] bArrB = pa4Var.f().b(1, 4);
        if ((i3 > i2) ^ (bArrB[0].length < bArrB.length)) {
            bArrB = d(bArrB);
            z = true;
        } else {
            z = false;
        }
        int length = i2 / bArrB[0].length;
        int length2 = i3 / bArrB.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return c(bArrB, i4);
        }
        byte[][] bArrB2 = pa4Var.f().b(length, length << 2);
        if (z) {
            bArrB2 = d(bArrB2);
        }
        return c(bArrB2, i4);
    }

    public static ht c(byte[][] bArr, int i) {
        int i2 = i * 2;
        ht htVar = new ht(bArr[0].length + i2, bArr.length + i2);
        htVar.a();
        int iH = (htVar.h() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr[i3][i4] == 1) {
                    htVar.m(i4 + i, iH);
                }
            }
            i3++;
            iH--;
        }
        return htVar;
    }

    public static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    @Override // defpackage.qo6
    public ht a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        int i3;
        int i4;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        pa4 pa4Var = new pa4();
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                pa4Var.h(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                pa4Var.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                id1 id1Var = (id1) map.get(encodeHintType3);
                pa4Var.j(id1Var.a(), id1Var.c(), id1Var.b(), id1Var.d());
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            int i5 = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            int i6 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                pa4Var.k(Charset.forName(map.get(encodeHintType6).toString()));
            }
            i4 = i5;
            i3 = i6;
        } else {
            i3 = 2;
            i4 = 30;
        }
        return b(pa4Var, str, i3, i, i2, i4);
    }
}
