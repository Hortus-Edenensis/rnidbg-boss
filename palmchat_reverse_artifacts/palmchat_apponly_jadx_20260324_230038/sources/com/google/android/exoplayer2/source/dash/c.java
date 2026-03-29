package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.f;
import com.google.common.collect.ImmutableMap;
import defpackage.a60;
import defpackage.b60;
import defpackage.bk4;
import defpackage.bt4;
import defpackage.c7;
import defpackage.cs;
import defpackage.du0;
import defpackage.es;
import defpackage.eu0;
import defpackage.fu0;
import defpackage.g86;
import defpackage.gr;
import defpackage.jo0;
import defpackage.jv;
import defpackage.od0;
import defpackage.or1;
import defpackage.ow4;
import defpackage.q43;
import defpackage.qd0;
import defpackage.te3;
import defpackage.u06;
import defpackage.ue3;
import defpackage.w45;
import defpackage.x50;
import defpackage.ys2;
import defpackage.z50;
import defpackage.zd5;
import defpackage.zt0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q43 f5949a;
    public final es b;
    public final int[] c;
    public final int d;
    public final com.google.android.exoplayer2.upstream.a e;
    public final long f;
    public final int g;

    @Nullable
    public final d.c h;
    public final b[] i;
    public or1 j;
    public zt0 k;
    public int l;

    @Nullable
    public IOException m;
    public boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements a.InterfaceC0354a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0360a f5950a;
        public final int b;
        public final z50.a c;

        public a(a.InterfaceC0360a interfaceC0360a) {
            this(interfaceC0360a, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0354a
        public com.google.android.exoplayer2.source.dash.a a(q43 q43Var, zt0 zt0Var, es esVar, int i, int[] iArr, or1 or1Var, int i2, long j, boolean z, List<m> list, @Nullable d.c cVar, @Nullable u06 u06Var, bk4 bk4Var, @Nullable od0 od0Var) {
            com.google.android.exoplayer2.upstream.a aVarCreateDataSource = this.f5950a.createDataSource();
            if (u06Var != null) {
                aVarCreateDataSource.b(u06Var);
            }
            return new c(this.c, q43Var, zt0Var, esVar, i, iArr, or1Var, i2, aVarCreateDataSource, j, this.b, z, list, cVar, bk4Var, od0Var);
        }

        public a(a.InterfaceC0360a interfaceC0360a, int i) {
            this(jv.j, interfaceC0360a, i);
        }

        public a(z50.a aVar, a.InterfaceC0360a interfaceC0360a, int i) {
            this.c = aVar;
            this.f5950a = interfaceC0360a;
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final z50 f5951a;
        public final ow4 b;
        public final cs c;

        @Nullable
        public final du0 d;
        public final long e;
        public final long f;

        public b(long j, ow4 ow4Var, cs csVar, @Nullable z50 z50Var, long j2, @Nullable du0 du0Var) {
            this.e = j;
            this.b = ow4Var;
            this.c = csVar;
            this.f = j2;
            this.f5951a = z50Var;
            this.d = du0Var;
        }

        @CheckResult
        public b b(long j, ow4 ow4Var) throws BehindLiveWindowException {
            long jD;
            long jD2;
            du0 du0VarK = this.b.k();
            du0 du0VarK2 = ow4Var.k();
            if (du0VarK == null) {
                return new b(j, ow4Var, this.c, this.f5951a, this.f, du0VarK);
            }
            if (!du0VarK.h()) {
                return new b(j, ow4Var, this.c, this.f5951a, this.f, du0VarK2);
            }
            long jE = du0VarK.e(j);
            if (jE == 0) {
                return new b(j, ow4Var, this.c, this.f5951a, this.f, du0VarK2);
            }
            long jF = du0VarK.f();
            long timeUs = du0VarK.getTimeUs(jF);
            long j2 = (jE + jF) - 1;
            long timeUs2 = du0VarK.getTimeUs(j2) + du0VarK.a(j2, j);
            long jF2 = du0VarK2.f();
            long timeUs3 = du0VarK2.getTimeUs(jF2);
            long j3 = this.f;
            if (timeUs2 == timeUs3) {
                jD = j2 + 1;
            } else {
                if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                }
                if (timeUs3 < timeUs) {
                    jD2 = j3 - (du0VarK2.d(timeUs, j) - jF);
                    return new b(j, ow4Var, this.c, this.f5951a, jD2, du0VarK2);
                }
                jD = du0VarK.d(timeUs3, j);
            }
            jD2 = j3 + (jD - jF2);
            return new b(j, ow4Var, this.c, this.f5951a, jD2, du0VarK2);
        }

        @CheckResult
        public b c(du0 du0Var) {
            return new b(this.e, this.b, this.c, this.f5951a, this.f, du0Var);
        }

        @CheckResult
        public b d(cs csVar) {
            return new b(this.e, this.b, csVar, this.f5951a, this.f, this.d);
        }

        public long e(long j) {
            return this.d.b(this.e, j) + this.f;
        }

        public long f() {
            return this.d.f() + this.f;
        }

        public long g(long j) {
            return (e(j) + this.d.i(this.e, j)) - 1;
        }

        public long h() {
            return this.d.e(this.e);
        }

        public long i(long j) {
            return k(j) + this.d.a(j - this.f, this.e);
        }

        public long j(long j) {
            return this.d.d(j, this.e) + this.f;
        }

        public long k(long j) {
            return this.d.getTimeUs(j - this.f);
        }

        public bt4 l(long j) {
            return this.d.g(j - this.f);
        }

        public boolean m(long j, long j2) {
            return this.d.h() || j2 == -9223372036854775807L || i(j) <= j2;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0355c extends gr {
        public final b e;
        public final long f;

        public C0355c(b bVar, long j, long j2, long j3) {
            super(j, j2);
            this.e = bVar;
            this.f = j3;
        }

        @Override // defpackage.ue3
        public long getChunkEndTimeUs() {
            a();
            return this.e.i(b());
        }

        @Override // defpackage.ue3
        public long getChunkStartTimeUs() {
            a();
            return this.e.k(b());
        }
    }

    public c(z50.a aVar, q43 q43Var, zt0 zt0Var, es esVar, int i, int[] iArr, or1 or1Var, int i2, com.google.android.exoplayer2.upstream.a aVar2, long j, int i3, boolean z, List<m> list, @Nullable d.c cVar, bk4 bk4Var, @Nullable od0 od0Var) {
        this.f5949a = q43Var;
        this.k = zt0Var;
        this.b = esVar;
        this.c = iArr;
        this.j = or1Var;
        this.d = i2;
        this.e = aVar2;
        this.l = i;
        this.f = j;
        this.g = i3;
        this.h = cVar;
        long jF = zt0Var.f(i);
        ArrayList<ow4> arrayListK = k();
        this.i = new b[or1Var.length()];
        int i4 = 0;
        while (i4 < this.i.length) {
            ow4 ow4Var = arrayListK.get(or1Var.getIndexInTrackGroup(i4));
            cs csVarJ = esVar.j(ow4Var.c);
            b[] bVarArr = this.i;
            if (csVarJ == null) {
                csVarJ = ow4Var.c.get(0);
            }
            int i5 = i4;
            bVarArr[i5] = new b(jF, ow4Var, csVarJ, aVar.a(i2, ow4Var.b, z, list, cVar, bk4Var), 0L, ow4Var.k());
            i4 = i5 + 1;
        }
    }

    @Override // defpackage.e60
    public long a(long j, w45 w45Var) {
        for (b bVar : this.i) {
            if (bVar.d != null) {
                long jH = bVar.h();
                if (jH != 0) {
                    long j2 = bVar.j(j);
                    long jK = bVar.k(j2);
                    return w45Var.a(j, jK, (jK >= j || (jH != -1 && j2 >= (bVar.f() + jH) - 1)) ? jK : bVar.k(j2 + 1));
                }
            }
        }
        return j;
    }

    @Override // defpackage.e60
    public boolean b(long j, x50 x50Var, List<? extends te3> list) {
        if (this.m != null) {
            return false;
        }
        return this.j.a(j, x50Var, list);
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void c(zt0 zt0Var, int i) {
        try {
            this.k = zt0Var;
            this.l = i;
            long jF = zt0Var.f(i);
            ArrayList<ow4> arrayListK = k();
            for (int i2 = 0; i2 < this.i.length; i2++) {
                ow4 ow4Var = arrayListK.get(this.j.getIndexInTrackGroup(i2));
                b[] bVarArr = this.i;
                bVarArr[i2] = bVarArr[i2].b(jF, ow4Var);
            }
        } catch (BehindLiveWindowException e) {
            this.m = e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0157  */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    @Override // defpackage.e60
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(long j, long j2, List<? extends te3> list, a60 a60Var) {
        boolean z;
        ?? r10;
        int i;
        int i2;
        ue3[] ue3VarArr;
        long j3;
        long j4;
        if (this.m != null) {
            return;
        }
        long j5 = j2 - j;
        long jH0 = g86.H0(this.k.f22506a) + g86.H0(this.k.c(this.l).b) + j2;
        d.c cVar = this.h;
        if (cVar != null && cVar.h(jH0)) {
            return;
        }
        long jH02 = g86.H0(g86.c0(this.f));
        long j6 = j(jH02);
        te3 te3Var = list.isEmpty() ? null : list.get(list.size() - 1);
        int length = this.j.length();
        ue3[] ue3VarArr2 = new ue3[length];
        int i3 = 0;
        while (i3 < length) {
            b bVar = this.i[i3];
            if (bVar.d == null) {
                ue3VarArr2[i3] = ue3.f21199a;
                i = i3;
                i2 = length;
                ue3VarArr = ue3VarArr2;
                j3 = j5;
                j4 = jH02;
            } else {
                long jE = bVar.e(jH02);
                long jG = bVar.g(jH02);
                i = i3;
                i2 = length;
                ue3VarArr = ue3VarArr2;
                j3 = j5;
                j4 = jH02;
                long jL = l(bVar, te3Var, j2, jE, jG);
                if (jL < jE) {
                    ue3VarArr[i] = ue3.f21199a;
                } else {
                    ue3VarArr[i] = new C0355c(o(i), jL, jG, j6);
                }
            }
            i3 = i + 1;
            jH02 = j4;
            ue3VarArr2 = ue3VarArr;
            length = i2;
            j5 = j3;
        }
        long j7 = j5;
        long j8 = jH02;
        this.j.b(j, j7, i(j8, j), list, ue3VarArr2);
        b bVarO = o(this.j.getSelectedIndex());
        z50 z50Var = bVarO.f5951a;
        if (z50Var != null) {
            ow4 ow4Var = bVarO.b;
            bt4 bt4VarM = z50Var.getSampleFormats() == null ? ow4Var.m() : null;
            bt4 bt4VarL = bVarO.d == null ? ow4Var.l() : null;
            if (bt4VarM != null || bt4VarL != null) {
                a60Var.f1159a = m(bVarO, this.e, this.j.getSelectedFormat(), this.j.getSelectionReason(), this.j.getSelectionData(), bt4VarM, bt4VarL, null);
                return;
            }
        }
        long j9 = bVarO.e;
        zt0 zt0Var = this.k;
        if (zt0Var.d) {
            z = true;
            r10 = 1;
            boolean z2 = this.l == zt0Var.d() - 1;
            boolean z3 = z2 || j9 != -9223372036854775807L;
            if (bVarO.h() != 0) {
                a60Var.b = z3;
                return;
            }
            long jE2 = bVarO.e(j8);
            long jG2 = bVarO.g(j8);
            if (z2) {
                long jI = bVarO.i(jG2);
                z3 &= jI + (jI - bVarO.k(jG2)) >= j9;
            }
            boolean z4 = z3;
            long jL2 = l(bVarO, te3Var, j2, jE2, jG2);
            if (jL2 < jE2) {
                this.m = new BehindLiveWindowException();
                return;
            }
            if (jL2 > jG2 || (this.n && jL2 >= jG2)) {
                a60Var.b = z4;
                return;
            }
            if (z4 && bVarO.k(jL2) >= j9) {
                a60Var.b = r10;
                return;
            }
            int iMin = (int) Math.min(this.g, (jG2 - jL2) + 1);
            if (j9 != -9223372036854775807L) {
                while (iMin > r10 && bVarO.k((((long) iMin) + jL2) - 1) >= j9) {
                    iMin--;
                }
            }
            a60Var.f1159a = n(bVarO, this.e, this.d, this.j.getSelectedFormat(), this.j.getSelectionReason(), this.j.getSelectionData(), jL2, iMin, list.isEmpty() ? j2 : -9223372036854775807L, j6, null);
            return;
        }
        z = true;
        r10 = z;
        if (z2) {
        }
        if (bVarO.h() != 0) {
        }
    }

    @Override // defpackage.e60
    public void e(x50 x50Var) {
        b60 chunkIndex;
        if (x50Var instanceof ys2) {
            int iC = this.j.c(((ys2) x50Var).d);
            b bVar = this.i[iC];
            if (bVar.d == null && (chunkIndex = bVar.f5951a.getChunkIndex()) != null) {
                this.i[iC] = bVar.c(new fu0(chunkIndex, bVar.b.d));
            }
        }
        d.c cVar = this.h;
        if (cVar != null) {
            cVar.i(x50Var);
        }
    }

    @Override // defpackage.e60
    public boolean f(x50 x50Var, boolean z, f.c cVar, f fVar) {
        f.b bVarB;
        if (!z) {
            return false;
        }
        d.c cVar2 = this.h;
        if (cVar2 != null && cVar2.j(x50Var)) {
            return true;
        }
        if (!this.k.d && (x50Var instanceof te3)) {
            IOException iOException = cVar.c;
            if ((iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar = this.i[this.j.c(x50Var.d)];
                long jH = bVar.h();
                if (jH != -1 && jH != 0) {
                    if (((te3) x50Var).e() > (bVar.f() + jH) - 1) {
                        this.n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.i[this.j.c(x50Var.d)];
        cs csVarJ = this.b.j(bVar2.b.c);
        if (csVarJ != null && !bVar2.c.equals(csVarJ)) {
            return true;
        }
        f.a aVarH = h(this.j, bVar2.b.c);
        if ((!aVarH.a(2) && !aVarH.a(1)) || (bVarB = fVar.b(aVarH, cVar)) == null || !aVarH.a(bVarB.f6025a)) {
            return false;
        }
        int i = bVarB.f6025a;
        if (i == 2) {
            or1 or1Var = this.j;
            return or1Var.excludeTrack(or1Var.c(x50Var.d), bVarB.b);
        }
        if (i != 1) {
            return false;
        }
        this.b.e(bVar2.c, bVarB.b);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void g(or1 or1Var) {
        this.j = or1Var;
    }

    @Override // defpackage.e60
    public int getPreferredQueueSize(long j, List<? extends te3> list) {
        return (this.m != null || this.j.length() < 2) ? list.size() : this.j.evaluateQueueSize(j, list);
    }

    public final f.a h(or1 or1Var, List<cs> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = or1Var.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (or1Var.isTrackExcluded(i2, jElapsedRealtime)) {
                i++;
            }
        }
        int iF = es.f(list);
        return new f.a(iF, iF - this.b.g(list), length, i);
    }

    public final long i(long j, long j2) {
        if (!this.k.d || this.i[0].h() == 0) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(j(j), this.i[0].i(this.i[0].g(j))) - j2);
    }

    public final long j(long j) {
        zt0 zt0Var = this.k;
        long j2 = zt0Var.f22506a;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - g86.H0(j2 + zt0Var.c(this.l).b);
    }

    public final ArrayList<ow4> k() {
        List<c7> list = this.k.c(this.l).c;
        ArrayList<ow4> arrayList = new ArrayList<>();
        for (int i : this.c) {
            arrayList.addAll(list.get(i).c);
        }
        return arrayList;
    }

    public final long l(b bVar, @Nullable te3 te3Var, long j, long j2, long j3) {
        return te3Var != null ? te3Var.e() : g86.r(bVar.j(j), j2, j3);
    }

    public x50 m(b bVar, com.google.android.exoplayer2.upstream.a aVar, m mVar, int i, @Nullable Object obj, @Nullable bt4 bt4Var, @Nullable bt4 bt4Var2, @Nullable qd0 qd0Var) {
        bt4 bt4Var3 = bt4Var;
        ow4 ow4Var = bVar.b;
        if (bt4Var3 != null) {
            bt4 bt4VarA = bt4Var3.a(bt4Var2, bVar.c.f16905a);
            if (bt4VarA != null) {
                bt4Var3 = bt4VarA;
            }
        } else {
            bt4Var3 = bt4Var2;
        }
        return new ys2(aVar, eu0.a(ow4Var, bVar.c.f16905a, bt4Var3, 0, qd0Var == null ? ImmutableMap.of() : qd0Var.d("i").a()), mVar, i, obj, bVar.f5951a);
    }

    @Override // defpackage.e60
    public void maybeThrowError() throws IOException {
        IOException iOException = this.m;
        if (iOException != null) {
            throw iOException;
        }
        this.f5949a.maybeThrowError();
    }

    public x50 n(b bVar, com.google.android.exoplayer2.upstream.a aVar, int i, m mVar, int i2, Object obj, long j, int i3, long j2, long j3, @Nullable qd0 qd0Var) {
        ow4 ow4Var = bVar.b;
        long jK = bVar.k(j);
        bt4 bt4VarL = bVar.l(j);
        if (bVar.f5951a == null) {
            long jI = bVar.i(j);
            return new zd5(aVar, eu0.a(ow4Var, bVar.c.f16905a, bt4VarL, bVar.m(j, j3) ? 0 : 8, qd0Var == null ? ImmutableMap.of() : qd0Var.c(jI - jK).d(qd0.b(this.j)).a()), mVar, i2, obj, jK, jI, j, i, mVar);
        }
        int i4 = 1;
        int i5 = 1;
        while (i4 < i3) {
            bt4 bt4VarA = bt4VarL.a(bVar.l(((long) i4) + j), bVar.c.f16905a);
            if (bt4VarA == null) {
                break;
            }
            i5++;
            i4++;
            bt4VarL = bt4VarA;
        }
        long j4 = (((long) i5) + j) - 1;
        long jI2 = bVar.i(j4);
        long j5 = bVar.e;
        return new jo0(aVar, eu0.a(ow4Var, bVar.c.f16905a, bt4VarL, bVar.m(j4, j3) ? 0 : 8, qd0Var == null ? ImmutableMap.of() : qd0Var.c(jI2 - jK).d(qd0.b(this.j)).a()), mVar, i2, obj, jK, jI2, j2, (j5 == -9223372036854775807L || j5 > jI2) ? -9223372036854775807L : j5, j, i5, -ow4Var.d, bVar.f5951a);
    }

    public final b o(int i) {
        b bVar = this.i[i];
        cs csVarJ = this.b.j(bVar.b.c);
        if (csVarJ == null || csVarJ.equals(bVar.c)) {
            return bVar;
        }
        b bVarD = bVar.d(csVarJ);
        this.i[i] = bVarD;
        return bVarD;
    }

    @Override // defpackage.e60
    public void release() {
        for (b bVar : this.i) {
            z50 z50Var = bVar.f5951a;
            if (z50Var != null) {
                z50Var.release();
            }
        }
    }
}
