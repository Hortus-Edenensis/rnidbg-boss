package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SmallSlideView extends RelativeLayout {
    private ObjectAnimator b;
    private ObjectAnimator fx;
    private final nr nr;
    private final View u;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends FrameLayout {
        public nr(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            q.u(context, "tt_splash_slide_up_bg", (View) imageView);
            addView(imageView);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends FrameLayout {
        public u(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            q.u(context, "tt_splash_slide_up_finger", imageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = y.fx(context, 38.0f);
            layoutParams.bottomMargin = y.fx(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            q.u(context, "tt_splash_slide_up_circle", imageView2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int iFx = y.fx(context, 30.0f);
            layoutParams2.setMargins(iFx, iFx, iFx, iFx);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    public SmallSlideView(Context context) {
        super(context);
        View uVar = new u(context);
        this.u = uVar;
        nr nrVar = new nr(context);
        this.nr = nrVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(y.fx(context, 10.0f), 0);
        layoutParams.setMargins(0, y.fx(context, 8.0f), 0, y.fx(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(nrVar, layoutParams);
        addView(uVar);
        setLayoutParams(new LinearLayout.LayoutParams(y.fx(context, 80.0f), y.fx(context, 80.0f)));
    }

    public void nr() {
        ObjectAnimator objectAnimator = this.fx;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.b;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    public void u() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.u, "translationY", y.fx(getContext(), 30.0f), y.fx(getContext(), -20.0f));
        this.fx = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(800L);
        this.fx.setRepeatCount(1);
        this.fx.setRepeatMode(1);
        this.fx.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.nr, "newHeight", y.fx(getContext(), 0.0f), y.fx(getContext(), 48.0f));
        this.b = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(800L);
        this.b.setRepeatCount(1);
        this.b.setRepeatMode(1);
        this.b.start();
    }
}
