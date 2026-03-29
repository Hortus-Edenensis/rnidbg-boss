package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class o36 extends t36 {
    public final t36 i = new oj1();

    public static qx4 q(qx4 qx4Var) throws FormatException {
        String strG = qx4Var.g();
        if (strG.charAt(0) == '0') {
            return new qx4(strG.substring(1), null, qx4Var.f(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }

    @Override // defpackage.a84, defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return q(this.i.a(xsVar, map));
    }

    @Override // defpackage.t36, defpackage.a84
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return q(this.i.b(i, etVar, map));
    }

    @Override // defpackage.t36
    public int k(et etVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.i.k(etVar, iArr, sb);
    }

    @Override // defpackage.t36
    public qx4 l(int i, et etVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return q(this.i.l(i, etVar, iArr, map));
    }

    @Override // defpackage.t36
    public BarcodeFormat p() {
        return BarcodeFormat.UPC_A;
    }
}
