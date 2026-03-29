package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class qu0 implements qo6 {
    public static ht b(tv tvVar) {
        int iE = tvVar.e();
        int iD = tvVar.d();
        ht htVar = new ht(iE, iD);
        htVar.a();
        for (int i = 0; i < iE; i++) {
            for (int i2 = 0; i2 < iD; i2++) {
                if (tvVar.b(i, i2) == 1) {
                    htVar.m(i, i2);
                }
            }
        }
        return htVar;
    }

    public static ht c(y61 y61Var, zp5 zp5Var) {
        int iH = zp5Var.h();
        int iG = zp5Var.g();
        tv tvVar = new tv(zp5Var.j(), zp5Var.i());
        int i = 0;
        for (int i2 = 0; i2 < iG; i2++) {
            if (i2 % zp5Var.e == 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < zp5Var.j(); i4++) {
                    tvVar.g(i3, i, i4 % 2 == 0);
                    i3++;
                }
                i++;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < iH; i6++) {
                if (i6 % zp5Var.d == 0) {
                    tvVar.g(i5, i, true);
                    i5++;
                }
                tvVar.g(i5, i, y61Var.e(i6, i2));
                i5++;
                int i7 = zp5Var.d;
                if (i6 % i7 == i7 - 1) {
                    tvVar.g(i5, i, i2 % 2 == 0);
                    i5++;
                }
            }
            i++;
            int i8 = zp5Var.e;
            if (i2 % i8 == i8 - 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < zp5Var.j(); i10++) {
                    tvVar.g(i9, i, true);
                    i9++;
                }
                i++;
            }
        }
        return b(tvVar);
    }

    @Override // defpackage.qo6
    public ht a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        gd1 gd1Var;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        gd1 gd1Var2 = null;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            gd1 gd1Var3 = (gd1) map.get(EncodeHintType.MIN_SIZE);
            if (gd1Var3 == null) {
                gd1Var3 = null;
            }
            gd1Var = (gd1) map.get(EncodeHintType.MAX_SIZE);
            if (gd1Var == null) {
                gd1Var = null;
            }
            gd1Var2 = gd1Var3;
        } else {
            gd1Var = null;
        }
        String strB = uh2.b(str, symbolShapeHint, gd1Var2, gd1Var);
        zp5 zp5VarL = zp5.l(strB.length(), symbolShapeHint, gd1Var2, gd1Var, true);
        y61 y61Var = new y61(xm1.c(strB, zp5VarL), zp5VarL.h(), zp5VarL.g());
        y61Var.h();
        return c(y61Var, zp5VarL);
    }
}
