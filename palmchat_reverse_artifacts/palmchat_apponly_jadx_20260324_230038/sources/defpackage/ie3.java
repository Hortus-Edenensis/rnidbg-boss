package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ie3 implements mt4 {
    public static final sx4[] b = new sx4[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iw0 f18151a = new iw0();

    public static ht b(ht htVar) throws NotFoundException {
        int[] iArrG = htVar.g();
        if (iArrG == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = iArrG[0];
        int i2 = iArrG[1];
        int i3 = iArrG[2];
        int i4 = iArrG[3];
        ht htVar2 = new ht(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
            for (int i7 = 0; i7 < 30; i7++) {
                if (htVar.e(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    htVar2.m(i7, i5);
                }
            }
        }
        return htVar2;
    }

    @Override // defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.getNotFoundInstance();
        }
        nw0 nw0VarB = this.f18151a.b(b(xsVar.a()), map);
        qx4 qx4Var = new qx4(nw0VarB.h(), nw0VarB.e(), b, BarcodeFormat.MAXICODE);
        String strC = nw0VarB.c();
        if (strC != null) {
            qx4Var.i(ResultMetadataType.ERROR_CORRECTION_LEVEL, strC);
        }
        return qx4Var;
    }

    @Override // defpackage.mt4
    public void reset() {
    }
}
