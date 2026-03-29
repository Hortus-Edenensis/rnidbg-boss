package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class u extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f5214a;
    protected bc b;
    protected NativeExpressView fx;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.u iz;
    protected String jk;
    protected int n;
    protected NativeExpressView nr;
    protected com.bytedance.sdk.openadsdk.my.fx.fx.nr pn;
    protected final Context u;
    protected com.bytedance.sdk.openadsdk.kj.u.nr.u.fx x;

    public u(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(context);
        this.jk = "banner_ad";
        this.u = context;
        this.b = bcVar;
        this.pn = nrVar;
        u();
    }

    private ObjectAnimator nr(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.u.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                u.this.f5214a = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return objectAnimatorOfFloat;
    }

    public void b() {
        NativeExpressView nativeExpressView = this.nr;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.nr.mv();
            this.nr = null;
        }
        NativeExpressView nativeExpressView2 = this.fx;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.fx.mv();
            this.fx = null;
        }
    }

    public void fx() {
        NativeExpressView nativeExpressView = this.fx;
        if (nativeExpressView != null) {
            nativeExpressView.o();
        }
    }

    public NativeExpressView getCurView() {
        return this.nr;
    }

    public NativeExpressView getNextView() {
        return this.fx;
    }

    public void iz() {
        if (this.f5214a || this.fx == null || this.nr == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(u(this.nr)).with(nr(this.fx));
        animatorSet.setDuration(this.n).start();
        y.u((View) this.fx, 0);
        this.f5214a = true;
        NativeExpressView nativeExpressView = this.nr;
        this.nr = this.fx;
        this.fx = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.fx.mv();
            this.fx = null;
        }
    }

    public void pn() {
        NativeExpressView nativeExpressView = this.nr;
        if (nativeExpressView != null) {
            nativeExpressView.o();
        }
    }

    public void setDuration(int i) {
        this.n = i;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar) {
        this.iz = uVar;
        NativeExpressView nativeExpressView = this.nr;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.u.2
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, int i) {
                    u uVar2 = u.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar3 = uVar2.iz;
                    if (uVar3 != null) {
                        uVar3.u(uVar2, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, String str, int i) {
                    u uVar2 = u.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar3 = uVar2.iz;
                    if (uVar3 != null) {
                        uVar3.u(uVar2, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, float f, float f2) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).dw()) {
                        u.this.u(f, f2);
                    }
                    u uVar2 = u.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar3 = uVar2.iz;
                    if (uVar3 != null) {
                        uVar3.u(uVar2, f, f2);
                    }
                }
            });
        }
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar) {
        this.x = fxVar;
    }

    public void u() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.u, this.b, this.pn, this.jk);
        this.nr = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void u(bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.u, bcVar, nrVar, this.jk);
        this.fx = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.u.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, int i) {
                u uVar = u.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar2 = uVar.iz;
                if (uVar2 != null) {
                    uVar2.u(uVar, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, float f, float f2) {
                u.this.u(f, f2);
                u.this.iz();
            }
        });
        y.u((View) this.fx, 8);
        addView(this.fx, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean nr() {
        return this.fx != null;
    }

    public void u(float f, float f2) {
        int iFx = y.fx(this.u, f);
        int iFx2 = y.fx(this.u, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iFx, iFx2);
        }
        layoutParams.width = iFx;
        layoutParams.height = iFx2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator u(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }
}
