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
public final class ou0 implements mt4 {
    public static final sx4[] b = new sx4[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hw0 f19876a = new hw0();

    public static ht b(ht htVar) throws NotFoundException {
        int[] iArrJ = htVar.j();
        int[] iArrF = htVar.f();
        if (iArrJ == null || iArrF == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iC = c(iArrJ, htVar);
        int i = iArrJ[1];
        int i2 = iArrF[1];
        int i3 = iArrJ[0];
        int i4 = ((iArrF[0] - i3) + 1) / iC;
        int i5 = ((i2 - i) + 1) / iC;
        if (i4 <= 0 || i5 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = iC / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        ht htVar2 = new ht(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iC) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (htVar.e((i11 * iC) + i8, i10)) {
                    htVar2.m(i11, i9);
                }
            }
        }
        return htVar2;
    }

    public static int c(int[] iArr, ht htVar) throws NotFoundException {
        int iK = htVar.k();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < iK && htVar.e(i, i2)) {
            i++;
        }
        if (i == iK) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i3 = i - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        sx4[] sx4VarArrB;
        nw0 nw0VarB;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            qb1 qb1VarC = new nb1(xsVar.a()).c();
            nw0 nw0VarB2 = this.f19876a.b(qb1VarC.a());
            sx4VarArrB = qb1VarC.b();
            nw0VarB = nw0VarB2;
        } else {
            nw0VarB = this.f19876a.b(b(xsVar.a()));
            sx4VarArrB = b;
        }
        qx4 qx4Var = new qx4(nw0VarB.h(), nw0VarB.e(), sx4VarArrB, BarcodeFormat.DATA_MATRIX);
        List<byte[]> listA = nw0VarB.a();
        if (listA != null) {
            qx4Var.i(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
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
