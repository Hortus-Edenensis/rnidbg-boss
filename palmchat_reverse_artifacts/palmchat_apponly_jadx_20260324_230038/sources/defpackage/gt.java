package defpackage;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.IOException;
import java.util.EnumMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gt {
    public static ht a(ht htVar) {
        int[] iArrG = htVar.g();
        int i = iArrG[2] + 1;
        int i2 = iArrG[3] + 1;
        ht htVar2 = new ht(i, i2);
        htVar2.a();
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (htVar.e(iArrG[0] + i3, iArrG[1] + i4)) {
                    htVar2.m(i3, i4);
                }
            }
        }
        return htVar2;
    }

    public static Bitmap b(String str, int i) throws WriterException {
        int i2 = i < 400 ? 1 : 4;
        int i3 = i / i2;
        BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
        if (str == null) {
            return null;
        }
        String strF = f(str);
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        if (strF != null) {
            enumMap.put(EncodeHintType.CHARACTER_SET, strF);
        }
        enumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        enumMap.put(EncodeHintType.MARGIN, 0);
        ht htVarA = new ns3().a(str, barcodeFormat, i3, i3, enumMap);
        int iK = htVarA.k();
        int iH = htVarA.h();
        int[] iArr = new int[iK * iH];
        for (int i4 = 0; i4 < iH; i4++) {
            int i5 = i4 * iK;
            for (int i6 = 0; i6 < iK; i6++) {
                iArr[i5 + i6] = htVarA.e(i6, i4) ? -16777216 : -1;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iK, iH, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, iK, 0, 0, iK, iH);
        return Bitmap.createScaledBitmap(bitmapCreateBitmap, iK * i2, iH * i2, false);
    }

    public static Bitmap c(String str, int i) throws WriterException {
        BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
        if (str == null) {
            return null;
        }
        String strF = f(str);
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        if (strF != null) {
            enumMap.put(EncodeHintType.CHARACTER_SET, strF);
        }
        enumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        enumMap.put(EncodeHintType.MARGIN, 0);
        ht htVarA = a(new ns3().a(str, barcodeFormat, i, i, enumMap));
        int iK = htVarA.k();
        int iH = htVarA.h();
        int[] iArr = new int[iK * iH];
        for (int i2 = 0; i2 < iH; i2++) {
            int i3 = i2 * iK;
            for (int i4 = 0; i4 < iK; i4++) {
                iArr[i3 + i4] = htVarA.e(i4, i2) ? -16777216 : -1;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iK, iH, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, iK, 0, 0, iK, iH);
        return Bitmap.createScaledBitmap(bitmapCreateBitmap, iK, iH, false);
    }

    public static Bitmap d(String str, int i) throws IOException, WriterException {
        return b(str, i);
    }

    public static Bitmap e(String str, int i) throws IOException, WriterException {
        return c(str, i);
    }

    public static String f(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }
}
