package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import defpackage.ot3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f17083a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;

    @Nullable
    public final String i;

    public dn(List<byte[]> list, int i, int i2, int i3, int i4, int i5, int i6, float f, @Nullable String str) {
        this.f17083a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = f;
        this.i = str;
    }

    public static byte[] a(gc4 gc4Var) {
        int iN = gc4Var.N();
        int iF = gc4Var.f();
        gc4Var.V(iN);
        return ee0.d(gc4Var.e(), iF, iN);
    }

    public static dn b(gc4 gc4Var) throws ParserException {
        String strA;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        try {
            gc4Var.V(4);
            int iH = (gc4Var.H() & 3) + 1;
            if (iH == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iH2 = gc4Var.H() & 31;
            for (int i6 = 0; i6 < iH2; i6++) {
                arrayList.add(a(gc4Var));
            }
            int iH3 = gc4Var.H();
            for (int i7 = 0; i7 < iH3; i7++) {
                arrayList.add(a(gc4Var));
            }
            if (iH2 > 0) {
                ot3.c cVarL = ot3.l((byte[]) arrayList.get(0), iH, ((byte[]) arrayList.get(0)).length);
                int i8 = cVarL.f;
                int i9 = cVarL.g;
                int i10 = cVarL.o;
                int i11 = cVarL.p;
                int i12 = cVarL.q;
                float f2 = cVarL.h;
                strA = ee0.a(cVarL.f19872a, cVarL.b, cVarL.c);
                i4 = i11;
                i5 = i12;
                f = f2;
                i = i8;
                i2 = i9;
                i3 = i10;
            } else {
                strA = null;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                f = 1.0f;
            }
            return new dn(arrayList, iH, i, i2, i3, i4, i5, f, strA);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e);
        }
    }
}
