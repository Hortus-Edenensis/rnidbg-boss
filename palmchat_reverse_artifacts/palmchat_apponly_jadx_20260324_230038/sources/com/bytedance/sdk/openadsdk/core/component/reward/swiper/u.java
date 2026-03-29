package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kj;
import com.bytedance.sdk.openadsdk.core.s.b;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.gi.t;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private boolean iz;

    public u(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, bcVar, str, z, z2);
    }

    public void fx(boolean z) {
        this.iz = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.nr
    public iz jk() {
        iz izVarU = zx.u(1, this.nr);
        izVarU.nr(this.nr.lk());
        izVarU.nr(100);
        izVarU.fx(100);
        izVarU.fx(this.nr.ap());
        izVarU.nr(this.b);
        if (t.u(this.nr)) {
            izVarU.u(true);
        }
        return izVarU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.nr
    public void u(NativeExpressView nativeExpressView) {
        Map<String, Object> mapU = this.u.u(this.nr);
        if (nativeExpressView.getDynamicShowType() == 0) {
            kj.u(mapU, this.nr, nativeExpressView);
        } else {
            mapU.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
        }
        gi giVarTw = this.nr.tw();
        Double dOa = null;
        if (giVarTw != null) {
            mapU.put("refresh_num", Integer.valueOf(giVarTw.fx()));
            if (this.iz) {
                dOa = this.u.oa();
            }
        }
        b.u(this.nr, this.fx, mapU, dOa);
        nativeExpressView.getAdShowTime().u(1.0f, 11);
        com.bytedance.sdk.openadsdk.core.bf.u.u().b();
        xg.u(this.nr.n());
    }
}
