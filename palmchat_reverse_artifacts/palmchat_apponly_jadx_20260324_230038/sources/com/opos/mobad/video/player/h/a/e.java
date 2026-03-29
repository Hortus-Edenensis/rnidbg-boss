package com.opos.mobad.video.player.h.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f10372a;
    private ObjectAnimator b;
    private AnimatorSet c;
    private View d;
    private float e;
    private float f;
    private long g;

    public e(View view, float f, float f2, long j) {
        this.e = 1.0f;
        this.f = 1.1f;
        this.g = com.igexin.push.config.c.j;
        this.d = view;
        if (f > 0.0f) {
            this.e = f;
        }
        if (f2 > 0.0f) {
            this.f = f2;
        }
        if (j > 0) {
            this.g = j;
        }
        c();
    }

    private void c() {
        try {
            View view = this.d;
            if (view == null) {
                return;
            }
            float f = this.e;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", f, this.f, f);
            this.f10372a = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setRepeatCount(-1);
            View view2 = this.d;
            float f2 = this.e;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, "scaleY", f2, this.f, f2);
            this.b = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            this.c = animatorSet;
            animatorSet.play(this.f10372a).with(this.b);
            this.c.setDuration(this.g);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e);
        }
    }

    public void a() {
        try {
            if (this.d == null) {
                return;
            }
            this.c.start();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e);
        }
    }

    public void b() {
        try {
            if (this.d == null) {
                return;
            }
            this.c.cancel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e);
        }
    }
}
