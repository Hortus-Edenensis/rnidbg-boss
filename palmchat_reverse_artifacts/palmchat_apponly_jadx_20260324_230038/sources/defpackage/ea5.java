package defpackage;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ea5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f17247a;
    public Thread b = null;
    public boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends g13 {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (true) {
                ea5 ea5Var = ea5.this;
                if (ea5Var.c) {
                    return;
                }
                ea5Var.b(ea5Var.f17247a, -30);
                for (int i = 0; i < 50; i++) {
                    try {
                        if (ea5.this.c) {
                            break;
                        }
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public ea5(View view) {
        this.f17247a = view;
    }

    public final void b(View view, int i) {
        if (view != null && i < 0) {
            try {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, i);
                translateAnimation.setInterpolator(new CycleInterpolator(1.0f));
                translateAnimation.setDuration(250L);
                translateAnimation.setAnimationListener(new b(view, i));
                translateAnimation.setFillAfter(true);
                view.startAnimation(translateAnimation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        this.c = false;
        a aVar = new a();
        this.b = aVar;
        aVar.start();
    }

    public void d() {
        this.c = true;
        try {
            this.b.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f17249a;
        public final /* synthetic */ int b;

        public b(View view, int i) {
            this.f17249a = view;
            this.b = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ea5.this.b(this.f17249a, this.b + 3);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
