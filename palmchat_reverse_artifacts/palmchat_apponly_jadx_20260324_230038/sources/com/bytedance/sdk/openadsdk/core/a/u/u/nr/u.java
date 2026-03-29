package com.bytedance.sdk.openadsdk.core.a.u.u.nr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.my.fx.nr.a;
import com.huawei.openalliance.ad.constant.az;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    private Object b;
    private bc fx;
    private boolean iz;
    private String jk;
    private int n;
    private Context nr;
    private Map<String, Object> pn;
    private com.bytedance.sdk.openadsdk.core.video.nr.nr t;
    private String x;
    private boolean u = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5201a = false;

    public u(bc bcVar, Context context, String str, int i) {
        this.fx = bcVar;
        this.nr = context;
        this.x = str;
        this.n = i;
    }

    public void fx(boolean z) {
        this.f5201a = z;
    }

    public void nr(boolean z) {
        this.iz = z;
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.t = nrVar;
    }

    private com.bytedance.sdk.openadsdk.core.multipro.nr.u fx() {
        Object obj;
        if (!bc.nr(this.fx) || (obj = this.b) == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVarR_ = obj instanceof u.InterfaceC0273u ? ((u.InterfaceC0273u) obj).r_() : null;
        if (uVarR_ != null) {
            this.pn.put("multi_process_data", uVarR_.u().toString());
        }
        Object obj2 = this.b;
        if (!(obj2 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.nr)) {
            return uVarR_;
        }
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVarT = ((com.bytedance.sdk.openadsdk.core.nativeexpress.nr) obj2).t();
        if (uVarT != null) {
            this.pn.put("multi_process_data", uVarT.u().toString());
        }
        return uVarT;
    }

    public void nr(Map<String, Object> map) {
        this.pn = map;
    }

    public void u(boolean z) {
        this.u = z;
    }

    private boolean nr(String str) {
        if (!o.u(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.nr instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.component.utils.nr.u(this.nr, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public Class<?> u() {
        boolean z = this.u;
        this.u = false;
        if (this.b instanceof a) {
            return jk.iz(this.fx) ? TTNativePageActivity.class : TTWebPageActivity.class;
        }
        if (!bc.nr(this.fx) || z || u(this.b) || !jp.x(this.fx)) {
            return jk.iz(this.fx) ? TTNativePageActivity.class : TTWebPageActivity.class;
        }
        if (jk.iz(this.fx)) {
            return TTNativePageActivity.class;
        }
        bc bcVar = this.fx;
        return (bcVar == null || !bcVar.jk()) ? nr(TTVideoWebPageActivity.class) : TTWebPageActivity.class;
    }

    private void nr() {
        if (this.f5201a && this.fx != null) {
            if (this.pn == null) {
                this.pn = new HashMap();
            }
            if (TextUtils.isEmpty(this.jk)) {
                this.jk = this.fx.jf();
            }
            this.pn.put("url", this.jk);
            this.pn.put("gecko_id", this.fx.wv());
            this.pn.put("web_title", this.fx.wf());
            this.pn.put("sdk_version", Integer.valueOf(d.fx));
            this.pn.put("adid", this.fx.lk());
            this.pn.put("log_extra", this.fx.ap());
            this.pn.put("icon_url", this.fx.dd() == null ? null : this.fx.dd().u());
            this.pn.put("event_tag", this.x);
            this.pn.put(az.at, Integer.valueOf(this.n));
            this.pn.put("is_outer_click", Boolean.TRUE);
            jp.u(this.pn, this.fx);
        }
    }

    private static boolean u(Object obj) {
        if (obj == null || !(obj instanceof u.InterfaceC0273u)) {
            return false;
        }
        try {
            return ((u.InterfaceC0273u) obj).m_();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean u(Class cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.fx.ap());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.fx.gq()));
            jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.fx.xx());
            Boolean bool = Boolean.TRUE;
            jSONObject.putOpt("uchain", bool);
            jSONObject.putOpt("uchain_old", bool);
            jSONObject.putOpt(WfConstant.EXTRA_KEY_INTERACTION_TYPE, Integer.valueOf(this.fx.qf()));
        } catch (JSONException unused) {
        }
        s.u().u("landing_page", TurnInfo.TYPE_NATIVE, 0, jSONObject);
        if (this.fx.qf() == 2) {
            return nr(this.fx.jf());
        }
        com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar = this.t;
        if (nrVar != null && new nr(nrVar).u(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.nr, (Class<?>) cls);
        if (!(this.nr instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.fx.iz());
        nr();
        if (this.pn == null) {
            this.pn = new HashMap();
        }
        for (Map.Entry<String, Object> entry : this.pn.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.nr.u(this.nr, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.nr.u.1
            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u() {
            }

            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u(Throwable th) {
            }
        });
        return true;
    }

    private Class nr(Class cls) {
        int i;
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVarFx = fx();
        if (uVarFx != null) {
            this.pn.put("video_is_auto_play", Boolean.valueOf(uVarFx.b));
        }
        if (!TTVideoWebPageActivity.class.equals(cls)) {
            return cls;
        }
        if (uVarFx == null && !this.iz) {
            return cls;
        }
        try {
            if (uVarFx != null) {
                i = (int) ((uVarFx.x / uVarFx.pn) * 100.0f);
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
                uVar.x = 100L;
                uVar.u = true;
                uVar.b = jp.q(this.fx);
                this.pn.put("multi_process_data", uVar.u().toString());
                i = 100;
            }
            if (this.fx.qb() == 0) {
                return TTVideoScrollWebPageActivity.class;
            }
            if (this.fx.qb() > 0 && i > this.fx.qb()) {
                if (jp.q(this.fx)) {
                    return TTVideoScrollWebPageActivity.class;
                }
            }
        } catch (Throwable unused) {
        }
        return cls;
    }

    public void u(String str) {
        this.jk = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(Map<String, Object> map) {
        if (this.fx == null) {
            return false;
        }
        return u((Class) u());
    }
}
