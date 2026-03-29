package com.bytedance.sdk.openadsdk.core.bf.u;

import android.os.Message;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u implements rh.u {
    private qq nr;
    private final rh u = new rh(jk.u().getLooper(), this);

    public void u(JSONObject jSONObject, int i) {
        int iU = u(i);
        if (nr(i)) {
            u(jSONObject, com.bytedance.sdk.openadsdk.core.bf.u.u().nr(), iU);
        } else if (fx(i)) {
            u(jSONObject, com.bytedance.sdk.openadsdk.core.bf.u.u().fx(), iU);
        }
    }

    private void u(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.nr = u();
            this.u.removeCallbacksAndMessages(null);
            this.u.sendEmptyMessage(1);
        }
    }

    private qq u() {
        qq qqVar = new qq(dw.getContext(), 1, n.o().pn(), dw.nr().jk());
        if (qqVar.u(0)) {
            return qqVar;
        }
        u(0, System.currentTimeMillis(), 0L);
        qqVar.nr(0);
        return null;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            qq qqVar = this.nr;
            if (qqVar != null) {
                qqVar.nr(0);
            }
            u(3, 0L, System.currentTimeMillis());
            return;
        }
        qq qqVar2 = this.nr;
        if (qqVar2 == null) {
            return;
        }
        qqVar2.u(new qq.fx() { // from class: com.bytedance.sdk.openadsdk.core.bf.u.nr.1
            @Override // com.bytedance.sdk.component.utils.qq.fx
            public void u() {
                nr.this.u(1, System.currentTimeMillis(), 0L);
                if (nr.this.u != null) {
                    nr.this.u.removeCallbacksAndMessages(null);
                }
                if (nr.this.nr != null) {
                    nr.this.nr.nr(0);
                }
            }
        });
        this.u.sendEmptyMessageDelayed(2, u(dw.nr().tr()));
    }
}
