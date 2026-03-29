package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x implements View.OnTouchListener {
    private static int fx = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.n b;
    private float nr;
    private int pn;
    private float u;
    private RectF iz = new RectF();
    private long x = 0;
    private final int n = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5094a = 3;
    private SoftReference<View> jk = new SoftReference<>(null);

    public x(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar, int i, final ViewGroup viewGroup) {
        this.pn = fx;
        this.b = nVar;
        if (i > 0) {
            this.pn = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.u.x.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    x.this.jk = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.iz = u(this.jk.get());
            this.u = motionEvent.getRawX();
            this.nr = motionEvent.getRawY();
            this.x = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.iz;
            if (rectF != null && !rectF.contains(this.u, this.nr)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.u);
            float fAbs2 = Math.abs(rawY - this.nr);
            int iNr = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), Math.abs(rawX - this.u));
            int i = fx;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.x < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (nVar = this.b) != null) {
                    nVar.u();
                }
            } else if (rawX > this.u && iNr > this.pn && (nVar2 = this.b) != null) {
                nVar2.u();
            }
        }
        return true;
    }

    private RectF u(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }
}
