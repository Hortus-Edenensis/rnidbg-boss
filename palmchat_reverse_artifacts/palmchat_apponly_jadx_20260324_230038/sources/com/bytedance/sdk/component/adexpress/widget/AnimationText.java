package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.b.t;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5104a;
    private final int b;
    private int fx;
    private TextView iz;
    private int jk;
    private int l;
    private int mv;
    private int n;
    private List<String> nr;
    private Context pn;
    private Handler s;
    private int t;
    Animation.AnimationListener u;
    private int x;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.nr = new ArrayList();
        this.fx = 0;
        this.b = 1;
        this.s = new rh(Looper.getMainLooper(), this);
        this.u = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.iz != null) {
                    AnimationText.this.iz.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.pn = context;
        this.n = i;
        this.f5104a = f;
        this.jk = i2;
        this.mv = i3;
        fx();
    }

    private void fx() {
        setFactory(this);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.iz = textView;
        textView.setTextColor(this.n);
        this.iz.setTextSize(this.f5104a);
        this.iz.setMaxLines(this.jk);
        this.iz.setTextAlignment(this.mv);
        return this.iz;
    }

    public void nr() {
        List<String> list = this.nr;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.fx;
        this.fx = i + 1;
        this.t = i;
        setText(this.nr.get(i));
        if (this.fx > this.nr.size() - 1) {
            this.fx = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s.sendEmptyMessageDelayed(1, this.x);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(t.nr(this.nr.get(this.t), this.f5104a, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    public void setAnimationDuration(int i) {
        this.x = i;
    }

    public void setAnimationText(List<String> list) {
        this.nr = list;
    }

    public void setAnimationType(int i) {
        this.l = i;
    }

    public void setMaxLines(int i) {
        this.jk = i;
    }

    public void setTextColor(int i) {
        this.n = i;
    }

    public void setTextSize(float f) {
        this.f5104a = f;
    }

    public void u() {
        int i = this.l;
        if (i == 1) {
            setInAnimation(getContext(), q.t(this.pn, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), q.t(this.pn, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), q.t(this.pn, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), q.t(this.pn, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.u);
            getOutAnimation().setAnimationListener(this.u);
        }
        this.s.sendEmptyMessage(1);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 1) {
            return;
        }
        nr();
        this.s.sendEmptyMessageDelayed(1, this.x);
    }
}
