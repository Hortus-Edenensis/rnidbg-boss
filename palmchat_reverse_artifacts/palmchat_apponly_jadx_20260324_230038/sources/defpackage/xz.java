package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xz {
    public static void a(long j, gc4 gc4Var, c06[] c06VarArr) {
        while (true) {
            if (gc4Var.a() <= 1) {
                return;
            }
            int iC = c(gc4Var);
            int iC2 = c(gc4Var);
            int iF = gc4Var.f() + iC2;
            if (iC2 == -1 || iC2 > gc4Var.a()) {
                y53.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iF = gc4Var.g();
            } else if (iC == 4 && iC2 >= 8) {
                int iH = gc4Var.H();
                int iN = gc4Var.N();
                int iQ = iN == 49 ? gc4Var.q() : 0;
                int iH2 = gc4Var.H();
                if (iN == 47) {
                    gc4Var.V(1);
                }
                boolean z = iH == 181 && (iN == 49 || iN == 47) && iH2 == 3;
                if (iN == 49) {
                    z &= iQ == 1195456820;
                }
                if (z) {
                    b(j, gc4Var, c06VarArr);
                }
            }
            gc4Var.U(iF);
        }
    }

    public static void b(long j, gc4 gc4Var, c06[] c06VarArr) {
        int iH = gc4Var.H();
        if ((iH & 64) != 0) {
            gc4Var.V(1);
            int i = (iH & 31) * 3;
            int iF = gc4Var.f();
            for (c06 c06Var : c06VarArr) {
                gc4Var.U(iF);
                c06Var.d(gc4Var, i);
                if (j != -9223372036854775807L) {
                    c06Var.e(j, 1, i, 0, null);
                }
            }
        }
    }

    public static int c(gc4 gc4Var) {
        int i = 0;
        while (gc4Var.a() != 0) {
            int iH = gc4Var.H();
            i += iH;
            if (iH != 255) {
                return i;
            }
        }
        return -1;
    }
}
