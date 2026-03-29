package defpackage;

import androidx.annotation.Nullable;
import defpackage.jo4;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ko4 {
    @Nullable
    public static jo4 a(byte[] bArr, int i) {
        ArrayList<jo4.a> arrayListF;
        gc4 gc4Var = new gc4(bArr);
        try {
            arrayListF = c(gc4Var) ? f(gc4Var) : e(gc4Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new jo4(arrayListF.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new jo4(arrayListF.get(0), arrayListF.get(1), i);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    public static boolean c(gc4 gc4Var) {
        gc4Var.V(4);
        int iQ = gc4Var.q();
        gc4Var.U(0);
        return iQ == 1886547818;
    }

    @Nullable
    public static jo4.a d(gc4 gc4Var) {
        int iQ = gc4Var.q();
        if (iQ > 10000) {
            return null;
        }
        float[] fArr = new float[iQ];
        for (int i = 0; i < iQ; i++) {
            fArr[i] = gc4Var.p();
        }
        int iQ2 = gc4Var.q();
        if (iQ2 > 32000) {
            return null;
        }
        double d = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iQ) * 2.0d) / dLog);
        fc4 fc4Var = new fc4(gc4Var.e());
        int i2 = 8;
        fc4Var.p(gc4Var.f() * 8);
        float[] fArr2 = new float[iQ2 * 5];
        int i3 = 5;
        int[] iArr = new int[5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < iQ2) {
            int i6 = 0;
            while (i6 < i3) {
                int iB = iArr[i6] + b(fc4Var.h(iCeil));
                if (iB >= iQ || iB < 0) {
                    return null;
                }
                fArr2[i5] = fArr[iB];
                iArr[i6] = iB;
                i6++;
                i5++;
                i3 = 5;
            }
            i4++;
            i3 = 5;
        }
        fc4Var.p((fc4Var.e() + 7) & (-8));
        int i7 = 32;
        int iH = fc4Var.h(32);
        jo4.b[] bVarArr = new jo4.b[iH];
        int i8 = 0;
        while (i8 < iH) {
            int iH2 = fc4Var.h(i2);
            int iH3 = fc4Var.h(i2);
            int iH4 = fc4Var.h(i7);
            if (iH4 > 128000) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(((double) iQ2) * d) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int iB2 = 0;
            for (int i9 = 0; i9 < iH4; i9++) {
                iB2 += b(fc4Var.h(iCeil2));
                if (iB2 < 0 || iB2 >= iQ2) {
                    return null;
                }
                int i10 = i9 * 3;
                int i11 = iB2 * 5;
                fArr3[i10] = fArr2[i11];
                fArr3[i10 + 1] = fArr2[i11 + 1];
                fArr3[i10 + 2] = fArr2[i11 + 2];
                int i12 = i9 * 2;
                fArr4[i12] = fArr2[i11 + 3];
                fArr4[i12 + 1] = fArr2[i11 + 4];
            }
            bVarArr[i8] = new jo4.b(iH2, fArr3, fArr4, iH3);
            i8++;
            i7 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new jo4.a(bVarArr);
    }

    @Nullable
    public static ArrayList<jo4.a> e(gc4 gc4Var) {
        if (gc4Var.H() != 0) {
            return null;
        }
        gc4Var.V(7);
        int iQ = gc4Var.q();
        if (iQ == 1684433976) {
            gc4 gc4Var2 = new gc4();
            Inflater inflater = new Inflater(true);
            try {
                if (!g86.v0(gc4Var, gc4Var2, inflater)) {
                    return null;
                }
                inflater.end();
                gc4Var = gc4Var2;
            } finally {
                inflater.end();
            }
        } else if (iQ != 1918990112) {
            return null;
        }
        return g(gc4Var);
    }

    @Nullable
    public static ArrayList<jo4.a> f(gc4 gc4Var) {
        int iQ;
        gc4Var.V(8);
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        while (iF < iG && (iQ = gc4Var.q() + iF) > iF && iQ <= iG) {
            int iQ2 = gc4Var.q();
            if (iQ2 == 2037673328 || iQ2 == 1836279920) {
                gc4Var.T(iQ);
                return e(gc4Var);
            }
            gc4Var.U(iQ);
            iF = iQ;
        }
        return null;
    }

    @Nullable
    public static ArrayList<jo4.a> g(gc4 gc4Var) {
        ArrayList<jo4.a> arrayList = new ArrayList<>();
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        while (iF < iG) {
            int iQ = gc4Var.q() + iF;
            if (iQ <= iF || iQ > iG) {
                return null;
            }
            if (gc4Var.q() == 1835365224) {
                jo4.a aVarD = d(gc4Var);
                if (aVarD == null) {
                    return null;
                }
                arrayList.add(aVarD);
            }
            gc4Var.U(iQ);
            iF = iQ;
        }
        return arrayList;
    }
}
