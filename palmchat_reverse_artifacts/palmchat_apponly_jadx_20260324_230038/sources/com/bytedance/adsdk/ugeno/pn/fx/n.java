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
public class n extends nr implements a.u {
    private Handler l;
    private int t;

    public n(Context context) {
        super(context);
        this.t = 500;
        this.l = new a(Looper.getMainLooper(), this);
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
        int action = motionEvent.getAction();
        if (action == 0) {
            this.l.sendEmptyMessageDelayed(1101, this.t);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.l.removeMessages(1101);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.iz.a.u
    public void u(Message message) {
        if (message.what != 1101) {
            return;
        }
        t tVar = this.u;
        if (tVar != null) {
            tVar.u(this.nr, this.iz, this.fx.nr());
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
