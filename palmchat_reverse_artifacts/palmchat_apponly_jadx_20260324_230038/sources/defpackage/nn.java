package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class nn implements mt4 {
    @Override // defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        sx4[] sx4VarArrB;
        sx4[] sx4VarArrB2;
        FormatException formatException;
        tx4 tx4Var;
        mb1 mb1Var = new mb1(xsVar.a());
        nw0 nw0VarC = null;
        try {
            mn mnVarA = mb1Var.a(false);
            sx4VarArrB = mnVarA.b();
            try {
                sx4VarArrB2 = sx4VarArrB;
                formatException = null;
                nw0VarC = new gw0().c(mnVarA);
                e = null;
            } catch (FormatException e) {
                e = e;
                sx4VarArrB2 = sx4VarArrB;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                sx4VarArrB2 = sx4VarArrB;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            sx4VarArrB = null;
        } catch (NotFoundException e4) {
            e = e4;
            sx4VarArrB = null;
        }
        if (nw0VarC == null) {
            try {
                mn mnVarA2 = mb1Var.a(true);
                sx4VarArrB2 = mnVarA2.b();
                nw0VarC = new gw0().c(mnVarA2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        if (map != null && (tx4Var = (tx4) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (sx4 sx4Var : sx4VarArrB2) {
                tx4Var.a(sx4Var);
            }
        }
        qx4 qx4Var = new qx4(nw0VarC.h(), nw0VarC.e(), sx4VarArrB2, BarcodeFormat.AZTEC);
        List<byte[]> listA = nw0VarC.a();
        if (listA != null) {
            qx4Var.i(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strC = nw0VarC.c();
        if (strC != null) {
            qx4Var.i(ResultMetadataType.ERROR_CORRECTION_LEVEL, strC);
        }
        return qx4Var;
    }

    @Override // defpackage.mt4
    public void reset() {
    }
}
