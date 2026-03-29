package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.Mask;
import defpackage.dd;
import defpackage.eu;
import defpackage.h03;
import defpackage.ii1;
import defpackage.md;
import defpackage.nd;
import defpackage.np0;
import defpackage.pd;
import defpackage.u73;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class Layer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<np0> f2525a;
    public final u73 b;
    public final String c;
    public final long d;
    public final LayerType e;
    public final long f;

    @Nullable
    public final String g;
    public final List<Mask> h;
    public final pd i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;

    @Nullable
    public final md q;

    @Nullable
    public final nd r;

    @Nullable
    public final dd s;
    public final List<h03<Float>> t;
    public final MatteType u;
    public final boolean v;

    @Nullable
    public final eu w;

    @Nullable
    public final ii1 x;

    /* JADX INFO: compiled from: SearchBox */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<np0> list, u73 u73Var, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, pd pdVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable md mdVar, @Nullable nd ndVar, List<h03<Float>> list3, MatteType matteType, @Nullable dd ddVar, boolean z, @Nullable eu euVar, @Nullable ii1 ii1Var) {
        this.f2525a = list;
        this.b = u73Var;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = pdVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = mdVar;
        this.r = ndVar;
        this.t = list3;
        this.u = matteType;
        this.s = ddVar;
        this.v = z;
        this.w = euVar;
        this.x = ii1Var;
    }

    @Nullable
    public eu a() {
        return this.w;
    }

    public u73 b() {
        return this.b;
    }

    @Nullable
    public ii1 c() {
        return this.x;
    }

    public long d() {
        return this.d;
    }

    public List<h03<Float>> e() {
        return this.t;
    }

    public LayerType f() {
        return this.e;
    }

    public List<Mask> g() {
        return this.h;
    }

    public MatteType h() {
        return this.u;
    }

    public String i() {
        return this.c;
    }

    public long j() {
        return this.f;
    }

    public int k() {
        return this.p;
    }

    public int l() {
        return this.o;
    }

    @Nullable
    public String m() {
        return this.g;
    }

    public List<np0> n() {
        return this.f2525a;
    }

    public int o() {
        return this.l;
    }

    public int p() {
        return this.k;
    }

    public int q() {
        return this.j;
    }

    public float r() {
        return this.n / this.b.e();
    }

    @Nullable
    public md s() {
        return this.q;
    }

    @Nullable
    public nd t() {
        return this.r;
    }

    public String toString() {
        return y("");
    }

    @Nullable
    public dd u() {
        return this.s;
    }

    public float v() {
        return this.m;
    }

    public pd w() {
        return this.i;
    }

    public boolean x() {
        return this.v;
    }

    public String y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        sb.append("\n");
        Layer layerT = this.b.t(j());
        if (layerT != null) {
            sb.append("\t\tParents: ");
            sb.append(layerT.i());
            Layer layerT2 = this.b.t(layerT.j());
            while (layerT2 != null) {
                sb.append("->");
                sb.append(layerT2.i());
                layerT2 = this.b.t(layerT2.j());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!g().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(g().size());
            sb.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f2525a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (np0 np0Var : this.f2525a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(np0Var);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
