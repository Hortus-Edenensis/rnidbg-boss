package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class qj1 extends t36 {
    public final int[] i = new int[4];

    @Override // defpackage.t36
    public int k(et etVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = etVar.k();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < iK; i2++) {
            sb.append((char) (t36.i(etVar, iArr2, i, t36.g) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = t36.m(etVar, i, true, t36.e)[1];
        for (int i5 = 0; i5 < 4 && i4 < iK; i5++) {
            sb.append((char) (t36.i(etVar, iArr2, i4, t36.g) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override // defpackage.t36
    public BarcodeFormat p() {
        return BarcodeFormat.EAN_8;
    }
}
