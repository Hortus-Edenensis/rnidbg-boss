package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import com.bytedance.sdk.openadsdk.core.component.reward.u;
import com.bytedance.sdk.openadsdk.core.component.reward.u.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.yd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void b(String str) {
        u.u(1, this.w, str, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void fx(boolean z) {
        byte b = -1;
        if (this.qq) {
            if (dw.nr().si() == 1) {
                b = 2000;
            }
        } else if (z) {
            b = 0;
        }
        if (b < 0 || this.dw.get()) {
            return;
        }
        if (b != 0) {
            this.nr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TTFullScreenVideoActivity.this.dw.getAndSet(true)) {
                        return;
                    }
                    nr.u().u(String.valueOf(TTFullScreenVideoActivity.this.oa));
                }
            }, 2000L);
        } else {
            if (this.dw.getAndSet(true)) {
                return;
            }
            nr.u().u(String.valueOf(this.oa));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean kj() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void w() {
        String str;
        super.w();
        if (yd.o(this.pn) || this.wq.rh()) {
            return;
        }
        if (this.xg.bf()) {
            this.bf.u(false, null, null, true, true);
            return;
        }
        int iRh = ((int) this.xg.rh()) / 1000;
        String str2 = this.y.iz(false) + "s";
        boolean z = iRh >= this.y.wi();
        if (z || !dw.nr().pn(String.valueOf(this.oa))) {
            str = null;
        } else {
            str = (this.y.wi() - iRh) + "s后可跳过";
        }
        this.bf.u(false, str2, str, z, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void z() {
        if (this.fx.getAndSet(true) || this.nb.nr()) {
            return;
        }
        b("onAdClose");
    }
}
