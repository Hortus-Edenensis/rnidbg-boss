package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
    private float b;
    private int iz;
    private float pn;
    private boolean t;
    private final u u;
    private int x;
    private boolean nr = false;
    private boolean fx = false;
    private boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5405a = false;
    private final View.OnTouchListener jk = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.s.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (s.this.u.k()) {
                return s.this.nr || !s.this.fx;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                s sVar = s.this;
                sVar.t = sVar.u(motionEvent);
                s.this.b = x;
                s.this.pn = y;
                s.this.iz = (int) x;
                s.this.x = (int) y;
                s.this.n = true;
                if (s.this.u != null && s.this.fx && !s.this.nr) {
                    s.this.u.u(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - s.this.iz) > 20.0f || Math.abs(y - s.this.x) > 20.0f) {
                    s.this.n = false;
                }
                if (!s.this.nr) {
                    s.this.n = true;
                }
                s.this.f5405a = false;
                s.this.b = 0.0f;
                s.this.pn = 0.0f;
                s.this.iz = 0;
                if (s.this.u != null) {
                    s.this.u.u(view, s.this.n);
                }
                s.this.t = false;
            } else if (action != 2) {
                if (action == 3) {
                    s.this.t = false;
                }
            } else if (s.this.nr && !s.this.t) {
                float f = x - s.this.b;
                float f2 = y - s.this.pn;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (!s.this.f5405a) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    s.this.f5405a = true;
                }
                if (s.this.u != null) {
                    s.this.u.s();
                }
                s.this.b = x;
                s.this.pn = y;
            }
            return s.this.nr || !s.this.fx;
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        boolean k();

        void s();

        void u(View view, boolean z);
    }

    public s(u uVar) {
        this.u = uVar;
    }

    public void u(View view) {
        if (view != null) {
            view.setOnTouchListener(this.jk);
        }
    }

    public void u(boolean z) {
        this.fx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iB = y.b(dw.getContext().getApplicationContext());
        int iPn = y.pn(dw.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iB;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iPn;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
