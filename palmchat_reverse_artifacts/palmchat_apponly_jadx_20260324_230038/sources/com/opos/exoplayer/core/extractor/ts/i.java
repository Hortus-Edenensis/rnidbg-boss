package com.opos.exoplayer.core.extractor.ts;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import com.opos.exoplayer.core.util.n;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f8232a;
    private final boolean b;
    private final boolean c;
    private long g;
    private String i;
    private com.opos.exoplayer.core.extractor.n j;
    private b k;
    private boolean l;
    private long m;
    private final boolean[] h = new boolean[3];
    private final t d = new t(7, 128);
    private final t e = new t(8, 128);
    private final t f = new t(6, 128);
    private final com.opos.exoplayer.core.util.p n = new com.opos.exoplayer.core.util.p();

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.extractor.n f8233a;
        private final boolean b;
        private final boolean c;
        private final SparseArray<n.b> d = new SparseArray<>();
        private final SparseArray<n.a> e = new SparseArray<>();
        private final com.opos.exoplayer.core.util.q f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private a m;
        private a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f8234a;
            private boolean b;
            private n.b c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private a() {
            }

            public void a() {
                this.b = false;
                this.f8234a = false;
            }

            public boolean b() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }

            public void a(int i) {
                this.e = i;
                this.b = true;
            }

            public void a(n.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = bVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.f8234a = true;
                this.b = true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(a aVar) {
                boolean z;
                boolean z2;
                if (this.f8234a) {
                    if (!aVar.f8234a || this.f != aVar.f || this.g != aVar.g || this.h != aVar.h) {
                        return true;
                    }
                    if (this.i && aVar.i && this.j != aVar.j) {
                        return true;
                    }
                    int i = this.d;
                    int i2 = aVar.d;
                    if (i != i2 && (i == 0 || i2 == 0)) {
                        return true;
                    }
                    int i3 = this.c.h;
                    if (i3 == 0 && aVar.c.h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                        return true;
                    }
                    if ((i3 == 1 && aVar.c.h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
                        return true;
                    }
                    if (z && z2 && this.l != aVar.l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public b(com.opos.exoplayer.core.extractor.n nVar, boolean z, boolean z2) {
            this.f8233a = nVar;
            this.b = z;
            this.c = z2;
            this.m = new a();
            this.n = new a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new com.opos.exoplayer.core.util.q(bArr, 0, 0);
            b();
        }

        private void a(int i) {
            boolean z = this.r;
            this.f8233a.a(this.q, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        public void b() {
            this.k = false;
            this.o = false;
            this.n.a();
        }

        public void a(long j, int i) {
            boolean z = false;
            if (this.i == 9 || (this.c && this.n.a(this.m))) {
                if (this.o) {
                    a(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            boolean z2 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (this.b && i2 == 1 && this.n.b())) {
                z = true;
            }
            this.r = z2 | z;
        }

        public void a(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.a();
            this.h = 0;
            this.k = true;
        }

        public void a(n.a aVar) {
            this.e.append(aVar.f8397a, aVar);
        }

        public void a(n.b bVar) {
            this.d.append(bVar.f8398a, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean zB;
            boolean z3;
            int iD;
            int i3;
            int i4;
            int i5;
            int iE;
            int iE2;
            if (this.k) {
                int i6 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i7 = this.h + i6;
                if (length < i7) {
                    this.g = Arrays.copyOf(bArr2, i7 * 2);
                }
                System.arraycopy(bArr, i, this.g, this.h, i6);
                int i8 = this.h + i6;
                this.h = i8;
                this.f.a(this.g, 0, i8);
                if (this.f.b(8)) {
                    this.f.a();
                    int iC = this.f.c(2);
                    this.f.a(5);
                    if (this.f.c()) {
                        this.f.d();
                        if (this.f.c()) {
                            int iD2 = this.f.d();
                            if (!this.c) {
                                this.k = false;
                                this.n.a(iD2);
                                return;
                            }
                            if (this.f.c()) {
                                int iD3 = this.f.d();
                                if (this.e.indexOfKey(iD3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                n.a aVar = this.e.get(iD3);
                                n.b bVar = this.d.get(aVar.b);
                                if (bVar.e) {
                                    if (!this.f.b(2)) {
                                        return;
                                    } else {
                                        this.f.a(2);
                                    }
                                }
                                if (this.f.b(bVar.g)) {
                                    int iC2 = this.f.c(bVar.g);
                                    if (bVar.f) {
                                        z = false;
                                    } else {
                                        if (!this.f.b(1)) {
                                            return;
                                        }
                                        boolean zB2 = this.f.b();
                                        if (zB2) {
                                            if (this.f.b(1)) {
                                                z = zB2;
                                                zB = this.f.b();
                                                z2 = true;
                                                z3 = this.i != 5;
                                                if (z3) {
                                                    iD = 0;
                                                } else if (!this.f.c()) {
                                                    return;
                                                } else {
                                                    iD = this.f.d();
                                                }
                                                i3 = bVar.h;
                                                if (i3 != 0) {
                                                    if (!this.f.b(bVar.i)) {
                                                        return;
                                                    }
                                                    int iC3 = this.f.c(bVar.i);
                                                    if (aVar.c && !z) {
                                                        if (this.f.c()) {
                                                            iE = this.f.e();
                                                            i4 = iC3;
                                                            i5 = 0;
                                                            iE2 = 0;
                                                            this.n.a(bVar, iC, iD2, iC2, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i4 = iC3;
                                                } else {
                                                    if (i3 == 1 && !bVar.j) {
                                                        if (this.f.c()) {
                                                            int iE3 = this.f.e();
                                                            if (!aVar.c || z) {
                                                                i5 = iE3;
                                                                i4 = 0;
                                                                iE = 0;
                                                                iE2 = 0;
                                                                this.n.a(bVar, iC, iD2, iC2, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                                                this.k = false;
                                                            }
                                                            if (this.f.c()) {
                                                                iE2 = this.f.e();
                                                                i5 = iE3;
                                                                i4 = 0;
                                                                iE = 0;
                                                                this.n.a(bVar, iC, iD2, iC2, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                                                this.k = false;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    i4 = 0;
                                                }
                                                iE = 0;
                                                i5 = 0;
                                                iE2 = 0;
                                                this.n.a(bVar, iC, iD2, iC2, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = zB2;
                                    }
                                    z2 = false;
                                    zB = false;
                                    if (this.i != 5) {
                                    }
                                    if (z3) {
                                    }
                                    i3 = bVar.h;
                                    if (i3 != 0) {
                                    }
                                    iE = 0;
                                    i5 = 0;
                                    iE2 = 0;
                                    this.n.a(bVar, iC, iD2, iC2, iD3, z, z2, zB, z3, iD, i4, iE, i5, iE2);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean a() {
            return this.c;
        }
    }

    public i(u uVar, boolean z, boolean z2) {
        this.f8232a = uVar;
        this.b = z;
        this.c = z2;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        com.opos.exoplayer.core.util.n.a(this.h);
        this.d.a();
        this.e.a();
        this.f.a();
        this.k.b();
        this.g = 0L;
    }

    private void a(long j, int i, int i2, long j2) {
        t tVar;
        if (!this.l || this.k.a()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.b()) {
                    t tVar2 = this.d;
                    this.k.a(com.opos.exoplayer.core.util.n.a(tVar2.f8248a, 3, tVar2.b));
                    tVar = this.d;
                } else if (this.e.b()) {
                    t tVar3 = this.e;
                    this.k.a(com.opos.exoplayer.core.util.n.b(tVar3.f8248a, 3, tVar3.b));
                    tVar = this.e;
                }
            } else if (this.d.b() && this.e.b()) {
                ArrayList arrayList = new ArrayList();
                t tVar4 = this.d;
                arrayList.add(Arrays.copyOf(tVar4.f8248a, tVar4.b));
                t tVar5 = this.e;
                arrayList.add(Arrays.copyOf(tVar5.f8248a, tVar5.b));
                t tVar6 = this.d;
                n.b bVarA = com.opos.exoplayer.core.util.n.a(tVar6.f8248a, 3, tVar6.b);
                t tVar7 = this.e;
                n.a aVarB = com.opos.exoplayer.core.util.n.b(tVar7.f8248a, 3, tVar7.b);
                this.j.a(Format.a(this.i, "video/avc", (String) null, -1, -1, bVarA.b, bVarA.c, -1.0f, arrayList, -1, bVarA.d, (DrmInitData) null));
                this.l = true;
                this.k.a(bVarA);
                this.k.a(aVarB);
                this.d.a();
                tVar = this.e;
            }
            tVar.a();
        }
        if (this.f.b(i2)) {
            t tVar8 = this.f;
            this.n.a(this.f.f8248a, com.opos.exoplayer.core.util.n.a(tVar8.f8248a, tVar8.b));
            this.n.c(4);
            this.f8232a.a(j2, this.n);
        }
        this.k.a(j, i);
    }

    private void a(long j, int i, long j2) {
        if (!this.l || this.k.a()) {
            this.d.a(i);
            this.e.a(i);
        }
        this.f.a(i);
        this.k.a(j, i, j2);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        this.m = j;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        this.i = dVar.c();
        com.opos.exoplayer.core.extractor.n nVarA = gVar.a(dVar.b(), 2);
        this.j = nVarA;
        this.k = new b(nVarA, this.b, this.c);
        this.f8232a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        int iD = pVar.d();
        int iC = pVar.c();
        byte[] bArr = pVar.f8400a;
        this.g += (long) pVar.b();
        this.j.a(pVar, pVar.b());
        while (true) {
            int iA = com.opos.exoplayer.core.util.n.a(bArr, iD, iC, this.h);
            if (iA == iC) {
                a(bArr, iD, iC);
                return;
            }
            int iB = com.opos.exoplayer.core.util.n.b(bArr, iA);
            int i = iA - iD;
            if (i > 0) {
                a(bArr, iD, iA);
            }
            int i2 = iC - iA;
            long j = this.g - ((long) i2);
            a(j, i2, i < 0 ? -i : 0, this.m);
            a(j, iB, this.m);
            iD = iA + 3;
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.a()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }
}
