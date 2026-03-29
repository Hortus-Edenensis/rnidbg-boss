package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.c;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.xg;
import com.bytedance.sdk.openadsdk.core.pb;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.huawei.openalliance.ad.constant.az;
import com.qiniu.android.collect.ReportItem;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements com.bytedance.sdk.openadsdk.core.a.u.u.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5202a;
    private Context b;
    private String fx;
    private boolean jk;
    private String l;
    private com.bytedance.sdk.openadsdk.core.video.nr.nr mv;
    private bc nr;
    private my pn;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx t;
    private com.bytedance.sdk.openadsdk.core.a.u.u.u u;
    private boolean iz = false;
    private boolean x = false;
    private Function<SparseArray<Object>, Object> n = com.bytedance.sdk.openadsdk.core.n.o().y();

    public fx(com.bytedance.sdk.openadsdk.core.a.u.u.u uVar, bc bcVar, String str, my myVar, Context context) {
        this.u = uVar;
        this.nr = bcVar;
        this.fx = str;
        this.b = context;
        this.pn = myVar;
    }

    public void fx(boolean z) {
        this.f5202a = z;
    }

    public void nr(boolean z) {
        this.x = z;
    }

    private String fx(String str) {
        bc bcVar;
        xg xgVarMd;
        if (TextUtils.isEmpty(str) || (bcVar = this.nr) == null || !su.u(bcVar) || (xgVarMd = this.nr.md()) == null) {
            return str;
        }
        try {
            String strFx = xgVarMd.fx();
            String strB = xgVarMd.b();
            Map<String, String> mapU = com.bytedance.sdk.openadsdk.core.y.bc.u(str);
            mapU.put("live_short_touch_params", strFx);
            mapU.put("extra_pangle_scheme_params", strB);
            String strU = com.bytedance.sdk.openadsdk.core.y.bc.u(str, mapU);
            com.bytedance.sdk.openadsdk.core.nr.u().put("is_reward_deep_link_to_live", true);
            return strU;
        } catch (Exception unused) {
            return str;
        }
    }

    private boolean nr() {
        String strFx = c.fx(this.nr, this.l);
        bc bcVar = this.nr;
        Context context = this.b;
        String str = this.fx;
        com.bytedance.sdk.openadsdk.core.a.u.u.nr.u uVar = new com.bytedance.sdk.openadsdk.core.a.u.u.nr.u(bcVar, context, str, jp.nr(str));
        uVar.fx(true);
        uVar.u(strFx);
        uVar.u(this.mv);
        return uVar.u((Map<String, Object>) new HashMap());
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.mv = nrVar;
    }

    public void u(boolean z) {
        this.iz = z;
    }

    public void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar) {
        this.t = fxVar;
    }

    public void u(String str) {
        this.l = str;
    }

    private my u() {
        my myVar = this.pn;
        return myVar == null ? new my() : myVar;
    }

    public String nr(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getScheme())) ? "" : uri.getScheme().toLowerCase(Locale.US);
    }

    public Boolean u(Map<String, Object> map, String str, JSONObject jSONObject) {
        String strFx = fx(str);
        if (TextUtils.isEmpty(strFx)) {
            return null;
        }
        my.u((String) null);
        Uri uri = Uri.parse(strFx);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (this.iz) {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.nr, this.fx, "lp_open_dpl", nr(strFx));
        }
        boolean zNr = jp.nr(this.b);
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.iz));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zNr));
        } catch (Exception unused) {
        }
        if (zNr) {
            boolean zU = jp.u(this.b, intent);
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(zU));
            } catch (Exception unused2) {
            }
            if (zU) {
                return u(map, intent, true, jSONObject);
            }
            u(map, true, (Throwable) null);
            u(1);
            return null;
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.live.pn.u.u(strFx)));
            String strGi = jp.gi(this.nr);
            if (strGi != null && strGi.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(jp.u(strGi)));
            }
            jSONObject.putOpt("pkg", strGi);
        } catch (Throwable unused3) {
        }
        return u(map, intent, false, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final Intent intent) {
        bc bcVar = this.nr;
        if (bcVar == null || this.b == null || intent == null) {
            return;
        }
        String strFx = bcVar.pu() != null ? this.nr.pu().fx() : "";
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.b, this.nr.lk(), strFx, TextUtils.isEmpty(strFx) ? "是否立即打开应用" : "是否立即打开".concat(String.valueOf(strFx)), "立即打开", "退出", new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.fx.3
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                HashMap map = new HashMap();
                map.put(az.at, "DeepLinkConverter");
                com.bytedance.sdk.openadsdk.core.s.b.n(fx.this.nr, fx.this.fx, "open_url_app", map);
                com.bytedance.sdk.component.utils.nr.u(fx.this.b, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.fx.3.1
                    @Override // com.bytedance.sdk.component.utils.nr.u
                    public void u() {
                        com.bytedance.sdk.openadsdk.core.s.n.u().u(fx.this.nr, fx.this.fx, false);
                        com.bytedance.sdk.openadsdk.core.s.b.u(fx.this.nr, fx.this.fx, "deeplink_success_realtime", (Throwable) null);
                    }

                    @Override // com.bytedance.sdk.component.utils.nr.u
                    public void u(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.s.b.u(fx.this.nr, fx.this.fx, "deeplink_fail_realtime", th);
                    }
                }, TextUtils.equals("main", UMModuleRegister.INNER));
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
            }
        });
    }

    private Boolean u(JSONObject jSONObject) {
        Boolean boolValueOf;
        try {
            jSONObject.putOpt("tag", this.l);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.l) || !c.u(this.nr, this.l)) {
            return null;
        }
        int iNr = c.nr(this.nr, this.l);
        if (iNr != 1) {
            boolValueOf = u(new HashMap(), c.fx(this.nr, this.l), jSONObject);
        } else {
            boolValueOf = Boolean.valueOf(nr());
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(iNr));
            jSONObject.putOpt("dpl_result", boolValueOf);
        } catch (JSONException unused2) {
        }
        return boolValueOf;
    }

    private Boolean u(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        jp.nr(intent);
        u(intent);
        HashMap map2 = new HashMap();
        map2.put(az.at, "DeepLinkConverter");
        if (this.x) {
            boolean zU = u(this.fx, "open_fallback_url", this.nr, map);
            if (!zU) {
                com.bytedance.sdk.openadsdk.core.s.b.n(this.nr, this.fx, "open_url_app", map2);
            }
            try {
                jSONObject.putOpt("intercept", Boolean.valueOf(zU));
            } catch (JSONException unused) {
            }
        } else {
            com.bytedance.sdk.openadsdk.core.s.b.n(this.nr, this.fx, "open_url_app", map2);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.nr.u(this.b, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.fx.1
            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u() {
                atomicBoolean.set(true);
                if (fx.this.iz) {
                    com.bytedance.sdk.openadsdk.core.s.b.u(fx.this.nr, fx.this.fx, "lp_openurl", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.s.b.u(fx.this.nr, fx.this.fx, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.s.b.u(fx.this.nr, fx.this.fx, "deeplink_success_realtime", (Throwable) null);
                }
                com.bytedance.sdk.openadsdk.core.s.n.u().u(fx.this.nr, fx.this.fx, fx.this.iz);
                fx.this.u(0);
            }

            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u(Throwable th) {
                atomicBoolean.set(false);
                fx.this.u((Map<String, Object>) map, z, th);
                fx.this.u(3);
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i) {
        bc bcVar = this.nr;
        if (bcVar == null || bcVar.ud() != 1) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, 1, 1, i, d.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Map<String, Object> map, boolean z, Throwable th) {
        if (this.x && !z) {
            com.bytedance.sdk.openadsdk.core.s.b.fx(this.nr, this.fx, "open_fallback_download");
        }
        if (this.x) {
            com.bytedance.sdk.openadsdk.core.s.b.fx(this.nr, this.fx, "lp_openurl_failed");
            if (!this.jk && !u(this.fx, "open_fallback_url", this.nr, map)) {
                this.jk = true;
                com.bytedance.sdk.openadsdk.core.s.b.n(this.nr, this.fx, "open_fallback_url", null);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.s.b.n(this.nr, this.fx, "open_fallback_url", null);
        }
        if (this.f5202a) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, (this.x && this.iz) ? "lp_deeplink_fail_realtime" : "deeplink_fail_realtime", th);
    }

    private boolean u(String str, String str2, bc bcVar, Map<String, Object> map) {
        if (this.n == null) {
            return false;
        }
        Object objApply = this.n.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(Boolean.class).u(0, new wq().u("tagIntercept", str).u("label", str2).u("hashCode", Integer.valueOf(u.fx(map))).u("meta", bcVar.et().toString())).nr());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    public void u(final Intent intent) {
        final com.bytedance.sdk.openadsdk.core.y.u uVarB;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        bc bcVar = this.nr;
        if (bcVar == null || intent == null || this.b == null) {
            return;
        }
        my myVarKv = bcVar.kv();
        if (myVarKv != null && myVarKv.fx() == 2 && !myVarKv.u() && com.bytedance.sdk.openadsdk.core.nr.u().get("dpl_reject_by_dialog", false)) {
            pb.u(this.nr, this.fx);
        } else if (this.nr.hc() && (uVarB = com.bytedance.sdk.openadsdk.core.n.o().b()) != null) {
            uVarB.u(new u.fx() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.fx.2
                @Override // com.bytedance.sdk.openadsdk.core.y.u.fx, com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
                public void u() {
                    if (System.currentTimeMillis() - jCurrentTimeMillis <= 3000) {
                        fx.this.nr(intent);
                    }
                    com.bytedance.sdk.openadsdk.core.y.u uVar = uVarB;
                    if (uVar != null) {
                        uVar.fx();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(Map<String, Object> map) {
        Object objValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolU = u(jSONObject);
            try {
                if (boolU != null && boolU.booleanValue()) {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.nr.gq()));
                    jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.nr.xx());
                    objValueOf = Boolean.valueOf(this.nr.nr());
                } else {
                    my myVarU = u();
                    if (myVarU == null) {
                        myVarU = this.nr.kv();
                    }
                    if (myVarU != null && !TextUtils.isEmpty(myVarU.nr())) {
                        String strNr = myVarU.nr();
                        Boolean boolU2 = u(map, strNr, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", boolU2);
                            jSONObject.putOpt("url", strNr);
                        } catch (Exception unused2) {
                        }
                        if (myVarU.pn() == 2 && this.t != null && !this.x && (boolU2 == null || !boolU2.booleanValue())) {
                            this.t.b(false);
                            this.t.u(this.nr, com.bytedance.sdk.openadsdk.core.a.u.b.u.u(map));
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.nr.gq()));
                            jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.nr.xx());
                            objValueOf = Boolean.valueOf(this.nr.nr());
                        } else {
                            if (boolU2 != null && !this.x) {
                                return boolU2.booleanValue();
                            }
                            if (this.x && (boolU2 == null || !boolU2.booleanValue())) {
                                try {
                                    jSONObject.putOpt("uchain", Boolean.TRUE);
                                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.nr.gq()));
                                    jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.nr.xx());
                                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.nr.nr()));
                                } catch (Exception unused3) {
                                }
                                s.u().u("open_detail_page", TurnInfo.TYPE_NATIVE, 0, jSONObject);
                                com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.u;
                                return uVar != null && uVar.u(map);
                            }
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.nr.gq()));
                                jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.nr.xx());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.nr.nr()));
                            } catch (Exception unused4) {
                            }
                            s.u().u("open_detail_page", TurnInfo.TYPE_NATIVE, 0, jSONObject);
                            return false;
                        }
                    } else {
                        try {
                            jSONObject.putOpt("dpl_null", Boolean.TRUE);
                        } catch (Exception unused5) {
                        }
                        com.bytedance.sdk.openadsdk.core.a.u.u.u uVar2 = this.u;
                        z = uVar2 != null && uVar2.u(map);
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.nr.gq()));
                        jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.nr.xx());
                        objValueOf = Boolean.valueOf(this.nr.nr());
                    }
                }
                jSONObject.putOpt("web_meta", objValueOf);
            } catch (Exception unused6) {
            }
            s.u().u("open_detail_page", TurnInfo.TYPE_NATIVE, 0, jSONObject);
            return z;
        } finally {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.nr.gq()));
                jSONObject.putOpt(ReportItem.RequestKeyRequestId, this.nr.xx());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.nr.nr()));
            } catch (Exception unused7) {
            }
            s.u().u("open_detail_page", TurnInfo.TYPE_NATIVE, 0, jSONObject);
        }
    }
}
