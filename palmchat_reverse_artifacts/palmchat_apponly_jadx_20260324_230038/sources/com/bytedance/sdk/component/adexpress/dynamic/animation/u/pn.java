package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends b {
    public pn(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    private void b(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.nr.bq())).setDuration((int) (this.nr.jk() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(u(duration));
    }

    private void fx(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.nr.bq())).setDuration((int) (this.nr.jk() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.u.pn.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                pn.this.fx.setTranslationY(0.0f);
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
        list.add(u(duration));
    }

    private void nr(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.nr.bq())).setDuration((int) (this.nr.jk() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.u.pn.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                pn.this.fx.setTranslationY(0.0f);
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
        list.add(u(duration));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ObjectAnimator> u() {
        byte b;
        ArrayList arrayList = new ArrayList();
        String strDw = this.nr.dw();
        switch (strDw.hashCode()) {
            case 3029889:
                b = !strDw.equals("both") ? (byte) -1 : (byte) 0;
                break;
            case 3387192:
                if (strDw.equals("none")) {
                    b = 3;
                    break;
                }
                break;
            case 483313230:
                if (strDw.equals("forwards")) {
                    b = 1;
                    break;
                }
                break;
            case 1356771568:
                if (strDw.equals("backwards")) {
                    b = 2;
                    break;
                }
                break;
        }
        if (b == 0) {
            u(arrayList);
        } else if (b == 1) {
            b(arrayList);
        } else if (b != 2) {
            fx(arrayList);
        } else {
            nr(arrayList);
        }
        return arrayList;
    }

    private void u(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.nr.bq())).setDuration(((int) (this.nr.jk() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar = this.nr;
        uVar.iz(uVar.k() * 2);
        list.add(u(duration));
    }
}
