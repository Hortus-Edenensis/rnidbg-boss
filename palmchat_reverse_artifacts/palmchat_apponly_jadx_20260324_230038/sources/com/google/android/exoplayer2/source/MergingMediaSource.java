package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.i;
import com.google.common.collect.v;
import defpackage.c41;
import defpackage.gk0;
import defpackage.ps3;
import defpackage.u06;
import defpackage.vh;
import defpackage.w9;
import defpackage.z12;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class MergingMediaSource extends c<Integer> {
    public static final com.google.android.exoplayer2.p v = new p.c().d("MergingMediaSource").a();
    public final boolean k;
    public final boolean l;
    public final i[] m;
    public final e0[] n;
    public final ArrayList<i> o;
    public final gk0 p;
    public final Map<Object, Long> q;
    public final ps3<Object, b> r;
    public int s;
    public long[][] t;

    @Nullable
    public IllegalMergeException u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends z12 {
        public final long[] g;
        public final long[] h;

        public a(e0 e0Var, Map<Object, Long> map) {
            super(e0Var);
            int iT = e0Var.t();
            this.h = new long[e0Var.t()];
            e0.d dVar = new e0.d();
            for (int i = 0; i < iT; i++) {
                this.h[i] = e0Var.r(i, dVar).n;
            }
            int iM = e0Var.m();
            this.g = new long[iM];
            e0.b bVar = new e0.b();
            for (int i2 = 0; i2 < iM; i2++) {
                e0Var.k(i2, bVar, true);
                long jLongValue = ((Long) vh.e(map.get(bVar.b))).longValue();
                long[] jArr = this.g;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.d : jLongValue;
                jArr[i2] = jLongValue;
                long j = bVar.d;
                if (j != -9223372036854775807L) {
                    long[] jArr2 = this.h;
                    int i3 = bVar.c;
                    jArr2[i3] = jArr2[i3] - (j - jLongValue);
                }
            }
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.b k(int i, e0.b bVar, boolean z) {
            super.k(i, bVar, z);
            bVar.d = this.g[i];
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public e0.d s(int i, e0.d dVar, long j) {
            long jMin;
            super.s(i, dVar, j);
            long j2 = this.h[i];
            dVar.n = j2;
            if (j2 != -9223372036854775807L) {
                long j3 = dVar.m;
                jMin = j3 == -9223372036854775807L ? dVar.m : Math.min(j3, j2);
            }
            dVar.m = jMin;
            return dVar;
        }
    }

    public MergingMediaSource(i... iVarArr) {
        this(false, iVarArr);
    }

    public final void D() {
        e0.b bVar = new e0.b();
        for (int i = 0; i < this.s; i++) {
            long j = -this.n[0].j(i, bVar).q();
            int i2 = 1;
            while (true) {
                e0[] e0VarArr = this.n;
                if (i2 < e0VarArr.length) {
                    this.t[i][i2] = j - (-e0VarArr[i2].j(i, bVar).q());
                    i2++;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.c
    @Nullable
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public i.b x(Integer num, i.b bVar) {
        if (num.intValue() == 0) {
            return bVar;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void A(Integer num, i iVar, e0 e0Var) {
        if (this.u != null) {
            return;
        }
        if (this.s == -1) {
            this.s = e0Var.m();
        } else if (e0Var.m() != this.s) {
            this.u = new IllegalMergeException(0);
            return;
        }
        if (this.t.length == 0) {
            this.t = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.s, this.n.length);
        }
        this.o.remove(iVar);
        this.n[num.intValue()] = e0Var;
        if (this.o.isEmpty()) {
            if (this.k) {
                D();
            }
            e0 aVar = this.n[0];
            if (this.l) {
                G();
                aVar = new a(aVar, this.q);
            }
            u(aVar);
        }
    }

    public final void G() {
        e0[] e0VarArr;
        e0.b bVar = new e0.b();
        for (int i = 0; i < this.s; i++) {
            long j = Long.MIN_VALUE;
            int i2 = 0;
            while (true) {
                e0VarArr = this.n;
                if (i2 >= e0VarArr.length) {
                    break;
                }
                long jM = e0VarArr[i2].j(i, bVar).m();
                if (jM != -9223372036854775807L) {
                    long j2 = jM + this.t[i][i2];
                    if (j == Long.MIN_VALUE || j2 < j) {
                        j = j2;
                    }
                }
                i2++;
            }
            Object objQ = e0VarArr[0].q(i);
            this.q.put(objQ, Long.valueOf(j));
            Iterator<b> it = this.r.get(objQ).iterator();
            while (it.hasNext()) {
                it.next().l(0L, j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public h c(i.b bVar, w9 w9Var, long j) {
        int length = this.m.length;
        h[] hVarArr = new h[length];
        int iF = this.n[0].f(bVar.f18710a);
        for (int i = 0; i < length; i++) {
            hVarArr[i] = this.m[i].c(bVar.c(this.n[i].q(iF)), w9Var, j - this.t[iF][i]);
        }
        k kVar = new k(this.p, this.t[iF], hVarArr);
        if (!this.l) {
            return kVar;
        }
        b bVar2 = new b(kVar, true, 0L, ((Long) vh.e(this.q.get(bVar.f18710a))).longValue());
        this.r.put(bVar.f18710a, bVar2);
        return bVar2;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(h hVar) {
        if (this.l) {
            b bVar = (b) hVar;
            Iterator<Map.Entry<Object, b>> it = this.r.entries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Object, b> next = it.next();
                if (next.getValue().equals(bVar)) {
                    this.r.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            hVar = bVar.f5933a;
        }
        k kVar = (k) hVar;
        int i = 0;
        while (true) {
            i[] iVarArr = this.m;
            if (i >= iVarArr.length) {
                return;
            }
            iVarArr[i].f(kVar.d(i));
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.p getMediaItem() {
        i[] iVarArr = this.m;
        return iVarArr.length > 0 ? iVarArr[0].getMediaItem() : v;
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.u;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void t(@Nullable u06 u06Var) {
        super.t(u06Var);
        for (int i = 0; i < this.m.length; i++) {
            C(Integer.valueOf(i), this.m[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void v() {
        super.v();
        Arrays.fill(this.n, (Object) null);
        this.s = -1;
        this.u = null;
        this.o.clear();
        Collections.addAll(this.o, this.m);
    }

    public MergingMediaSource(boolean z, i... iVarArr) {
        this(z, false, iVarArr);
    }

    public MergingMediaSource(boolean z, boolean z2, i... iVarArr) {
        this(z, z2, new c41(), iVarArr);
    }

    public MergingMediaSource(boolean z, boolean z2, gk0 gk0Var, i... iVarArr) {
        this.k = z;
        this.l = z2;
        this.m = iVarArr;
        this.p = gk0Var;
        this.o = new ArrayList<>(Arrays.asList(iVarArr));
        this.s = -1;
        this.n = new e0[iVarArr.length];
        this.t = new long[0][];
        this.q = new HashMap();
        this.r = v.a().a().g();
    }
}
