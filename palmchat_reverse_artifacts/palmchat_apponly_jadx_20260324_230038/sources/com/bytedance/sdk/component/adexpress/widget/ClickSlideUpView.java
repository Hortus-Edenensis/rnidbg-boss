package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ClickSlideUpView extends SlideUpView {
    private AnimatorSet fx;
    private View nr;
    private TextView u;

    public ClickSlideUpView(Context context) {
        super(context);
        this.fx = new AnimatorSet();
        nr(context);
    }

    private void b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.nr, "translationY", 0.0f, n.u(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.nr, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.fx.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.fx.setDuration(1000L);
        this.fx.start();
    }

    private void nr(Context context) {
        View viewU = com.bytedance.sdk.component.adexpress.fx.u.u(context);
        this.nr = viewU;
        addView(viewU);
        setClipChildren(false);
        this.u = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.u == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.u.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void u(Context context) {
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void u() {
        b();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void nr() {
        this.fx.cancel();
    }
}
