package defpackage;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.LimitLine;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class jn extends zj0 {
    public h96 g;
    public int n;
    public int o;
    public List<LimitLine> z;
    public int h = -7829368;
    public float i = 1.0f;
    public int j = -7829368;
    public float k = 1.0f;
    public float[] l = new float[0];
    public float[] m = new float[0];
    public int p = 6;
    public float q = 1.0f;
    public boolean r = false;
    public boolean s = false;
    public boolean t = true;
    public boolean u = true;
    public boolean v = true;
    public boolean w = false;
    public DashPathEffect x = null;
    public DashPathEffect y = null;
    public boolean A = false;
    public boolean B = true;
    public float C = 0.0f;
    public float D = 0.0f;
    public boolean E = false;
    public boolean F = false;
    public float G = 0.0f;
    public float H = 0.0f;
    public float I = 0.0f;

    public jn() {
        this.e = s86.e(10.0f);
        this.b = s86.e(5.0f);
        this.c = s86.e(5.0f);
        this.z = new ArrayList();
    }

    public boolean A() {
        return this.A;
    }

    public boolean B() {
        return this.s;
    }

    public boolean C() {
        return this.r;
    }

    public void D(boolean z) {
        this.u = z;
    }

    public void E(boolean z) {
        this.t = z;
    }

    public void F(float f) {
        this.D = f;
    }

    public void G(float f) {
        this.C = f;
    }

    public void h(float f, float f2) {
        float f3 = this.E ? this.H : f - this.C;
        float f4 = this.F ? this.G : f2 + this.D;
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        this.H = f3;
        this.G = f4;
        this.I = Math.abs(f4 - f3);
    }

    public int i() {
        return this.j;
    }

    public DashPathEffect j() {
        return this.x;
    }

    public float k() {
        return this.k;
    }

    public float l() {
        return this.H;
    }

    public String m(int i) {
        return (i < 0 || i >= this.l.length) ? "" : u().a(this.l[i], this);
    }

    public float n() {
        return this.q;
    }

    public int o() {
        return this.h;
    }

    public DashPathEffect p() {
        return this.y;
    }

    public float q() {
        return this.i;
    }

    public int r() {
        return this.p;
    }

    public List<LimitLine> s() {
        return this.z;
    }

    public String t() {
        String str = "";
        for (int i = 0; i < this.l.length; i++) {
            String strM = m(i);
            if (strM != null && str.length() < strM.length()) {
                str = strM;
            }
        }
        return str;
    }

    public h96 u() {
        h96 h96Var = this.g;
        if (h96Var == null || ((h96Var instanceof t31) && ((t31) h96Var).j() != this.o)) {
            this.g = new t31(this.o);
        }
        return this.g;
    }

    public boolean v() {
        return this.w && this.n > 0;
    }

    public boolean w() {
        return this.u;
    }

    public boolean x() {
        return this.B;
    }

    public boolean y() {
        return this.t;
    }

    public boolean z() {
        return this.v;
    }
}
