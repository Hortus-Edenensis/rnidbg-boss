package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5342a;
    private float fx;
    private float jk;
    private float n;
    private float nr;
    private float t;
    private View u;
    private float b = 0.0f;
    private float pn = 0.0f;
    private float iz = 0.0f;
    private float x = 0.0f;
    private boolean l = false;
    private boolean mv = false;
    private boolean s = false;
    private boolean k = false;

    public my(View view) {
        this.u = view;
    }

    public boolean nr(MotionEvent motionEvent) {
        this.nr = ((ViewGroup) this.u.getParent()).getWidth();
        this.fx = ((ViewGroup) this.u.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.mv = false;
                this.s = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.b;
                float f2 = y - this.pn;
                this.n = this.u.getLeft() + f;
                this.f5342a = this.u.getTop() + f2;
                this.jk = this.u.getRight() + f;
                this.t = this.u.getBottom() + f2;
                if (this.n < 0.0f) {
                    this.s = true;
                    this.n = 0.0f;
                    this.jk = this.u.getWidth() + 0.0f;
                }
                float f3 = this.jk;
                float f4 = this.nr;
                if (f3 > f4) {
                    this.mv = true;
                    this.jk = f4;
                    this.n = f4 - this.u.getWidth();
                }
                if (this.f5342a < 0.0f) {
                    this.f5342a = 0.0f;
                    this.t = 0.0f + this.u.getHeight();
                }
                float f5 = this.t;
                float f6 = this.fx;
                if (f5 > f6) {
                    this.t = f6;
                    this.f5342a = f6 - this.u.getHeight();
                }
                this.u.offsetLeftAndRight((int) f);
                this.u.offsetTopAndBottom((int) f2);
                if (this.s) {
                    View view = this.u;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.mv) {
                    this.u.offsetLeftAndRight((int) (this.nr - r7.getRight()));
                }
            }
        } else {
            if (!this.k) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.nr / 2.0f) {
                this.l = false;
                this.u.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.nr - this.u.getWidth()).start();
                this.u.offsetLeftAndRight((int) (this.nr - r7.getRight()));
            } else {
                this.l = true;
                this.u.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view2 = this.u;
                view2.offsetLeftAndRight(-view2.getLeft());
            }
            this.u.invalidate();
        }
        return true;
    }

    public boolean u(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.b = motionEvent.getX();
            this.pn = motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        this.iz = motionEvent.getX();
        this.x = motionEvent.getY();
        if (Math.abs(this.iz - this.b) < 5.0f || Math.abs(this.x - this.pn) < 5.0f) {
            this.k = false;
            return false;
        }
        this.k = true;
        return true;
    }
}
