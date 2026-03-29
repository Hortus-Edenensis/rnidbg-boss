package com.bytedance.sdk.openadsdk.core.component.splash.presentation;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.mk;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SlideInterceptView extends View implements rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f5269a;
    private MotionEvent b;
    private long fx;
    private float iz;
    private final com.bytedance.adsdk.ugeno.fx.nr.u jk;
    private final mk n;
    private float nr;
    private float pn;
    private final rh t;
    private float u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(View view, jk jkVar);
    }

    public SlideInterceptView(Context context, mk mkVar, u uVar) {
        super(context);
        this.x = false;
        this.jk = new com.bytedance.adsdk.ugeno.fx.nr.u();
        this.t = new rh(this);
        this.n = mkVar;
        this.f5269a = uVar;
    }

    private boolean u(float f, float f2, int i, int i2) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        boolean z4 = (i & 8) == 8;
        if (z && (-f2) > i2) {
            return true;
        }
        if (z2 && f2 > i2) {
            return true;
        }
        if (!z3 || (-f) <= i2) {
            return z4 && f > ((float) i2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0117 A[RETURN] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.pn = motionEvent.getX();
        this.iz = motionEvent.getY();
        this.b = motionEvent;
        if (this.jk.u(motionEvent)) {
            return false;
        }
        com.bytedance.adsdk.ugeno.fx.nr.u uVar = this.jk;
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        uVar.u(this, sb.toString(), motionEvent);
        float f = x - this.u;
        float f2 = y - this.nr;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.fx;
        int iSx = this.n.sx();
        int iFx = y.fx(getContext(), this.n.bg());
        int iQ = this.n.q();
        int iFx2 = y.fx(getContext(), this.n.qq());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.t.removeMessages(1);
                if (u(f, f2, iSx, iFx)) {
                    if (!this.x) {
                        this.x = true;
                        u uVar2 = this.f5269a;
                        if (uVar2 != null) {
                            uVar2.u(this, u(x, y, motionEvent));
                        }
                    }
                } else if (!u(f, f2, jCurrentTimeMillis, iQ, iFx2)) {
                    z = this.x ? false : true;
                } else if (!this.x) {
                    this.x = true;
                    u uVar3 = this.f5269a;
                    if (uVar3 != null) {
                        uVar3.u(this, u(x, y, motionEvent));
                    }
                }
            } else if (action != 2) {
                if (action != 3) {
                }
            } else if (this.n.c() == 1 && u(f, f2, iSx, iFx)) {
                if (!this.x) {
                    this.x = true;
                    u uVar4 = this.f5269a;
                    if (uVar4 != null) {
                        uVar4.u(this, u(x, y, motionEvent));
                    }
                }
            } else if (u(f, f2, jCurrentTimeMillis, iQ, iFx2) && !this.x) {
                this.x = true;
                u uVar5 = this.f5269a;
                if (uVar5 != null) {
                    uVar5.u(this, u(x, y, motionEvent));
                }
            }
            if (z) {
                this.jk.u(this);
            }
            return this.x;
        }
        this.u = x;
        this.nr = y;
        this.fx = System.currentTimeMillis();
        if (iQ > 0) {
            this.t.sendEmptyMessageDelayed(1, iQ);
        }
        if (z) {
        }
        if (this.x) {
        }
    }

    private boolean u(float f, float f2, long j, int i, int i2) {
        if (i <= 0 || j < i) {
            return false;
        }
        float f3 = i2;
        return Math.abs(f) <= f3 && Math.abs(f2) <= f3;
    }

    private jk u(float f, float f2, MotionEvent motionEvent) {
        jk jkVar = new jk();
        jkVar.u(this.u);
        jkVar.nr(this.nr);
        jkVar.fx(f);
        jkVar.b(f2);
        jkVar.b(motionEvent.getSource());
        jkVar.u(this.fx);
        jkVar.nr(System.currentTimeMillis());
        return jkVar;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (!u(this.pn - this.u, this.iz - this.nr, System.currentTimeMillis() - this.fx, this.n.q(), y.fx(getContext(), this.n.qq())) || this.x) {
            return;
        }
        this.x = true;
        u uVar = this.f5269a;
        if (uVar != null) {
            uVar.u(this, u(this.pn, this.iz, this.b));
        }
    }

    public void u() {
        this.t.removeMessages(1);
    }
}
