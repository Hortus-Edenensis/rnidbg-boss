package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import defpackage.ot3;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class lh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f18977a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;

    @Nullable
    public final String i;

    public lh2(List<byte[]> list, int i, int i2, int i3, int i4, int i5, int i6, float f, @Nullable String str) {
        this.f18977a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = f;
        this.i = str;
    }

    public static lh2 a(gc4 gc4Var) throws ParserException {
        int i;
        int i2;
        try {
            gc4Var.V(21);
            int iH = gc4Var.H() & 3;
            int iH2 = gc4Var.H();
            int iF = gc4Var.f();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < iH2; i5++) {
                gc4Var.V(1);
                int iN = gc4Var.N();
                for (int i6 = 0; i6 < iN; i6++) {
                    int iN2 = gc4Var.N();
                    i4 += iN2 + 4;
                    gc4Var.V(iN2);
                }
            }
            gc4Var.U(iF);
            byte[] bArr = new byte[i4];
            String strC = null;
            int i7 = 0;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            float f = 1.0f;
            while (i7 < iH2) {
                int iH3 = gc4Var.H() & 63;
                int iN3 = gc4Var.N();
                int i14 = 0;
                while (i14 < iN3) {
                    int iN4 = gc4Var.N();
                    byte[] bArr2 = ot3.f19869a;
                    int i15 = iH2;
                    System.arraycopy(bArr2, i3, bArr, i8, bArr2.length);
                    int length = i8 + bArr2.length;
                    System.arraycopy(gc4Var.e(), gc4Var.f(), bArr, length, iN4);
                    if (iH3 == 33 && i14 == 0) {
                        ot3.a aVarH = ot3.h(bArr, length, length + iN4);
                        int i16 = aVarH.k;
                        i10 = aVarH.l;
                        i11 = aVarH.n;
                        int i17 = aVarH.o;
                        int i18 = aVarH.p;
                        float f2 = aVarH.m;
                        i = iH3;
                        i2 = iN3;
                        i9 = i16;
                        strC = ee0.c(aVarH.f19870a, aVarH.b, aVarH.c, aVarH.d, aVarH.h, aVarH.i);
                        i13 = i18;
                        i12 = i17;
                        f = f2;
                    } else {
                        i = iH3;
                        i2 = iN3;
                    }
                    i8 = length + iN4;
                    gc4Var.V(iN4);
                    i14++;
                    iH2 = i15;
                    iH3 = i;
                    iN3 = i2;
                    i3 = 0;
                }
                i7++;
                i3 = 0;
            }
            return new lh2(i4 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iH + 1, i9, i10, i11, i12, i13, f, strC);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }
}
