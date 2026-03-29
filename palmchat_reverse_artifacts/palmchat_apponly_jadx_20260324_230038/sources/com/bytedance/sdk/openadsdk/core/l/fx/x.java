package com.bytedance.sdk.openadsdk.core.l.fx;

import android.content.Context;
import android.os.Message;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.huawei.openalliance.ad.constant.az;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends pn {
    private Map<String, Object> z;

    public x(Context context, bc bcVar, String str, boolean z) {
        super(context, bcVar, str, z);
    }

    private void o() {
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = this.pn.pu();
        if (pnVarPu != null) {
            this.z.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, pnVarPu.nr());
        }
        this.z.put("download_status_listener", this.kj);
        this.z.put("event_tag", this.iz);
        this.z.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.a.u.u.u() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.x.1
            @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
            public boolean u(Map<String, Object> map) {
                x xVar = x.this;
                Context context = xVar.getContext();
                x xVar2 = x.this;
                return xVar.u(context, xVar2.pn, xVar2.iz);
            }
        });
        this.z.put("download_popup_manager", n());
        this.z.put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void b() {
        if (this.b == null) {
            return;
        }
        this.jk.set(false);
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(Void.class).u(0, new wq().u("force", Boolean.TRUE).u("hashCode", Integer.valueOf(x()))).nr());
        }
        my();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public boolean fx(JSONObject jSONObject, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public boolean iz() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public boolean k() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public synchronized void my() {
        o();
        this.jk.set(true);
        if (this.c != null) {
            this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(5).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(x())).u("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.my.fx.b.u(this.kj))).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public void n(boolean z) {
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.iz, this.pn, (JSONObject) null, x());
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.pn, x(), z);
        this.z = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public Map<String, Object> pn() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public synchronized void t() {
        if (this.b == null) {
            return;
        }
        if (this.c != null && d.fx >= 6400 && !d.x()) {
            com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u((com.bytedance.sdk.openadsdk.core.l.u.b) null, x());
        }
        AtomicBoolean atomicBoolean = this.jk;
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.jk.set(false);
            if (this.c != null) {
                this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(4).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(x()))).nr());
            }
        }
        jk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public boolean fx() {
        Function<SparseArray<Object>, Object> function = this.c;
        return function != null && com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(function, x()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public void iz(boolean z) {
        this.z.put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(bc bcVar, boolean z) {
        if (getContext() == null) {
            return;
        }
        u(jp.dw(bcVar), z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void fx(boolean z) {
        this.z.put("is_open_oppo_market_auto_download", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(int i) {
        this.z.put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(JSONObject jSONObject, boolean z) {
        jp.gi();
        HashMap map = new HashMap();
        map.put("material_meta", this.pn);
        map.put("context", dw.getContext());
        map.put("is_market_covert", Boolean.valueOf(fx()));
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = this.pn.pu();
        if (pnVarPu != null) {
            map.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, pnVarPu.nr());
        }
        Map<String, Object> map2 = this.z;
        if (map2 != null) {
            map.putAll(map2);
        }
        map.put("download_status_listener", this.kj);
        map.put("event_tag", this.iz);
        map.put(az.at, Integer.valueOf(jp.nr(this.iz)));
        map.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.a.u.u.u() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.x.2
            @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
            public boolean u(Map<String, Object> map3) {
                x xVar = x.this;
                Context context = xVar.getContext();
                x xVar2 = x.this;
                return xVar.u(context, xVar2.pn, xVar2.iz);
            }
        });
        map.put("download_popup_manager", n());
        map.putAll(com.bytedance.sdk.component.t.pn.u.u().u(this.pn.hashCode() + this.pn.xx()));
        map.put("convert_from_downloader", Boolean.TRUE);
        map.put("download_manager_hash_code", Integer.valueOf(x()));
        map.put("is_feed_register_direct_download", Boolean.valueOf(z));
        HashMap map3 = new HashMap();
        map.put("download_manager_hash_code", Integer.valueOf(x()));
        com.bytedance.sdk.openadsdk.core.a.u.b.u.u(this.pn, map3, "clickEvent", map, this.iz, new HashMap());
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void b(boolean z) {
        this.qq = z;
        this.z.put("is_click_button", Boolean.valueOf(z));
    }
}
