package com.bytedance.adsdk.lottie.model.layer;

import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.u.l f4989a;
    private final long b;
    private final com.bytedance.adsdk.lottie.model.u.nr bg;
    private final List<com.bytedance.adsdk.lottie.iz.u<Float>> bq;
    private final boolean c;
    private final nr dw;
    private final String fx;
    private final long iz;
    private final int jk;
    private final float k;
    private final int l;
    private final float mv;
    private final float my;
    private final List<com.bytedance.adsdk.lottie.model.nr.n> n;
    private final com.bytedance.adsdk.lottie.iz nr;
    private final com.bytedance.adsdk.lottie.model.u.jk o;
    private final u pn;
    private final com.bytedance.adsdk.lottie.model.nr.u q;
    private final com.bytedance.adsdk.lottie.b.jk qq;
    private final float s;
    private final com.bytedance.adsdk.lottie.model.u.t sx;
    private final int t;
    private final List<com.bytedance.adsdk.lottie.model.nr.fx> u;
    private final String x;

    /* JADX INFO: compiled from: SearchBox */
    public enum nr {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public n(List<com.bytedance.adsdk.lottie.model.nr.fx> list, com.bytedance.adsdk.lottie.iz izVar, String str, long j, u uVar, long j2, String str2, List<com.bytedance.adsdk.lottie.model.nr.n> list2, com.bytedance.adsdk.lottie.model.u.l lVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.lottie.model.u.jk jkVar, com.bytedance.adsdk.lottie.model.u.t tVar, List<com.bytedance.adsdk.lottie.iz.u<Float>> list3, nr nrVar, com.bytedance.adsdk.lottie.model.u.nr nrVar2, boolean z, com.bytedance.adsdk.lottie.model.nr.u uVar2, com.bytedance.adsdk.lottie.b.jk jkVar2) {
        this.u = list;
        this.nr = izVar;
        this.fx = str;
        this.b = j;
        this.pn = uVar;
        this.iz = j2;
        this.x = str2;
        this.n = list2;
        this.f4989a = lVar;
        this.jk = i;
        this.t = i2;
        this.l = i3;
        this.mv = f;
        this.s = f2;
        this.k = f3;
        this.my = f4;
        this.o = jkVar;
        this.sx = tVar;
        this.bq = list3;
        this.dw = nrVar;
        this.bg = nrVar2;
        this.c = z;
        this.q = uVar2;
        this.qq = jkVar2;
    }

    public float a() {
        return this.my;
    }

    public List<com.bytedance.adsdk.lottie.iz.u<Float>> b() {
        return this.bq;
    }

    public com.bytedance.adsdk.lottie.model.u.jk bg() {
        return this.o;
    }

    public com.bytedance.adsdk.lottie.model.u.t bq() {
        return this.sx;
    }

    public boolean c() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.u.nr dw() {
        return this.bg;
    }

    public float fx() {
        return this.s / this.nr.sx();
    }

    public String iz() {
        return this.fx;
    }

    public List<com.bytedance.adsdk.lottie.model.nr.n> jk() {
        return this.n;
    }

    public com.bytedance.adsdk.lottie.model.u.l k() {
        return this.f4989a;
    }

    public nr l() {
        return this.dw;
    }

    public long mv() {
        return this.iz;
    }

    public int my() {
        return this.l;
    }

    public float n() {
        return this.k;
    }

    public float nr() {
        return this.mv;
    }

    public int o() {
        return this.t;
    }

    public long pn() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.nr.u q() {
        return this.q;
    }

    public com.bytedance.adsdk.lottie.b.jk qq() {
        return this.qq;
    }

    public List<com.bytedance.adsdk.lottie.model.nr.fx> s() {
        return this.u;
    }

    public int sx() {
        return this.jk;
    }

    public u t() {
        return this.pn;
    }

    public String toString() {
        return u("");
    }

    public com.bytedance.adsdk.lottie.iz u() {
        return this.nr;
    }

    public String x() {
        return this.x;
    }

    public String u(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(iz());
        sb.append("\n");
        n nVarU = this.nr.u(mv());
        if (nVarU != null) {
            sb.append("\t\tParents: ");
            sb.append(nVarU.iz());
            n nVarU2 = this.nr.u(nVarU.mv());
            while (nVarU2 != null) {
                sb.append("->");
                sb.append(nVarU2.iz());
                nVarU2 = this.nr.u(nVarU2.mv());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!jk().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(jk().size());
            sb.append("\n");
        }
        if (sx() != 0 && o() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(sx()), Integer.valueOf(o()), Integer.valueOf(my())));
        }
        if (!this.u.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.bytedance.adsdk.lottie.model.nr.fx fxVar : this.u) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(fxVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
