package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn {
    public View fx;
    com.bytedance.sdk.component.adexpress.dynamic.fx.u nr;
    private Set<ScheduledFuture<?>> b = new HashSet();
    public List<ObjectAnimator> u = u();

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Runnable {
        ScheduledFuture<?> nr;
        ObjectAnimator u;

        public u(ObjectAnimator objectAnimator) {
            this.u = objectAnimator;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null) {
                com.bytedance.sdk.component.adexpress.u.u.u.u().fx().nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.u.b.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.u.resume();
                    }
                });
                if (this.nr != null) {
                    b.this.b.remove(this.nr);
                }
            }
        }

        public void u(ScheduledFuture<?> scheduledFuture) {
            this.nr = scheduledFuture;
        }
    }

    public b(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        this.fx = view;
        this.nr = uVar;
    }

    public void fx() {
        List<ObjectAnimator> list = this.u;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.nr.o() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.u.b.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        u uVar = b.this.new u(objectAnimator);
                        ScheduledFuture<?> scheduledFutureU = com.bytedance.sdk.component.adexpress.b.pn.u(uVar, (long) (b.this.nr.o() * 1000.0d), TimeUnit.MILLISECONDS);
                        uVar.u(scheduledFutureU);
                        b.this.b.add(scheduledFutureU);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn
    public void nr() {
        List<ObjectAnimator> list = this.u;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public abstract List<ObjectAnimator> u();

    public ObjectAnimator u(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.nr.s() * 1000.0d));
        if (this.nr.k() > 0) {
            objectAnimator.setRepeatCount(this.nr.k() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL.equals(this.nr.my())) {
            if ("alternate".equals(this.nr.my()) || "alternate-reverse".equals(this.nr.my())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.nr.mv())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.nr.my())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.nr.my())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.u.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    b.this.fx.setVisibility(0);
                    if (b.this.fx.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) b.this.fx.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }
}
