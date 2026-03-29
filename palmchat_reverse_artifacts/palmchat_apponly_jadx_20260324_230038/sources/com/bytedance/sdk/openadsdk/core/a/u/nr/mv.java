package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.huawei.openalliance.ad.constant.be;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class mv implements com.bytedance.sdk.component.t.u.u.fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.t.nr.u(u = "download_adapter")
    private com.bytedance.sdk.openadsdk.core.l.nr.fx f5198a;

    @com.bytedance.sdk.component.t.nr.u(u = "deep_link")
    private JSONObject b;

    @com.bytedance.sdk.component.t.nr.u(u = "event_tag")
    private String fx;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_from_landing_page")
    private boolean iz;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_tag")
    private String jk;

    @com.bytedance.sdk.component.t.nr.u(u = "is_market_covert")
    private boolean n;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = be.D)
    private JSONObject pn;

    @com.bytedance.sdk.component.t.nr.u(u = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.nr.nr t;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    private bc u;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_from_downloader")
    private boolean x;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        com.bytedance.sdk.openadsdk.core.a.u.u.u.x xVar = new com.bytedance.sdk.openadsdk.core.a.u.u.u.x(com.bytedance.sdk.openadsdk.core.u.nr(this.pn), this.nr);
        xVar.u(this.u);
        xVar.u(this.fx);
        com.bytedance.sdk.openadsdk.core.a.u.u.u.fx fxVar = new com.bytedance.sdk.openadsdk.core.a.u.u.u.fx(xVar, this.u, this.fx, new com.bytedance.sdk.openadsdk.core.kj.my(this.b), this.nr);
        fxVar.nr(this.x);
        fxVar.u(this.iz);
        fxVar.fx(this.n);
        fxVar.u(this.f5198a);
        fxVar.u(this.jk);
        fxVar.u(this.t);
        if (fxVar.u(map2)) {
            uVar.u(map2);
            return true;
        }
        uVar.nr(map2);
        return true;
    }
}
