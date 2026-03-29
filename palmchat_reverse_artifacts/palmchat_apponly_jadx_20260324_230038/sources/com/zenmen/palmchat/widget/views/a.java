package com.zenmen.palmchat.widget.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.media3.common.C;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f16067a;
    public Context b;
    public GestureDetector c;
    public Scroller d;
    public int e;
    public boolean f;
    public GestureDetector.SimpleOnGestureListener g = new C1150a();
    public final int h = 0;
    public final int i = 1;
    public Handler j = new b();

    /* JADX INFO: renamed from: com.zenmen.palmchat.widget.views.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1150a extends GestureDetector.SimpleOnGestureListener {
        public C1150a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            a.this.e = 0;
            a.this.d.fling(0, a.this.e, 0, (int) (-f2), 0, 0, C.RATE_UNSET_INT, Integer.MAX_VALUE);
            a.this.m(0);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a.this.d.computeScrollOffset();
            int currY = a.this.d.getCurrY();
            int i = a.this.e - currY;
            a.this.e = currY;
            if (i != 0) {
                a.this.f16067a.b(i);
            }
            if (Math.abs(currY - a.this.d.getFinalY()) < 1) {
                a.this.d.getFinalY();
                a.this.d.forceFinished(true);
            }
            if (!a.this.d.isFinished()) {
                a.this.j.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                a.this.j();
            } else {
                a.this.i();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void b(int i);

        void c();

        void onStarted();
    }

    public a(Context context, c cVar) {
        GestureDetector gestureDetector = new GestureDetector(context, this.g);
        this.c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.d = new Scroller(context);
        this.f16067a = cVar;
        this.b = context;
    }

    public final void h() {
        this.j.removeMessages(0);
        this.j.removeMessages(1);
    }

    public void i() {
        if (this.f) {
            this.f16067a.a();
            this.f = false;
        }
    }

    public final void j() {
        this.f16067a.c();
        m(1);
    }

    public void k(int i, int i2) {
        this.d.forceFinished(true);
        this.e = 0;
        this.d.startScroll(0, 0, 0, i, i2 != 0 ? i2 : 400);
        m(0);
        n();
    }

    public void l(Interpolator interpolator) {
        this.d.forceFinished(true);
        this.d = new Scroller(this.b, interpolator);
    }

    public final void m(int i) {
        h();
        this.j.sendEmptyMessage(i);
    }

    public final void n() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.f16067a.onStarted();
    }

    public void o() {
        this.d.forceFinished(true);
    }
}
