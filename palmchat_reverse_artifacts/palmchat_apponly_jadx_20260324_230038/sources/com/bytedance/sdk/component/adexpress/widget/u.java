package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Interpolator {
    protected PointF b;
    protected PointF fx;
    protected PointF nr;
    protected PointF pn;
    protected PointF u;

    public u(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.fx = new PointF();
        this.b = new PointF();
        this.pn = new PointF();
        float f = pointF.x;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f2 = pointF2.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.u = pointF;
        this.nr = pointF2;
    }

    private float b(float f) {
        PointF pointF = this.pn;
        PointF pointF2 = this.u;
        float f2 = pointF2.x * 3.0f;
        pointF.x = f2;
        PointF pointF3 = this.b;
        float f3 = ((this.nr.x - pointF2.x) * 3.0f) - f2;
        pointF3.x = f3;
        PointF pointF4 = this.fx;
        float f4 = (1.0f - pointF.x) - f3;
        pointF4.x = f4;
        return f * (pointF.x + ((pointF3.x + (f4 * f)) * f));
    }

    private float fx(float f) {
        return this.pn.x + (f * ((this.b.x * 2.0f) + (this.fx.x * 3.0f * f)));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return u(nr(f));
    }

    public float nr(float f) {
        float fFx = f;
        for (int i = 1; i < 14; i++) {
            float fB = b(fFx) - f;
            if (Math.abs(fB) < 0.001d) {
                break;
            }
            fFx -= fB / fx(fFx);
        }
        return fFx;
    }

    public float u(float f) {
        PointF pointF = this.pn;
        PointF pointF2 = this.u;
        float f2 = pointF2.y * 3.0f;
        pointF.y = f2;
        PointF pointF3 = this.b;
        float f3 = ((this.nr.y - pointF2.y) * 3.0f) - f2;
        pointF3.y = f3;
        PointF pointF4 = this.fx;
        float f4 = (1.0f - pointF.y) - f3;
        pointF4.y = f4;
        return f * (pointF.y + ((pointF3.y + (f4 * f)) * f));
    }

    public u(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }
}
