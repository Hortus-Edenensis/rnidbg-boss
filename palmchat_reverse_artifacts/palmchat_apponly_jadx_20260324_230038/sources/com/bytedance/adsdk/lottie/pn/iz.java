package com.bytedance.adsdk.lottie.pn;

import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz extends u implements Choreographer.FrameCallback {
    private com.bytedance.adsdk.lottie.iz jk;
    private float nr = 1.0f;
    private boolean fx = false;
    private long b = 0;
    private float pn = 0.0f;
    private float iz = 0.0f;
    private int x = 0;
    private float n = -2.1474836E9f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5005a = 2.1474836E9f;
    protected boolean u = false;
    private boolean t = false;

    private float bg() {
        com.bytedance.adsdk.lottie.iz izVar = this.jk;
        if (izVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / izVar.mv()) / Math.abs(this.nr);
    }

    private boolean bq() {
        return jk() < 0.0f;
    }

    private void dw() {
        if (this.jk == null) {
            return;
        }
        float f = this.iz;
        if (f < this.n || f > this.f5005a) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.n), Float.valueOf(this.f5005a), Float.valueOf(this.iz)));
        }
    }

    public void a() {
        fx(-jk());
    }

    @MainThread
    public void b(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.u = false;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        nr();
        sx();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        o();
        if (this.jk == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.lottie.pn.u("LottieValueAnimator#doFrame");
        float fBg = (this.b != 0 ? j - r1 : 0L) / bg();
        float f = this.pn;
        if (bq()) {
            fBg = -fBg;
        }
        float f2 = f + fBg;
        boolean z = !n.fx(f2, k(), my());
        float f3 = this.pn;
        float fNr = n.nr(f2, k(), my());
        this.pn = fNr;
        if (this.t) {
            fNr = (float) Math.floor(fNr);
        }
        this.iz = fNr;
        this.b = j;
        if (!this.t || this.pn != f3) {
            fx();
        }
        if (z) {
            if (getRepeatCount() == -1 || this.x < getRepeatCount()) {
                u();
                this.x++;
                if (getRepeatMode() == 2) {
                    this.fx = !this.fx;
                    a();
                } else {
                    float fMy = bq() ? my() : k();
                    this.pn = fMy;
                    this.iz = fMy;
                }
                this.b = j;
            } else {
                float fK = this.nr < 0.0f ? k() : my();
                this.pn = fK;
                this.iz = fK;
                sx();
                nr(bq());
            }
        }
        dw();
        com.bytedance.adsdk.lottie.pn.nr("LottieValueAnimator#doFrame");
    }

    public void fx(boolean z) {
        this.t = z;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        float fK;
        float fMy;
        float fK2;
        if (this.jk == null) {
            return 0.0f;
        }
        if (bq()) {
            fK = my() - this.iz;
            fMy = my();
            fK2 = k();
        } else {
            fK = this.iz - k();
            fMy = my();
            fK2 = k();
        }
        return fK / (fMy - fK2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(iz());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.iz izVar = this.jk;
        if (izVar == null) {
            return 0L;
        }
        return (long) izVar.pn();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.u;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float iz() {
        com.bytedance.adsdk.lottie.iz izVar = this.jk;
        if (izVar == null) {
            return 0.0f;
        }
        return (this.iz - izVar.iz()) / (this.jk.x() - this.jk.iz());
    }

    public float jk() {
        return this.nr;
    }

    public float k() {
        com.bytedance.adsdk.lottie.iz izVar = this.jk;
        if (izVar == null) {
            return 0.0f;
        }
        float f = this.n;
        return f == -2.1474836E9f ? izVar.iz() : f;
    }

    @MainThread
    public void l() {
        sx();
        nr(bq());
    }

    @MainThread
    public void mv() {
        sx();
        b();
    }

    public float my() {
        com.bytedance.adsdk.lottie.iz izVar = this.jk;
        if (izVar == null) {
            return 0.0f;
        }
        float f = this.f5005a;
        return f == 2.1474836E9f ? izVar.x() : f;
    }

    public void n() {
        this.jk = null;
        this.n = -2.1474836E9f;
        this.f5005a = 2.1474836E9f;
    }

    public void nr(float f) {
        u(this.n, f);
    }

    public void o() {
        if (isRunning()) {
            b(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void s() {
        this.u = true;
        o();
        this.b = 0L;
        if (bq() && x() == k()) {
            u(my());
        } else if (!bq() && x() == my()) {
            u(k());
        }
        pn();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.fx) {
            return;
        }
        this.fx = false;
        a();
    }

    @MainThread
    public void sx() {
        b(true);
    }

    @MainThread
    public void t() {
        this.u = true;
        u(bq());
        u((int) (bq() ? my() : k()));
        this.b = 0L;
        this.x = 0;
        o();
    }

    public void u(com.bytedance.adsdk.lottie.iz izVar) {
        boolean z = this.jk == null;
        this.jk = izVar;
        if (z) {
            u(Math.max(this.n, izVar.iz()), Math.min(this.f5005a, izVar.x()));
        } else {
            u((int) izVar.iz(), (int) izVar.x());
        }
        float f = this.iz;
        this.iz = 0.0f;
        this.pn = 0.0f;
        u((int) f);
        fx();
    }

    public float x() {
        return this.iz;
    }

    public void fx(float f) {
        this.nr = f;
    }

    @Override // com.bytedance.adsdk.lottie.pn.u
    public void nr() {
        super.nr();
        nr(bq());
    }

    public void u(float f) {
        if (this.pn == f) {
            return;
        }
        float fNr = n.nr(f, k(), my());
        this.pn = fNr;
        if (this.t) {
            fNr = (float) Math.floor(fNr);
        }
        this.iz = fNr;
        this.b = 0L;
        fx();
    }

    public void u(int i) {
        u(i, (int) this.f5005a);
    }

    public void u(float f, float f2) {
        if (f <= f2) {
            com.bytedance.adsdk.lottie.iz izVar = this.jk;
            float fIz = izVar == null ? -3.4028235E38f : izVar.iz();
            com.bytedance.adsdk.lottie.iz izVar2 = this.jk;
            float fX = izVar2 == null ? Float.MAX_VALUE : izVar2.x();
            float fNr = n.nr(f, fIz, fX);
            float fNr2 = n.nr(f2, fIz, fX);
            if (fNr == this.n && fNr2 == this.f5005a) {
                return;
            }
            this.n = fNr;
            this.f5005a = fNr2;
            u((int) n.nr(this.iz, fNr, fNr2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
    }
}
