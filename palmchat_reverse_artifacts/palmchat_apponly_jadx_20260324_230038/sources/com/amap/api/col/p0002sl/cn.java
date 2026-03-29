package com.amap.api.col.p0002sl;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.animation.Animation;
import com.amap.api.col.p0002sl.bi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cn extends p {
    public float c;
    public boolean d;
    private Animation.AnimationListener e;
    private m f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private boolean m;

    public cn(m mVar, Animation.AnimationListener animationListener, int i) {
        super(i < 160 ? 160 : i, 40);
        this.m = false;
        this.c = -1.0f;
        this.d = false;
        this.f = mVar;
        this.e = animationListener;
        this.f3041a /= 2;
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void a(int i) {
        this.f3041a = i / 2;
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void b() {
        m mVar;
        if (this.m) {
            return;
        }
        try {
            mVar = this.f;
        } catch (Exception e) {
            ct.a(e, "ZoomCtlAnim", "onStop");
        }
        if (mVar != null && mVar.a() != null) {
            this.f.a().e.b = false;
            if (this.d) {
                Point point = new Point((int) this.g, (int) this.h);
                af afVarA = this.f.c().a((int) this.g, (int) this.h);
                this.f.a().h.l = be.a(afVarA);
                this.f.a().h.a(point);
                this.f.a().c.a(false);
            }
            this.f.g().a(this.c);
            this.e.onAnimationEnd(null);
            if (this.d) {
                Point point2 = new Point(bi.c.c() / 2, bi.c.d() / 2);
                af afVarA2 = this.f.c().a(bi.c.c() / 2, bi.c.d() / 2);
                this.f.a().h.l = be.a(afVarA2);
                this.f.a().h.a(point2);
                this.f.a().c.a(false);
            }
            m mVar2 = this.f;
            mVar2.f2987a.h.c = 1.0f;
            bk.j = 1.0f;
            mVar2.a().a(true);
            u.a().b();
            this.f3041a = 160;
        }
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void c() {
        b();
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void a() {
        bi biVar;
        try {
            m mVar = this.f;
            if (mVar != null && (biVar = mVar.f2987a) != null) {
                if (this.l) {
                    biVar.h.c += this.k;
                } else {
                    biVar.h.c -= this.k;
                }
                Matrix matrix = new Matrix();
                float f = this.f.f2987a.h.c;
                matrix.setScale(f, f, this.g, this.h);
                m mVar2 = this.f;
                mVar2.b(mVar2.f2987a.h.c);
                this.f.a(matrix);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(float f, boolean z, float f2, float f3) {
        m mVar = this.f;
        float[] fArr = mVar.c;
        float f4 = fArr[1];
        fArr[0] = f4;
        fArr[1] = f;
        if (f4 == f) {
            return;
        }
        mVar.a().a(this.f.f());
        if (!g()) {
            if (this.f3041a < 160) {
                this.f3041a = 160;
            }
            b(this.f.i(), z, f2, f3);
            this.f.a().e.a(true);
            this.f.a().e.b = true;
            this.e.onAnimationStart(null);
            super.d();
            return;
        }
        this.m = true;
        e();
        b(this.j, z, f2, f3);
        this.f.a().e.a(true);
        this.f.a().e.b = true;
        this.e.onAnimationStart(null);
        super.d();
        this.m = false;
    }

    private void b(float f, boolean z, float f2, float f3) {
        this.l = z;
        this.g = f2;
        this.h = f3;
        this.i = f;
        this.f.f2987a.h.c = f;
        if (z) {
            this.k = (this.b * f) / this.f3041a;
            this.j = f * 2.0f;
        } else {
            this.k = ((f * 0.5f) * this.b) / this.f3041a;
            this.j = f * 0.5f;
        }
    }
}
