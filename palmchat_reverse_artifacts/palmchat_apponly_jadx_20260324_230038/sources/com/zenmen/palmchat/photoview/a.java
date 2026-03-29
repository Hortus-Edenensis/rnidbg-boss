package com.zenmen.palmchat.photoview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f15024a;
    public View b;
    public boolean c = true;
    public boolean d = false;
    public final int e = BmLocated.HALF_LEFT_TOP;
    public final int f = 7172;
    public ValueAnimator g;
    public d h;

    /* JADX INFO: renamed from: com.zenmen.palmchat.photoview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1096a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15025a;

        public C1096a(int i) {
            this.f15025a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.b.setTranslationY((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f15025a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationCancel isShow" + a.this.c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationEnd isShow" + a.this.c);
            if (a.this.c) {
                return;
            }
            a.this.f15024a.setSystemUiVisibility(7172);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationRepeat isShow" + a.this.c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LogUtil.i("PhotoViewSysUiHelper", "AnimatorListener  onAnimationStart isShow" + a.this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g.reverse();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(boolean z);
    }

    public a(ViewGroup viewGroup, View view) {
        this.f15024a = viewGroup;
        this.b = view;
        e();
    }

    public final void e() {
        this.f15024a.setOnSystemUiVisibilityChangeListener(this);
        int i = -me1.b(this.f15024a.getContext(), 120);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.g = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
        this.g.setFloatValues(0.0f, 1.0f);
        this.g.setDuration(250L);
        this.g.addUpdateListener(new C1096a(i));
        this.g.addListener(new b());
        g(true, false);
    }

    public void f(d dVar) {
        this.h = dVar;
    }

    public final void g(boolean z, boolean z2) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(z);
        }
        this.c = z;
        this.d = z2;
        if (z2) {
            if (!z) {
                this.g.start();
                return;
            } else {
                this.f15024a.setSystemUiVisibility(BmLocated.HALF_LEFT_TOP);
                this.f15024a.postDelayed(new c(), 200L);
                return;
            }
        }
        if (z) {
            this.f15024a.setSystemUiVisibility(BmLocated.HALF_LEFT_TOP);
            this.b.setVisibility(0);
        } else {
            this.f15024a.setSystemUiVisibility(7172);
            this.b.setVisibility(8);
        }
    }

    public void h() {
        LogUtil.i("PhotoViewSysUiHelper", "switchStatus isShow=" + this.c);
        if (this.g.isRunning()) {
            return;
        }
        g(!this.c, true);
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        LogUtil.i("PhotoViewSysUiHelper", "onSystemUiVisibilityChange=" + i + "    " + (i == 0));
    }
}
