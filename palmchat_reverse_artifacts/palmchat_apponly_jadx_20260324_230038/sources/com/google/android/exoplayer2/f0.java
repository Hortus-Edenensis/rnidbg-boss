package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.f0;
import com.google.common.collect.ImmutableList;
import defpackage.fr3;
import defpackage.g86;
import defpackage.hv;
import defpackage.ku;
import defpackage.qz5;
import defpackage.vh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f0 implements f {
    public static final f0 b = new f0(ImmutableList.of());
    public static final String c = g86.w0(0);
    public static final f.a<f0> d = new f.a() { // from class: q06
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return f0.g(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<a> f5873a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements f {
        public static final String f = g86.w0(0);
        public static final String g = g86.w0(1);
        public static final String h = g86.w0(3);
        public static final String i = g86.w0(4);
        public static final f.a<a> j = new f.a() { // from class: t06
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return f0.a.k(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5874a;
        public final qz5 b;
        public final boolean c;
        public final int[] d;
        public final boolean[] e;

        public a(qz5 qz5Var, boolean z, int[] iArr, boolean[] zArr) {
            int i2 = qz5Var.f20360a;
            this.f5874a = i2;
            boolean z2 = false;
            vh.a(i2 == iArr.length && i2 == zArr.length);
            this.b = qz5Var;
            if (z && i2 > 1) {
                z2 = true;
            }
            this.c = z2;
            this.d = (int[]) iArr.clone();
            this.e = (boolean[]) zArr.clone();
        }

        public static /* synthetic */ a k(Bundle bundle) {
            qz5 qz5Var = (qz5) qz5.h.fromBundle((Bundle) vh.e(bundle.getBundle(f)));
            return new a(qz5Var, bundle.getBoolean(i, false), (int[]) fr3.a(bundle.getIntArray(g), new int[qz5Var.f20360a]), (boolean[]) fr3.a(bundle.getBooleanArray(h), new boolean[qz5Var.f20360a]));
        }

        public qz5 b() {
            return this.b;
        }

        public m c(int i2) {
            return this.b.c(i2);
        }

        public int d() {
            return this.b.c;
        }

        public boolean e() {
            return this.c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.c == aVar.c && this.b.equals(aVar.b) && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e);
        }

        public boolean f() {
            return ku.a(this.e, true);
        }

        public boolean g(boolean z) {
            for (int i2 = 0; i2 < this.d.length; i2++) {
                if (j(i2, z)) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(int i2) {
            return this.e[i2];
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
        }

        public boolean i(int i2) {
            return j(i2, false);
        }

        public boolean j(int i2, boolean z) {
            int i3 = this.d[i2];
            return i3 == 4 || (z && i3 == 3);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f, this.b.toBundle());
            bundle.putIntArray(g, this.d);
            bundle.putBooleanArray(h, this.e);
            bundle.putBoolean(i, this.c);
            return bundle;
        }
    }

    public f0(List<a> list) {
        this.f5873a = ImmutableList.copyOf((Collection) list);
    }

    public static /* synthetic */ f0 g(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(c);
        return new f0(parcelableArrayList == null ? ImmutableList.of() : hv.d(a.j, parcelableArrayList));
    }

    public ImmutableList<a> b() {
        return this.f5873a;
    }

    public boolean c() {
        return this.f5873a.isEmpty();
    }

    public boolean d(int i) {
        for (int i2 = 0; i2 < this.f5873a.size(); i2++) {
            a aVar = this.f5873a.get(i2);
            if (aVar.f() && aVar.d() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i) {
        return f(i, false);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f0.class != obj.getClass()) {
            return false;
        }
        return this.f5873a.equals(((f0) obj).f5873a);
    }

    public boolean f(int i, boolean z) {
        for (int i2 = 0; i2 < this.f5873a.size(); i2++) {
            if (this.f5873a.get(i2).d() == i && this.f5873a.get(i2).g(z)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f5873a.hashCode();
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(c, hv.i(this.f5873a));
        return bundle;
    }
}
