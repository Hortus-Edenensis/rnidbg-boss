package com.bytedance.sdk.openadsdk.core.nr;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.pb.a;
import com.bytedance.sdk.openadsdk.core.y.kj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static int f5345a = 8;
    private static float b;
    private static float fx;
    private static float nr;
    private static long pn;
    private static float u;
    protected final Context iz;
    protected jk x = new jk();
    protected final com.bytedance.sdk.openadsdk.core.nr.u.b n = new com.bytedance.sdk.openadsdk.core.nr.u.b();

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public long b;
        public double fx;
        public double nr;
        public int u;

        public u(int i, double d, double d2, long j) {
            this.u = i;
            this.nr = d;
            this.fx = d2;
            this.b = j;
        }
    }

    static {
        try {
            if (ViewConfiguration.get(dw.getContext()) != null) {
                f5345a = ViewConfiguration.get(dw.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public b(Context context) {
        if (context == null) {
            this.iz = dw.getContext();
        } else {
            this.iz = context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (a.u()) {
            u(view, this.x);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i;
        this.x.fx(motionEvent.getDeviceId());
        this.x.nr(motionEvent.getToolType(0));
        this.x.b(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.x.pn((int) motionEvent.getRawX());
            this.x.iz((int) motionEvent.getRawY());
            this.x.u(motionEvent.getRawX());
            this.x.nr(motionEvent.getRawY());
            this.x.u(System.currentTimeMillis());
            this.x.nr(motionEvent.getToolType(0));
            this.x.fx(motionEvent.getDeviceId());
            this.x.b(motionEvent.getSource());
            pn = System.currentTimeMillis();
            this.x.nr(true);
            kj.u(motionEvent);
            i = 0;
        } else if (actionMasked != 1) {
            i = 2;
            if (actionMasked == 2) {
                fx += Math.abs(motionEvent.getX() - u);
                b += Math.abs(motionEvent.getY() - nr);
                u = motionEvent.getX();
                nr = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis() - pn;
                this.x.fx(motionEvent.getRawX());
                this.x.b(motionEvent.getRawY());
                if (Math.abs(this.x.sx() - this.x.jk()) >= f5345a || Math.abs(this.x.bg() - this.x.t()) >= f5345a) {
                    this.x.nr(false);
                }
                if (jCurrentTimeMillis > 200) {
                    float f = fx;
                    int i2 = f5345a;
                    if (f > i2 || nr > i2) {
                        i = 1;
                    }
                }
            } else if (actionMasked != 3) {
                i = -1;
            } else {
                if (com.bytedance.sdk.component.adexpress.dynamic.nr.u.u(view) && com.bytedance.sdk.component.adexpress.dynamic.nr.u.nr(view)) {
                    view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                b bVar = b.this;
                                bVar.u(view, bVar.x);
                            }
                        }
                    });
                    return true;
                }
                i = 4;
            }
        } else {
            this.x.fx(motionEvent.getRawX());
            this.x.b(motionEvent.getRawY());
            if (Math.abs(this.x.sx() - this.x.jk()) >= f5345a || Math.abs(this.x.bg() - this.x.t()) >= f5345a) {
                this.x.nr(false);
            }
            this.x.nr(System.currentTimeMillis());
            Context context = this.iz;
            if (context == null) {
                context = dw.getContext();
            }
            com.bytedance.sdk.openadsdk.core.nr.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.nr.u.nr) u(com.bytedance.sdk.openadsdk.core.nr.u.nr.class);
            if (nrVar != null) {
                nrVar.u(this.x);
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.nr.u.u(view)) {
                if (com.bytedance.sdk.component.adexpress.dynamic.nr.u.u(view, this.x.sx(), this.x.bg(), this.x.jk(), this.x.t())) {
                    return false;
                }
                if (com.bytedance.sdk.component.adexpress.dynamic.nr.u.nr(view)) {
                    u(view, this.x);
                }
                return true;
            }
            if (nrVar != null) {
                Point point = new Point((int) this.x.sx(), (int) this.x.bg());
                if (view != null && !nrVar.u(view, context) && nrVar.u((View) view.getParent(), point)) {
                    return true;
                }
            }
            i = 3;
        }
        this.x.l().put(motionEvent.getActionMasked(), new u(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public abstract void u(View view, jk jkVar);

    public void u(q qVar) {
    }

    public <T extends com.bytedance.sdk.openadsdk.core.nr.u.u> T u(Class<T> cls) {
        return (T) this.n.u(cls);
    }

    public void b() {
    }

    public void fx() {
    }

    public void pn(int i) {
    }
}
