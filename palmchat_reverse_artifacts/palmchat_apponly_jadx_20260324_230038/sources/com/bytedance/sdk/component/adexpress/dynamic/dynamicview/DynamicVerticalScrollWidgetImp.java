package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp {
    private int bq;
    private Runnable c;
    private boolean dw;
    ObjectAnimator nr;
    ObjectAnimator u;

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.bq = 0;
        this.dw = false;
        this.c = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.a();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        final View childAt;
        final View childAt2 = getChildAt(this.bq);
        int i = this.bq;
        if (i == 0) {
            this.dw = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.bq + 1)).getChildCount() <= 0;
        if (this.mv.jk().pn().u() || !z) {
            View childAt3 = z ? getChildAt((this.bq + 2) % getChildCount()) : getChildAt((this.bq + 1) % getChildCount());
            this.u = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (-(this.n + getChildAt(this.bq).getHeight())) / 2);
            if (z) {
                this.bq++;
            }
            childAt = childAt3;
        } else {
            this.dw = true;
            childAt = getChildAt(this.bq - 1);
            this.u = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (this.n + getChildAt(this.bq).getHeight()) / 2);
        }
        this.u.setInterpolator(new LinearInterpolator());
        this.u.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
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
        if (this.dw) {
            this.nr = ObjectAnimator.ofFloat(childAt, "translationY", (-(this.n + childAt.getHeight())) / 2, 0.0f);
        } else {
            this.nr = ObjectAnimator.ofFloat(childAt, "translationY", (this.n + childAt.getHeight()) / 2, 0.0f);
        }
        this.nr.setInterpolator(new LinearInterpolator());
        this.nr.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.u.setDuration(500L);
        this.nr.setDuration(500L);
        this.u.start();
        this.nr.start();
        if (this.dw) {
            this.bq--;
        } else {
            int i2 = this.bq + 1;
            this.bq = i2;
            this.bq = i2 % getChildCount();
        }
        postDelayed(this.c, 3000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn
    public void nr() {
        removeCallbacks(this.c);
        ObjectAnimator objectAnimator = this.u;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.u.cancel();
        }
        ObjectAnimator objectAnimator2 = this.nr;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.nr.cancel();
        }
        super.nr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.n - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.c, 2500L);
    }
}
