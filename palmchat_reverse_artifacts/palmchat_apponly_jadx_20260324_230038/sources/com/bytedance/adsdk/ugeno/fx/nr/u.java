package com.bytedance.adsdk.ugeno.fx.nr;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    public String u = "GesThrough_";
    private List<MotionEvent> nr = new ArrayList();
    private Set<String> fx = Collections.synchronizedSet(new HashSet());

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        if (fxVar == null || motionEvent == null || this.nr == null) {
            return;
        }
        u(fxVar.a(), fxVar.ja(), motionEvent);
    }

    public void u(View view, String str, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || this.nr == null) {
            return;
        }
        this.u = "GesThrough_".concat(String.valueOf(str));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.nr.clear();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i, i2);
        this.nr.add(motionEventObtain);
    }

    public boolean u(MotionEvent motionEvent) {
        if (motionEvent == null || this.fx == null) {
            return false;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        return this.fx.contains(motionEvent.getDownTime() + "_" + pointerId);
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (this.nr.isEmpty() || this.fx == null || fxVar == null || fxVar.a() == null || fxVar.a().getRootView() == null) {
            return;
        }
        u(fxVar.a());
    }

    public void u(View view) {
        if (this.nr.isEmpty() || this.fx == null || view == null || view.getRootView() == null) {
            return;
        }
        final View rootView = view.getRootView();
        this.nr.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.fx.nr.u.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : u.this.nr) {
                    if (motionEvent != null) {
                        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        u.this.fx.add(motionEvent.getDownTime() + "_" + pointerId);
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                u.this.nr.clear();
            }
        }, 300L);
    }
}
