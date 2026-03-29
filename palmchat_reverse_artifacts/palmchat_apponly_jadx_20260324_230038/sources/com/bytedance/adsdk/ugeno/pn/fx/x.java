package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.iz.a;
import com.bytedance.adsdk.ugeno.pn.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x extends nr implements a.u {
    private boolean l;
    private Handler mv;
    private int t;

    public x(Context context) {
        super(context);
        this.t = 500;
        this.mv = new a(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.t = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("delay"), 500);
        return u(this.nr, motionEvent);
    }

    private boolean u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        t tVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mv.sendEmptyMessageDelayed(1102, this.t);
        } else {
            if (action == 1) {
                if (this.l && (tVar = this.u) != null) {
                    tVar.u(this.nr, this.iz, this.fx.nr());
                    this.l = false;
                    Handler handler = this.mv;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.mv;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.l = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.mv;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.l = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.iz.a.u
    public void u(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.l = true;
        Handler handler = this.mv;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
