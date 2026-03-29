package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.z;
import com.google.common.collect.ImmutableList;
import defpackage.bd3;
import defpackage.d7;
import defpackage.k06;
import defpackage.or1;
import defpackage.t91;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class t91 extends bd3 implements a0.a {
    public static final q94<Integer> k = q94.b(new Comparator() { // from class: h91
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return t91.S((Integer) obj, (Integer) obj2);
        }
    });
    public static final q94<Integer> l = q94.b(new Comparator() { // from class: j91
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return t91.T((Integer) obj, (Integer) obj2);
        }
    });
    public final Object d;

    @Nullable
    public final Context e;
    public final or1.b f;
    public final boolean g;

    @GuardedBy("lock")
    public d h;

    @Nullable
    @GuardedBy("lock")
    public f i;

    @GuardedBy("lock")
    public com.google.android.exoplayer2.audio.a j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends h<b> implements Comparable<b> {
        public final int e;
        public final boolean f;

        @Nullable
        public final String g;
        public final d h;
        public final boolean i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;
        public final int n;
        public final int o;
        public final boolean p;
        public final int q;
        public final int r;
        public final int s;
        public final int t;
        public final boolean u;
        public final boolean v;

        public b(int i, qz5 qz5Var, int i2, d dVar, int i3, boolean z, em4<m> em4Var) {
            int i4;
            int iG;
            int iG2;
            super(i, qz5Var, i2);
            this.h = dVar;
            this.g = t91.X(this.d.c);
            this.i = t91.O(i3, false);
            int i5 = 0;
            while (true) {
                i4 = Integer.MAX_VALUE;
                if (i5 >= dVar.n.size()) {
                    i5 = Integer.MAX_VALUE;
                    iG = 0;
                    break;
                } else {
                    iG = t91.G(this.d, dVar.n.get(i5), false);
                    if (iG > 0) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.k = i5;
            this.j = iG;
            this.l = t91.K(this.d.e, dVar.o);
            m mVar = this.d;
            int i6 = mVar.e;
            this.m = i6 == 0 || (i6 & 1) != 0;
            this.p = (mVar.d & 1) != 0;
            int i7 = mVar.y;
            this.q = i7;
            this.r = mVar.z;
            int i8 = mVar.h;
            this.s = i8;
            this.f = (i8 == -1 || i8 <= dVar.q) && (i7 == -1 || i7 <= dVar.p) && em4Var.apply(mVar);
            String[] strArrJ0 = g86.j0();
            int i9 = 0;
            while (true) {
                if (i9 >= strArrJ0.length) {
                    i9 = Integer.MAX_VALUE;
                    iG2 = 0;
                    break;
                } else {
                    iG2 = t91.G(this.d, strArrJ0[i9], false);
                    if (iG2 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.n = i9;
            this.o = iG2;
            int i10 = 0;
            while (true) {
                if (i10 < dVar.r.size()) {
                    String str = this.d.l;
                    if (str != null && str.equals(dVar.r.get(i10))) {
                        i4 = i10;
                        break;
                    }
                    i10++;
                } else {
                    break;
                }
            }
            this.t = i4;
            this.u = qv4.e(i3) == 128;
            this.v = qv4.g(i3) == 64;
            this.e = f(i3, z);
        }

        public static int c(List<b> list, List<b> list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList<b> e(int i, qz5 qz5Var, d dVar, int[] iArr, boolean z, em4<m> em4Var) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i2 = 0; i2 < qz5Var.f20360a; i2++) {
                aVarBuilder.a(new b(i, qz5Var, i2, dVar, iArr[i2], z, em4Var));
            }
            return aVarBuilder.e();
        }

        @Override // t91.h
        public int a() {
            return this.e;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            q94 q94VarS = (this.f && this.i) ? t91.k : t91.k.s();
            hj0 hj0VarG = hj0.k().h(this.i, bVar.i).g(Integer.valueOf(this.k), Integer.valueOf(bVar.k), q94.o().s()).d(this.j, bVar.j).d(this.l, bVar.l).h(this.p, bVar.p).h(this.m, bVar.m).g(Integer.valueOf(this.n), Integer.valueOf(bVar.n), q94.o().s()).d(this.o, bVar.o).h(this.f, bVar.f).g(Integer.valueOf(this.t), Integer.valueOf(bVar.t), q94.o().s()).g(Integer.valueOf(this.s), Integer.valueOf(bVar.s), this.h.w ? t91.k.s() : t91.l).h(this.u, bVar.u).h(this.v, bVar.v).g(Integer.valueOf(this.q), Integer.valueOf(bVar.q), q94VarS).g(Integer.valueOf(this.r), Integer.valueOf(bVar.r), q94VarS);
            Integer numValueOf = Integer.valueOf(this.s);
            Integer numValueOf2 = Integer.valueOf(bVar.s);
            if (!g86.c(this.g, bVar.g)) {
                q94VarS = t91.l;
            }
            return hj0VarG.g(numValueOf, numValueOf2, q94VarS).j();
        }

        public final int f(int i, boolean z) {
            if (!t91.O(i, this.h.s0)) {
                return 0;
            }
            if (!this.f && !this.h.m0) {
                return 0;
            }
            if (t91.O(i, false) && this.f && this.d.h != -1) {
                d dVar = this.h;
                if (!dVar.x && !dVar.w && (dVar.u0 || !z)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // t91.h
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i;
            String str;
            int i2;
            d dVar = this.h;
            if ((dVar.p0 || ((i2 = this.d.y) != -1 && i2 == bVar.d.y)) && (dVar.n0 || ((str = this.d.l) != null && TextUtils.equals(str, bVar.d.l)))) {
                d dVar2 = this.h;
                if ((dVar2.o0 || ((i = this.d.z) != -1 && i == bVar.d.z)) && (dVar2.q0 || (this.u == bVar.u && this.v == bVar.v))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20926a;
        public final boolean b;

        public c(m mVar, int i) {
            this.f20926a = (mVar.d & 1) != 0;
            this.b = t91.O(i, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return hj0.k().h(this.b, cVar.b).h(this.f20926a, cVar.f20926a).j();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends k06 {
        public static final String A0;
        public static final String B0;
        public static final String C0;
        public static final String D0;
        public static final String E0;
        public static final String F0;
        public static final String G0;
        public static final String H0;
        public static final String I0;
        public static final String J0;
        public static final String K0;
        public static final String L0;
        public static final String M0;
        public static final String N0;
        public static final String O0;
        public static final String P0;
        public static final String Q0;
        public static final String R0;
        public static final f.a<d> S0;
        public static final d y0;

        @Deprecated
        public static final d z0;
        public final boolean i0;
        public final boolean j0;
        public final boolean k0;
        public final boolean l0;
        public final boolean m0;
        public final boolean n0;
        public final boolean o0;
        public final boolean p0;
        public final boolean q0;
        public final boolean r0;
        public final boolean s0;
        public final boolean t0;
        public final boolean u0;
        public final boolean v0;
        public final SparseArray<Map<vz5, e>> w0;
        public final SparseBooleanArray x0;

        static {
            d dVarA = new a().A();
            y0 = dVarA;
            z0 = dVarA;
            A0 = g86.w0(1000);
            B0 = g86.w0(1001);
            C0 = g86.w0(1002);
            D0 = g86.w0(1003);
            E0 = g86.w0(1004);
            F0 = g86.w0(1005);
            G0 = g86.w0(1006);
            H0 = g86.w0(1007);
            I0 = g86.w0(1008);
            J0 = g86.w0(1009);
            K0 = g86.w0(1010);
            L0 = g86.w0(1011);
            M0 = g86.w0(1012);
            N0 = g86.w0(1013);
            O0 = g86.w0(1014);
            P0 = g86.w0(1015);
            Q0 = g86.w0(1016);
            R0 = g86.w0(1017);
            S0 = new f.a() { // from class: u91
                @Override // com.google.android.exoplayer2.f.a
                public final f fromBundle(Bundle bundle) {
                    return t91.d.O(bundle);
                }
            };
        }

        public static boolean F(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean G(SparseArray<Map<vz5, e>> sparseArray, SparseArray<Map<vz5, e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (iIndexOfKey < 0 || !H(sparseArray.valueAt(i), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean H(Map<vz5, e> map, Map<vz5, e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<vz5, e> entry : map.entrySet()) {
                vz5 key = entry.getKey();
                if (!map2.containsKey(key) || !g86.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static d J(Context context) {
            return new a(context).A();
        }

        public static int[] K(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        public static /* synthetic */ d O(Bundle bundle) {
            return new a(bundle).A();
        }

        public static void P(Bundle bundle, SparseArray<Map<vz5, e>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int iKeyAt = sparseArray.keyAt(i);
                for (Map.Entry<vz5, e> entry : sparseArray.valueAt(i).entrySet()) {
                    e value = entry.getValue();
                    if (value != null) {
                        sparseArray2.put(arrayList2.size(), value);
                    }
                    arrayList2.add(entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(K0, ku2.p(arrayList));
                bundle.putParcelableArrayList(L0, hv.i(arrayList2));
                bundle.putSparseParcelableArray(M0, hv.j(sparseArray2));
            }
        }

        @Override // defpackage.k06
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public a A() {
            return new a();
        }

        public boolean L(int i) {
            return this.x0.get(i);
        }

        @Nullable
        @Deprecated
        public e M(int i, vz5 vz5Var) {
            Map<vz5, e> map = this.w0.get(i);
            if (map != null) {
                return map.get(vz5Var);
            }
            return null;
        }

        @Deprecated
        public boolean N(int i, vz5 vz5Var) {
            Map<vz5, e> map = this.w0.get(i);
            return map != null && map.containsKey(vz5Var);
        }

        @Override // defpackage.k06
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.i0 == dVar.i0 && this.j0 == dVar.j0 && this.k0 == dVar.k0 && this.l0 == dVar.l0 && this.m0 == dVar.m0 && this.n0 == dVar.n0 && this.o0 == dVar.o0 && this.p0 == dVar.p0 && this.q0 == dVar.q0 && this.r0 == dVar.r0 && this.s0 == dVar.s0 && this.t0 == dVar.t0 && this.u0 == dVar.u0 && this.v0 == dVar.v0 && F(this.x0, dVar.x0) && G(this.w0, dVar.w0);
        }

        @Override // defpackage.k06
        public int hashCode() {
            return ((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.i0 ? 1 : 0)) * 31) + (this.j0 ? 1 : 0)) * 31) + (this.k0 ? 1 : 0)) * 31) + (this.l0 ? 1 : 0)) * 31) + (this.m0 ? 1 : 0)) * 31) + (this.n0 ? 1 : 0)) * 31) + (this.o0 ? 1 : 0)) * 31) + (this.p0 ? 1 : 0)) * 31) + (this.q0 ? 1 : 0)) * 31) + (this.r0 ? 1 : 0)) * 31) + (this.s0 ? 1 : 0)) * 31) + (this.t0 ? 1 : 0)) * 31) + (this.u0 ? 1 : 0)) * 31) + (this.v0 ? 1 : 0);
        }

        @Override // defpackage.k06, com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(A0, this.i0);
            bundle.putBoolean(B0, this.j0);
            bundle.putBoolean(C0, this.k0);
            bundle.putBoolean(O0, this.l0);
            bundle.putBoolean(D0, this.m0);
            bundle.putBoolean(E0, this.n0);
            bundle.putBoolean(F0, this.o0);
            bundle.putBoolean(G0, this.p0);
            bundle.putBoolean(P0, this.q0);
            bundle.putBoolean(Q0, this.r0);
            bundle.putBoolean(H0, this.s0);
            bundle.putBoolean(I0, this.t0);
            bundle.putBoolean(J0, this.u0);
            bundle.putBoolean(R0, this.v0);
            P(bundle, this.w0);
            bundle.putIntArray(N0, K(this.x0));
            return bundle;
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class a extends k06.a {
            public boolean A;
            public boolean B;
            public boolean C;
            public boolean D;
            public boolean E;
            public boolean F;
            public boolean G;
            public boolean H;
            public boolean I;
            public boolean J;
            public boolean K;
            public boolean L;
            public boolean M;
            public boolean N;
            public final SparseArray<Map<vz5, e>> O;
            public final SparseBooleanArray P;

            public static SparseArray<Map<vz5, e>> e0(SparseArray<Map<vz5, e>> sparseArray) {
                SparseArray<Map<vz5, e>> sparseArray2 = new SparseArray<>();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
            public a J(int i, boolean z) {
                super.J(i, z);
                return this;
            }

            public a B0(boolean z) {
                this.L = z;
                return this;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
            public a K(int i, int i2, boolean z) {
                super.K(i, i2, z);
                return this;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
            public a L(Context context, boolean z) {
                super.L(context, z);
                return this;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            @Override // k06.a
            /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
            public a B(int i) {
                super.B(i);
                return this;
            }

            public final void f0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
                this.N = false;
            }

            public final SparseBooleanArray g0(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i : iArr) {
                    sparseBooleanArray.append(i, true);
                }
                return sparseBooleanArray;
            }

            public a h0(k06 k06Var) {
                super.E(k06Var);
                return this;
            }

            public a i0(boolean z) {
                this.H = z;
                return this;
            }

            public a j0(boolean z) {
                this.I = z;
                return this;
            }

            public a k0(boolean z) {
                this.F = z;
                return this;
            }

            public a l0(boolean z) {
                this.G = z;
                return this;
            }

            public a m0(boolean z) {
                this.N = z;
                return this;
            }

            public a n0(boolean z) {
                this.M = z;
                return this;
            }

            public a o0(boolean z) {
                this.D = z;
                return this;
            }

            public a p0(boolean z) {
                this.B = z;
                return this;
            }

            public a q0(boolean z) {
                this.C = z;
                return this;
            }

            public a r0(boolean z) {
                this.J = z;
                return this;
            }

            public a s0(boolean z) {
                this.E = z;
                return this;
            }

            public a t0(boolean z) {
                this.K = z;
                return this;
            }

            public a u0(boolean z) {
                this.A = z;
                return this;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a F(int i) {
                super.F(i);
                return this;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
            public a G(g06 g06Var) {
                super.G(g06Var);
                return this;
            }

            @Override // k06.a
            /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
            public a H(Context context) {
                super.H(context);
                return this;
            }

            @Deprecated
            public a y0(int i, vz5 vz5Var, @Nullable e eVar) {
                Map<vz5, e> map = this.O.get(i);
                if (map == null) {
                    map = new HashMap<>();
                    this.O.put(i, map);
                }
                if (map.containsKey(vz5Var) && g86.c(map.get(vz5Var), eVar)) {
                    return this;
                }
                map.put(vz5Var, eVar);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void z0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(d.K0);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(d.L0);
                ImmutableList immutableListOf = parcelableArrayList == null ? ImmutableList.of() : hv.d(vz5.f, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(d.M0);
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : hv.e(e.h, sparseParcelableArray);
                if (intArray == null || intArray.length != immutableListOf.size()) {
                    return;
                }
                for (int i = 0; i < intArray.length; i++) {
                    y0(intArray[i], (vz5) immutableListOf.get(i), (e) sparseArray.get(i));
                }
            }

            @Deprecated
            public a() {
                this.O = new SparseArray<>();
                this.P = new SparseBooleanArray();
                f0();
            }

            public a(Context context) {
                super(context);
                this.O = new SparseArray<>();
                this.P = new SparseBooleanArray();
                f0();
            }

            public a(d dVar) {
                super(dVar);
                this.A = dVar.i0;
                this.B = dVar.j0;
                this.C = dVar.k0;
                this.D = dVar.l0;
                this.E = dVar.m0;
                this.F = dVar.n0;
                this.G = dVar.o0;
                this.H = dVar.p0;
                this.I = dVar.q0;
                this.J = dVar.r0;
                this.K = dVar.s0;
                this.L = dVar.t0;
                this.M = dVar.u0;
                this.N = dVar.v0;
                this.O = e0(dVar.w0);
                this.P = dVar.x0.clone();
            }

            public a(Bundle bundle) {
                super(bundle);
                f0();
                d dVar = d.y0;
                u0(bundle.getBoolean(d.A0, dVar.i0));
                p0(bundle.getBoolean(d.B0, dVar.j0));
                q0(bundle.getBoolean(d.C0, dVar.k0));
                o0(bundle.getBoolean(d.O0, dVar.l0));
                s0(bundle.getBoolean(d.D0, dVar.m0));
                k0(bundle.getBoolean(d.E0, dVar.n0));
                l0(bundle.getBoolean(d.F0, dVar.o0));
                i0(bundle.getBoolean(d.G0, dVar.p0));
                j0(bundle.getBoolean(d.P0, dVar.q0));
                r0(bundle.getBoolean(d.Q0, dVar.r0));
                t0(bundle.getBoolean(d.H0, dVar.s0));
                B0(bundle.getBoolean(d.I0, dVar.t0));
                n0(bundle.getBoolean(d.J0, dVar.u0));
                m0(bundle.getBoolean(d.R0, dVar.v0));
                this.O = new SparseArray<>();
                z0(bundle);
                this.P = g0(bundle.getIntArray(d.N0));
            }
        }

        public d(a aVar) {
            super(aVar);
            this.i0 = aVar.A;
            this.j0 = aVar.B;
            this.k0 = aVar.C;
            this.l0 = aVar.D;
            this.m0 = aVar.E;
            this.n0 = aVar.F;
            this.o0 = aVar.G;
            this.p0 = aVar.H;
            this.q0 = aVar.I;
            this.r0 = aVar.J;
            this.s0 = aVar.K;
            this.t0 = aVar.L;
            this.u0 = aVar.M;
            this.v0 = aVar.N;
            this.w0 = aVar.O;
            this.x0 = aVar.P;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements com.google.android.exoplayer2.f {
        public static final String e = g86.w0(0);
        public static final String f = g86.w0(1);
        public static final String g = g86.w0(2);
        public static final f.a<e> h = new f.a() { // from class: z91
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return t91.e.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20927a;
        public final int[] b;
        public final int c;
        public final int d;

        public e(int i, int[] iArr, int i2) {
            this.f20927a = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = iArrCopyOf;
            this.c = iArr.length;
            this.d = i2;
            Arrays.sort(iArrCopyOf);
        }

        public static /* synthetic */ e b(Bundle bundle) {
            int i = bundle.getInt(e, -1);
            int[] intArray = bundle.getIntArray(f);
            int i2 = bundle.getInt(g, -1);
            vh.a(i >= 0 && i2 >= 0);
            vh.e(intArray);
            return new e(i, intArray, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f20927a == eVar.f20927a && Arrays.equals(this.b, eVar.b) && this.d == eVar.d;
        }

        public int hashCode() {
            return (((this.f20927a * 31) + Arrays.hashCode(this.b)) * 31) + this.d;
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(e, this.f20927a);
            bundle.putIntArray(f, this.b);
            bundle.putInt(g, this.d);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(32)
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Spatializer f20928a;
        public final boolean b;

        @Nullable
        public Handler c;

        @Nullable
        public Spatializer.OnSpatializerStateChangedListener d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Spatializer.OnSpatializerStateChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t91 f20929a;

            public a(t91 t91Var) {
                this.f20929a = t91Var;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                this.f20929a.V();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                this.f20929a.V();
            }
        }

        public f(Spatializer spatializer) {
            this.f20928a = spatializer;
            this.b = spatializer.getImmersiveAudioLevel() != 0;
        }

        @Nullable
        public static f g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new f(audioManager.getSpatializer());
        }

        public boolean a(com.google.android.exoplayer2.audio.a aVar, m mVar) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(g86.G(("audio/eac3-joc".equals(mVar.l) && mVar.y == 16) ? 12 : mVar.y));
            int i = mVar.z;
            if (i != -1) {
                channelMask.setSampleRate(i);
            }
            return this.f20928a.canBeSpatialized(aVar.b().f5831a, channelMask.build());
        }

        public void b(t91 t91Var, Looper looper) {
            if (this.d == null && this.c == null) {
                this.d = new a(t91Var);
                Handler handler = new Handler(looper);
                this.c = handler;
                Spatializer spatializer = this.f20928a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new bl0(handler), this.d);
            }
        }

        public boolean c() {
            return this.f20928a.isAvailable();
        }

        public boolean d() {
            return this.f20928a.isEnabled();
        }

        public boolean e() {
            return this.b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.d;
            if (onSpatializerStateChangedListener == null || this.c == null) {
                return;
            }
            this.f20928a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            ((Handler) g86.j(this.c)).removeCallbacksAndMessages(null);
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g extends h<g> implements Comparable<g> {
        public final int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;

        public g(int i, qz5 qz5Var, int i2, d dVar, int i3, @Nullable String str) {
            int iG;
            super(i, qz5Var, i2);
            int i4 = 0;
            this.f = t91.O(i3, false);
            int i5 = this.d.d & (~dVar.u);
            this.g = (i5 & 1) != 0;
            this.h = (i5 & 2) != 0;
            ImmutableList<String> immutableListOf = dVar.s.isEmpty() ? ImmutableList.of("") : dVar.s;
            int i6 = 0;
            while (true) {
                if (i6 >= immutableListOf.size()) {
                    i6 = Integer.MAX_VALUE;
                    iG = 0;
                    break;
                } else {
                    iG = t91.G(this.d, immutableListOf.get(i6), dVar.v);
                    if (iG > 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.i = i6;
            this.j = iG;
            int iK = t91.K(this.d.e, dVar.t);
            this.k = iK;
            this.m = (this.d.e & 1088) != 0;
            int iG2 = t91.G(this.d, str, t91.X(str) == null);
            this.l = iG2;
            boolean z = iG > 0 || (dVar.s.isEmpty() && iK > 0) || this.g || (this.h && iG2 > 0);
            if (t91.O(i3, dVar.s0) && z) {
                i4 = 1;
            }
            this.e = i4;
        }

        public static int c(List<g> list, List<g> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<g> e(int i, qz5 qz5Var, d dVar, int[] iArr, @Nullable String str) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i2 = 0; i2 < qz5Var.f20360a; i2++) {
                aVarBuilder.a(new g(i, qz5Var, i2, dVar, iArr[i2], str));
            }
            return aVarBuilder.e();
        }

        @Override // t91.h
        public int a() {
            return this.e;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            hj0 hj0VarD = hj0.k().h(this.f, gVar.f).g(Integer.valueOf(this.i), Integer.valueOf(gVar.i), q94.o().s()).d(this.j, gVar.j).d(this.k, gVar.k).h(this.g, gVar.g).g(Boolean.valueOf(this.h), Boolean.valueOf(gVar.h), this.j == 0 ? q94.o() : q94.o().s()).d(this.l, gVar.l);
            if (this.k == 0) {
                hj0VarD = hj0VarD.i(this.m, gVar.m);
            }
            return hj0VarD.j();
        }

        @Override // t91.h
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean b(g gVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class h<T extends h<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20930a;
        public final qz5 b;
        public final int c;
        public final m d;

        /* JADX INFO: compiled from: SearchBox */
        public interface a<T extends h<T>> {
            List<T> a(int i, qz5 qz5Var, int[] iArr);
        }

        public h(int i, qz5 qz5Var, int i2) {
            this.f20930a = i;
            this.b = qz5Var;
            this.c = i2;
            this.d = qz5Var.c(i2);
        }

        public abstract int a();

        public abstract boolean b(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i extends h<i> {
        public final boolean e;
        public final d f;
        public final boolean g;
        public final boolean h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;
        public final boolean n;
        public final int o;
        public final boolean p;
        public final boolean q;
        public final int r;

        /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public i(int i, qz5 qz5Var, int i2, d dVar, int i3, int i4, boolean z) {
            boolean z2;
            boolean z3;
            m mVar;
            int i5;
            int i6;
            int i7;
            m mVar2;
            int i8;
            int i9;
            int i10;
            super(i, qz5Var, i2);
            this.f = dVar;
            int i11 = dVar.k0 ? 24 : 16;
            this.n = dVar.j0 && (i4 & i11) != 0;
            if (!z || (((i8 = (mVar2 = this.d).q) != -1 && i8 > dVar.f18545a) || ((i9 = mVar2.r) != -1 && i9 > dVar.b))) {
                z2 = false;
            } else {
                float f = mVar2.s;
                if ((f == -1.0f || f <= dVar.c) && ((i10 = mVar2.h) == -1 || i10 <= dVar.d)) {
                    z2 = true;
                }
            }
            this.e = z2;
            if (!z || (((i5 = (mVar = this.d).q) != -1 && i5 < dVar.e) || ((i6 = mVar.r) != -1 && i6 < dVar.f))) {
                z3 = false;
            } else {
                float f2 = mVar.s;
                if ((f2 == -1.0f || f2 >= dVar.g) && ((i7 = mVar.h) == -1 || i7 >= dVar.h)) {
                    z3 = true;
                }
            }
            this.g = z3;
            this.h = t91.O(i3, false);
            m mVar3 = this.d;
            this.i = mVar3.h;
            this.j = mVar3.f();
            this.l = t91.K(this.d.e, dVar.m);
            int i12 = this.d.e;
            this.m = i12 == 0 || (i12 & 1) != 0;
            int i13 = 0;
            while (true) {
                if (i13 >= dVar.l.size()) {
                    i13 = Integer.MAX_VALUE;
                    break;
                }
                String str = this.d.l;
                if (str != null && str.equals(dVar.l.get(i13))) {
                    break;
                } else {
                    i13++;
                }
            }
            this.k = i13;
            this.p = qv4.e(i3) == 128;
            this.q = qv4.g(i3) == 64;
            this.r = t91.L(this.d.l);
            this.o = i(i3, i11);
        }

        public static int e(i iVar, i iVar2) {
            hj0 hj0VarH = hj0.k().h(iVar.h, iVar2.h).d(iVar.l, iVar2.l).h(iVar.m, iVar2.m).h(iVar.e, iVar2.e).h(iVar.g, iVar2.g).g(Integer.valueOf(iVar.k), Integer.valueOf(iVar2.k), q94.o().s()).h(iVar.p, iVar2.p).h(iVar.q, iVar2.q);
            if (iVar.p && iVar.q) {
                hj0VarH = hj0VarH.d(iVar.r, iVar2.r);
            }
            return hj0VarH.j();
        }

        public static int f(i iVar, i iVar2) {
            q94 q94VarS = (iVar.e && iVar.h) ? t91.k : t91.k.s();
            return hj0.k().g(Integer.valueOf(iVar.i), Integer.valueOf(iVar2.i), iVar.f.w ? t91.k.s() : t91.l).g(Integer.valueOf(iVar.j), Integer.valueOf(iVar2.j), q94VarS).g(Integer.valueOf(iVar.i), Integer.valueOf(iVar2.i), q94VarS).j();
        }

        public static int g(List<i> list, List<i> list2) {
            return hj0.k().g((i) Collections.max(list, new Comparator() { // from class: ia1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return t91.i.e((t91.i) obj, (t91.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: ia1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return t91.i.e((t91.i) obj, (t91.i) obj2);
                }
            }), new Comparator() { // from class: ia1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return t91.i.e((t91.i) obj, (t91.i) obj2);
                }
            }).d(list.size(), list2.size()).g((i) Collections.max(list, new Comparator() { // from class: ja1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return t91.i.f((t91.i) obj, (t91.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: ja1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return t91.i.f((t91.i) obj, (t91.i) obj2);
                }
            }), new Comparator() { // from class: ja1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return t91.i.f((t91.i) obj, (t91.i) obj2);
                }
            }).j();
        }

        public static ImmutableList<i> h(int i, qz5 qz5Var, d dVar, int[] iArr, int i2) {
            int iH = t91.H(qz5Var, dVar.i, dVar.j, dVar.k);
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i3 = 0; i3 < qz5Var.f20360a; i3++) {
                int iF = qz5Var.c(i3).f();
                aVarBuilder.a(new i(i, qz5Var, i3, dVar, iArr[i3], i2, iH == Integer.MAX_VALUE || (iF != -1 && iF <= iH)));
            }
            return aVarBuilder.e();
        }

        @Override // t91.h
        public int a() {
            return this.o;
        }

        public final int i(int i, int i2) {
            if ((this.d.e & 16384) != 0 || !t91.O(i, this.f.s0)) {
                return 0;
            }
            if (!this.e && !this.f.i0) {
                return 0;
            }
            if (t91.O(i, false) && this.g && this.e && this.d.h != -1) {
                d dVar = this.f;
                if (!dVar.x && !dVar.w && (i & i2) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // t91.h
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return (this.n || g86.c(this.d.l, iVar.d.l)) && (this.f.l0 || (this.p == iVar.p && this.q == iVar.q));
        }
    }

    public t91(Context context) {
        this(context, new d7.b());
    }

    public static void D(bd3.a aVar, d dVar, or1.a[] aVarArr) {
        int iD = aVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            vz5 vz5VarF = aVar.f(i2);
            if (dVar.N(i2, vz5VarF)) {
                e eVarM = dVar.M(i2, vz5VarF);
                aVarArr[i2] = (eVarM == null || eVarM.b.length == 0) ? null : new or1.a(vz5VarF.b(eVarM.f20927a), eVarM.b, eVarM.d);
            }
        }
    }

    public static void E(bd3.a aVar, k06 k06Var, or1.a[] aVarArr) {
        int iD = aVar.d();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < iD; i2++) {
            F(aVar.f(i2), k06Var, map);
        }
        F(aVar.h(), k06Var, map);
        for (int i3 = 0; i3 < iD; i3++) {
            g06 g06Var = (g06) map.get(Integer.valueOf(aVar.e(i3)));
            if (g06Var != null) {
                aVarArr[i3] = (g06Var.b.isEmpty() || aVar.f(i3).c(g06Var.f17630a) == -1) ? null : new or1.a(g06Var.f17630a, ku2.p(g06Var.b));
            }
        }
    }

    public static void F(vz5 vz5Var, k06 k06Var, Map<Integer, g06> map) {
        g06 g06Var;
        for (int i2 = 0; i2 < vz5Var.f21565a; i2++) {
            g06 g06Var2 = k06Var.y.get(vz5Var.b(i2));
            if (g06Var2 != null && ((g06Var = map.get(Integer.valueOf(g06Var2.b()))) == null || (g06Var.b.isEmpty() && !g06Var2.b.isEmpty()))) {
                map.put(Integer.valueOf(g06Var2.b()), g06Var2);
            }
        }
    }

    public static int G(m mVar, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(mVar.c)) {
            return 4;
        }
        String strX = X(str);
        String strX2 = X(mVar.c);
        if (strX2 == null || strX == null) {
            return (z && strX2 == null) ? 1 : 0;
        }
        if (strX2.startsWith(strX) || strX.startsWith(strX2)) {
            return 3;
        }
        return g86.a1(strX2, "-")[0].equals(g86.a1(strX, "-")[0]) ? 2 : 0;
    }

    public static int H(qz5 qz5Var, int i2, int i3, boolean z) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            for (int i6 = 0; i6 < qz5Var.f20360a; i6++) {
                m mVarC = qz5Var.c(i6);
                int i7 = mVarC.q;
                if (i7 > 0 && (i4 = mVarC.r) > 0) {
                    Point pointI = I(z, i2, i3, i7, i4);
                    int i8 = mVarC.q;
                    int i9 = mVarC.r;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (pointI.x * 0.98f)) && i9 >= ((int) (pointI.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point I(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            if ((i4 > i5) == (i2 > i3)) {
                i3 = i2;
                i2 = i3;
            }
        }
        int i6 = i4 * i2;
        int i7 = i5 * i3;
        return i6 >= i7 ? new Point(i3, g86.l(i7, i4)) : new Point(g86.l(i6, i5), i2);
    }

    public static int K(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    public static int L(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public static boolean N(m mVar) {
        String str = mVar.l;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
        }
        return false;
    }

    public static boolean O(int i2, boolean z) {
        int iF = qv4.f(i2);
        return iF == 4 || (z && iF == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List P(d dVar, boolean z, int i2, qz5 qz5Var, int[] iArr) {
        return b.e(i2, qz5Var, dVar, iArr, z, new em4() { // from class: r91
            @Override // defpackage.em4
            public final boolean apply(Object obj) {
                return this.f20419a.M((m) obj);
            }
        });
    }

    public static /* synthetic */ List Q(d dVar, String str, int i2, qz5 qz5Var, int[] iArr) {
        return g.e(i2, qz5Var, dVar, iArr, str);
    }

    public static /* synthetic */ List R(d dVar, int[] iArr, int i2, qz5 qz5Var, int[] iArr2) {
        return i.h(i2, qz5Var, dVar, iArr2, iArr[i2]);
    }

    public static /* synthetic */ int S(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int T(Integer num, Integer num2) {
        return 0;
    }

    public static void U(bd3.a aVar, int[][][] iArr, tv4[] tv4VarArr, or1[] or1VarArr) {
        boolean z;
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < aVar.d(); i4++) {
            int iE = aVar.e(i4);
            or1 or1Var = or1VarArr[i4];
            if ((iE == 1 || iE == 2) && or1Var != null && Y(iArr[i4], aVar.f(i4), or1Var)) {
                if (iE == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            tv4 tv4Var = new tv4(true);
            tv4VarArr[i3] = tv4Var;
            tv4VarArr[i2] = tv4Var;
        }
    }

    @Nullable
    public static String X(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean Y(int[][] iArr, vz5 vz5Var, or1 or1Var) {
        if (or1Var == null) {
            return false;
        }
        int iC = vz5Var.c(or1Var.getTrackGroup());
        for (int i2 = 0; i2 < or1Var.length(); i2++) {
            if (qv4.h(iArr[iC][or1Var.getIndexInTrackGroup(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.o06
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public d c() {
        d dVar;
        synchronized (this.d) {
            dVar = this.h;
        }
        return dVar;
    }

    public final boolean M(m mVar) {
        boolean z;
        f fVar;
        f fVar2;
        synchronized (this.d) {
            z = !this.h.r0 || this.g || mVar.y <= 2 || (N(mVar) && (g86.f17680a < 32 || (fVar2 = this.i) == null || !fVar2.e())) || (g86.f17680a >= 32 && (fVar = this.i) != null && fVar.e() && this.i.c() && this.i.d() && this.i.a(this.j, mVar));
        }
        return z;
    }

    public final void V() {
        boolean z;
        f fVar;
        synchronized (this.d) {
            z = this.h.r0 && !this.g && g86.f17680a >= 32 && (fVar = this.i) != null && fVar.e();
        }
        if (z) {
            f();
        }
    }

    public final void W(z zVar) {
        boolean z;
        synchronized (this.d) {
            z = this.h.v0;
        }
        if (z) {
            g(zVar);
        }
    }

    public or1.a[] Z(bd3.a aVar, int[][][] iArr, int[] iArr2, d dVar) throws ExoPlaybackException {
        String str;
        int iD = aVar.d();
        or1.a[] aVarArr = new or1.a[iD];
        Pair<or1.a, Integer> pairE0 = e0(aVar, iArr, iArr2, dVar);
        if (pairE0 != null) {
            aVarArr[((Integer) pairE0.second).intValue()] = (or1.a) pairE0.first;
        }
        Pair<or1.a, Integer> pairA0 = a0(aVar, iArr, iArr2, dVar);
        if (pairA0 != null) {
            aVarArr[((Integer) pairA0.second).intValue()] = (or1.a) pairA0.first;
        }
        if (pairA0 == null) {
            str = null;
        } else {
            Object obj = pairA0.first;
            str = ((or1.a) obj).f19816a.c(((or1.a) obj).b[0]).c;
        }
        Pair<or1.a, Integer> pairC0 = c0(aVar, iArr, dVar, str);
        if (pairC0 != null) {
            aVarArr[((Integer) pairC0.second).intValue()] = (or1.a) pairC0.first;
        }
        for (int i2 = 0; i2 < iD; i2++) {
            int iE = aVar.e(i2);
            if (iE != 2 && iE != 1 && iE != 3) {
                aVarArr[i2] = b0(iE, aVar.f(i2), iArr[i2], dVar);
            }
        }
        return aVarArr;
    }

    @Override // com.google.android.exoplayer2.a0.a
    public void a(z zVar) {
        W(zVar);
    }

    @Nullable
    public Pair<or1.a, Integer> a0(bd3.a aVar, int[][][] iArr, int[] iArr2, final d dVar) throws ExoPlaybackException {
        final boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < aVar.d()) {
                if (2 == aVar.e(i2) && aVar.f(i2).f21565a > 0) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return d0(1, aVar, iArr, new h.a() { // from class: o91
            @Override // t91.h.a
            public final List a(int i3, qz5 qz5Var, int[] iArr3) {
                return this.f19716a.P(dVar, z, i3, qz5Var, iArr3);
            }
        }, new Comparator() { // from class: p91
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return t91.b.c((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public or1.a b0(int i2, vz5 vz5Var, int[][] iArr, d dVar) throws ExoPlaybackException {
        qz5 qz5Var = null;
        c cVar = null;
        int i3 = 0;
        for (int i4 = 0; i4 < vz5Var.f21565a; i4++) {
            qz5 qz5VarB = vz5Var.b(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < qz5VarB.f20360a; i5++) {
                if (O(iArr2[i5], dVar.s0)) {
                    c cVar2 = new c(qz5VarB.c(i5), iArr2[i5]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        qz5Var = qz5VarB;
                        i3 = i5;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (qz5Var == null) {
            return null;
        }
        return new or1.a(qz5Var, i3);
    }

    @Nullable
    public Pair<or1.a, Integer> c0(bd3.a aVar, int[][][] iArr, final d dVar, @Nullable final String str) throws ExoPlaybackException {
        return d0(3, aVar, iArr, new h.a() { // from class: c91
            @Override // t91.h.a
            public final List a(int i2, qz5 qz5Var, int[] iArr2) {
                return t91.Q(dVar, str, i2, qz5Var, iArr2);
            }
        }, new Comparator() { // from class: g91
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return t91.g.c((List) obj, (List) obj2);
            }
        });
    }

    @Nullable
    public final <T extends h<T>> Pair<or1.a, Integer> d0(int i2, bd3.a aVar, int[][][] iArr, h.a<T> aVar2, Comparator<List<T>> comparator) {
        int i3;
        RandomAccess randomAccessOf;
        bd3.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int iD = aVar.d();
        int i4 = 0;
        while (i4 < iD) {
            if (i2 == aVar3.e(i4)) {
                vz5 vz5VarF = aVar3.f(i4);
                for (int i5 = 0; i5 < vz5VarF.f21565a; i5++) {
                    qz5 qz5VarB = vz5VarF.b(i5);
                    List<T> listA = aVar2.a(i4, qz5VarB, iArr[i4][i5]);
                    boolean[] zArr = new boolean[qz5VarB.f20360a];
                    int i6 = 0;
                    while (i6 < qz5VarB.f20360a) {
                        T t = listA.get(i6);
                        int iA = t.a();
                        if (zArr[i6] || iA == 0) {
                            i3 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessOf = ImmutableList.of(t);
                                i3 = iD;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(t);
                                int i7 = i6 + 1;
                                while (i7 < qz5VarB.f20360a) {
                                    T t2 = listA.get(i7);
                                    int i8 = iD;
                                    if (t2.a() == 2 && t.b(t2)) {
                                        arrayList2.add(t2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    iD = i8;
                                }
                                i3 = iD;
                                randomAccessOf = arrayList2;
                            }
                            arrayList.add(randomAccessOf);
                        }
                        i6++;
                        iD = i3;
                    }
                }
            }
            i4++;
            aVar3 = aVar;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((h) list.get(i9)).c;
        }
        h hVar = (h) list.get(0);
        return Pair.create(new or1.a(hVar.b, iArr2), Integer.valueOf(hVar.f20930a));
    }

    @Nullable
    public Pair<or1.a, Integer> e0(bd3.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) throws ExoPlaybackException {
        return d0(2, aVar, iArr, new h.a() { // from class: l91
            @Override // t91.h.a
            public final List a(int i2, qz5 qz5Var, int[] iArr3) {
                return t91.R(dVar, iArr2, i2, qz5Var, iArr3);
            }
        }, new Comparator() { // from class: m91
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return t91.i.g((List) obj, (List) obj2);
            }
        });
    }

    public final void f0(d dVar) {
        boolean z;
        vh.e(dVar);
        synchronized (this.d) {
            z = !this.h.equals(dVar);
            this.h = dVar;
        }
        if (z) {
            if (dVar.r0 && this.e == null) {
                y53.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            f();
        }
    }

    @Override // defpackage.o06
    public boolean h() {
        return true;
    }

    @Override // defpackage.o06
    public void j() {
        f fVar;
        synchronized (this.d) {
            if (g86.f17680a >= 32 && (fVar = this.i) != null) {
                fVar.f();
            }
        }
        super.j();
    }

    @Override // defpackage.o06
    public void l(com.google.android.exoplayer2.audio.a aVar) {
        boolean z;
        synchronized (this.d) {
            z = !this.j.equals(aVar);
            this.j = aVar;
        }
        if (z) {
            V();
        }
    }

    @Override // defpackage.o06
    public void m(k06 k06Var) {
        if (k06Var instanceof d) {
            f0((d) k06Var);
        }
        f0(new d.a().h0(k06Var).A());
    }

    @Override // defpackage.bd3
    public final Pair<tv4[], or1[]> q(bd3.a aVar, int[][][] iArr, int[] iArr2, i.b bVar, e0 e0Var) throws ExoPlaybackException {
        d dVar;
        f fVar;
        synchronized (this.d) {
            dVar = this.h;
            if (dVar.r0 && g86.f17680a >= 32 && (fVar = this.i) != null) {
                fVar.b(this, (Looper) vh.i(Looper.myLooper()));
            }
        }
        int iD = aVar.d();
        or1.a[] aVarArrZ = Z(aVar, iArr, iArr2, dVar);
        E(aVar, dVar, aVarArrZ);
        D(aVar, dVar, aVarArrZ);
        for (int i2 = 0; i2 < iD; i2++) {
            int iE = aVar.e(i2);
            if (dVar.L(i2) || dVar.z.contains(Integer.valueOf(iE))) {
                aVarArrZ[i2] = null;
            }
        }
        or1[] or1VarArrA = this.f.a(aVarArrZ, b(), bVar, e0Var);
        tv4[] tv4VarArr = new tv4[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            boolean z = true;
            if ((dVar.L(i3) || dVar.z.contains(Integer.valueOf(aVar.e(i3)))) || (aVar.e(i3) != -2 && or1VarArrA[i3] == null)) {
                z = false;
            }
            tv4VarArr[i3] = z ? tv4.b : null;
        }
        if (dVar.t0) {
            U(aVar, iArr, tv4VarArr, or1VarArrA);
        }
        return Pair.create(tv4VarArr, or1VarArrA);
    }

    public t91(Context context, or1.b bVar) {
        this(context, d.J(context), bVar);
    }

    public t91(Context context, k06 k06Var, or1.b bVar) {
        this(k06Var, bVar, context);
    }

    public t91(k06 k06Var, or1.b bVar, @Nullable Context context) {
        this.d = new Object();
        this.e = context != null ? context.getApplicationContext() : null;
        this.f = bVar;
        if (k06Var instanceof d) {
            this.h = (d) k06Var;
        } else {
            this.h = (context == null ? d.y0 : d.J(context)).A().h0(k06Var).A();
        }
        this.j = com.google.android.exoplayer2.audio.a.g;
        boolean z = context != null && g86.C0(context);
        this.g = z;
        if (!z && context != null && g86.f17680a >= 32) {
            this.i = f.g(context);
        }
        if (this.h.r0 && context == null) {
            y53.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    @Override // defpackage.o06
    @Nullable
    public a0.a d() {
        return this;
    }
}
