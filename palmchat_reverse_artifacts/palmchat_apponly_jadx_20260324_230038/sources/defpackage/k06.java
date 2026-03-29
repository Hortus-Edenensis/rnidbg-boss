package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class k06 implements f {
    public static final k06 A;

    @Deprecated
    public static final k06 B;
    public static final String C;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;
    public static final String e0;
    public static final String f0;
    public static final String g0;

    @Deprecated
    public static final f.a<k06> h0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18545a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final ImmutableList<String> l;
    public final int m;
    public final ImmutableList<String> n;
    public final int o;
    public final int p;
    public final int q;
    public final ImmutableList<String> r;
    public final ImmutableList<String> s;
    public final int t;
    public final int u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final ImmutableMap<qz5, g06> y;
    public final ImmutableSet<Integer> z;

    static {
        k06 k06VarA = new a().A();
        A = k06VarA;
        B = k06VarA;
        C = g86.w0(1);
        E = g86.w0(2);
        F = g86.w0(3);
        G = g86.w0(4);
        H = g86.w0(5);
        I = g86.w0(6);
        J = g86.w0(7);
        K = g86.w0(8);
        L = g86.w0(9);
        M = g86.w0(10);
        N = g86.w0(11);
        O = g86.w0(12);
        P = g86.w0(13);
        Q = g86.w0(14);
        R = g86.w0(15);
        S = g86.w0(16);
        T = g86.w0(17);
        U = g86.w0(18);
        V = g86.w0(19);
        W = g86.w0(20);
        X = g86.w0(21);
        Y = g86.w0(22);
        Z = g86.w0(23);
        e0 = g86.w0(24);
        f0 = g86.w0(25);
        g0 = g86.w0(26);
        h0 = new f.a() { // from class: h06
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return k06.B(bundle);
            }
        };
    }

    public k06(a aVar) {
        this.f18545a = aVar.f18546a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = ImmutableMap.copyOf((Map) aVar.y);
        this.z = ImmutableSet.copyOf((Collection) aVar.z);
    }

    public static k06 B(Bundle bundle) {
        return new a(bundle).A();
    }

    public a A() {
        return new a(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k06 k06Var = (k06) obj;
        return this.f18545a == k06Var.f18545a && this.b == k06Var.b && this.c == k06Var.c && this.d == k06Var.d && this.e == k06Var.e && this.f == k06Var.f && this.g == k06Var.g && this.h == k06Var.h && this.k == k06Var.k && this.i == k06Var.i && this.j == k06Var.j && this.l.equals(k06Var.l) && this.m == k06Var.m && this.n.equals(k06Var.n) && this.o == k06Var.o && this.p == k06Var.p && this.q == k06Var.q && this.r.equals(k06Var.r) && this.s.equals(k06Var.s) && this.t == k06Var.t && this.u == k06Var.u && this.v == k06Var.v && this.w == k06Var.w && this.x == k06Var.x && this.y.equals(k06Var.y) && this.z.equals(k06Var.z);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.f18545a + 31) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + (this.k ? 1 : 0)) * 31) + this.i) * 31) + this.j) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t) * 31) + this.u) * 31) + (this.v ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0)) * 31) + this.y.hashCode()) * 31) + this.z.hashCode();
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(I, this.f18545a);
        bundle.putInt(J, this.b);
        bundle.putInt(K, this.c);
        bundle.putInt(L, this.d);
        bundle.putInt(M, this.e);
        bundle.putInt(N, this.f);
        bundle.putInt(O, this.g);
        bundle.putInt(P, this.h);
        bundle.putInt(Q, this.i);
        bundle.putInt(R, this.j);
        bundle.putBoolean(S, this.k);
        bundle.putStringArray(T, (String[]) this.l.toArray(new String[0]));
        bundle.putInt(f0, this.m);
        bundle.putStringArray(C, (String[]) this.n.toArray(new String[0]));
        bundle.putInt(E, this.o);
        bundle.putInt(U, this.p);
        bundle.putInt(V, this.q);
        bundle.putStringArray(W, (String[]) this.r.toArray(new String[0]));
        bundle.putStringArray(F, (String[]) this.s.toArray(new String[0]));
        bundle.putInt(G, this.t);
        bundle.putInt(g0, this.u);
        bundle.putBoolean(H, this.v);
        bundle.putBoolean(X, this.w);
        bundle.putBoolean(Y, this.x);
        bundle.putParcelableArrayList(Z, hv.i(this.y.values()));
        bundle.putIntArray(e0, ku2.p(this.z));
        return bundle;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18546a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public ImmutableList<String> l;
        public int m;
        public ImmutableList<String> n;
        public int o;
        public int p;
        public int q;
        public ImmutableList<String> r;
        public ImmutableList<String> s;
        public int t;
        public int u;
        public boolean v;
        public boolean w;
        public boolean x;
        public HashMap<qz5, g06> y;
        public HashSet<Integer> z;

        @Deprecated
        public a() {
            this.f18546a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = ImmutableList.of();
            this.m = 0;
            this.n = ImmutableList.of();
            this.o = 0;
            this.p = Integer.MAX_VALUE;
            this.q = Integer.MAX_VALUE;
            this.r = ImmutableList.of();
            this.s = ImmutableList.of();
            this.t = 0;
            this.u = 0;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = new HashMap<>();
            this.z = new HashSet<>();
        }

        public static ImmutableList<String> D(String[] strArr) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (String str : (String[]) vh.e(strArr)) {
                aVarBuilder.a(g86.J0((String) vh.e(str)));
            }
            return aVarBuilder.e();
        }

        public k06 A() {
            return new k06(this);
        }

        public a B(int i) {
            Iterator<g06> it = this.y.values().iterator();
            while (it.hasNext()) {
                if (it.next().b() == i) {
                    it.remove();
                }
            }
            return this;
        }

        public final void C(k06 k06Var) {
            this.f18546a = k06Var.f18545a;
            this.b = k06Var.b;
            this.c = k06Var.c;
            this.d = k06Var.d;
            this.e = k06Var.e;
            this.f = k06Var.f;
            this.g = k06Var.g;
            this.h = k06Var.h;
            this.i = k06Var.i;
            this.j = k06Var.j;
            this.k = k06Var.k;
            this.l = k06Var.l;
            this.m = k06Var.m;
            this.n = k06Var.n;
            this.o = k06Var.o;
            this.p = k06Var.p;
            this.q = k06Var.q;
            this.r = k06Var.r;
            this.s = k06Var.s;
            this.t = k06Var.t;
            this.u = k06Var.u;
            this.v = k06Var.v;
            this.w = k06Var.w;
            this.x = k06Var.x;
            this.z = new HashSet<>(k06Var.z);
            this.y = new HashMap<>(k06Var.y);
        }

        public a E(k06 k06Var) {
            C(k06Var);
            return this;
        }

        public a F(int i) {
            this.u = i;
            return this;
        }

        public a G(g06 g06Var) {
            B(g06Var.b());
            this.y.put(g06Var.f17630a, g06Var);
            return this;
        }

        public a H(Context context) {
            if (g86.f17680a >= 19) {
                I(context);
            }
            return this;
        }

        @RequiresApi(19)
        public final void I(Context context) {
            CaptioningManager captioningManager;
            if ((g86.f17680a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.s = ImmutableList.of(g86.Y(locale));
                }
            }
        }

        public a J(int i, boolean z) {
            if (z) {
                this.z.add(Integer.valueOf(i));
            } else {
                this.z.remove(Integer.valueOf(i));
            }
            return this;
        }

        public a K(int i, int i2, boolean z) {
            this.i = i;
            this.j = i2;
            this.k = z;
            return this;
        }

        public a L(Context context, boolean z) {
            Point pointN = g86.N(context);
            return K(pointN.x, pointN.y, z);
        }

        public a(Context context) {
            this();
            H(context);
            L(context, true);
        }

        public a(k06 k06Var) {
            C(k06Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Bundle bundle) {
            ImmutableList immutableListD;
            String str = k06.I;
            k06 k06Var = k06.A;
            this.f18546a = bundle.getInt(str, k06Var.f18545a);
            this.b = bundle.getInt(k06.J, k06Var.b);
            this.c = bundle.getInt(k06.K, k06Var.c);
            this.d = bundle.getInt(k06.L, k06Var.d);
            this.e = bundle.getInt(k06.M, k06Var.e);
            this.f = bundle.getInt(k06.N, k06Var.f);
            this.g = bundle.getInt(k06.O, k06Var.g);
            this.h = bundle.getInt(k06.P, k06Var.h);
            this.i = bundle.getInt(k06.Q, k06Var.i);
            this.j = bundle.getInt(k06.R, k06Var.j);
            this.k = bundle.getBoolean(k06.S, k06Var.k);
            this.l = ImmutableList.copyOf((String[]) fr3.a(bundle.getStringArray(k06.T), new String[0]));
            this.m = bundle.getInt(k06.f0, k06Var.m);
            this.n = D((String[]) fr3.a(bundle.getStringArray(k06.C), new String[0]));
            this.o = bundle.getInt(k06.E, k06Var.o);
            this.p = bundle.getInt(k06.U, k06Var.p);
            this.q = bundle.getInt(k06.V, k06Var.q);
            this.r = ImmutableList.copyOf((String[]) fr3.a(bundle.getStringArray(k06.W), new String[0]));
            this.s = D((String[]) fr3.a(bundle.getStringArray(k06.F), new String[0]));
            this.t = bundle.getInt(k06.G, k06Var.t);
            this.u = bundle.getInt(k06.g0, k06Var.u);
            this.v = bundle.getBoolean(k06.H, k06Var.v);
            this.w = bundle.getBoolean(k06.X, k06Var.w);
            this.x = bundle.getBoolean(k06.Y, k06Var.x);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(k06.Z);
            if (parcelableArrayList == null) {
                immutableListD = ImmutableList.of();
            } else {
                immutableListD = hv.d(g06.e, parcelableArrayList);
            }
            this.y = new HashMap<>();
            for (int i = 0; i < immutableListD.size(); i++) {
                g06 g06Var = (g06) immutableListD.get(i);
                this.y.put(g06Var.f17630a, g06Var);
            }
            int[] iArr = (int[]) fr3.a(bundle.getIntArray(k06.e0), new int[0]);
            this.z = new HashSet<>();
            for (int i2 : iArr) {
                this.z.add(Integer.valueOf(i2));
            }
        }
    }
}
