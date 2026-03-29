package com.opos.exoplayer.core.extractor.c;

import com.opos.exoplayer.core.extractor.f;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class c {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8179a;
        public final long b;

        private a(int i, long j) {
            this.f8179a = i;
            this.b = j;
        }

        public static a a(f fVar, p pVar) {
            fVar.c(pVar.f8400a, 0, 8);
            pVar.c(0);
            return new a(pVar.o(), pVar.n());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(f fVar) throws m {
        a aVarA;
        int iB;
        StringBuilder sb;
        String str;
        com.opos.exoplayer.core.util.a.a(fVar);
        p pVar = new p(16);
        if (a.a(fVar, pVar).f8179a != y.f("RIFF")) {
            return null;
        }
        fVar.c(pVar.f8400a, 0, 4);
        pVar.c(0);
        int iO = pVar.o();
        if (iO != y.f("WAVE")) {
            sb = new StringBuilder();
            sb.append("Unsupported RIFF format: ");
            sb.append(iO);
        } else {
            while (true) {
                aVarA = a.a(fVar, pVar);
                if (aVarA.f8179a == y.f("fmt ")) {
                    break;
                }
                fVar.c((int) aVarA.b);
            }
            com.opos.exoplayer.core.util.a.b(aVarA.b >= 16);
            fVar.c(pVar.f8400a, 0, 16);
            pVar.c(0);
            int i = pVar.i();
            int i2 = pVar.i();
            int iV = pVar.v();
            int iV2 = pVar.v();
            int i3 = pVar.i();
            int i4 = pVar.i();
            int i5 = (i2 * i4) / 8;
            if (i3 != i5) {
                throw new m("Expected block alignment: " + i5 + "; got: " + i3);
            }
            if (i == 1) {
                iB = y.b(i4);
                if (iB != 0) {
                    fVar.c(((int) aVarA.b) - 16);
                    return new b(i2, iV, iV2, i3, i4, iB);
                }
                sb = new StringBuilder();
                sb.append("Unsupported WAV bit depth ");
                sb.append(i4);
                str = " for type ";
                sb.append(str);
                sb.append(i);
            } else if (i != 3) {
                if (i != 65534) {
                    sb = new StringBuilder();
                    str = "Unsupported WAV format type: ";
                    sb.append(str);
                    sb.append(i);
                }
                iB = y.b(i4);
                if (iB != 0) {
                }
            } else {
                iB = i4 == 32 ? 4 : 0;
                if (iB != 0) {
                }
            }
        }
        com.opos.cmn.an.f.a.d("WavHeaderReader", sb.toString());
        return null;
    }

    public static void a(f fVar, b bVar) throws m {
        com.opos.exoplayer.core.util.a.a(fVar);
        com.opos.exoplayer.core.util.a.a(bVar);
        fVar.a();
        p pVar = new p(8);
        while (true) {
            a aVarA = a.a(fVar, pVar);
            if (aVarA.f8179a == y.f("data")) {
                fVar.b(8);
                bVar.a(fVar.c(), aVarA.b);
                return;
            }
            com.opos.cmn.an.f.a.c("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f8179a);
            long j = aVarA.b + 8;
            if (aVarA.f8179a == y.f("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new m("Chunk is too large (~2GB+) to skip; id: " + aVarA.f8179a);
            }
            fVar.b((int) j);
        }
    }
}
