package com.opos.exoplayer.core.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.ts.s;
import com.opos.exoplayer.core.util.w;
import com.opos.exoplayer.core.util.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TsExtractor implements com.opos.exoplayer.core.extractor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.extractor.h f8221a = new a();
    private static final long b = y.f("AC-3");
    private static final long c = y.f("EAC3");
    private static final long d = y.f("HEVC");
    private final int e;
    private final List<w> f;
    private final com.opos.exoplayer.core.util.p g;
    private final SparseIntArray h;
    private final s.c i;
    private final SparseArray<s> j;
    private final SparseBooleanArray k;
    private com.opos.exoplayer.core.extractor.g l;
    private int m;
    private boolean n;
    private s o;
    private int p;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.opos.exoplayer.core.extractor.h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new TsExtractor()};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements p {
        private final com.opos.exoplayer.core.util.o b = new com.opos.exoplayer.core.util.o(new byte[4]);

        public b() {
        }

        @Override // com.opos.exoplayer.core.extractor.ts.p
        public void a(com.opos.exoplayer.core.util.p pVar) {
            if (pVar.g() != 0) {
                return;
            }
            pVar.d(7);
            int iB = pVar.b() / 4;
            for (int i = 0; i < iB; i++) {
                pVar.a(this.b, 4);
                int iC = this.b.c(16);
                this.b.b(3);
                if (iC == 0) {
                    this.b.b(13);
                } else {
                    int iC2 = this.b.c(13);
                    TsExtractor.this.j.put(iC2, new q(TsExtractor.this.new c(iC2)));
                    TsExtractor.b(TsExtractor.this);
                }
            }
            if (TsExtractor.this.e != 2) {
                TsExtractor.this.j.remove(0);
            }
        }

        @Override // com.opos.exoplayer.core.extractor.ts.p
        public void a(w wVar, com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements p {
        private final com.opos.exoplayer.core.util.o b = new com.opos.exoplayer.core.util.o(new byte[5]);
        private final SparseArray<s> c = new SparseArray<>();
        private final SparseIntArray d = new SparseIntArray();
        private final int e;

        public c(int i) {
            this.e = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private s.b a(com.opos.exoplayer.core.util.p pVar, int i) {
            int iD = pVar.d();
            int i2 = i + iD;
            int i3 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (pVar.d() < i2) {
                int iG = pVar.g();
                int iD2 = pVar.d() + pVar.g();
                if (iG == 5) {
                    long jM = pVar.m();
                    if (jM == TsExtractor.b) {
                        i3 = 129;
                    } else if (jM == TsExtractor.c) {
                        i3 = 135;
                    } else if (jM == TsExtractor.d) {
                        i3 = 36;
                    }
                } else if (iG != 106) {
                    if (iG != 122) {
                        if (iG == 123) {
                            i3 = 138;
                        } else if (iG == 10) {
                            strTrim = pVar.e(3).trim();
                        } else if (iG == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (pVar.d() < iD2) {
                                String strTrim2 = pVar.e(3).trim();
                                int iG2 = pVar.g();
                                byte[] bArr = new byte[4];
                                pVar.a(bArr, 0, 4);
                                arrayList2.add(new s.a(strTrim2, iG2, bArr));
                            }
                            arrayList = arrayList2;
                            i3 = 89;
                        }
                    }
                }
                pVar.d(iD2 - pVar.d());
            }
            pVar.c(i2);
            return new s.b(i3, strTrim, arrayList, Arrays.copyOfRange(pVar.f8400a, iD, i2));
        }

        @Override // com.opos.exoplayer.core.extractor.ts.p
        public void a(com.opos.exoplayer.core.util.p pVar) {
            w wVar;
            if (pVar.g() != 2) {
                return;
            }
            if (TsExtractor.this.e == 1 || TsExtractor.this.e == 2 || TsExtractor.this.m == 1) {
                wVar = (w) TsExtractor.this.f.get(0);
            } else {
                wVar = new w(((w) TsExtractor.this.f.get(0)).a());
                TsExtractor.this.f.add(wVar);
            }
            pVar.d(2);
            int iH = pVar.h();
            int i = 5;
            pVar.d(5);
            pVar.a(this.b, 2);
            int i2 = 4;
            this.b.b(4);
            pVar.d(this.b.c(12));
            if (TsExtractor.this.e == 2 && TsExtractor.this.o == null) {
                s.b bVar = new s.b(21, null, null, new byte[0]);
                TsExtractor tsExtractor = TsExtractor.this;
                tsExtractor.o = tsExtractor.i.a(21, bVar);
                TsExtractor.this.o.a(wVar, TsExtractor.this.l, new s.d(iH, 21, 8192));
            }
            this.c.clear();
            this.d.clear();
            int iB = pVar.b();
            while (iB > 0) {
                pVar.a(this.b, i);
                int iC = this.b.c(8);
                this.b.b(3);
                int iC2 = this.b.c(13);
                this.b.b(i2);
                int iC3 = this.b.c(12);
                s.b bVarA = a(pVar, iC3);
                if (iC == 6) {
                    iC = bVarA.f8246a;
                }
                iB -= iC3 + 5;
                int i3 = TsExtractor.this.e == 2 ? iC : iC2;
                if (!TsExtractor.this.k.get(i3)) {
                    s sVarA = (TsExtractor.this.e == 2 && iC == 21) ? TsExtractor.this.o : TsExtractor.this.i.a(iC, bVarA);
                    if (TsExtractor.this.e != 2 || iC2 < this.d.get(i3, 8192)) {
                        this.d.put(i3, iC2);
                        this.c.put(i3, sVarA);
                    }
                }
                i = 5;
                i2 = 4;
            }
            int size = this.d.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = this.d.keyAt(i4);
                TsExtractor.this.k.put(iKeyAt, true);
                s sVarValueAt = this.c.valueAt(i4);
                if (sVarValueAt != null) {
                    if (sVarValueAt != TsExtractor.this.o) {
                        sVarValueAt.a(wVar, TsExtractor.this.l, new s.d(iH, iKeyAt, 8192));
                    }
                    TsExtractor.this.j.put(this.d.valueAt(i4), sVarValueAt);
                }
            }
            if (TsExtractor.this.e != 2) {
                TsExtractor.this.j.remove(this.e);
                TsExtractor tsExtractor2 = TsExtractor.this;
                tsExtractor2.m = tsExtractor2.e != 1 ? TsExtractor.this.m - 1 : 0;
                if (TsExtractor.this.m != 0) {
                    return;
                } else {
                    TsExtractor.this.l.a();
                }
            } else {
                if (TsExtractor.this.n) {
                    return;
                }
                TsExtractor.this.l.a();
                TsExtractor.this.m = 0;
            }
            TsExtractor.this.n = true;
        }

        @Override // com.opos.exoplayer.core.extractor.ts.p
        public void a(w wVar, com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        }
    }

    public TsExtractor() {
        this(0);
    }

    public static /* synthetic */ int b(TsExtractor tsExtractor) {
        int i = tsExtractor.m;
        tsExtractor.m = i + 1;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00dd  */
    @Override // com.opos.exoplayer.core.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(com.opos.exoplayer.core.extractor.f fVar, com.opos.exoplayer.core.extractor.k kVar) throws com.opos.exoplayer.core.m {
        com.opos.exoplayer.core.util.p pVar = this.g;
        byte[] bArr = pVar.f8400a;
        if (9400 - pVar.d() < 188) {
            int iB = this.g.b();
            if (iB > 0) {
                System.arraycopy(bArr, this.g.d(), bArr, 0, iB);
            }
            this.g.a(bArr, iB);
        }
        while (this.g.b() < 188) {
            int iC = this.g.c();
            int iA = fVar.a(bArr, iC, 9400 - iC);
            if (iA == -1) {
                return -1;
            }
            this.g.b(iC + iA);
        }
        int iC2 = this.g.c();
        int iD = this.g.d();
        int i = iD;
        while (i < iC2 && bArr[i] != 71) {
            i++;
        }
        this.g.c(i);
        int i2 = i + 188;
        if (i2 > iC2) {
            int i3 = this.p + (i - iD);
            this.p = i3;
            if (this.e != 2 || i3 <= 376) {
                return 0;
            }
            throw new com.opos.exoplayer.core.m("Cannot find sync byte. Most likely not a Transport Stream.");
        }
        this.p = 0;
        int iO = this.g.o();
        if ((8388608 & iO) == 0) {
            boolean z = (4194304 & iO) != 0;
            int i4 = (2096896 & iO) >> 8;
            boolean z2 = (iO & 32) != 0;
            s sVar = (iO & 16) != 0 ? this.j.get(i4) : null;
            if (sVar != null) {
                if (this.e != 2) {
                    int i5 = iO & 15;
                    int i6 = this.h.get(i4, i5 - 1);
                    this.h.put(i4, i5);
                    if (i6 != i5) {
                        if (i5 != ((i6 + 1) & 15)) {
                            sVar.a();
                        }
                        if (z2) {
                            this.g.d(this.g.g());
                        }
                        this.g.b(i2);
                        sVar.a(this.g, z);
                        this.g.b(iC2);
                    }
                } else {
                    if (z2) {
                    }
                    this.g.b(i2);
                    sVar.a(this.g, z);
                    this.g.b(iC2);
                }
            }
        }
        this.g.c(i2);
        return 0;
    }

    public TsExtractor(int i) {
        this(1, i);
    }

    private void e() {
        this.k.clear();
        this.j.clear();
        SparseArray<s> sparseArrayA = this.i.a();
        int size = sparseArrayA.size();
        for (int i = 0; i < size; i++) {
            this.j.put(sparseArrayA.keyAt(i), sparseArrayA.valueAt(i));
        }
        this.j.put(0, new q(new b()));
        this.o = null;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }

    public TsExtractor(int i, int i2) {
        this(i, new w(0L), new DefaultTsPayloadReaderFactory(i2));
    }

    public TsExtractor(int i, w wVar, s.c cVar) {
        this.i = (s.c) com.opos.exoplayer.core.util.a.a(cVar);
        this.e = i;
        if (i == 1 || i == 2) {
            this.f = Collections.singletonList(wVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add(wVar);
        }
        this.g = new com.opos.exoplayer.core.util.p(new byte[AVMDLDataLoader.KeyIsIgnorePlayInfo], 0);
        this.k = new SparseBooleanArray();
        this.j = new SparseArray<>();
        this.h = new SparseIntArray();
        e();
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).d();
        }
        this.g.a();
        this.h.clear();
        e();
        this.p = 0;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(com.opos.exoplayer.core.extractor.g gVar) {
        this.l = gVar;
        gVar.a(new l.b(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.opos.exoplayer.core.extractor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        byte[] bArr = this.g.f8400a;
        fVar.c(bArr, 0, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
            }
            fVar.b(i);
            return true;
        }
        return false;
    }
}
