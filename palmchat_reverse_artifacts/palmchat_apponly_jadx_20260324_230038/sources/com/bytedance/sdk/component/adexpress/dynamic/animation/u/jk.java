package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends b {
    private u b;
    private float iz;
    private float pn;

    /* JADX INFO: compiled from: SearchBox */
    public class u {
        private View nr;

        public u(View view) {
            this.nr = view;
        }

        public void u(int i) {
            if (!Constant.MAP_KEY_TOP.equals(jk.this.nr.u())) {
                ViewGroup.LayoutParams layoutParams = this.nr.getLayoutParams();
                layoutParams.height = i;
                this.nr.setLayoutParams(layoutParams);
                this.nr.requestLayout();
                return;
            }
            if (jk.this.fx instanceof ViewGroup) {
                for (int i2 = 0; i2 < ((ViewGroup) jk.this.fx).getChildCount(); i2++) {
                    ((ViewGroup) jk.this.fx).getChildAt(i2).setTranslationY(i - jk.this.pn);
                }
            }
            jk jkVar = jk.this;
            jkVar.fx.setTranslationY(jkVar.pn - i);
        }
    }

    public jk(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        int i;
        String str;
        View view = this.fx;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicBaseWidget)) {
            this.fx = (View) this.fx.getParent();
        }
        this.fx.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "alpha", 0.0f, 1.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        this.b = new u(this.fx);
        final int i2 = this.fx.getLayoutParams().height;
        this.pn = i2;
        this.iz = this.fx.getLayoutParams().width;
        if ("left".equals(this.nr.u()) || "right".equals(this.nr.u())) {
            i = (int) this.iz;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.b, str, 0, i).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        arrayList.add(u(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.u.jk.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                jk.this.b.u(i2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return arrayList;
    }
}
