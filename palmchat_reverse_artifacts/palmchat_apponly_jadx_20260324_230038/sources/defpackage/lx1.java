package defpackage;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class lx1 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19094a;
    }

    public static boolean a(gc4 gc4Var, px1 px1Var, int i) {
        int iJ = j(gc4Var, i);
        return iJ != -1 && iJ <= px1Var.b;
    }

    public static boolean b(gc4 gc4Var, int i) {
        return gc4Var.H() == g86.u(gc4Var.e(), i, gc4Var.f() - 1, 0);
    }

    public static boolean c(gc4 gc4Var, px1 px1Var, boolean z, a aVar) {
        try {
            long jO = gc4Var.O();
            if (!z) {
                jO *= (long) px1Var.b;
            }
            aVar.f19094a = jO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(gc4 gc4Var, px1 px1Var, int i, a aVar) {
        int iF = gc4Var.f();
        long J = gc4Var.J();
        long j = J >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) (15 & (J >> 4)), px1Var) && f((int) ((J >> 1) & 7), px1Var) && !(((J & 1) > 1L ? 1 : ((J & 1) == 1L ? 0 : -1)) == 0) && c(gc4Var, px1Var, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(gc4Var, px1Var, (int) ((J >> 12) & 15)) && e(gc4Var, px1Var, (int) ((J >> 8) & 15)) && b(gc4Var, iF);
    }

    public static boolean e(gc4 gc4Var, px1 px1Var, int i) {
        int i2 = px1Var.e;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == px1Var.f;
        }
        if (i == 12) {
            return gc4Var.H() * 1000 == i2;
        }
        if (i > 14) {
            return false;
        }
        int iN = gc4Var.N();
        if (i == 14) {
            iN *= 10;
        }
        return iN == i2;
    }

    public static boolean f(int i, px1 px1Var) {
        return i == 0 || i == px1Var.i;
    }

    public static boolean g(int i, px1 px1Var) {
        return i <= 7 ? i == px1Var.g - 1 : i <= 10 && px1Var.g == 2;
    }

    public static boolean h(ps1 ps1Var, px1 px1Var, int i, a aVar) throws IOException {
        long peekPosition = ps1Var.getPeekPosition();
        byte[] bArr = new byte[2];
        ps1Var.peekFully(bArr, 0, 2);
        if ((((bArr[0] & UByte.MAX_VALUE) << 8) | (bArr[1] & UByte.MAX_VALUE)) != i) {
            ps1Var.resetPeekPosition();
            ps1Var.advancePeekPosition((int) (peekPosition - ps1Var.getPosition()));
            return false;
        }
        gc4 gc4Var = new gc4(16);
        System.arraycopy(bArr, 0, gc4Var.e(), 0, 2);
        gc4Var.T(rs1.c(ps1Var, gc4Var.e(), 2, 14));
        ps1Var.resetPeekPosition();
        ps1Var.advancePeekPosition((int) (peekPosition - ps1Var.getPosition()));
        return d(gc4Var, px1Var, i, aVar);
    }

    public static long i(ps1 ps1Var, px1 px1Var) throws IOException {
        ps1Var.resetPeekPosition();
        ps1Var.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        ps1Var.peekFully(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        ps1Var.advancePeekPosition(2);
        int i = z ? 7 : 6;
        gc4 gc4Var = new gc4(i);
        gc4Var.T(rs1.c(ps1Var, gc4Var.e(), 0, i));
        ps1Var.resetPeekPosition();
        a aVar = new a();
        if (c(gc4Var, px1Var, z, aVar)) {
            return aVar.f19094a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(gc4 gc4Var, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return gc4Var.H() + 1;
            case 7:
                return gc4Var.N() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
