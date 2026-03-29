package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class mp4 implements mt4 {
    public static final sx4[] b = new sx4[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jw0 f19286a = new jw0();

    public static ht b(ht htVar) throws NotFoundException {
        int[] iArrJ = htVar.j();
        int[] iArrF = htVar.f();
        if (iArrJ == null || iArrF == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fC = c(iArrJ, htVar);
        int i = iArrJ[1];
        int i2 = iArrF[1];
        int i3 = iArrJ[0];
        int i4 = iArrF[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= htVar.k()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i4 - i3) + 1) / fC);
        int iRound2 = Math.round((i5 + 1) / fC);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = (int) (fC / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fC)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fC)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i7 -= i10;
        }
        ht htVar2 = new ht(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fC)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (htVar.e(((int) (i13 * fC)) + i8, i12)) {
                    htVar2.m(i13, i11);
                }
            }
        }
        return htVar2;
    }

    public static float c(int[] iArr, ht htVar) throws NotFoundException {
        int iH = htVar.h();
        int iK = htVar.k();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < iK && i2 < iH) {
            if (z != htVar.e(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i == iK || i2 == iH) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i - iArr[0]) / 7.0f;
    }

    @Override // defpackage.mt4
    public final qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        sx4[] sx4VarArrB;
        nw0 nw0VarB;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            qb1 qb1VarE = new pb1(xsVar.a()).e(map);
            nw0 nw0VarB2 = this.f19286a.b(qb1VarE.a(), map);
            sx4VarArrB = qb1VarE.b();
            nw0VarB = nw0VarB2;
        } else {
            nw0VarB = this.f19286a.b(b(xsVar.a()), map);
            sx4VarArrB = b;
        }
        if (nw0VarB.d() instanceof lp4) {
            ((lp4) nw0VarB.d()).a(sx4VarArrB);
        }
        qx4 qx4Var = new qx4(nw0VarB.h(), nw0VarB.e(), sx4VarArrB, BarcodeFormat.QR_CODE);
        List<byte[]> listA = nw0VarB.a();
        if (listA != null) {
            qx4Var.i(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strC = nw0VarB.c();
        if (strC != null) {
            qx4Var.i(ResultMetadataType.ERROR_CORRECTION_LEVEL, strC);
        }
        if (nw0VarB.i()) {
            qx4Var.i(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(nw0VarB.g()));
            qx4Var.i(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(nw0VarB.f()));
        }
        qx4Var.j(nw0VarB.b());
        return qx4Var;
    }

    @Override // defpackage.mt4
    public void reset() {
    }
}
