package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.p;
import com.google.common.collect.ImmutableList;
import defpackage.fv;
import defpackage.g86;
import defpackage.gv;
import defpackage.s6;
import defpackage.vh;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class e0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f5869a = new a();
    public static final String b = g86.w0(0);
    public static final String c = g86.w0(1);
    public static final String d = g86.w0(2);
    public static final f.a<e0> e = new f.a() { // from class: ey5
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return e0.b(bundle);
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class a extends e0 {
        @Override // com.google.android.exoplayer2.e0
        public int f(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.e0
        public b k(int i, b bVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.e0
        public int m() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.e0
        public Object q(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.e0
        public d s(int i, d dVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.e0
        public int t() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements f {
        public static final String h = g86.w0(0);
        public static final String i = g86.w0(1);
        public static final String j = g86.w0(2);
        public static final String k = g86.w0(3);
        public static final String l = g86.w0(4);
        public static final f.a<b> m = new f.a() { // from class: hy5
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return e0.b.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f5870a;

        @Nullable
        public Object b;
        public int c;
        public long d;
        public long e;
        public boolean f;
        public s6 g = s6.g;

        public static b c(Bundle bundle) {
            int i2 = bundle.getInt(h, 0);
            long j2 = bundle.getLong(i, -9223372036854775807L);
            long j3 = bundle.getLong(j, 0L);
            boolean z = bundle.getBoolean(k, false);
            Bundle bundle2 = bundle.getBundle(l);
            s6 s6Var = bundle2 != null ? (s6) s6.m.fromBundle(bundle2) : s6.g;
            b bVar = new b();
            bVar.w(null, null, i2, j2, j3, s6Var, z);
            return bVar;
        }

        public int d(int i2) {
            return this.g.c(i2).b;
        }

        public long e(int i2, int i3) {
            s6.a aVarC = this.g.c(i2);
            if (aVarC.b != -1) {
                return aVarC.f[i3];
            }
            return -9223372036854775807L;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return g86.c(this.f5870a, bVar.f5870a) && g86.c(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && g86.c(this.g, bVar.g);
        }

        public int f() {
            return this.g.b;
        }

        public int g(long j2) {
            return this.g.d(j2, this.d);
        }

        public int h(long j2) {
            return this.g.e(j2, this.d);
        }

        public int hashCode() {
            Object obj = this.f5870a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.c) * 31;
            long j2 = this.d;
            int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.e;
            return ((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f ? 1 : 0)) * 31) + this.g.hashCode();
        }

        public long i(int i2) {
            return this.g.c(i2).f20672a;
        }

        public long j() {
            return this.g.c;
        }

        public int k(int i2, int i3) {
            s6.a aVarC = this.g.c(i2);
            if (aVarC.b != -1) {
                return aVarC.e[i3];
            }
            return 0;
        }

        public long l(int i2) {
            return this.g.c(i2).g;
        }

        public long m() {
            return this.d;
        }

        public int n(int i2) {
            return this.g.c(i2).f();
        }

        public int o(int i2, int i3) {
            return this.g.c(i2).g(i3);
        }

        public long p() {
            return g86.m1(this.e);
        }

        public long q() {
            return this.e;
        }

        public int r() {
            return this.g.e;
        }

        public boolean s(int i2) {
            return !this.g.c(i2).h();
        }

        public boolean t(int i2) {
            return i2 == f() - 1 && this.g.f(i2);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            int i2 = this.c;
            if (i2 != 0) {
                bundle.putInt(h, i2);
            }
            long j2 = this.d;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(i, j2);
            }
            long j3 = this.e;
            if (j3 != 0) {
                bundle.putLong(j, j3);
            }
            boolean z = this.f;
            if (z) {
                bundle.putBoolean(k, z);
            }
            if (!this.g.equals(s6.g)) {
                bundle.putBundle(l, this.g.toBundle());
            }
            return bundle;
        }

        public boolean u(int i2) {
            return this.g.c(i2).h;
        }

        public b v(@Nullable Object obj, @Nullable Object obj2, int i2, long j2, long j3) {
            return w(obj, obj2, i2, j2, j3, s6.g, false);
        }

        public b w(@Nullable Object obj, @Nullable Object obj2, int i2, long j2, long j3, s6 s6Var, boolean z) {
            this.f5870a = obj;
            this.b = obj2;
            this.c = i2;
            this.d = j2;
            this.e = j3;
            this.g = s6Var;
            this.f = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends e0 {
        public final ImmutableList<d> f;
        public final ImmutableList<b> g;
        public final int[] h;
        public final int[] i;

        public c(ImmutableList<d> immutableList, ImmutableList<b> immutableList2, int[] iArr) {
            vh.a(immutableList.size() == iArr.length);
            this.f = immutableList;
            this.g = immutableList2;
            this.h = iArr;
            this.i = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.i[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.e0
        public int e(boolean z) {
            if (u()) {
                return -1;
            }
            if (z) {
                return this.h[0];
            }
            return 0;
        }

        @Override // com.google.android.exoplayer2.e0
        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.e0
        public int g(boolean z) {
            if (u()) {
                return -1;
            }
            return z ? this.h[t() - 1] : t() - 1;
        }

        @Override // com.google.android.exoplayer2.e0
        public int i(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != g(z)) {
                return z ? this.h[this.i[i] + 1] : i + 1;
            }
            if (i2 == 2) {
                return e(z);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.e0
        public b k(int i, b bVar, boolean z) {
            b bVar2 = this.g.get(i);
            bVar.w(bVar2.f5870a, bVar2.b, bVar2.c, bVar2.d, bVar2.e, bVar2.g, bVar2.f);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.e0
        public int m() {
            return this.g.size();
        }

        @Override // com.google.android.exoplayer2.e0
        public int p(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != e(z)) {
                return z ? this.h[this.i[i] - 1] : i - 1;
            }
            if (i2 == 2) {
                return g(z);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.e0
        public Object q(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.e0
        public d s(int i, d dVar, long j) {
            d dVar2 = this.f.get(i);
            dVar.i(dVar2.f5871a, dVar2.c, dVar2.d, dVar2.e, dVar2.f, dVar2.g, dVar2.h, dVar2.i, dVar2.k, dVar2.m, dVar2.n, dVar2.o, dVar2.p, dVar2.q);
            dVar.l = dVar2.l;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.e0
        public int t() {
            return this.f.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements f {

        @Nullable
        @Deprecated
        public Object b;

        @Nullable
        public Object d;
        public long e;
        public long f;
        public long g;
        public boolean h;
        public boolean i;

        @Deprecated
        public boolean j;

        @Nullable
        public p.g k;
        public boolean l;
        public long m;
        public long n;
        public int o;
        public int p;
        public long q;
        public static final Object r = new Object();
        public static final Object s = new Object();
        public static final p t = new p.c().d("com.google.android.exoplayer2.Timeline").i(Uri.EMPTY).a();
        public static final String u = g86.w0(1);
        public static final String v = g86.w0(2);
        public static final String w = g86.w0(3);
        public static final String x = g86.w0(4);
        public static final String y = g86.w0(5);
        public static final String z = g86.w0(6);
        public static final String A = g86.w0(7);
        public static final String B = g86.w0(8);
        public static final String C = g86.w0(9);
        public static final String E = g86.w0(10);
        public static final String F = g86.w0(11);
        public static final String G = g86.w0(12);
        public static final String H = g86.w0(13);
        public static final f.a<d> I = new f.a() { // from class: iy5
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return e0.d.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f5871a = r;
        public p c = t;

        public static d b(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(u);
            p pVar = bundle2 != null ? (p) p.p.fromBundle(bundle2) : p.i;
            long j = bundle.getLong(v, -9223372036854775807L);
            long j2 = bundle.getLong(w, -9223372036854775807L);
            long j3 = bundle.getLong(x, -9223372036854775807L);
            boolean z2 = bundle.getBoolean(y, false);
            boolean z3 = bundle.getBoolean(z, false);
            Bundle bundle3 = bundle.getBundle(A);
            p.g gVar = bundle3 != null ? (p.g) p.g.l.fromBundle(bundle3) : null;
            boolean z4 = bundle.getBoolean(B, false);
            long j4 = bundle.getLong(C, 0L);
            long j5 = bundle.getLong(E, -9223372036854775807L);
            int i = bundle.getInt(F, 0);
            int i2 = bundle.getInt(G, 0);
            long j6 = bundle.getLong(H, 0L);
            d dVar = new d();
            dVar.i(s, pVar, null, j, j2, j3, z2, z3, gVar, j4, j5, i, i2, j6);
            dVar.l = z4;
            return dVar;
        }

        public long c() {
            return g86.c0(this.g);
        }

        public long d() {
            return g86.m1(this.m);
        }

        public long e() {
            return this.m;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return g86.c(this.f5871a, dVar.f5871a) && g86.c(this.c, dVar.c) && g86.c(this.d, dVar.d) && g86.c(this.k, dVar.k) && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.l == dVar.l && this.m == dVar.m && this.n == dVar.n && this.o == dVar.o && this.p == dVar.p && this.q == dVar.q;
        }

        public long f() {
            return g86.m1(this.n);
        }

        public long g() {
            return this.q;
        }

        public boolean h() {
            vh.g(this.j == (this.k != null));
            return this.k != null;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f5871a.hashCode()) * 31) + this.c.hashCode()) * 31;
            Object obj = this.d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            p.g gVar = this.k;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j = this.e;
            int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.g;
            int i3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31;
            long j4 = this.m;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.n;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.o) * 31) + this.p) * 31;
            long j6 = this.q;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public d i(Object obj, @Nullable p pVar, @Nullable Object obj2, long j, long j2, long j3, boolean z2, boolean z3, @Nullable p.g gVar, long j4, long j5, int i, int i2, long j6) {
            p.h hVar;
            this.f5871a = obj;
            this.c = pVar != null ? pVar : t;
            this.b = (pVar == null || (hVar = pVar.b) == null) ? null : hVar.i;
            this.d = obj2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.h = z2;
            this.i = z3;
            this.j = gVar != null;
            this.k = gVar;
            this.m = j4;
            this.n = j5;
            this.o = i;
            this.p = i2;
            this.q = j6;
            this.l = false;
            return this;
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (!p.i.equals(this.c)) {
                bundle.putBundle(u, this.c.toBundle());
            }
            long j = this.e;
            if (j != -9223372036854775807L) {
                bundle.putLong(v, j);
            }
            long j2 = this.f;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(w, j2);
            }
            long j3 = this.g;
            if (j3 != -9223372036854775807L) {
                bundle.putLong(x, j3);
            }
            boolean z2 = this.h;
            if (z2) {
                bundle.putBoolean(y, z2);
            }
            boolean z3 = this.i;
            if (z3) {
                bundle.putBoolean(z, z3);
            }
            p.g gVar = this.k;
            if (gVar != null) {
                bundle.putBundle(A, gVar.toBundle());
            }
            boolean z4 = this.l;
            if (z4) {
                bundle.putBoolean(B, z4);
            }
            long j4 = this.m;
            if (j4 != 0) {
                bundle.putLong(C, j4);
            }
            long j5 = this.n;
            if (j5 != -9223372036854775807L) {
                bundle.putLong(E, j5);
            }
            int i = this.o;
            if (i != 0) {
                bundle.putInt(F, i);
            }
            int i2 = this.p;
            if (i2 != 0) {
                bundle.putInt(G, i2);
            }
            long j6 = this.q;
            if (j6 != 0) {
                bundle.putLong(H, j6);
            }
            return bundle;
        }
    }

    public static e0 b(Bundle bundle) {
        ImmutableList immutableListC = c(d.I, gv.a(bundle, b));
        ImmutableList immutableListC2 = c(b.m, gv.a(bundle, c));
        int[] intArray = bundle.getIntArray(d);
        if (intArray == null) {
            intArray = d(immutableListC.size());
        }
        return new c(immutableListC, immutableListC2, intArray);
    }

    public static <T extends f> ImmutableList<T> c(f.a<T> aVar, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar2 = new ImmutableList.a();
        ImmutableList<Bundle> immutableListA = fv.a(iBinder);
        for (int i = 0; i < immutableListA.size(); i++) {
            aVar2.a(aVar.fromBundle(immutableListA.get(i)));
        }
        return aVar2.e();
    }

    public static int[] d(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    public int e(boolean z) {
        return u() ? -1 : 0;
    }

    public boolean equals(@Nullable Object obj) {
        int iG;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (e0Var.t() != t() || e0Var.m() != m()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i = 0; i < t(); i++) {
            if (!r(i, dVar).equals(e0Var.r(i, dVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < m(); i2++) {
            if (!k(i2, bVar, true).equals(e0Var.k(i2, bVar2, true))) {
                return false;
            }
        }
        int iE = e(true);
        if (iE != e0Var.e(true) || (iG = g(true)) != e0Var.g(true)) {
            return false;
        }
        while (iE != iG) {
            int i3 = i(iE, 0, true);
            if (i3 != e0Var.i(iE, 0, true)) {
                return false;
            }
            iE = i3;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z) {
        if (u()) {
            return -1;
        }
        return t() - 1;
    }

    public final int h(int i, b bVar, d dVar, int i2, boolean z) {
        int i3 = j(i, bVar).c;
        if (r(i3, dVar).p != i) {
            return i + 1;
        }
        int i4 = i(i3, i2, z);
        if (i4 == -1) {
            return -1;
        }
        return r(i4, dVar).o;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iT = 217 + t();
        for (int i = 0; i < t(); i++) {
            iT = (iT * 31) + r(i, dVar).hashCode();
        }
        int iM = (iT * 31) + m();
        for (int i2 = 0; i2 < m(); i2++) {
            iM = (iM * 31) + k(i2, bVar, true).hashCode();
        }
        int iE = e(true);
        while (iE != -1) {
            iM = (iM * 31) + iE;
            iE = i(iE, 0, true);
        }
        return iM;
    }

    public int i(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == g(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == g(z) ? e(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public final b j(int i, b bVar) {
        return k(i, bVar, false);
    }

    public abstract b k(int i, b bVar, boolean z);

    public b l(Object obj, b bVar) {
        return k(f(obj), bVar, true);
    }

    public abstract int m();

    public final Pair<Object, Long> n(d dVar, b bVar, int i, long j) {
        return (Pair) vh.e(o(dVar, bVar, i, j, 0L));
    }

    @Nullable
    public final Pair<Object, Long> o(d dVar, b bVar, int i, long j, long j2) {
        vh.c(i, 0, t());
        s(i, dVar, j2);
        if (j == -9223372036854775807L) {
            j = dVar.e();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = dVar.o;
        j(i2, bVar);
        while (i2 < dVar.p && bVar.e != j) {
            int i3 = i2 + 1;
            if (j(i3, bVar).e > j) {
                break;
            }
            i2 = i3;
        }
        k(i2, bVar, true);
        long jMin = j - bVar.e;
        long j3 = bVar.d;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(jMin, j3 - 1);
        }
        return Pair.create(vh.e(bVar.b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int p(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == e(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == e(z) ? g(z) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object q(int i);

    public final d r(int i, d dVar) {
        return s(i, dVar, 0L);
    }

    public abstract d s(int i, d dVar, long j);

    public abstract int t();

    @Override // com.google.android.exoplayer2.f
    public final Bundle toBundle() {
        ArrayList arrayList = new ArrayList();
        int iT = t();
        d dVar = new d();
        for (int i = 0; i < iT; i++) {
            arrayList.add(s(i, dVar, 0L).toBundle());
        }
        ArrayList arrayList2 = new ArrayList();
        int iM = m();
        b bVar = new b();
        for (int i2 = 0; i2 < iM; i2++) {
            arrayList2.add(k(i2, bVar, false).toBundle());
        }
        int[] iArr = new int[iT];
        if (iT > 0) {
            iArr[0] = e(true);
        }
        for (int i3 = 1; i3 < iT; i3++) {
            iArr[i3] = i(iArr[i3 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        gv.c(bundle, b, new fv(arrayList));
        gv.c(bundle, c, new fv(arrayList2));
        bundle.putIntArray(d, iArr);
        return bundle;
    }

    public final boolean u() {
        return t() == 0;
    }

    public final boolean v(int i, b bVar, d dVar, int i2, boolean z) {
        return h(i, bVar, dVar, i2, z) == -1;
    }
}
