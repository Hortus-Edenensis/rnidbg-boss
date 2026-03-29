package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends RecyclerView.bg {
    protected PointF fx;
    private final float iz;
    protected final LinearInterpolator u = new LinearInterpolator();
    protected final DecelerateInterpolator nr = new DecelerateInterpolator();
    protected int b = 0;
    protected int pn = 0;

    public iz(Context context) {
        this.iz = u(context.getResources().getDisplayMetrics());
    }

    private int nr(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int fx() {
        PointF pointF = this.fx;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.y;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.bg
    public void u(View view, RecyclerView.bq bqVar, RecyclerView.bg.u uVar) {
        int iNr = nr(view, nr());
        int iU = u(view, fx());
        int iU2 = u((int) Math.sqrt((iNr * iNr) + (iU * iU)));
        if (iU2 > 0) {
            uVar.update(-iNr, -iU, iU2, this.nr);
        }
    }

    public int nr(int i) {
        return (int) Math.ceil(Math.abs(i) * this.iz);
    }

    public int nr() {
        PointF pointF = this.fx;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.x;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }

    public int nr(View view, int i) {
        RecyclerView.a aVarB = b();
        if (aVarB == null || !aVarB.fx()) {
            return 0;
        }
        RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
        return u(aVarB.x(view) - ((ViewGroup.MarginLayoutParams) jkVar).leftMargin, aVarB.a(view) + ((ViewGroup.MarginLayoutParams) jkVar).rightMargin, aVarB.qq(), aVarB.c() - aVarB.z(), i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.bg
    public void u(int i, int i2, RecyclerView.bq bqVar, RecyclerView.bg.u uVar) {
        if (a() == 0) {
            pn();
            return;
        }
        this.b = nr(this.b, i);
        int iNr = nr(this.pn, i2);
        this.pn = iNr;
        if (this.b == 0 && iNr == 0) {
            u(uVar);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.bg
    public void u() {
        this.pn = 0;
        this.b = 0;
        this.fx = null;
    }

    public float u(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int u(int i) {
        return (int) Math.ceil(((double) nr(i)) / 0.3356d);
    }

    public void u(RecyclerView.bg.u uVar) {
        PointF pointFB = b(n());
        if (pointFB != null && (pointFB.x != 0.0f || pointFB.y != 0.0f)) {
            u(pointFB);
            this.fx = pointFB;
            this.b = (int) (pointFB.x * 10000.0f);
            this.pn = (int) (pointFB.y * 10000.0f);
            uVar.update((int) (this.b * 1.2f), (int) (this.pn * 1.2f), (int) (nr(10000) * 1.2f), this.u);
            return;
        }
        uVar.u(n());
        pn();
    }

    public int u(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int u(View view, int i) {
        RecyclerView.a aVarB = b();
        if (aVarB == null || !aVarB.b()) {
            return 0;
        }
        RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
        return u(aVarB.n(view) - ((ViewGroup.MarginLayoutParams) jkVar).topMargin, aVarB.jk(view) + ((ViewGroup.MarginLayoutParams) jkVar).bottomMargin, aVarB.kj(), aVarB.q() - aVarB.gi(), i);
    }
}
