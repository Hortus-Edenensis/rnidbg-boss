package com.opos.exoplayer.core.extractor.ts;

import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.ts.s;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements com.opos.exoplayer.core.extractor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.extractor.h f8226a = new a();
    private static final int b = y.f("ID3");
    private final long c;
    private final d d;
    private final com.opos.exoplayer.core.util.p e;
    private boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.opos.exoplayer.core.extractor.h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new c()};
        }
    }

    public c() {
        this(0L);
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(com.opos.exoplayer.core.extractor.f fVar, com.opos.exoplayer.core.extractor.k kVar) {
        int iA = fVar.a(this.e.f8400a, 0, 200);
        if (iA == -1) {
            return -1;
        }
        this.e.c(0);
        this.e.b(iA);
        if (!this.f) {
            this.d.a(this.c, true);
            this.f = true;
        }
        this.d.a(this.e);
        return 0;
    }

    public c(long j) {
        this.c = j;
        this.d = new d(true);
        this.e = new com.opos.exoplayer.core.util.p(200);
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        this.f = false;
        this.d.a();
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(com.opos.exoplayer.core.extractor.g gVar) {
        this.d.a(gVar, new s.d(0, 1));
        gVar.a();
        gVar.a(new l.b(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
    
        if ((r5 - r4) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        r11.a();
        r5 = r5 + 1;
     */
    @Override // com.opos.exoplayer.core.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        com.opos.exoplayer.core.util.p pVar = new com.opos.exoplayer.core.util.p(10);
        com.opos.exoplayer.core.util.o oVar = new com.opos.exoplayer.core.util.o(pVar.f8400a);
        int i = 0;
        while (true) {
            fVar.c(pVar.f8400a, 0, 10);
            pVar.c(0);
            if (pVar.k() != b) {
                break;
            }
            pVar.d(3);
            int iT = pVar.t();
            i += iT + 10;
            fVar.c(iT);
        }
        fVar.a();
        fVar.c(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                fVar.c(pVar.f8400a, 0, 2);
                pVar.c(0);
                if ((pVar.h() & 65526) != 65520) {
                    break;
                }
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                fVar.c(pVar.f8400a, 0, 4);
                oVar.a(14);
                int iC = oVar.c(13);
                if (iC <= 6) {
                    return false;
                }
                fVar.c(iC - 6);
                i4 += iC;
            }
            fVar.c(i2);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }
}
