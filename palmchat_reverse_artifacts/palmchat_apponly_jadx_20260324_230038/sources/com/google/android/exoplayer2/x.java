package com.google.android.exoplayer2;

import com.google.android.exoplayer2.e0;
import defpackage.g86;
import defpackage.ga5;
import defpackage.hm3;
import defpackage.s6;
import defpackage.z12;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class x extends com.google.android.exoplayer2.a {
    public final int i;
    public final int j;
    public final int[] k;
    public final int[] l;
    public final e0[] m;
    public final Object[] n;
    public final HashMap<Object, Integer> o;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends z12 {
        public final e0.d g;

        public a(e0 e0Var) {
            super(e0Var);
            this.g = new e0.d();
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.b k(int i, e0.b bVar, boolean z) {
            e0.b bVarK = super.k(i, bVar, z);
            if (super.r(bVarK.c, this.g).h()) {
                bVarK.w(bVar.f5870a, bVar.b, bVar.c, bVar.d, bVar.e, s6.g, true);
            } else {
                bVarK.f = true;
            }
            return bVarK;
        }
    }

    public x(Collection<? extends hm3> collection, ga5 ga5Var) {
        this(K(collection), L(collection), ga5Var);
    }

    public static e0[] K(Collection<? extends hm3> collection) {
        e0[] e0VarArr = new e0[collection.size()];
        Iterator<? extends hm3> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            e0VarArr[i] = it.next().getTimeline();
            i++;
        }
        return e0VarArr;
    }

    public static Object[] L(Collection<? extends hm3> collection) {
        Object[] objArr = new Object[collection.size()];
        Iterator<? extends hm3> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next().getUid();
            i++;
        }
        return objArr;
    }

    @Override // com.google.android.exoplayer2.a
    public Object B(int i) {
        return this.n[i];
    }

    @Override // com.google.android.exoplayer2.a
    public int D(int i) {
        return this.k[i];
    }

    @Override // com.google.android.exoplayer2.a
    public int E(int i) {
        return this.l[i];
    }

    @Override // com.google.android.exoplayer2.a
    public e0 H(int i) {
        return this.m[i];
    }

    public x I(ga5 ga5Var) {
        e0[] e0VarArr = new e0[this.m.length];
        int i = 0;
        while (true) {
            e0[] e0VarArr2 = this.m;
            if (i >= e0VarArr2.length) {
                return new x(e0VarArr, this.n, ga5Var);
            }
            e0VarArr[i] = new a(e0VarArr2[i]);
            i++;
        }
    }

    public List<e0> J() {
        return Arrays.asList(this.m);
    }

    @Override // com.google.android.exoplayer2.e0
    public int m() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.e0
    public int t() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.a
    public int w(Object obj) {
        Integer num = this.o.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.a
    public int x(int i) {
        return g86.h(this.k, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    public int y(int i) {
        return g86.h(this.l, i + 1, false, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(e0[] e0VarArr, Object[] objArr, ga5 ga5Var) {
        super(false, ga5Var);
        int i = 0;
        int length = e0VarArr.length;
        this.m = e0VarArr;
        this.k = new int[length];
        this.l = new int[length];
        this.n = objArr;
        this.o = new HashMap<>();
        int length2 = e0VarArr.length;
        int iT = 0;
        int iM = 0;
        int i2 = 0;
        while (i < length2) {
            e0 e0Var = e0VarArr[i];
            this.m[i2] = e0Var;
            this.l[i2] = iT;
            this.k[i2] = iM;
            iT += e0Var.t();
            iM += this.m[i2].m();
            this.o.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.i = iT;
        this.j = iM;
    }
}
