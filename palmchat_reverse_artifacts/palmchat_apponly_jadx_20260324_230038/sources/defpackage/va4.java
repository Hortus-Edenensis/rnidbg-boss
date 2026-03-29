package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class va4 implements mt4 {
    public static qx4[] b(xs xsVar, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, ChecksumException, FormatException {
        ArrayList arrayList = new ArrayList();
        sa4 sa4VarB = ob1.b(xsVar, map, z);
        for (sx4[] sx4VarArr : sa4VarB.b()) {
            nw0 nw0VarI = xa4.i(sa4VarB.a(), sx4VarArr[4], sx4VarArr[5], sx4VarArr[6], sx4VarArr[7], e(sx4VarArr), c(sx4VarArr));
            qx4 qx4Var = new qx4(nw0VarI.h(), nw0VarI.e(), sx4VarArr, BarcodeFormat.PDF_417);
            qx4Var.i(ResultMetadataType.ERROR_CORRECTION_LEVEL, nw0VarI.c());
            wa4 wa4Var = (wa4) nw0VarI.d();
            if (wa4Var != null) {
                qx4Var.i(ResultMetadataType.PDF417_EXTRA_METADATA, wa4Var);
            }
            arrayList.add(qx4Var);
        }
        return (qx4[]) arrayList.toArray(new qx4[arrayList.size()]);
    }

    public static int c(sx4[] sx4VarArr) {
        return Math.max(Math.max(d(sx4VarArr[0], sx4VarArr[4]), (d(sx4VarArr[6], sx4VarArr[2]) * 17) / 18), Math.max(d(sx4VarArr[1], sx4VarArr[5]), (d(sx4VarArr[7], sx4VarArr[3]) * 17) / 18));
    }

    public static int d(sx4 sx4Var, sx4 sx4Var2) {
        if (sx4Var == null || sx4Var2 == null) {
            return 0;
        }
        return (int) Math.abs(sx4Var.c() - sx4Var2.c());
    }

    public static int e(sx4[] sx4VarArr) {
        return Math.min(Math.min(f(sx4VarArr[0], sx4VarArr[4]), (f(sx4VarArr[6], sx4VarArr[2]) * 17) / 18), Math.min(f(sx4VarArr[1], sx4VarArr[5]), (f(sx4VarArr[7], sx4VarArr[3]) * 17) / 18));
    }

    public static int f(sx4 sx4Var, sx4 sx4Var2) {
        if (sx4Var == null || sx4Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(sx4Var.c() - sx4Var2.c());
    }

    @Override // defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        qx4 qx4Var;
        qx4[] qx4VarArrB = b(xsVar, map, false);
        if (qx4VarArrB == null || qx4VarArrB.length == 0 || (qx4Var = qx4VarArrB[0]) == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return qx4Var;
    }

    @Override // defpackage.mt4
    public void reset() {
    }
}
