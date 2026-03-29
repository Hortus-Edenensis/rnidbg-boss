package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.f;
import com.google.common.collect.u;
import com.huawei.openalliance.ad.constant.x;
import defpackage.ab1;
import defpackage.bk4;
import defpackage.c7;
import defpackage.cm1;
import defpackage.d25;
import defpackage.d60;
import defpackage.es;
import defpackage.g86;
import defpackage.gk0;
import defpackage.ku2;
import defpackage.mg4;
import defpackage.od0;
import defpackage.or1;
import defpackage.ow4;
import defpackage.q43;
import defpackage.qz5;
import defpackage.u06;
import defpackage.un1;
import defpackage.vn1;
import defpackage.vz5;
import defpackage.w45;
import defpackage.w9;
import defpackage.zt0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b implements h, q.a<d60<com.google.android.exoplayer2.source.dash.a>>, d60.b<com.google.android.exoplayer2.source.dash.a> {
    public static final Pattern y = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern z = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5947a;
    public final a.InterfaceC0354a b;

    @Nullable
    public final u06 c;
    public final com.google.android.exoplayer2.drm.c d;
    public final f e;
    public final es f;
    public final long g;
    public final q43 h;
    public final w9 i;
    public final vz5 j;
    public final a[] k;
    public final gk0 l;
    public final d m;
    public final j.a o;
    public final b.a p;
    public final bk4 q;

    @Nullable
    public h.a r;
    public q u;
    public zt0 v;
    public int w;
    public List<vn1> x;
    public d60<com.google.android.exoplayer2.source.dash.a>[] s = u(0);
    public un1[] t = new un1[0];
    public final IdentityHashMap<d60<com.google.android.exoplayer2.source.dash.a>, d.c> n = new IdentityHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f5948a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public a(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.b = i;
            this.f5948a = iArr;
            this.c = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.d = i6;
        }

        public static a a(int[] iArr, int i) {
            return new a(3, 1, iArr, i, -1, -1, -1);
        }

        public static a b(int[] iArr, int i) {
            return new a(5, 1, iArr, i, -1, -1, -1);
        }

        public static a c(int i) {
            return new a(5, 2, new int[0], -1, -1, -1, i);
        }

        public static a d(int i, int[] iArr, int i2, int i3, int i4) {
            return new a(i, 0, iArr, i2, i3, i4, -1);
        }
    }

    public b(int i, zt0 zt0Var, es esVar, int i2, a.InterfaceC0354a interfaceC0354a, @Nullable u06 u06Var, @Nullable od0 od0Var, com.google.android.exoplayer2.drm.c cVar, b.a aVar, f fVar, j.a aVar2, long j, q43 q43Var, w9 w9Var, gk0 gk0Var, d.b bVar, bk4 bk4Var) {
        this.f5947a = i;
        this.v = zt0Var;
        this.f = esVar;
        this.w = i2;
        this.b = interfaceC0354a;
        this.c = u06Var;
        this.d = cVar;
        this.p = aVar;
        this.e = fVar;
        this.o = aVar2;
        this.g = j;
        this.h = q43Var;
        this.i = w9Var;
        this.l = gk0Var;
        this.q = bk4Var;
        this.m = new d(zt0Var, bVar, w9Var);
        this.u = gk0Var.a(this.s);
        mg4 mg4VarC = zt0Var.c(i2);
        List<vn1> list = mg4VarC.d;
        this.x = list;
        Pair<vz5, a[]> pairK = k(cVar, mg4VarC.c, list);
        this.j = (vz5) pairK.first;
        this.k = (a[]) pairK.second;
    }

    public static void h(List<vn1> list, qz5[] qz5VarArr, a[] aVarArr, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            vn1 vn1Var = list.get(i2);
            qz5VarArr[i] = new qz5(vn1Var.a() + ":" + i2, new m.b().U(vn1Var.a()).g0("application/x-emsg").G());
            aVarArr[i] = a.c(i2);
            i2++;
            i++;
        }
    }

    public static int i(com.google.android.exoplayer2.drm.c cVar, List<c7> list, int[][] iArr, int i, boolean[] zArr, m[][] mVarArr, qz5[] qz5VarArr, a[] aVarArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int[] iArr2 = iArr[i4];
            ArrayList arrayList = new ArrayList();
            for (int i6 : iArr2) {
                arrayList.addAll(list.get(i6).c);
            }
            int size = arrayList.size();
            m[] mVarArr2 = new m[size];
            for (int i7 = 0; i7 < size; i7++) {
                m mVar = ((ow4) arrayList.get(i7)).b;
                mVarArr2[i7] = mVar.c(cVar.d(mVar));
            }
            c7 c7Var = list.get(iArr2[0]);
            long j = c7Var.f1901a;
            String string = j != -1 ? Long.toString(j) : "unset:" + i4;
            int i8 = i5 + 1;
            if (zArr[i4]) {
                i2 = i8 + 1;
            } else {
                i2 = i8;
                i8 = -1;
            }
            if (mVarArr[i4].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            qz5VarArr[i5] = new qz5(string, mVarArr2);
            aVarArr[i5] = a.d(c7Var.b, iArr2, i5, i8, i2);
            if (i8 != -1) {
                String str = string + ":emsg";
                qz5VarArr[i8] = new qz5(str, new m.b().U(str).g0("application/x-emsg").G());
                aVarArr[i8] = a.b(iArr2, i5);
            }
            if (i2 != -1) {
                qz5VarArr[i2] = new qz5(string + ":cc", mVarArr[i4]);
                aVarArr[i2] = a.a(iArr2, i5);
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    public static Pair<vz5, a[]> k(com.google.android.exoplayer2.drm.c cVar, List<c7> list, List<vn1> list2) {
        int[][] iArrP = p(list);
        int length = iArrP.length;
        boolean[] zArr = new boolean[length];
        m[][] mVarArr = new m[length][];
        int iT = t(length, list, iArrP, zArr, mVarArr) + length + list2.size();
        qz5[] qz5VarArr = new qz5[iT];
        a[] aVarArr = new a[iT];
        h(list2, qz5VarArr, aVarArr, i(cVar, list, iArrP, length, zArr, mVarArr, qz5VarArr, aVarArr));
        return Pair.create(new vz5(qz5VarArr), aVarArr);
    }

    @Nullable
    public static ab1 l(List<ab1> list) {
        return m(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    public static ab1 m(List<ab1> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            ab1 ab1Var = list.get(i);
            if (str.equals(ab1Var.f1189a)) {
                return ab1Var;
            }
        }
        return null;
    }

    @Nullable
    public static ab1 n(List<ab1> list) {
        return m(list, "http://dashif.org/guidelines/trickmode");
    }

    public static m[] o(List<c7> list, int[] iArr) {
        for (int i : iArr) {
            c7 c7Var = list.get(i);
            List<ab1> list2 = list.get(i).d;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                ab1 ab1Var = list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(ab1Var.f1189a)) {
                    return w(ab1Var, y, new m.b().g0("application/cea-608").U(c7Var.f1901a + ":cea608").G());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(ab1Var.f1189a)) {
                    return w(ab1Var, z, new m.b().g0("application/cea-708").U(c7Var.f1901a + ":cea708").G());
                }
            }
        }
        return new m[0];
    }

    public static int[][] p(List<c7> list) {
        ab1 ab1VarL;
        Integer num;
        int size = list.size();
        HashMap mapP = u.p(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i = 0; i < size; i++) {
            mapP.put(Long.valueOf(list.get(i).f1901a), Integer.valueOf(i));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i));
            arrayList.add(arrayList2);
            sparseArray.put(i, arrayList2);
        }
        for (int i2 = 0; i2 < size; i2++) {
            c7 c7Var = list.get(i2);
            ab1 ab1VarN = n(c7Var.e);
            if (ab1VarN == null) {
                ab1VarN = n(c7Var.f);
            }
            int iIntValue = (ab1VarN == null || (num = (Integer) mapP.get(Long.valueOf(Long.parseLong(ab1VarN.b)))) == null) ? i2 : num.intValue();
            if (iIntValue == i2 && (ab1VarL = l(c7Var.f)) != null) {
                for (String str : g86.Z0(ab1VarL.b, ",")) {
                    Integer num2 = (Integer) mapP.get(Long.valueOf(Long.parseLong(str)));
                    if (num2 != null) {
                        iIntValue = Math.min(iIntValue, num2.intValue());
                    }
                }
            }
            if (iIntValue != i2) {
                List list2 = (List) sparseArray.get(i2);
                List list3 = (List) sparseArray.get(iIntValue);
                list3.addAll(list2);
                sparseArray.put(i2, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i3 = 0; i3 < size2; i3++) {
            int[] iArrP = ku2.p((Collection) arrayList.get(i3));
            iArr[i3] = iArrP;
            Arrays.sort(iArrP);
        }
        return iArr;
    }

    public static boolean s(List<c7> list, int[] iArr) {
        for (int i : iArr) {
            List<ow4> list2 = list.get(i).c;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int t(int i, List<c7> list, int[][] iArr, boolean[] zArr, m[][] mVarArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (s(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            m[] mVarArrO = o(list, iArr[i3]);
            mVarArr[i3] = mVarArrO;
            if (mVarArrO.length != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static d60<com.google.android.exoplayer2.source.dash.a>[] u(int i) {
        return new d60[i];
    }

    public static m[] w(ab1 ab1Var, Pattern pattern, m mVar) {
        String str = ab1Var.b;
        if (str == null) {
            return new m[]{mVar};
        }
        String[] strArrZ0 = g86.Z0(str, x.aQ);
        m[] mVarArr = new m[strArrZ0.length];
        for (int i = 0; i < strArrZ0.length; i++) {
            Matcher matcher = pattern.matcher(strArrZ0[i]);
            if (!matcher.matches()) {
                return new m[]{mVar};
            }
            int i2 = Integer.parseInt(matcher.group(1));
            mVarArr[i] = mVar.b().U(mVar.f5892a + ":" + i2).H(i2).X(matcher.group(2)).G();
        }
        return mVarArr;
    }

    public final void A(or1[] or1VarArr, d25[] d25VarArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < or1VarArr.length; i++) {
            or1 or1Var = or1VarArr[i];
            if (or1Var != null) {
                d25 d25Var = d25VarArr[i];
                if (d25Var == null) {
                    zArr[i] = true;
                    a aVar = this.k[iArr[i]];
                    int i2 = aVar.c;
                    if (i2 == 0) {
                        d25VarArr[i] = j(aVar, or1Var, j);
                    } else if (i2 == 2) {
                        d25VarArr[i] = new un1(this.x.get(aVar.d), or1Var.getTrackGroup().c(0), this.v.d);
                    }
                } else if (d25Var instanceof d60) {
                    ((com.google.android.exoplayer2.source.dash.a) ((d60) d25Var).q()).g(or1Var);
                }
            }
        }
        for (int i3 = 0; i3 < or1VarArr.length; i3++) {
            if (d25VarArr[i3] == null && or1VarArr[i3] != null) {
                a aVar2 = this.k[iArr[i3]];
                if (aVar2.c == 1) {
                    int iQ = q(i3, iArr);
                    if (iQ == -1) {
                        d25VarArr[i3] = new cm1();
                    } else {
                        d25VarArr[i3] = ((d60) d25VarArr[iQ]).E(j, aVar2.b);
                    }
                }
            }
        }
    }

    public void B(zt0 zt0Var, int i) {
        this.v = zt0Var;
        this.w = i;
        this.m.q(zt0Var);
        d60<com.google.android.exoplayer2.source.dash.a>[] d60VarArr = this.s;
        if (d60VarArr != null) {
            for (d60<com.google.android.exoplayer2.source.dash.a> d60Var : d60VarArr) {
                ((com.google.android.exoplayer2.source.dash.a) d60Var.q()).c(zt0Var, i);
            }
            this.r.c(this);
        }
        this.x = zt0Var.c(i).d;
        for (un1 un1Var : this.t) {
            Iterator<vn1> it = this.x.iterator();
            while (true) {
                if (it.hasNext()) {
                    vn1 next = it.next();
                    if (next.a().equals(un1Var.a())) {
                        un1Var.d(next, zt0Var.d && i == zt0Var.d() - 1);
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        for (d60<com.google.android.exoplayer2.source.dash.a> d60Var : this.s) {
            if (d60Var.f16981a == 2) {
                return d60Var.a(j, w45Var);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        int[] iArrR = r(or1VarArr);
        y(or1VarArr, zArr, d25VarArr);
        z(or1VarArr, d25VarArr, iArrR);
        A(or1VarArr, d25VarArr, zArr2, j, iArrR);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d25 d25Var : d25VarArr) {
            if (d25Var instanceof d60) {
                arrayList.add((d60) d25Var);
            } else if (d25Var instanceof un1) {
                arrayList2.add((un1) d25Var);
            }
        }
        d60<com.google.android.exoplayer2.source.dash.a>[] d60VarArrU = u(arrayList.size());
        this.s = d60VarArrU;
        arrayList.toArray(d60VarArrU);
        un1[] un1VarArr = new un1[arrayList2.size()];
        this.t = un1VarArr;
        arrayList2.toArray(un1VarArr);
        this.u = this.l.a(this.s);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        return this.u.continueLoading(j);
    }

    @Override // d60.b
    public synchronized void d(d60<com.google.android.exoplayer2.source.dash.a> d60Var) {
        d.c cVarRemove = this.n.remove(d60Var);
        if (cVarRemove != null) {
            cVarRemove.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z2) {
        for (d60<com.google.android.exoplayer2.source.dash.a> d60Var : this.s) {
            d60Var.discardBuffer(j, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        this.r = aVar;
        aVar.f(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.u.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.u.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.u.isLoading();
    }

    public final d60<com.google.android.exoplayer2.source.dash.a> j(a aVar, or1 or1Var, long j) {
        qz5 qz5VarB;
        int i;
        qz5 qz5VarB2;
        int i2;
        int i3 = aVar.f;
        boolean z2 = i3 != -1;
        d.c cVarK = null;
        if (z2) {
            qz5VarB = this.j.b(i3);
            i = 1;
        } else {
            qz5VarB = null;
            i = 0;
        }
        int i4 = aVar.g;
        boolean z3 = i4 != -1;
        if (z3) {
            qz5VarB2 = this.j.b(i4);
            i += qz5VarB2.f20360a;
        } else {
            qz5VarB2 = null;
        }
        m[] mVarArr = new m[i];
        int[] iArr = new int[i];
        if (z2) {
            mVarArr[0] = qz5VarB.c(0);
            iArr[0] = 5;
            i2 = 1;
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            for (int i5 = 0; i5 < qz5VarB2.f20360a; i5++) {
                m mVarC = qz5VarB2.c(i5);
                mVarArr[i2] = mVarC;
                iArr[i2] = 3;
                arrayList.add(mVarC);
                i2++;
            }
        }
        if (this.v.d && z2) {
            cVarK = this.m.k();
        }
        d.c cVar = cVarK;
        d60<com.google.android.exoplayer2.source.dash.a> d60Var = new d60<>(aVar.b, iArr, mVarArr, this.b.a(this.h, this.v, this.f, this.w, aVar.f5948a, or1Var, aVar.b, this.g, z2, arrayList, cVar, this.c, this.q, null), this, this.i, j, this.d, this.p, this.e, this.o);
        synchronized (this) {
            this.n.put(d60Var, cVar);
        }
        return d60Var;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        this.h.maybeThrowError();
    }

    public final int q(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.k[i2].e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.k[i5].c == 0) {
                return i4;
            }
        }
        return -1;
    }

    public final int[] r(or1[] or1VarArr) {
        int[] iArr = new int[or1VarArr.length];
        for (int i = 0; i < or1VarArr.length; i++) {
            or1 or1Var = or1VarArr[i];
            if (or1Var != null) {
                iArr[i] = this.j.c(or1Var.getTrackGroup());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        this.u.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j) {
        for (d60<com.google.android.exoplayer2.source.dash.a> d60Var : this.s) {
            d60Var.D(j);
        }
        for (un1 un1Var : this.t) {
            un1Var.b(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void c(d60<com.google.android.exoplayer2.source.dash.a> d60Var) {
        this.r.c(this);
    }

    public void x() {
        this.m.o();
        for (d60<com.google.android.exoplayer2.source.dash.a> d60Var : this.s) {
            d60Var.B(this);
        }
        this.r = null;
    }

    public final void y(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr) {
        for (int i = 0; i < or1VarArr.length; i++) {
            if (or1VarArr[i] == null || !zArr[i]) {
                d25 d25Var = d25VarArr[i];
                if (d25Var instanceof d60) {
                    ((d60) d25Var).B(this);
                } else if (d25Var instanceof d60.a) {
                    ((d60.a) d25Var).b();
                }
                d25VarArr[i] = null;
            }
        }
    }

    public final void z(or1[] or1VarArr, d25[] d25VarArr, int[] iArr) {
        boolean z2;
        for (int i = 0; i < or1VarArr.length; i++) {
            d25 d25Var = d25VarArr[i];
            if ((d25Var instanceof cm1) || (d25Var instanceof d60.a)) {
                int iQ = q(i, iArr);
                if (iQ == -1) {
                    z2 = d25VarArr[i] instanceof cm1;
                } else {
                    d25 d25Var2 = d25VarArr[i];
                    z2 = (d25Var2 instanceof d60.a) && ((d60.a) d25Var2).f16982a == d25VarArr[iQ];
                }
                if (!z2) {
                    d25 d25Var3 = d25VarArr[i];
                    if (d25Var3 instanceof d60.a) {
                        ((d60.a) d25Var3).b();
                    }
                    d25VarArr[i] = null;
                }
            }
        }
    }
}
