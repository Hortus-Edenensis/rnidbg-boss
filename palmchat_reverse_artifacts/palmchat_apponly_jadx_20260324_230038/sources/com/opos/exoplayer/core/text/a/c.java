package com.opos.exoplayer.core.text.a;

import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8322a = y.f("GA94");
    private static final int b = y.f("DTG1");

    private static int a(p pVar) {
        int i = 0;
        while (pVar.b() != 0) {
            int iG = pVar.g();
            i += iG;
            if (iG != 255) {
                return i;
            }
        }
        return -1;
    }

    public static void a(long j, p pVar, n[] nVarArr) {
        while (pVar.b() > 1) {
            int iA = a(pVar);
            int iA2 = a(pVar);
            int iD = pVar.d() + iA2;
            if (iA2 == -1 || iA2 > pVar.b()) {
                com.opos.cmn.an.f.a.c("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iD = pVar.c();
            } else if (iA == 4 && iA2 >= 8) {
                int iG = pVar.g();
                int iH = pVar.h();
                int iO = iH == 49 ? pVar.o() : 0;
                int iG2 = pVar.g();
                if (iH == 47) {
                    pVar.d(1);
                }
                boolean z = iG == 181 && (iH == 49 || iH == 47) && iG2 == 3;
                if (iH == 49) {
                    z &= iO == f8322a || iO == b;
                }
                if (z) {
                    int iG3 = pVar.g() & 31;
                    pVar.d(1);
                    int i = iG3 * 3;
                    int iD2 = pVar.d();
                    for (n nVar : nVarArr) {
                        pVar.c(iD2);
                        nVar.a(pVar, i);
                        nVar.a(j, 1, i, 0, null);
                    }
                }
            }
            pVar.c(iD);
        }
    }
}
