package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.huawei.openalliance.ad.constant.be;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class x implements com.bytedance.sdk.component.t.u.u.fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.t.nr.u(u = "is_click_button")
    private volatile boolean f5200a;

    @com.bytedance.sdk.component.t.nr.u(u = "event_tag")
    protected String b;

    @com.bytedance.sdk.component.t.nr.u(u = "download_popup_manager")
    protected com.bytedance.sdk.openadsdk.core.l.fx.fx.fx iz;

    @com.bytedance.sdk.component.t.nr.u(u = WfConstant.EXTRA_KEY_DOWNLOAD_URL)
    private String jk;

    @com.bytedance.sdk.component.t.nr.u(u = be.D)
    private JSONObject l;

    @com.bytedance.sdk.component.t.nr.u(u = "dialog_to_landing_page_convert")
    private com.bytedance.sdk.openadsdk.core.a.u.u.u mv;

    @com.bytedance.sdk.component.t.nr.u(u = "is_open_oppo_market_auto_download")
    private volatile boolean n;

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    protected Context nr;

    @com.bytedance.sdk.component.t.nr.u(u = "download_status_listener")
    protected DownloadStatusChangeListener pn;

    @com.bytedance.sdk.component.t.nr.u(u = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.nr.nr s;

    @com.bytedance.sdk.component.t.nr.u(u = "download_conf")
    private JSONObject t;

    @com.bytedance.sdk.component.t.nr.u(u = "material_meta")
    protected bc u;

    @com.bytedance.sdk.component.t.nr.u(u = "convert_from_landing_page")
    protected volatile boolean fx = false;

    @com.bytedance.sdk.component.t.nr.u(u = "need_check_compliance")
    private int x = 0;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        if (!u()) {
            uVar.nr(map2);
            return true;
        }
        int iFx = com.bytedance.sdk.openadsdk.core.a.u.u.u.u.fx(map2);
        com.bytedance.sdk.openadsdk.core.a.u.u.u.b bVar = new com.bytedance.sdk.openadsdk.core.a.u.u.u.b(this.u, this.nr, this.b, this.iz, this.jk);
        bVar.nr(this.f5200a);
        bVar.u(this.n, iFx);
        bVar.u(this.pn);
        bVar.u(this.fx);
        bVar.u(this.x);
        bVar.u(this.mv);
        bVar.u(new bq(this.t));
        if (new com.bytedance.sdk.openadsdk.core.a.u.u.nr.nr(bVar, this.s).u(map2)) {
            uVar.u(map2);
        } else {
            uVar.nr(map2);
        }
        return true;
    }

    private boolean u() {
        if (this.u == null || this.nr == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.jk)) {
            return (TextUtils.isEmpty(this.b) || this.iz == null) ? false : true;
        }
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarNr = com.bytedance.sdk.openadsdk.core.u.nr(this.l);
        if (pnVarNr != null) {
            this.jk = pnVarNr.nr();
        }
        return false;
    }
}
