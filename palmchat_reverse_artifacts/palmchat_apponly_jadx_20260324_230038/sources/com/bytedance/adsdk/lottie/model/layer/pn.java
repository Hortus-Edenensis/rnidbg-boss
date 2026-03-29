package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4991a;
    private VideoFrame jk;
    private a.u.C0163u l;
    private float n;
    private LottieAnimationView t;

    public pn(com.bytedance.adsdk.lottie.n nVar, n nVar2, Context context, a.u.C0163u c0163u) {
        super(nVar, nVar2);
        this.n = -1.0f;
        this.f4991a = -1.0f;
        this.l = c0163u;
        if (((x) this).x == null || nVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewNr = nVar.nr();
        this.t = lottieAnimationViewNr;
        if (lottieAnimationViewNr == null) {
            return;
        }
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        this.n = (int) (((x) this).x.u() * fU);
        this.f4991a = (int) (((x) this).x.nr() * fU);
        dw dwVarU = nVar.u();
        View viewU = dwVarU != null ? dwVarU.u("videoview:", null) : null;
        if (viewU instanceof TextureView) {
            this.jk = new VideoFrame(context, (TextureView) viewU, c0163u);
        }
        this.t.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.pn.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (pn.this.t == view) {
                    pn.this.s();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        VideoFrame videoFrame = this.jk;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.jk);
            }
            ViewParent parent2 = this.t.getParent();
            if (parent2 instanceof ViewGroup) {
                this.jk.setTranslationX(2.1474836E9f);
                ((ViewGroup) parent2).addView(this.jk);
            }
        }
    }

    private static void u(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.x, com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        if (this.n <= 0.0f || this.jk == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        u(i);
        float fN = n();
        u(this.jk, (int) this.n, (int) this.f4991a);
        this.jk.setAlpha(fN);
        this.jk.draw(canvas);
        canvas.restore();
    }
}
