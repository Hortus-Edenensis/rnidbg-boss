package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Swiper extends BaseSwiper<fx> {
    private com.bytedance.adsdk.ugeno.fx b;

    public Swiper(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.b();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.fx fxVar2 = this.b;
        if (fxVar2 != null) {
            fxVar2.u(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.fx fxVar = this.b;
        if (fxVar != null) {
            int[] iArrU = fxVar.u(i, i2);
            super.onMeasure(iArrU[0], iArrU[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.fx fxVar2 = this.b;
        if (fxVar2 != null) {
            fxVar2.fx();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    public void u(com.bytedance.adsdk.ugeno.fx fxVar) {
        this.b = fxVar;
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View x(int i) {
        return ((fx) this.u.get(i)).a();
    }
}
