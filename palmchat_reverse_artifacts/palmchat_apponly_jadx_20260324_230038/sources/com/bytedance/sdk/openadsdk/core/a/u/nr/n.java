package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class n implements com.bytedance.sdk.component.t.u.u.fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.t.nr.u(u = "is_show_download_dialog")
    private boolean f5199a = true;

    @com.bytedance.sdk.component.t.nr.u(u = "is_app_market_convert")
    private boolean b;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc fx;

    @com.bytedance.sdk.component.t.nr.u(u = "event_tag")
    private String iz;

    @com.bytedance.sdk.component.t.nr.u(u = "is_from_new_click_event")
    private boolean jk;

    @com.bytedance.sdk.component.t.nr.u(u = "is_direct_download")
    private boolean l;

    @com.bytedance.sdk.component.t.nr.u(u = "download_dialog_listener")
    private com.bytedance.sdk.openadsdk.core.l.fx.u.u mv;

    @com.bytedance.sdk.component.t.nr.u(u = "start_download_listener")
    private com.bytedance.sdk.openadsdk.core.l.fx.u.nr n;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = "app_manage_model")
    private com.bytedance.sdk.openadsdk.core.kj.b pn;

    @com.bytedance.sdk.component.t.nr.u(u = "dynamic_download_dialog_type")
    private int t;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_from_landing_page")
    protected boolean u;

    @com.bytedance.sdk.component.t.nr.u(u = WfConstant.EXTRA_KEY_DOWNLOAD_URL)
    private String x;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVar = new com.bytedance.sdk.openadsdk.core.l.fx.fx.fx(this.nr, this.fx);
        fxVar.fx(this.l);
        fxVar.u(this.f5199a);
        fxVar.u(this.t);
        fxVar.nr(this.jk);
        fxVar.u(this.mv);
        fxVar.u(u());
        if (!fxVar.b(false)) {
            uVar.nr(map2);
            return true;
        }
        fxVar.u(this.pn, this.iz, this.x, this.n);
        uVar.u(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.l.fx.fx.u u() {
        if (this.b) {
            return new com.bytedance.sdk.openadsdk.core.l.fx.fx.pn();
        }
        if (this.u) {
            return new com.bytedance.sdk.openadsdk.core.l.fx.fx.b();
        }
        return new com.bytedance.sdk.openadsdk.core.l.fx.fx.nr();
    }
}
