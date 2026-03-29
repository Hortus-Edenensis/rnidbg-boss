package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends TouchDelegate {
    private boolean b;
    private Rect fx;
    private Rect nr;
    private int pn;
    private View u;

    public a(Rect rect, View view) {
        super(rect, view);
        this.nr = rect;
        this.pn = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.fx = rect2;
        int i = this.pn;
        rect2.inset(-i, -i);
        this.u = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zContains;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z2 = this.b;
                if (z2) {
                    zContains = this.fx.contains(x, y);
                    z = z2;
                } else {
                    z = z2;
                }
            } else {
                if (action == 3) {
                    boolean z3 = this.b;
                    this.b = false;
                    z = z3;
                }
                zContains = true;
                z = false;
            }
            zContains = true;
        } else if (this.nr.contains(x, y)) {
            this.b = true;
            zContains = true;
        } else {
            this.b = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.u;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.pn * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
