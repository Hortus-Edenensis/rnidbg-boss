package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cg6 implements View.OnTouchListener, GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    public static boolean y = false;
    public Context c;
    public View d;
    public View e;
    public final int f;
    public final int g;
    public final int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public final GestureDetector m;
    public final b n;
    public float o;
    public float p;
    public long q;
    public long r;
    public View s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1971a = me1.g();
    public int b = me1.f();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            cg6 cg6Var = cg6.this;
            cg6Var.v = (int) cg6Var.d.getTranslationX();
            cg6.this.x = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator, boolean z) {
            super.onAnimationStart(animator, z);
            cg6.this.x = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i, int i2);

        void onClick();
    }

    public cg6(Context context, View view, View view2, b bVar) {
        this.c = context;
        this.d = view2;
        this.s = view;
        this.f = f(context);
        this.g = me1.b(this.c, 80);
        this.h = me1.b(this.c, 50);
        GestureDetector gestureDetector = new GestureDetector(this.c, this);
        this.m = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        this.n = bVar;
    }

    public static int f(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final void c() {
        int i = -(this.f1971a - this.d.getWidth());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", this.v, this.v > i / 2 ? 0.0f : i).setDuration((int) ((((Math.abs(r1 - r0) * 1.0f) / this.f1971a) / 2.0f) * 400.0f));
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addListener(new a());
        duration.start();
    }

    public final int d(int i) {
        if (i > 0) {
            return 0;
        }
        return i < (-(this.f1971a - this.d.getWidth())) ? -(this.f1971a - this.d.getWidth()) : i;
    }

    public final int e(int i) {
        int i2 = this.h;
        return i > i2 ? i2 : i < (-(((this.s.getHeight() - this.d.getHeight()) - this.f) - this.g)) ? -(((this.s.getHeight() - this.d.getHeight()) - this.f) - this.g) : i;
    }

    public final void g(int i, int i2, boolean z) {
        int iD = d(this.v + i);
        int iE = e(this.w + i2);
        this.d.setTranslationX(iD);
        this.d.setTranslationY(iE);
        if (z) {
            this.v = iD;
            this.w = iE;
            c();
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    @SuppressLint({"NewApi"})
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        b bVar = this.n;
        if (bVar != null) {
            bVar.onClick();
        }
        y = true;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b bVar;
        if (this.x) {
            return true;
        }
        this.e = view;
        this.k = motionEvent.getRawX();
        this.l = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.i = motionEvent.getRawY();
            this.j = motionEvent.getRawX();
            this.o = motionEvent.getRawX();
            this.p = motionEvent.getRawY();
            this.q = System.currentTimeMillis();
        } else if (action == 1) {
            int i = (int) (this.k - this.j);
            this.t = i;
            int i2 = (int) (this.l - this.i);
            this.u = i2;
            g(i, i2, true);
            b bVar2 = this.n;
            if (bVar2 != null) {
                bVar2.a(this.t, this.u);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.r = jCurrentTimeMillis;
            if (jCurrentTimeMillis - this.q < 800 && Math.abs(this.o - this.k) < 20.0d && Math.abs(this.p - this.l) < 20.0d && (bVar = this.n) != null) {
                bVar.onClick();
            }
        } else if (action == 2) {
            int i3 = (int) (this.k - this.j);
            this.t = i3;
            int i4 = (int) (this.l - this.i);
            this.u = i4;
            g(i3, i4, false);
        } else if (action == 3) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
