package com.amap.api.col.p0002sl;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import com.amap.api.col.p0002sl.bi;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class az implements View.OnKeyListener {
    private bi c;
    private b e;
    private a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2624a = 0.0f;
    private float b = 0.0f;
    private boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {
        private LinkedList<Animation> b;
        private cn c;

        private b() {
            this.b = new LinkedList<>();
            this.c = null;
        }

        private void b(float f, int i, int i2, boolean z, int i3) {
            try {
                cn cnVar = this.c;
                if (cnVar == null) {
                    this.c = new cn(az.this.c.c.g(), this, i3);
                } else {
                    if (i3 <= 160) {
                        i3 = 160;
                    }
                    cnVar.a(i3);
                }
                cn cnVar2 = this.c;
                cnVar2.c = f;
                cnVar2.d = z;
                if (z) {
                    Point point = new Point(i, i2);
                    af afVarA = az.this.c.c.g().c().a(i, i2);
                    be beVar = az.this.c.h;
                    bi unused = az.this.c;
                    beVar.l = be.a(afVarA);
                    az.this.c.h.a(point);
                }
                this.c.a(f, true, i, i2);
            } catch (Throwable th) {
                ct.a(th, "MapController", "doZoomIn");
            }
        }

        public final void a() {
            this.b.clear();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            if (az.this.c == null) {
                return;
            }
            if (this.b.size() == 0) {
                az.this.c.e.b();
            } else {
                az.this.c.c.g().startAnimation(this.b.remove());
            }
        }

        public final void a(int i, int i2, float f, boolean z, boolean z2, int i3) {
            if (z) {
                b(f, i, i2, z2, i3);
            } else {
                a(f, i, i2, z2, i3);
            }
        }

        public /* synthetic */ b(az azVar, byte b) {
            this();
        }

        private void a(float f, int i, int i2, boolean z, int i3) {
            try {
                if (this.c == null && az.this.c != null && az.this.c.c != null) {
                    this.c = new cn(az.this.c.c.g(), this, i3);
                } else {
                    cn cnVar = this.c;
                    if (i3 <= 160) {
                        i3 = 160;
                    }
                    cnVar.a(i3);
                }
                cn cnVar2 = this.c;
                if (cnVar2 != null) {
                    cnVar2.d = z;
                    cnVar2.c = f;
                    cnVar2.a(f, false, i, i2);
                }
            } catch (Throwable th) {
                ct.a(th, "MapController", "doZoomOut");
            }
        }

        public final void a(int i, int i2, float f, float f2, int i3) {
            try {
                cn cnVar = this.c;
                if (cnVar == null) {
                    this.c = new cn(az.this.c.c.g(), this, i3);
                } else {
                    if (i3 <= 160) {
                        i3 = 160;
                    }
                    cnVar.a(i3);
                }
                cn cnVar2 = this.c;
                cnVar2.c = f;
                cnVar2.a(f, f > f2, i, i2);
            } catch (Throwable th) {
                ct.a(th, "MapController", "zoomTo");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    public az(bi biVar) {
        this.c = biVar;
        byte b2 = 0;
        this.e = new b(this, b2);
        this.f = new a(this, b2);
    }

    public final float b() {
        return this.b;
    }

    public final void c() {
        this.f2624a = 0.0f;
    }

    public final void d() {
        this.b = 0.0f;
    }

    public final boolean e() {
        return a(0);
    }

    public final boolean f() {
        return b(0);
    }

    public final void g() {
        this.e.a();
        this.f.b();
    }

    public final void h() {
        this.d = true;
    }

    public final boolean i() {
        return this.f.a();
    }

    public final void j() {
        this.f.b();
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (i) {
            case 19:
                b(0, -10);
                return true;
            case 20:
                b(0, 10);
                return true;
            case 21:
                b(-10, 0);
                return true;
            case 22:
                b(10, 0);
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ch {
        private cg b;
        private Message c;
        private Runnable d;

        private a() {
            this.b = null;
            this.c = null;
            this.d = null;
        }

        private cg b(af afVar, int i) {
            if (i < 500) {
                i = 500;
            }
            try {
                return new cg(i, az.this.c.h.l, afVar, this);
            } catch (Throwable th) {
                ct.a(th, "MapController", "makeTransTool");
                return null;
            }
        }

        private void d() {
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public final boolean a() {
            cg cgVar = this.b;
            if (cgVar != null) {
                return cgVar.g();
            }
            return false;
        }

        @Override // com.amap.api.col.p0002sl.ch
        public final void c() {
            Message message = this.c;
            if (message != null) {
                message.getTarget().sendMessage(this.c);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
            d();
            if (az.this.c == null || az.this.c.d == null) {
                return;
            }
            az.this.c.d.f2644a = false;
        }

        public final void a(af afVar, int i) {
            if (az.this.c != null) {
                az.this.c.d.f2644a = true;
                az.this.c.h.m = afVar.g();
            }
            cg cgVarB = b(afVar, i);
            this.b = cgVarB;
            this.c = null;
            this.d = null;
            if (cgVarB != null) {
                cgVarB.d();
            }
        }

        public final void b() {
            cg cgVar = this.b;
            if (cgVar != null) {
                cgVar.e();
            }
        }

        public /* synthetic */ a(az azVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.p0002sl.ch
        public final void a(af afVar) {
            if (az.this.c == null) {
                return;
            }
            if (afVar.d() == Long.MIN_VALUE || afVar.c() == Long.MIN_VALUE) {
                bi unused = az.this.c;
                az.this.a(be.b(afVar));
                return;
            }
            az.this.a(afVar);
        }
    }

    private boolean b(af afVar) {
        bi biVar;
        bi.c cVar;
        af afVarF;
        if (afVar == null || (biVar = this.c) == null || (cVar = biVar.c) == null || (afVarF = cVar.f()) == null) {
            return false;
        }
        return (afVar.b() == afVarF.b() && afVar.a() == afVarF.a()) ? false : true;
    }

    private void c(af afVar) {
        bi.c cVar;
        m mVar;
        bi biVar = this.c;
        if (biVar != null && (mVar = biVar.g) != null) {
            mVar.m();
        }
        bi biVar2 = this.c;
        if (biVar2 == null || (cVar = biVar2.c) == null) {
            return;
        }
        cVar.a(afVar);
    }

    private float d(float f) {
        bi.c cVar;
        bi biVar = this.c;
        if (biVar == null || (cVar = biVar.c) == null) {
            return f;
        }
        if (f < cVar.b()) {
            f = this.c.c.b();
        }
        return f > ((float) this.c.c.a()) ? this.c.c.a() : f;
    }

    public final float a() {
        return this.f2624a;
    }

    public final void a(af afVar) {
        if (b(afVar)) {
            c(afVar);
        }
    }

    public final void a(af afVar, float f) {
        if (b(afVar) || c(f)) {
            c(afVar);
            b(f);
        }
    }

    private float b(float f) {
        bi.c cVar;
        bi biVar = this.c;
        if (biVar != null && (cVar = biVar.c) != null) {
            m mVarG = cVar.g();
            mVarG.m();
            f = mVarG.a(f);
            this.c.c.a(f);
            try {
                if (this.c.g.b().isScaleControlsEnabled()) {
                    this.c.g.n();
                }
            } catch (RemoteException e) {
                ct.a(e, "MapController", "setZoom");
            }
        }
        return f;
    }

    private boolean c(float f) {
        bi.c cVar;
        bi biVar = this.c;
        return (biVar == null || (cVar = biVar.c) == null || f == cVar.e()) ? false : true;
    }

    private boolean d(int i) {
        bi biVar = this.c;
        if (biVar == null || biVar.c == null) {
            return false;
        }
        return a(bi.c.c() / 2, bi.c.d() / 2, false, false, i);
    }

    private boolean c(int i) {
        bi biVar = this.c;
        if (biVar == null || biVar.c == null) {
            return false;
        }
        return a(bi.c.c() / 2, bi.c.d() / 2, true, false, i);
    }

    public final float a(float f) {
        if (!c(f)) {
            return f;
        }
        b(f);
        return f;
    }

    public final float a(float f, int i) {
        int i2 = z.c;
        if (f >= i2) {
            f = i2;
        }
        int i3 = z.d;
        if (f <= i3) {
            f = i3;
        }
        if (!c(f)) {
            return f;
        }
        b(f, i);
        return f;
    }

    private boolean c(int i, int i2) {
        return a(i, i2, true, true, 0);
    }

    private void b(float f, float f2) {
        bi biVar;
        bi.c cVar;
        float f3;
        float fE;
        int i;
        int iB;
        int iA;
        double d;
        double d2;
        float fD = 0.0f;
        if (f <= 0.0f || f2 <= 0.0f || (biVar = this.c) == null || (cVar = biVar.c) == null || biVar.b == null) {
            return;
        }
        try {
            fE = cVar.e();
            i = 0;
            iB = this.c.b.b(0, 0, 0);
            iA = this.c.b.a(0, 0, 0);
        } catch (Exception e) {
            e = e;
        }
        if (iB == 0 && iA == 0) {
            this.f2624a = f;
            this.b = f2;
            return;
        }
        try {
            double dMin = Math.min(iA / f, iB / f2);
            be beVar = this.c.h;
            d = beVar.k / dMin;
            d2 = beVar.d;
        } catch (Exception e2) {
            e = e2;
            fD = fE;
            ct.a(e, "MapController", "zoomToSpan");
        }
        while (true) {
            d2 /= 2.0d;
            if (d2 <= d) {
                break;
            } else {
                i++;
            }
            f3 = fD;
            a(f3);
        }
        fD = d((float) (((double) i) + (Math.log((this.c.h.d / ((double) (1 << i))) / d) / Math.log(2.0d))));
        float f4 = (int) fD;
        double d3 = fD - f4;
        double d4 = bi.f2640a;
        if (d3 <= 1.0d - ((1.0d - d4) * 0.4d)) {
            if (d3 <= d4) {
                if (Math.abs(d3 - d4) <= 9.999999747378752E-5d) {
                    fD = f4 + ((float) (bi.f2640a - 9.999999747378752E-5d));
                }
                f3 = fD;
                a(f3);
            }
            d4 -= 9.999999747378752E-5d;
        }
        f3 = f4 + ((float) d4);
        a(f3);
    }

    public final void a(float f, float f2) {
        b(f, f2);
    }

    public final Pair<Float, Boolean> a(float f, float f2, int i, int i2, int i3, int i4) {
        bi biVar;
        bi.c cVar;
        float f3;
        if (f > 0.0f && f2 > 0.0f && (biVar = this.c) != null && (cVar = biVar.c) != null && biVar.b != null) {
            try {
                cVar.e();
                int iB = this.c.b.b(i, i2, i3);
                int iA = this.c.b.a(i, i2, i4);
                if (iB == 0 && iA == 0) {
                    this.f2624a = f;
                    this.b = f2;
                    return null;
                }
                double d = iB / f2;
                double dMin = Math.min(iA / f, d);
                be beVar = this.c.h;
                double d2 = beVar.k / dMin;
                double d3 = beVar.d;
                int i5 = 0;
                while (true) {
                    d3 /= 2.0d;
                    if (d3 <= d2) {
                        break;
                    }
                    i5++;
                }
                float fD = d((float) (((double) i5) + (Math.log((this.c.h.d / ((double) (1 << i5))) / d2) / Math.log(2.0d))));
                float f4 = (int) fD;
                double d4 = fD - f4;
                double d5 = bi.f2640a;
                if (d4 > 1.0d - ((1.0d - d5) * 0.4d)) {
                    f3 = (float) d5;
                    fD = f3 + f4;
                } else if (d4 > d5) {
                    d5 -= 9.999999747378752E-5d;
                    f3 = (float) d5;
                    fD = f3 + f4;
                } else if (Math.abs(d4 - d5) <= 9.999999747378752E-5d) {
                    f3 = (float) (bi.f2640a - 9.999999747378752E-5d);
                    fD = f3 + f4;
                }
                return new Pair<>(Float.valueOf(fD), Boolean.valueOf(dMin == d));
            } catch (Exception e) {
                ct.a(e, "MapController", "zoomToSpan");
            }
        }
        return null;
    }

    public final boolean b(int i) {
        return d(i);
    }

    private boolean b(float f, int i) {
        return a(bi.c.c() / 2, bi.c.d() / 2, f, i);
    }

    public final boolean a(int i) {
        return c(i);
    }

    public final void a(boolean z) {
        float fE;
        this.c.c.g().m();
        if (z) {
            fE = this.c.c.e() + 1.0f;
        } else {
            fE = this.c.c.e() - 1.0f;
        }
        float fA = this.c.c.g().a(fE);
        if (fA != this.c.c.e()) {
            a(fA);
        }
    }

    public final void b(int i, int i2) {
        if (this.d) {
            this.d = false;
            return;
        }
        if ((i == 0 && i2 == 0) || this.c == null) {
            return;
        }
        try {
            if (z.s) {
                PointF pointF = new PointF(0.0f, 0.0f);
                PointF pointF2 = new PointF(i, i2);
                bi biVar = this.c;
                be beVar = biVar.h;
                biVar.c.e();
                beVar.a(pointF, pointF2);
            }
            this.c.c.a(false);
        } catch (Throwable th) {
            ct.a(th, "MapController", "scrollBy");
        }
    }

    public final boolean a(float f, int i, int i2, int i3) {
        return a(i, i2, f, i3);
    }

    public final boolean a(int i, int i2) {
        return c(i, i2);
    }

    public final void a(af afVar, int i) {
        this.f.a(afVar, i);
    }

    public final void a(int i, int i2, int i3) {
        if (this.d) {
            this.d = false;
            return;
        }
        if ((i == 0 && i2 == 0) || this.c == null) {
            return;
        }
        try {
            if (z.s) {
                a(this.c.h.b(new PointF(0.0f, 0.0f), new PointF(i, i2)), i3);
            }
            this.c.c.a(false);
        } catch (Throwable th) {
            ct.a(th, "MapController", "scrollBy");
        }
    }

    private void a(int i, int i2, float f, boolean z, boolean z2, int i3) {
        this.e.a(i, i2, f, z, z2, i3);
    }

    private boolean a(int i, int i2, boolean z, boolean z2, int i3) {
        bi.c cVar;
        bi biVar = this.c;
        boolean z3 = false;
        if (biVar != null && (cVar = biVar.c) != null) {
            cVar.g().m();
            bi.c cVar2 = this.c.c;
            float fA = this.c.c.g().a(z ? cVar2.e() + 1.0f : cVar2.e() - 1.0f);
            if (fA != this.c.c.e()) {
                a(i, i2, fA, z, z2, i3);
                z3 = true;
            }
            try {
                if (this.c.g.b().isScaleControlsEnabled()) {
                    this.c.g.n();
                }
            } catch (RemoteException e) {
                ct.a(e, "MapController", "zoomWithAnimation");
            }
        }
        return z3;
    }

    private boolean a(int i, int i2, float f, int i3) {
        bi.c cVar;
        bi biVar = this.c;
        boolean z = false;
        if (biVar != null && (cVar = biVar.c) != null) {
            cVar.g().m();
            float fE = this.c.c.e();
            if (f != fE) {
                this.e.a(i, i2, f, fE, i3);
                z = true;
            }
            try {
                if (this.c.g.b().isScaleControlsEnabled()) {
                    this.c.g.n();
                }
            } catch (RemoteException e) {
                ct.a(e, "MapController", "zoomToAnimation");
            }
        }
        return z;
    }
}
