package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b.a;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.utils.ja;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CircleLongPressView extends FrameLayout {
    private TextView b;
    private ImageView fx;
    private AnimatorSet iz;
    private ImageView nr;
    private RingProgressView pn;
    private Context u;

    public CircleLongPressView(Context context) {
        super(context);
        this.iz = new AnimatorSet();
        this.u = context;
        pn();
        iz();
    }

    private void iz() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.fx, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.fx, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iz.setDuration(800L);
        this.iz.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void pn() {
        FrameLayout frameLayout = new FrameLayout(this.u);
        this.pn = new RingProgressView(this.u);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) n.u(this.u, 95.0f), (int) n.u(this.u, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.pn, layoutParams);
        this.nr = new ImageView(this.u);
        int iU = ja.u(this.u, 60.0f);
        this.nr.setImageDrawable(a.u(1, null, null, new int[]{iU, iU}, Integer.valueOf(ja.u(this.u, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) n.u(this.u, 75.0f), (int) n.u(this.u, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.nr, layoutParams2);
        this.fx = new ImageView(this.u);
        int iU2 = ja.u(this.u, 50.0f);
        this.fx.setImageDrawable(a.u(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iU2, iU2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) n.u(this.u, 63.0f), (int) n.u(this.u, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.fx, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.u);
        this.b = textView;
        textView.setTextColor(-1);
        this.b.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.b, layoutParams4);
    }

    public void b() {
        this.pn.nr();
        this.pn.fx();
    }

    public void fx() {
        this.pn.u();
    }

    public void nr() {
        this.iz.cancel();
    }

    public void setGuideText(String str) {
        this.b.setText(str);
    }

    public void u() {
        this.iz.start();
    }
}
