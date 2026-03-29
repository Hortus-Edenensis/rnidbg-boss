package com.opos.exoplayer.core.extractor.mp4;

import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8216a = {y.f("isom"), y.f("iso2"), y.f("iso3"), y.f("iso4"), y.f("iso5"), y.f("iso6"), y.f("avc1"), y.f("hvc1"), y.f("hev1"), y.f("mp41"), y.f("mp42"), y.f("3g2a"), y.f("3g2b"), y.f("3gr6"), y.f("3gs6"), y.f("3ge6"), y.f("3gg6"), y.f("M4V "), y.f("M4A "), y.f("f4v "), y.f("kddi"), y.f("M4VP"), y.f("qt  "), y.f("MSNV")};

    private static boolean a(int i) {
        if ((i >>> 8) == y.f("3gp")) {
            return true;
        }
        for (int i2 : f8216a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(com.opos.exoplayer.core.extractor.f fVar) {
        return a(fVar, false);
    }

    public static boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        return a(fVar, true);
    }

    private static boolean a(com.opos.exoplayer.core.extractor.f fVar, boolean z) {
        boolean z2;
        int i;
        long jD = fVar.d();
        long j = -1;
        if (jD == -1 || jD > 4096) {
            jD = 4096;
        }
        int i2 = (int) jD;
        p pVar = new p(64);
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i2) {
            pVar.a(8);
            fVar.c(pVar.f8400a, 0, 8);
            long jM = pVar.m();
            int iO = pVar.o();
            if (jM == 1) {
                fVar.c(pVar.f8400a, 8, 8);
                pVar.b(16);
                jM = pVar.w();
                i = 16;
            } else {
                if (jM == 0) {
                    long jD2 = fVar.d();
                    if (jD2 != j) {
                        jM = ((long) 8) + (jD2 - fVar.c());
                    }
                }
                i = 8;
            }
            long j2 = i;
            if (jM < j2) {
                return false;
            }
            i3 += i;
            if (iO != d.B) {
                if (iO == d.K || iO == d.M) {
                    z2 = true;
                    break;
                }
                if ((((long) i3) + jM) - j2 >= i2) {
                    break;
                }
                int i4 = (int) (jM - j2);
                i3 += i4;
                if (iO == d.f8207a) {
                    if (i4 < 8) {
                        return false;
                    }
                    pVar.a(i4);
                    fVar.c(pVar.f8400a, 0, i4);
                    int i5 = i4 / 4;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            break;
                        }
                        if (i6 == 1) {
                            pVar.d(4);
                        } else if (a(pVar.o())) {
                            z3 = true;
                            break;
                        }
                        i6++;
                    }
                    if (!z3) {
                        return false;
                    }
                } else if (i4 != 0) {
                    fVar.c(i4);
                }
                j = -1;
            }
        }
        z2 = false;
        return z3 && z == z2;
    }
}
