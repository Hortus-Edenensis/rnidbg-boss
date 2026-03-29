package defpackage;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.zenmen.openapi.webapp.floatview.AppFloatIcon;
import com.zenmen.openapi.webapp.floatview.AppFloatMenuBox;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vg implements fa3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppFloatIcon f21431a;
    public AppFloatMenuBox b;
    public fa3 c;
    public double f;
    public double g;
    public double h;
    public double i;
    public long j;
    public double k;
    public double l;
    public Runnable d = new a();
    public View.OnTouchListener e = new b();
    public double m = 0.0d;
    public double n = 0.0d;
    public double o = 0.0d;
    public AlphaAnimation p = null;
    public ScaleAnimation q = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vg.this.B();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return true;
            }
            vg.this.D();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0037  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Point pointM = a46.m(vg.this.f21431a.getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) vg.this.f21431a.getLayoutParams();
            if (a46.s(vg.this.f21431a.getContext())) {
                int i = pointM.y;
                int i2 = pointM.x;
                if (i > i2) {
                    layoutParams.topMargin = (i2 / 5) * 3;
                } else {
                    layoutParams.topMargin = (pointM.y / 5) * 3;
                }
            }
            vg.this.f21431a.setTranslationX(0.0f);
            vg.this.f21431a.setTranslationY(0.0f);
            vg.this.f21431a.setLayoutParams(layoutParams);
            vg.this.f21431a.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnTouchListener {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                vg.this.x();
                vg.this.j = System.currentTimeMillis();
                vg.this.f = rawX;
                vg.this.g = rawY;
                vg.this.h = rawX;
                vg.this.i = rawY;
            } else if (action == 1) {
                vg.this.s();
                if (System.currentTimeMillis() - vg.this.j < 500 && Math.abs(vg.this.h - vg.this.f) < 5.0d && Math.abs(vg.this.i - vg.this.g) < 5.0d) {
                    vg.this.C();
                }
            } else if (action == 2) {
                vg.this.w(rawX - vg.this.f, rawY - vg.this.g);
                vg.this.f = rawX;
                vg.this.g = rawY;
            } else if (action == 3) {
            }
            return true;
        }
    }

    public vg(AppFloatIcon appFloatIcon, AppFloatMenuBox appFloatMenuBox) {
        this.f21431a = appFloatIcon;
        this.b = appFloatMenuBox;
        appFloatMenuBox.setEventCallback(this);
        this.b.setOnTouchListener(this.e);
    }

    public final void A() {
        this.f21431a.getLocationInWindow(new int[2]);
        Point pointM = a46.m(this.f21431a.getContext());
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, (r1[0] + (this.f21431a.getWidth() / 2)) / pointM.x, 1, r1[1] / pointM.y);
        this.q = scaleAnimation;
        scaleAnimation.setDuration(300L);
        this.q.setFillAfter(true);
        this.b.setAnimation(this.q);
        this.b.startAnimation(this.q);
    }

    public final void B() {
        this.f21431a.setAnimation(this.p);
        this.f21431a.startAnimation(this.p);
    }

    public final void C() {
        this.f21431a.setVisibility(8);
        this.f21431a.removeCallbacks(this.d);
        this.b.setVisibility(0);
        A();
        onEvent(10, null);
    }

    public final void D() {
        z();
        x();
    }

    public final void E() {
        AppFloatIcon appFloatIcon = this.f21431a;
        if (appFloatIcon != null) {
            appFloatIcon.setVisibility(0);
        }
        AppFloatMenuBox appFloatMenuBox = this.b;
        if (appFloatMenuBox != null) {
            appFloatMenuBox.clearAnimation();
            this.b.setVisibility(8);
        }
    }

    public void F(boolean z) {
        if (z || this.f21431a.getVisibility() != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
            this.p = alphaAnimation;
            alphaAnimation.setDuration(600L);
            this.p.setFillAfter(true);
            this.f21431a.post(new c());
            this.b.setVisibility(8);
            x();
            u();
        }
    }

    @Override // defpackage.fa3
    public void onEvent(int i, Object obj) {
        fa3 fa3Var = this.c;
        if (fa3Var != null) {
            fa3Var.onEvent(i, obj);
        }
        if (i != 10) {
            E();
        }
    }

    public final void s() {
        Point pointM = a46.m(this.f21431a.getContext());
        int iB = a46.b(this.f21431a.getContext(), 16.0f);
        this.l = iB - this.f21431a.getTop();
        int height = pointM.y;
        if (this.f21431a.getParent() instanceof ViewGroup) {
            height = ((ViewGroup) this.f21431a.getParent()).getHeight();
        }
        this.k = (height - this.f21431a.getBottom()) - iB;
        ma3.f("mFloatIcon.getWidth()/2 " + (this.f21431a.getWidth() / 2));
        double width = (double) (((pointM.x / 2) + (this.f21431a.getWidth() / 2)) - this.f21431a.getRight());
        this.o = width;
        this.n = width * 2.0d;
        double translationY = this.f21431a.getTranslationY();
        double translationX = this.f21431a.getTranslationX();
        double d2 = this.l;
        if (translationY < d2) {
            this.f21431a.setTranslationY((float) d2);
        } else {
            double d3 = this.k;
            if (translationY > d3) {
                this.f21431a.setTranslationY((float) d3);
            }
        }
        if (translationX < this.o) {
            this.f21431a.setTranslationX((float) this.n);
        } else {
            this.f21431a.setTranslationX((float) this.m);
        }
        x();
    }

    public void t() {
        AppFloatIcon appFloatIcon = this.f21431a;
        if (appFloatIcon != null) {
            appFloatIcon.clearAnimation();
            this.f21431a.removeCallbacks(this.d);
            this.f21431a.setVisibility(8);
        }
        AppFloatMenuBox appFloatMenuBox = this.b;
        if (appFloatMenuBox != null) {
            appFloatMenuBox.clearAnimation();
            this.b.setVisibility(8);
        }
    }

    public final void u() {
        this.f21431a.setOnTouchListener(new d());
    }

    public boolean v() {
        AppFloatIcon appFloatIcon = this.f21431a;
        if (appFloatIcon != null && appFloatIcon.getVisibility() == 0) {
            return true;
        }
        AppFloatMenuBox appFloatMenuBox = this.b;
        return appFloatMenuBox != null && appFloatMenuBox.getVisibility() == 0;
    }

    public final void w(double d2, double d3) {
        AppFloatIcon appFloatIcon = this.f21431a;
        appFloatIcon.setTranslationX((float) (((double) appFloatIcon.getTranslationX()) + d2));
        AppFloatIcon appFloatIcon2 = this.f21431a;
        appFloatIcon2.setTranslationY((float) (((double) appFloatIcon2.getTranslationY()) + d3));
    }

    public final void x() {
        this.f21431a.removeCallbacks(this.d);
        this.f21431a.clearAnimation();
        this.f21431a.setAlpha(1.0f);
        this.f21431a.postDelayed(this.d, 3000L);
    }

    public void y(fa3 fa3Var) {
        this.c = fa3Var;
    }

    public final void z() {
        Point pointM = a46.m(this.f21431a.getContext());
        this.f21431a.getLocationInWindow(new int[2]);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, (r2[0] + (this.f21431a.getWidth() / 2)) / pointM.x, 1, r2[1] / pointM.y);
        this.q = scaleAnimation;
        scaleAnimation.setDuration(300L);
        this.q.setFillAfter(true);
        this.q.setAnimationListener(new e());
        this.b.setAnimation(this.q);
        this.b.startAnimation(this.q);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            vg.this.f21431a.setVisibility(0);
            vg.this.b.clearAnimation();
            vg.this.b.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
