package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class sf5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f20733a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : f20733a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(ps1 ps1Var) throws IOException {
        return c(ps1Var, true, false);
    }

    public static boolean c(ps1 ps1Var, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        int i;
        long length = ps1Var.getLength();
        long j = 4096;
        long j2 = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i2 != 0 && length <= 4096) {
            j = length;
        }
        int i3 = (int) j;
        gc4 gc4Var = new gc4(64);
        boolean z5 = false;
        int i4 = 0;
        boolean z6 = false;
        while (i4 < i3) {
            gc4Var.Q(8);
            if (!ps1Var.peekFully(gc4Var.e(), z5 ? 1 : 0, 8, true)) {
                break;
            }
            long J = gc4Var.J();
            int iQ = gc4Var.q();
            if (J == 1) {
                ps1Var.peekFully(gc4Var.e(), 8, 8);
                gc4Var.T(16);
                J = gc4Var.A();
                i = 16;
            } else {
                if (J == 0) {
                    long length2 = ps1Var.getLength();
                    if (length2 != j2) {
                        J = (length2 - ps1Var.getPeekPosition()) + ((long) 8);
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (J < j3) {
                return z5;
            }
            i4 += i;
            if (iQ == 1836019574) {
                i3 += (int) J;
                if (i2 != 0 && i3 > length) {
                    i3 = (int) length;
                }
                j2 = -1;
            } else {
                if (iQ == 1836019558 || iQ == 1836475768) {
                    z3 = true;
                    z4 = true;
                    break;
                }
                int i5 = i2;
                if ((((long) i4) + J) - j3 >= i3) {
                    break;
                }
                int i6 = (int) (J - j3);
                i4 += i6;
                if (iQ == 1718909296) {
                    if (i6 < 8) {
                        return false;
                    }
                    gc4Var.Q(i6);
                    ps1Var.peekFully(gc4Var.e(), 0, i6);
                    int i7 = i6 / 4;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= i7) {
                            break;
                        }
                        if (i8 == 1) {
                            gc4Var.V(4);
                        } else if (a(gc4Var.q(), z2)) {
                            z6 = true;
                            break;
                        }
                        i8++;
                    }
                    if (!z6) {
                        return false;
                    }
                } else if (i6 != 0) {
                    ps1Var.advancePeekPosition(i6);
                }
                i2 = i5;
                j2 = -1;
                z5 = false;
            }
        }
        z3 = true;
        z4 = false;
        if (z6 && z == z4) {
            return z3;
        }
        return false;
    }

    public static boolean d(ps1 ps1Var, boolean z) throws IOException {
        return c(ps1Var, false, z);
    }
}
