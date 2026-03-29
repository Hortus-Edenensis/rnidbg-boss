package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.iz.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz extends nr implements a.u {
    private int l;
    private Handler mv;
    private int s;
    private int t;

    public iz(Context context) {
        super(context);
        this.l = 0;
        this.mv = new a(Looper.getMainLooper(), this);
        this.s = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        Map<String, String> map = this.pn;
        if (map != null) {
            int iU = com.bytedance.adsdk.ugeno.iz.fx.u(map.get("loop"), 0);
            this.t = iU;
            if (iU <= 0) {
                this.s = -1;
            } else {
                this.s = iU;
            }
            this.l = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("duration"), 0);
        }
        this.mv.sendEmptyMessageDelayed(1001, this.l);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.iz.a.u
    public void u(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.u.u(this.nr, this.iz, this.fx.nr());
        int i3 = this.s - 1;
        this.s = i3;
        if (i3 < 0 && (i2 = this.l) != 0) {
            this.mv.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.l) != 0) {
            this.mv.sendEmptyMessageDelayed(1001, i);
        } else {
            this.mv.removeMessages(1001);
        }
    }
}
