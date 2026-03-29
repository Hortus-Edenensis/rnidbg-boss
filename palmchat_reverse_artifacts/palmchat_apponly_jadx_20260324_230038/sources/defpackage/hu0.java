package defpackage;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import defpackage.t96;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class hu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18052a;
    public final byte[] b;

    public hu0(int i, byte[] bArr) {
        this.f18052a = i;
        this.b = bArr;
    }

    public static hu0[] b(byte[] bArr, t96 t96Var, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != t96Var.h()) {
            throw new IllegalArgumentException();
        }
        t96.b bVarF = t96Var.f(errorCorrectionLevel);
        t96.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (t96.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        hu0[] hu0VarArr = new hu0[iA];
        int i = 0;
        for (t96.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                hu0VarArr[i] = new hu0(iB, new byte[bVarF.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = hu0VarArr[0].b.length;
        int i3 = iA - 1;
        while (i3 >= 0 && hu0VarArr[i3].b.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int iB2 = length - bVarF.b();
        int i5 = 0;
        for (int i6 = 0; i6 < iB2; i6++) {
            int i7 = 0;
            while (i7 < i) {
                hu0VarArr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            hu0VarArr[i8].b[iB2] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = hu0VarArr[0].b.length;
        while (iB2 < length2) {
            int i9 = 0;
            while (i9 < i) {
                hu0VarArr[i9].b[i9 < i4 ? iB2 : iB2 + 1] = bArr[i5];
                i9++;
                i5++;
            }
            iB2++;
        }
        return hu0VarArr;
    }

    public byte[] a() {
        return this.b;
    }

    public int c() {
        return this.f18052a;
    }
}
