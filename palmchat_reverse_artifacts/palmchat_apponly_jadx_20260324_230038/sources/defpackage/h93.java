package defpackage;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h93 extends er implements Choreographer.FrameCallback {

    @Nullable
    public u73 j;
    public float c = 1.0f;
    public boolean d = false;
    public long e = 0;
    public float f = 0.0f;
    public int g = 0;
    public float h = -2.1474836E9f;
    public float i = 2.1474836E9f;

    @VisibleForTesting
    public boolean k = false;

    public void A(int i) {
        z(i, (int) this.i);
    }

    public void B(float f) {
        this.c = f;
    }

    public final void C() {
        if (this.j == null) {
            return;
        }
        float f = this.f;
        if (f < this.h || f > this.i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.h), Float.valueOf(this.i), Float.valueOf(this.f)));
        }
    }

    @Override // defpackage.er
    public void a() {
        super.a();
        b(n());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        r();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        q();
        if (this.j == null || !isRunning()) {
            return;
        }
        m03.a("LottieValueAnimator#doFrame");
        float fJ = (this.e != 0 ? j - r1 : 0L) / j();
        float f = this.f;
        if (n()) {
            fJ = -fJ;
        }
        float f2 = f + fJ;
        this.f = f2;
        boolean z = !sp3.d(f2, l(), k());
        this.f = sp3.b(this.f, l(), k());
        this.e = j;
        e();
        if (z) {
            if (getRepeatCount() == -1 || this.g < getRepeatCount()) {
                c();
                this.g++;
                if (getRepeatMode() == 2) {
                    this.d = !this.d;
                    v();
                } else {
                    this.f = n() ? k() : l();
                }
                this.e = j;
            } else {
                this.f = this.c < 0.0f ? l() : k();
                r();
                b(n());
            }
        }
        C();
        m03.b("LottieValueAnimator#doFrame");
    }

    public void f() {
        this.j = null;
        this.h = -2.1474836E9f;
        this.i = 2.1474836E9f;
    }

    @MainThread
    public void g() {
        r();
        b(n());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        float fL;
        float fK;
        float fL2;
        if (this.j == null) {
            return 0.0f;
        }
        if (n()) {
            fL = k() - this.f;
            fK = k();
            fL2 = l();
        } else {
            fL = this.f - l();
            fK = k();
            fL2 = l();
        }
        return fL / (fK - fL2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        u73 u73Var = this.j;
        if (u73Var == null) {
            return 0L;
        }
        return (long) u73Var.d();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float h() {
        u73 u73Var = this.j;
        if (u73Var == null) {
            return 0.0f;
        }
        return (this.f - u73Var.p()) / (this.j.f() - this.j.p());
    }

    public float i() {
        return this.f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.k;
    }

    public final float j() {
        u73 u73Var = this.j;
        if (u73Var == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / u73Var.i()) / Math.abs(this.c);
    }

    public float k() {
        u73 u73Var = this.j;
        if (u73Var == null) {
            return 0.0f;
        }
        float f = this.i;
        return f == 2.1474836E9f ? u73Var.f() : f;
    }

    public float l() {
        u73 u73Var = this.j;
        if (u73Var == null) {
            return 0.0f;
        }
        float f = this.h;
        return f == -2.1474836E9f ? u73Var.p() : f;
    }

    public float m() {
        return this.c;
    }

    public final boolean n() {
        return m() < 0.0f;
    }

    @MainThread
    public void o() {
        r();
    }

    @MainThread
    public void p() {
        this.k = true;
        d(n());
        x((int) (n() ? k() : l()));
        this.e = 0L;
        this.g = 0;
        q();
    }

    public void q() {
        if (isRunning()) {
            s(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void r() {
        s(true);
    }

    @MainThread
    public void s(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.k = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.d) {
            return;
        }
        this.d = false;
        v();
    }

    @MainThread
    public void t() {
        this.k = true;
        q();
        this.e = 0L;
        if (n() && i() == l()) {
            this.f = k();
        } else {
            if (n() || i() != k()) {
                return;
            }
            this.f = l();
        }
    }

    public void v() {
        B(-m());
    }

    public void w(u73 u73Var) {
        boolean z = this.j == null;
        this.j = u73Var;
        if (z) {
            z(Math.max(this.h, u73Var.p()), Math.min(this.i, u73Var.f()));
        } else {
            z((int) u73Var.p(), (int) u73Var.f());
        }
        float f = this.f;
        this.f = 0.0f;
        x((int) f);
        e();
    }

    public void x(float f) {
        if (this.f == f) {
            return;
        }
        this.f = sp3.b(f, l(), k());
        this.e = 0L;
        e();
    }

    public void y(float f) {
        z(this.h, f);
    }

    public void z(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        u73 u73Var = this.j;
        float fP = u73Var == null ? -3.4028235E38f : u73Var.p();
        u73 u73Var2 = this.j;
        float f3 = u73Var2 == null ? Float.MAX_VALUE : u73Var2.f();
        float fB = sp3.b(f, fP, f3);
        float fB2 = sp3.b(f2, fP, f3);
        if (fB == this.h && fB2 == this.i) {
            return;
        }
        this.h = fB;
        this.i = fB2;
        x((int) sp3.b(this.f, fB, fB2));
    }
}
