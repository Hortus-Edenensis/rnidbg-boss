package com.zenmen.palmchat.videocall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import defpackage.tj2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a implements View.OnTouchListener, GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    public static final String u = tj2.k();
    public static boolean v = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15855a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public GestureDetector l;
    public Context m;
    public View n;
    public View o;
    public InterfaceC1128a p;
    public float q;
    public float r;
    public long s;
    public long t;

    /* JADX INFO: renamed from: com.zenmen.palmchat.videocall.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1128a {
        void a(int i, int i2);
    }

    public a(Context context, View view, WindowManager windowManager, WindowManager.LayoutParams layoutParams, InterfaceC1128a interfaceC1128a) {
        this.m = context;
        this.n = view;
        this.j = windowManager;
        this.k = layoutParams;
        this.b = windowManager.getDefaultDisplay().getWidth();
        this.c = this.j.getDefaultDisplay().getHeight();
        this.f15855a = a(context);
        GestureDetector gestureDetector = new GestureDetector(this.m, this);
        this.l = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        this.p = interfaceC1128a;
    }

    public static int a(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean b() {
        return v;
    }

    public static void c() {
        v = false;
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
        this.o.setVisibility(8);
        Intent intent = new Intent(this.m, (Class<?>) VideoCallActivity.class);
        intent.addFlags(268435456);
        this.m.startActivity(intent);
        v = true;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.l.onTouchEvent(motionEvent);
        this.o = view;
        this.f = motionEvent.getRawX();
        this.g = motionEvent.getRawY() - this.f15855a;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getY();
            this.e = motionEvent.getX();
            this.q = motionEvent.getRawX();
            this.r = motionEvent.getRawY();
            this.h = motionEvent.getRawX();
            this.i = motionEvent.getRawY();
            this.s = System.currentTimeMillis();
        } else if (action == 1) {
            WindowManager.LayoutParams layoutParams = this.k;
            int i = layoutParams.x;
            int i2 = this.b;
            if (i <= i2 / 2) {
                i2 = 0;
            }
            layoutParams.x = i2;
            layoutParams.y = (int) (this.g - this.d);
            this.j.updateViewLayout(this.n, layoutParams);
            InterfaceC1128a interfaceC1128a = this.p;
            if (interfaceC1128a != null) {
                WindowManager.LayoutParams layoutParams2 = this.k;
                interfaceC1128a.a(layoutParams2.x, layoutParams2.y);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.t = jCurrentTimeMillis;
            if (jCurrentTimeMillis - this.s < 800 && Math.abs(this.q - this.h) < 10.0d) {
                Math.abs(this.r - this.i);
            }
        } else if (action == 2) {
            this.k.x = (int) (this.b - (this.f + (this.n.getWidth() / 2)));
            Log.i("aaa", "x - mTouchStartX:" + (this.f - this.e) + "          x:" + this.f + "         mTouchStartX:" + this.e);
            WindowManager.LayoutParams layoutParams3 = this.k;
            layoutParams3.y = (int) (this.g - this.d);
            this.j.updateViewLayout(this.n, layoutParams3);
        }
        return zOnTouchEvent;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
